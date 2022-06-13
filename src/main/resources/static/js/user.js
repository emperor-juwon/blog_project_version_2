$("#btn-join").click(()=>{
    join();
});

$("#btn-login").click(()=>{
    login();
});

function usernameRemember() {
    let cookies = document.cookie.split("=");

    $("#username").val(cookies[1]);
}

usernameRemember();

async function join(){

    let userDto = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            addr: $("#addr").val()
        }

        let response = await fetch("/join",{
            method: "POST",
            body: JSON.stringify(userDto), 
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        });
        let responseParse = await response.json();

        if (responseParse.code == 1) {
            alert("회원가입에 성공하였습니다.");
            location.href = "/loginForm";
        } else {
            alert("회원가입에 실패하였습니다");
        }
}


async function login(){

    let checked = $("#remember").is(':checked');

  let loginDto = {
            username: $("#username").val(),
            password: $("#password").val(),
            remember: checked ?"on":"off"
        }

        let response = await fetch("/login",{
            method: "POST",
            body: JSON.stringify(loginDto), 
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        });

        let responseParse = await response.json();

         if (responseParse.code == 1) {
            alert("로그인에 성공하였습니다.");
            location.href = "/";
        } else {
            alert("로그인에 실패하였습니다");
        }
} 
    
