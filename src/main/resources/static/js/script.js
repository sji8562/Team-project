function Postcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가짐
      var addr = ""; // 주소 변수
      var extraAddr = ""; // 상세주소 변수

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === "R") {
        // 사용자가 도로명 주소를 선택했을 경우
        addr = data.roadAddress;
      } else {
        // 사용자가 지번 주소를 선택했을 경우
        addr = data.jibunAddress;
      }

      // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
      if (data.userSelectedType === "R") {
        // 법정동명이 있을 경우 추가하는 코드 - 법정동명의 경우 마지막 문자가 "동/로/가"로 끝난다.
        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        // 건물명이 있고, 공동주택일 경우 추가하는 코드
        if (data.buildingName !== "" && data.apartment === "Y") {
          extraAddr +=
            extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
        }
        // 표시할 상세주소가 있을 경우 추가하는 코드
        if (extraAddr !== "") {
          extraAddr = " (" + extraAddr + ")";
        }
        // 조합된 상세주소를 address에 넣는다
        document.getElementById("addressDetail").value = extraAddr;
      } else {
        document.getElementById("addressDetail").value = "";
      }

      // 우편번호와 주소 정보를 주소칸에 넣는다.
      document.getElementById("address").value = addr;
      // 커서를 상세주소 필드로 이동한다.
      document.getElementById("addressDetail").focus();
    },
  }).open();
}

async function check() {
  let username = document.querySelector("#userId").value;

  let response = await fetch(`/url 넣는 자리/?userId=${userId}`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
    },
  });

  let responseBody = await response.json();
  if (responseBody.success) {
    alert(responseBody.data);
  } else {
    alert(responseBody.data);
  }
}

