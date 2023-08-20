/**
 * 
 */
	const baseURL = "http://localhost:8080/app";
	let pagePath = null;
	let fullURL = null;
	let shoppingBtn = document.getElementById("shopping");
	const ed_btn = document.querySelector(".edit");
	const login_btn = document.getElementById("login-button");

console.log("ROLE: " , userRole);
	
const logo_btn = document.getElementById("logo");
logo_btn.addEventListener("click",function(){

	pagePath = "/Main.jsp"
	fullURL = baseURL + pagePath;
	
	location.href = fullURL;
});

function handleLoginLogout() {
  const loginButton = document.getElementById("login-button");

  // 숨겨진 input 필드에서 현재 ROLE 값을 가져옵니다.
  

 if (loginButton.textContent === 'login') {
    // 로그인 폼을 불러오는 요청 보내기
    axios.get("/app/member/auth/Login")
      .then(response => {
        if (response.status === 200) {
          // 로그인 폼을 페이지에 추가하거나 모달로 표시하는 등의 처리
          // response.data를 활용하여 로그인 폼을 조작
          window.location.href = response.data.redirectUrl;
        }
      })
      .catch(error => {
        console.error('Error:', error);
      });
 	 } else {
    // 로그아웃 처리 로직
    axios.post("/app/logout")
      .then(response => {
        if (response.status === 200) {
          // 세션 정보를 지웁니다.
          // ...

          // 로그인 아이콘으로 변경
          loginButton.textContent = 'login';
        }
      })
      .catch(error => {
        console.error('Logout error:', error);
      });
  }
}


/* function handleLoginLogout() {
  const loginButton = document.getElementById("login-button");

  // 숨겨진 input 필드에서 현재 ROLE 값을 가져옵니다.
  

  if (userRole === 'ROLE_Admin' || userRole === 'ROLE_User') {
    // 사용자가 로그인한 경우 로그아웃 처리를 위해 /Logout.do로 Ajax 요청을 보냅니다.
    axios.post("/app/logout")
      .then(response => {
        if (response.status === 200) {
          // 세션 정보를 지웁니다.
         
          loginButton.textContent = 'login'; // 로그인 아이콘으로 변경합니다.
        }
      })
      .catch(error => {
        console.error('Logout error:', error);
      });
  } else {
    // 사용자가 로그인하지 않은 경우, 로그인 페이지로 이동하도록 구현하면 됩니다.
    // 예시로 주석 처리하였습니다.
    axios.get("/customLogin")
      .then(response => {
        if (response.status === 200) {
          // 로그인 페이지로 이동한 후 처리할 내용을 작성하세요.
          // 예를 들어, 리다이렉트 처리 등
          window.location.href = response.data.redirectUrl; // 예시 코드, 실제 응답 데이터에 따라 처리
        }
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }
}*/

document.addEventListener('DOMContentLoaded', () => {
  if (userRole === 'ROLE_Admin' || userRole ==='ROLE_User') {
    login_btn.textContent = 'logout';
  } else {
    login_btn.textContent = 'login';
  }
  login_btn.addEventListener('click', handleLoginLogout);
});


  
/*  // 로그인 버튼 클릭 이벤트 핸들러
  login_btn.addEventListener("click", function() {
   
   axios.get("/customLogin")
      .then(response => {
        if (response.status === 200) {
          // 세션 정보를 지웁니다.
         
          loginButton.textContent = 'login'; // 로그인 아이콘으로 변경합니다.
        }
      })
      .catch(error => {
        console.error('Logout error:', error);
      });
    // 로그인 버튼 클릭 시 로그인 페이지로 이동
	pagePath = "/member/auth/Login"
	fullURL = baseURL + pagePath;
	
	location.href = fullURL;
  });
  */
shoppingBtn.addEventListener("click", function() {
    if (userRole === "ROLE_Admin") {
 
        axios.get("/app/order/ShoppingBasket_Admin")
			.then(response => {
        if (response.status === 200) {
          // 로그인 페이지로 이동한 후 처리할 내용을 작성하세요.
          // 예를 들어, 리다이렉트 처리 등
          window.location.href ="/app/order/ShoppingBasket_Admin"; // 예시 코드, 실제 응답 데이터에 따라 처리
        }
      })
      .catch(error => {
        console.error('Error:', error);
      });
  }
     else if (userRole === "ROLE_User") {
         axios.get("/app/order/ShoppingBasket_user")
			.then(response => {
        if (response.status === 200) {
          // 로그인 페이지로 이동한 후 처리할 내용을 작성하세요.
          // 예를 들어, 리다이렉트 처리 등
          window.location.href ="/app/order/ShoppingBasket_user"; // 예시 코드, 실제 응답 데이터에 따라 처리
        }
      })
      .catch(error => {
        console.error('Error:', error);
      });
    } else {
   	 alert("잘못된 접근입니다.");
    };
    });

ed_btn.addEventListener("click",function(){
			 axios.get("/app/order/ShoppingBasket_Admin2")
			.then(response => {
        if (response.status === 200) {
          // 로그인 페이지로 이동한 후 처리할 내용을 작성하세요.
          // 예를 들어, 리다이렉트 처리 등
          window.location.href ="/app/order/ShoppingBasket_Admin2"; // 예시 코드, 실제 응답 데이터에 따라 처리
        }
      })
      .catch(error => {
        console.error('Error:', error);
      });
      });
    
    