var baseUrl = "http://localhost:8080/api/v1/auth";

function handleLogin() {
    // lấy username + password
    var inputUsername = $("#inputUsername").val();
    var inputPassword = $("#inputPassword").val();

    // call api login
    $.ajax({
        type: "GET",
        url: baseUrl + "/login",
        dataType: "JSON",
        beforeSend: function (xhr) {
            xhr.setRequestHeader(
                "Authorization",
                "Basic " + btoa(`${inputUsername}:${inputPassword}`),
            );
        },
        success: function (response) {
            var acc = {
                username: inputUsername,
                password: inputPassword,
            };
            localStorage.setItem("loginInfor", JSON.stringify(acc));
            alert("Đăng nhập thành công");
            window.open("./index.html", "_self");
        },
        error: function (error) {
            alert("Sai thông tin đăng nhập");
        },
    });
}
