/**
 *  作者:小宝
 *  时间:2018-07-15
 *  登录
 */

function login() {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
        url: contextPath + "/Login",
        method: "post",
        data: {
            username: username,
            password: password,
            action: "login"
        },
        success: function (jsonStr) {
            var result = eval("(" + jsonStr + ")");
            if (result.status == "1") {
                window.location.href = contextPath + "/Home?action=index";
            } else {
                $("#username").val("");
                $("#password").val("");
                showMessage(result.message);
            }
        }
    })
}