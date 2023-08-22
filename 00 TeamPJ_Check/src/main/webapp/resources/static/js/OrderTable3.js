// 주문 정보 수정 모드 변수
let editMode = false;

// 주문 정보 수정 모드 활성화 함수
function enableEditMode() {
  const tableRows = document.querySelectorAll('.table-body tr');
  tableRows.forEach((row) => {
    const checkboxes = row.querySelectorAll('.order-checkbox');
    checkboxes.forEach((checkbox) => {
      checkbox.disabled = true;
    });

    const cells = row.querySelectorAll('.editable-cell');
    cells.forEach((cell) => {
      cell.contentEditable = true;
      cell.style.backgroundColor = '#f0f0f0';
    });
  });

  editMode = true;
}

// 주문 정보 수정 모드 비활성화 함수
function disableEditMode() {
  const tableRows = document.querySelectorAll('.table-body tr');
  tableRows.forEach((row) => {
    const checkboxes = row.querySelectorAll('.order-checkbox');
    checkboxes.forEach((checkbox) => {
      checkbox.disabled = false;
    });

    const cells = row.querySelectorAll('.editable-cell');
    cells.forEach((cell) => {
      cell.contentEditable = false;
      cell.style.backgroundColor = '';
    });
  });

  editMode = false;
}

// 주문 정보 수정 버튼 클릭 이벤트 처리
const editButton = document.getElementById('edit_button');
editButton.addEventListener('click', function() {
  if (editMode) {
    // 수정 완료 모드
    disableEditMode();
    sendData(); // 수정된 데이터 서버로 전송
  } else {
    // 수정 모드 활성화
    enableEditMode();
  }
});

// 삭제 버튼 클릭 이벤트 처리
const deleteButton = document.getElementById('delete_button');
deleteButton.addEventListener('click', function() {
  const selectedOrderIds = getSelectedOrderIds();
  if (selectedOrderIds.length > 0) {
    deleteOrders(selectedOrderIds);
  } else {
    console.error("No orders selected to delete.");
  }
});

// 주문 정보를 선택할 때 해당 행에 selected 클래스를 추가하는 코드
function addCheckboxEventListeners() {
  const orderCheckboxes = document.querySelectorAll(".order-checkbox");
  orderCheckboxes.forEach((checkbox) => {
    checkbox.addEventListener("click", function() {
      const orderRow = this.parentElement.parentElement;
      if (this.checked) {
        orderRow.classList.add("selected");
      } else {
        orderRow.classList.remove("selected");
      }
      // 체크박스 클릭 시 선택된 주문 ID 출력 (테스트용)
      const selectedOrderIds = getSelectedOrderIds();
      console.log("Selected Order IDs:", selectedOrderIds);
    });
  });
}

// 주문 정보를 서버로부터 가져와서 테이블에 표시하는 코드
function fetchAndDisplayOrderData(order_id) {
  let url = '/app/order/ShoppingBasket_Admin2';
  if (order_id) {
    // 주문번호가 입력되어 있다면 해당 주문번호에 해당하는 주문 정보만 가져오도록 URL 수정
    url += '?order_id=' + encodeURIComponent(order_id);
  }

  axios.get(url)
    .then(response => {
      const orderList = response.data;
      displayOrderList(orderList);
      addCheckboxEventListeners(); // 주문 정보를 테이블에 표시한 후 이벤트 리스너 등록
    })
    .catch(error => {
      console.error(error);
      displayOrderList([]); // 에러 발생 시 빈 배열로 테이블에 표시
      addCheckboxEventListeners(); // 에러 발생 시 이벤트 리스너 등록
    });
}

// 주문 정보를 JSON 형태로 변환하여 서버로 전송하는 코드
function sendData() {
  const selectedOrders = document.querySelectorAll(".table-body tr.selected");
  const orderUpdateRequest = [];
  let isValidData = true;

  selectedOrders.forEach((order) => {
    const orderId = order.querySelector("[name='order_id']").textContent;
    const memberId = order.querySelector("[name^='member_id']").textContent;
    const odrAmount = order.querySelector("[name^='odr_amount']").textContent;
    const price = order.querySelector("[name^='price']").textContent;

    if (!orderId || !memberId || isNaN(parseInt(odrAmount)) || isNaN(parseInt(price))) {
      console.error("Invalid order data detected. Skipping order:", order);
      isValidData = false;
      return;
    }

    const orderData = {
      "order_id": orderId,
      "member_id": memberId,
      "odr_amount": parseInt(odrAmount),
      "price": parseInt(price)
    };
    orderUpdateRequest.push(orderData);
  });

  if (!isValidData) {
    console.error("Please fill in all required fields with valid data.");
    return;
  }

  console.log(orderUpdateRequest);
  axios.post('/TeamProject2/order/updateadmin.do', orderUpdateRequest)
    .then(response => {
      console.log("Update success:", response.data);
    })
    .catch(error => {
      console.error("Update failed:", error);
    });
}

// ... (기존 코드)
function displayOrderList(orderList) {
var tBody = document.querySelector('.table-body');


  const dataArray = Array.isArray(orderList) ? orderList : [orderList];

  dataArray.forEach((order) => {
    const row = document.createElement('tr');

    // 주문 정보를 각 열에 추가
    row.innerHTML = `
      <td contenteditable="false"><input type="checkbox" class="order-checkbox" /></td>
      <td contenteditable="true" name="order_id">${order.order_id}</td>
      <td contenteditable="true" name="member_id">${order.member_id || ''}</td>
      <td contenteditable="true" name="product_code">${order.product_code || ''}</td>
      <td contenteditable="true" name="product_name">${order.product_name || ''}</td>
      <td contenteditable="true" name="adr_addr">${order.adr_addr || ''}</td>
      <td contenteditable="true" name="odr_amount">${order.odr_amount || ''}</td>
      <td contenteditable="true" name="odr_date">${order.odr_date ? new Date(order.odr_date).toLocaleString() : ''}</td>
      <td contenteditable="true" name="price">${order.price || ''}</td>
      <td>
        <span class="table-remove glyphicon glyphicon-remove" id="removebt"></span>
      </td>
    `;

    tBody.appendChild(row);
  });
   addCheckboxEventListeners();
 
}

// 주문 정보를 삭제하는 함수
function deleteOrders(selectedOrderIds) {
  if (!selectedOrderIds || selectedOrderIds.length === 0) {
    console.error("No valid order IDs to delete.");
    return;
  }

  axios.post('/TeamProject2/order/delete.do', { "order_id": selectedOrderIds })
    .then(response => {
      console.log("Delete success:", response.data);
      fetchAndDisplayOrderData(); // 삭제 성공 시 테이블 갱신
    })
    .catch(error => {
      console.error("Delete failed:", error);
    });
}

// ... (기존 코드)
function initialize() {
  fetchAndDisplayOrderData();

}

// DOMContentLoaded 이벤트 발생 시 초기화 함수 호출
document.addEventListener('DOMContentLoaded', initialize);
const edit_btn = document.getElementById("edit_button").addEventListener("click", sendData);

// 검색 버튼 클릭 이벤트 처리
document.querySelector(".search_btn").addEventListener("click", function() {
  const order_id = document.getElementById("odrtype").value.trim();
  fetchAndDisplayOrderData(order_id);
});