function pwcheck() {
  let regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{8,16}$/;
  let pwcheck = document.getElementById("pwcheck");
  let pw = document.getElementById("pwd").value;
  pwcheck.style.color = "black";

  if (!regex.test(pw)) {
    pwcheck.style.color = "red";
  } else {
    pwcheck.style.color = "black";
  }
}
function isSame() {
  var pw = document.getElementById("pwd").value;
  var pwcheck = document.getElementById("pwdchk").value;

  if (pw != pwcheck) {
    document.getElementById("same").innerHTML = "비밀번호가 일치하지 않습니다";
    document.getElementById("same").style.color = "red";
  } else {
    document.getElementById("same").innerHTML = "비밀번호가 일치합니다";
    document.getElementById("same").style.color = "blue";
  }
}
//sessiouUserId 나중에 넣어줘야함
async function saveSkills() {
  let requestBody = {
    skill: document.querySelector("#skill").value,
  };

  let response = await fetch("/api/skills/save", {
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestBody),
  });
}
$(function () {
  $("#slider-div").slick({
    slide: "div", //슬라이드 되어야 할 태그 ex) div, li
    infinite: true, //무한 반복 옵션
    slidesToShow: 4, // 한 화면에 보여질 컨텐츠 개수
    slidesToScroll: 1, //스크롤 한번에 움직일 컨텐츠 개수
    speed: 1000, // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
    arrows: true, // 옆으로 이동하는 화살표 표시 여부
    dots: false, // 스크롤바 아래 점으로 페이지네이션 여부
    autoplay: true, // 자동 스크롤 사용 여부
    autoplaySpeed: 5000, // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
    pauseOnHover: true, // 슬라이드 이동    시 마우스 호버하면 슬라이더 멈추게 설정
    vertical: false, // 세로 방향 슬라이드 옵션
    prevArrow: $(".prev"), // 이전 화살표 모양 설정
    nextArrow: $(".next"), // 다음 화살표 모양 설정
    dotsClass: "slick-dots", //아래 나오는 페이지네이션(점) css class 지정
    draggable: true, //드래그 가능 여부

    responsive: [
      // 반응형 웹 구x현 옵션
      {
        breakpoint: 960, //화면 사이즈 960px
        settings: {
          //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 768, //화면 사이즈 768px
        settings: {
          //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
          slidesToShow: 1,
        },
      },
    ],
  });
});

$(function () {
  $("#ann-div").slick({
    slide: "div", //슬라이드 되어야 할 태그 ex) div, li
    infinite: true, //무한 반복 옵션
    slidesToShow: 4, // 한 화면에 보여질 컨텐츠 개수
    slidesToScroll: 1, //스크롤 한번에 움직일 컨텐츠 개수
    speed: 1000, // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
    arrows: true, // 옆으로 이동하는 화살표 표시 여부
    dots: false, // 스크롤바 아래 점으로 페이지네이션 여부
    autoplay: true, // 자동 스크롤 사용 여부
    autoplaySpeed: 5000, // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
    pauseOnHover: true, // 슬라이드 이동    시 마우스 호버하면 슬라이더 멈추게 설정
    vertical: false, // 세로 방향 슬라이드 옵션
    prevArrow: $(".ann-prev"), // 이전 화살표 모양 설정
    nextArrow: $(".ann-next"), // 다음 화살표 모양 설정
    dotsClass: "slick-dots", //아래 나오는 페이지네이션(점) css class 지정
    draggable: true, //드래그 가능 여부

    responsive: [
      // 반응형 웹 구x현 옵션
      {
        breakpoint: 960, //화면 사이즈 960px
        settings: {
          //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 768, //화면 사이즈 768px
        settings: {
          //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
          slidesToShow: 1,
        },
      },
    ],
  });
});

$(function () {
  $("#comp-div").slick({
    slide: "div", //슬라이드 되어야 할 태그 ex) div, li
    infinite: true, //무한 반복 옵션
    slidesToShow: 4, // 한 화면에 보여질 컨텐츠 개수
    slidesToScroll: 1, //스크롤 한번에 움직일 컨텐츠 개수
    speed: 1000, // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
    arrows: true, // 옆으로 이동하는 화살표 표시 여부
    dots: false, // 스크롤바 아래 점으로 페이지네이션 여부
    autoplay: true, // 자동 스크롤 사용 여부
    autoplaySpeed: 5000, // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
    pauseOnHover: true, // 슬라이드 이동    시 마우스 호버하면 슬라이더 멈추게 설정
    vertical: false, // 세로 방향 슬라이드 옵션
    prevArrow: $(".comp-prev"), // 이전 화살표 모양 설정
    nextArrow: $(".comp-next"), // 다음 화살표 모양 설정
    dotsClass: "slick-dots", //아래 나오는 페이지네이션(점) css class 지정
    draggable: true, //드래그 가능 여부

    responsive: [
      // 반응형 웹 구x현 옵션
      {
        breakpoint: 960, //화면 사이즈 960px
        settings: {
          //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
          slidesToShow: 2,
        },
      },
      {
        breakpoint: 768, //화면 사이즈 768px
        settings: {
          //위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
          slidesToShow: 1,
        },
      },
    ],
  });
});

function loginWithKakao() {
  Kakao.Auth.authorize({
    redirectUri: "https://developers.kakao.com/tool/demo/oauth",
  });
}

// 아래는 데모를 위한 UI 코드입니다.
displayToken();
function displayToken() {
  var token = getCookie("authorize-access-token");

  if (token) {
    Kakao.Auth.setAccessToken(token);
    Kakao.Auth.getStatusInfo()
      .then(function (res) {
        if (res.status === "connected") {
          document.getElementById("token-result").innerText =
            "login success, token: " + Kakao.Auth.getAccessToken();
        }
      })
      .catch(function (err) {
        Kakao.Auth.setAccessToken(null);
      });
  }
}

function getCookie(name) {
  var parts = document.cookie.split(name + "=");
  if (parts.length === 2) {
    return parts[1].split(";")[0];
  }
  $(document).ready(function () {
    $(".dropdown-submenu").hover(
      function () {
        $(this).find(".dropdown-menu").addClass("show");
      },
      function () {
        $(this).find(".dropdown-menu").removeClass("show");
      }
    );
  });
}
// skill
//   $(document).ready(function () {
//     // 페이지 로드 시 모든 체크박스 컨테이너를 숨깁니다.
//     // $(".row > div").hide();

//     $(".class-select").click(function () {
//       var selectedClass = $(this).data("class");

//       // 모든 체크박스 컨테이너를 숨깁니다.
//       $(".row > div").hide();

//       // 선택된 클래스의 체크박스 컨테이너만 보이도록 합니다.
//       $(".리스트" + selectedClass).show();
//     });
//   });
// }

// nav

$(document).ready(function () {
  // let companyIdSameCheck = false;

  // function companyIdChange() {
  //   console.log("변경됨");
  //   usernameSameCheck = false;
  // }

  // function companyValid() {
  //   if (companyIdSameCheck) {
  //     return true;
  //   } else {
  //     alert("유저네임 중복체크를 해주세요");
  //     return false;
  //   }
  // }

  // // 책임 : input태그로 부터 company을 가져와서 통신을 요청하고, 중복이 되었는지 확인한다.
  // async function companyCheckin() {
  //   // 1. DOM으로 부터 값 가져오기
  //   let companyId = document.querySelector("#companyId").value;
  //   console.log("유저네임", userId);
  //   // 2. 통신하기
  //   let response = await fetch(`/check?companyId=${companyId}`);
  //   // 3. 파싱하기
  //   let responseBody = await response.text(); // response.json();
  //   console.log(responseBody);

  //   let btnJoin = document.querySelector("#btnJoin");
  //   if (response.status == 200) {
  //     alert(responseBody);
  //     companyIdSameCheck = true;
  //   } else {
  //     alert(responseBody);
  //     companyIdSameCheck = false;
  //   }
  // }

  let modelResult = document.getElementById("status").value;
  let buttons = document.querySelectorAll(".apply_stsboard button");

  // 버튼을 활성화 또는 비활성화하는 함수

  function setActiveButton(result) {
    document.getElementById("accepted").hidden = result !== "1";
    document.getElementById("denied").hidden = result !== "2";
    document.getElementById("hold").hidden = result !== "3";
  }

  setActiveButton(modelResult);

  $(".dropdown-submenu").hover(
    function () {
      $(this).find(".dropdown-menu").addClass("show");
    },
    function () {
      $(this).find(".dropdown-menu").removeClass("show");
    }
  );
});

// skill
//   $(document).ready(function () {
//     // 페이지 로드 시 모든 체크박스 컨테이너를 숨깁니다.
//     // $(".row > div").hide();

//     $(".class-select").click(function () {
//       var selectedClass = $(this).data("class");

//       // 모든 체크박스 컨테이너를 숨깁니다.
//       $(".row > div").hide();

//       // 선택된 클래스의 체크박스 컨테이너만 보이도록 합니다.
//       $(".리스트" + selectedClass).show();
//     });
//   });
// }

// nav

$(document).ready(function () {
  let companyIdSameCheck = false;

  function companyIdChange() {
    console.log("변경됨");
    usernameSameCheck = false;
  }

  function companyValid() {
    if (companyIdSameCheck) {
      return true;
    } else {
      alert("유저네임 중복체크를 해주세요");
      return false;
    }
  }

  // 책임 : input태그로 부터 username을 가져와서 통신을 요청하고, 중복이 되었는지 확인한다.
  async function companyCheckin() {
    // 1. DOM으로 부터 값 가져오기
    let companyId = document.querySelector("#companyId").value;
    console.log("유저네임", userId);
    // 2. 통신하기
    let response = await fetch(`/check?companyId=${companyId}`);
    // 3. 파싱하기
    let responseBody = await response.text(); // response.json();
    console.log(responseBody);

    let btnJoin = document.querySelector("#btnJoin");
    if (response.status == 200) {
      alert(responseBody);
      companyIdSameCheck = true;
    } else {
      alert(responseBody);
      companyIdSameCheck = false;
    }
  }

  let usernameSameCheck = false;

  function usernameChange() {
    console.log("변경됨");
    usernameSameCheck = false;
  }

  function userValid() {
    if (usernameSameCheck) {
      return true;
    } else {
      alert("유저네임 중복체크를 해주세요");
      return false;
    }
  }

  // 책임 : input태그로 부터 username을 가져와서 통신을 요청하고, 중복이 되었는지 확인한다.
  async function userCheckin() {
    // 1. DOM으로 부터 값 가져오기
    let userId = document.querySelector("#userId").value;
    console.log("유저네임", userId);
    // 2. 통신하기
    let response = await fetch(`/check?userId=${userId}`);
    // 3. 파싱하기
    let responseBody = await response.text(); // response.json();
    console.log(responseBody);

    let btnJoin = document.querySelector("#btnJoin");
    if (response.status == 200) {
      alert(responseBody);
      usernameSameCheck = true;
    } else {
      alert(responseBody);
      usernameSameCheck = false;
    }
  }

  $(".dropdown-submenu").hover(
    function () {
      $(this).find(".dropdown-menu").addClass("show");
    },
    function () {
      $(this).find(".dropdown-menu").removeClass("show");
    }
  );

  $(".toggle-orange").click(function () {
    if ($(this).hasClass("orange")) {
      // The element has the "orange" class, so it's currently bookmarked
      // Perform bookmark deletion here
      const annIdx = $("#annIndex").val();
      const userIdx = $("#userIndex").val();
      deleteUserBookmark(annIdx, userIdx);
    } else {
      // The element does not have the "orange" class, so it's not bookmarked
      // Perform bookmark saving here
      bookmarkuserSave();
    }
    // Toggle the "orange" class
    $(this).toggleClass("orange");
  });

  $(".toggle-orange1").click(function () {
    if ($(this).hasClass("orange")) {
      // The element has the "orange" class, so it's currently bookmarked
      // Perform bookmark deletion here
      const resumeIdx = $("#resumeIndex").val();
      const companyIdx = $("#companyIndex").val();
      deleteCompanyBookmark(resumeIdx, companyIdx);
    } else {
      // The element does not have the "orange" class, so it's not bookmarked
      // Perform bookmark saving here
      bookmarkcompanySave();
    }
    // Toggle the "orange" class
    $(this).toggleClass("orange");
  });
});

async function deleteReply(id) {
  let response = await fetch(`/api/reply/${id}/delete`, {
    method: "delete",
  });
  let responseBody = await response.json();
  if (responseBody.sucuess) {
    location.reload();
  } else {
    alert(responseBody.data);
  }
}

async function saveReply() {
  let requestBody = {
    boardId: document.querySelector("#boardId").value,
    comment: document.querySelector("#comment").value,
  };

  console.log(requestBody);

  let response = await fetch("/api/reply/save", {
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestBody),
  });

  let responseBody = await response.json();
  console.log(responseBody);

  if (responseBody.sucuess) {
    location.reload();
  } else {
    alert(responseBody.data);
  }
}
document
  .getElementById("bigJobMenu")
  .addEventListener("click", function (event) {
    var clickedItem = event.target.innerText;
    if (clickedItem === "A") {
      // 'A'를 클릭한 경우 '스몰잡' 드롭다운 메뉴 변경
      document.getElementById("smallJobButton").innerText = "스몰잡 (A 선택)";
      document.getElementById("smallJobButton").disabled = false;
      document.getElementById("smallJobMenu").innerHTML =
        '<a href="#">a</a><a href="#">b</a><a href="#">c</a>';
    } else if (clickedItem === "B") {
      // 'B'를 클릭한 경우 '스몰잡' 드롭다운 메뉴 변경
      document.getElementById("smallJobButton").innerText = "스몰잡 (B 선택)";
      document.getElementById("smallJobButton").disabled = false;
      document.getElementById("smallJobMenu").innerHTML =
        '<a href="#">d</a><a href="#">e</a><a href="#">f</a>';
    }
  });

// JavaScript로 '스몰잡' 메뉴 항목 클릭 이벤트 처리
document
  .getElementById("smallJobMenu")
  .addEventListener("click", function (event) {
    event.stopPropagation(); // 부모 요소로의 이벤트 전파 방지
  });

async function bookmarkuserSave() {
  let requestBody = {
    userIdx: document.querySelector("#userIndex").value,
    annIdx: document.querySelector("#annIndex").value,
    compIdx: document.querySelector("#compIndex").value,
  };
  try {
    let response = await fetch("/api/userScrap/save", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestBody),
    });

    let responseBody = await response.json();
    console.log(responseBody);

    if (responseBody.success) {
      location.reload();
    } else {
      alert(responseBody.data);
      console.log(responseBody.data);
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

async function bookmarkcompanySave() {
  let requestBody = {
    resumeIdx: document.querySelector("#resumeIndex").value,
    compIdx: document.querySelector("#companyIndex").value,
  };
  console.log(requestBody);
  try {
    let response = await fetch("/api/CompanyScrap/save", {
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestBody),
    });

    let responseBody = await response.json();
    console.log(responseBody);

    if (responseBody.success) {
      location.reload();
    } else {
      alert(responseBody.data);
      console.log(responseBody.data);
    }
  } catch (error) {
    console.error("An error occurred:", error);
  }
}

async function deleteUserBookmark(annIdx, userIdx) {
  try {
    let response = await fetch(
      `/api/userScrap/delete?annIdx=${annIdx}&userIdx=${userIdx}`,
      {
        method: "DELETE",
      }
    );

    if (response.ok) {
      alert("북마크 삭제");
    } else {
      // Handle the case where bookmark deletion failed
      console.error("Bookmark deletion failed.");
    }
  } catch (error) {
    console.error("An error occurred while deleting the bookmark:", error);
  }
}

async function deleteCompanyBookmark(resumeIndex, companyIndex) {
  try {
    let response = await fetch(
      `/api/companyScrap/delete?resumeIdx=${resumeIndex}&compIdx=${companyIndex}`,
      {
        method: "DELETE",
      }
    );

    if (response.ok) {
      // Bookmark successfully deleted
      // Update your UI to reflect the change
    } else {
      // Handle the case where bookmark deletion failed
      console.error("Bookmark deletion failed.");
    }
  } catch (error) {
    console.error("An error occurred while deleting the bookmark:", error);
  }
}

function changePic(e1) {
  let f = e1.srcElement.files[0];
  console.log(f.type);

  let fileMessage = document.getElementById("fileMessage");

  if (!f) {
    fileMessage.textContent = "이미지를 등록해주세요";
    return;
  }

  if (!f.type.match("image.*")) {
    alert("이미지를 등록해주세요");
    fileMessage.textContent = "이미지를 등록해주세요";
    return;
  }

  let reader = new FileReader();
  reader.onload = function (e2) {
    let previewEl = document.querySelector("#preview");
    previewEl.setAttribute("src", e2.target.result);
  };
  reader.readAsDataURL(f);
}

async function resList() {
  let response = await fetch(`/api/applyRes`);
  let resume = await response.json();
  modalBody = document.querySelector(".modal-body");
  modalHeader = document.querySelector(".modal-header");
  modalHeader.innerHTML = "내 이력서 목록";
  modalBody.innerHTML = "";

  if (resume.length === 0) {
    alert(
      "이력서가 없으면 공고에 지원할 수 없습니다. 이력서를 먼저 작성해주세요"
    );
    modalBody.innerHTML = "내 이력서가 없습니다.";
  } else {
    modalBody = document.querySelector(".modal-body");
    resume.forEach((resume, index) => {
      const resumeItem = document.createElement("div");
      resumeItem.classList.add("resume-item"); // 필요에 따라 CSS 클래스를 추가할 수 있습니다.

      // 제목을 표시하는 요소 (예시로 h3 사용)
      const titleElement = document.createElement("button");
      titleElement.innerHTML = resume.title;
      titleElement.addEventListener("click", () => {
        applyInsert(resume);
      });

      // 모달 바디에 추가
      resumeItem.appendChild(titleElement);
      modalBody.appendChild(resumeItem);
    });
  }
}

async function applyInsert(resume) {
  let ann = document.getElementById("annId").value;
  let requestBody = {
    annId: ann,
    resume: resume,
  };
  console.log(requestBody);

  let response = await fetch("/api/apply/save", {
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(requestBody),
  });

  let responseBody = await response.json();
  alert(responseBody.data);
}

let usernameSameCheck = false;

function usernameChange() {
  console.log("변경됨");
  usernameSameCheck = false;
}

function userValid() {
  if (usernameSameCheck) {
    return true;
  } else {
    alert("유저네임 중복체크를 해주세요");
    return false;
  }
}

// 책임 : input태그로 부터 username을 가져와서 통신을 요청하고, 중복이 되었는지 확인한다.
async function userCheckin() {
  // 1. DOM으로 부터 값 가져오기
  let userId = document.querySelector("#userId").value;
  console.log("유저네임", userId);
  // 2. 통신하기
  let response = await fetch(`/check?userId=${userId}`);
  // 3. 파싱하기
  let responseBody = await response.text(); // response.json();
  console.log(responseBody);

  let btnJoin = document.querySelector("#btnJoin");
  if (response.status == 200) {
    alert(responseBody);
    usernameSameCheck = true;
  } else {
    alert(responseBody);
    usernameSameCheck = false;
  }
}
