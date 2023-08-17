
					
					 const search_btn_el = document.querySelector(".search_btn");
					 
					 function insertDataIntoTable(data) {
					      const tableBody = document.querySelector('.table-body');
					      tableBody.innerHTML = ''; // 기존 테이블 데이터를 지우기 위해 비웁니다.
						  const dataArray = Array.isArray(data) ? data : [data];

					      dataArray.forEach((order) => {
					        const row = tableBody.insertRow(); // 새로운 행 요소 생성

					        // 각 데이터에 해당하는 셀을 생성하고 데이터를 추가합니다.
					        const orderIdCell = row.insertCell();
					        orderIdCell.textContent = order.order_id;

					        const productNameCell = row.insertCell();
					        productNameCell.textContent = order.product_name;

					        const addressCell = row.insertCell();
					        addressCell.textContent = order.adr_addr;

					        const orderAmountCell = row.insertCell();
					        orderAmountCell.textContent = order.odr_amount;

					        const orderDateCell = row.insertCell();
					        orderDateCell.textContent = order.odr_date;

					        const priceCell = row.insertCell();
					        priceCell.textContent = order.price;
							 });
					    }
					 
						search_btn_el.addEventListener("click",function(){
							const projectPath = '/TeamProject2';
							const ServerPort = '8080';
							console.log("search_btn_el click..",projectPath);
							
							const tableBody = document.querySelector('.table-body'); // 테이블의 tbody 요소를 가져옵니다.
							console.log(tableBody);
							/*tableBody.innerHTML = ' '; // 기존 테이블 데이터를 지우기 위해 비웁니다.*/ 
					    	
					    	  // 입력한 주문 ID 값을 가져옴
  							const orderIdInput = document.getElementById("odrtype");
  							const orderId = orderIdInput.value.trim(); // 입력값 앞뒤 공백 제거
  							console.log(orderId);
  							console.log(memberId);
					    	
					    	const url = "http://localhost:" + ServerPort + projectPath + "/order/search2.do" +
              							(orderId !== "" ? "?orderId=" + orderId : (memberId !== "" ? "?memberId=" + memberId : "")); // orderId 또는 memberId 중 하나만 쿼리 파라미터에 추가
							axios.get(url)
							.then(response=>{alert("Success!",response.data);
								console.log(response.data);
								const list = response.data;
								console.log("list : " + list);
	
								insertDataIntoTable(list); // 테이블에 데이터를 삽입하는 함수 호출
					        })
					        .catch((error) => {
					          console.log('fail..', error);
					        });
					    });