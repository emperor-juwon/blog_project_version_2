$("#btn-logout").click(() => {
    logout();
});

async function logout() {
    let response = await fetch("/logout");
     let responseParse = await response.json();
    
    if (responseParse.code == 1) {
        location.href = "/";
    }
}