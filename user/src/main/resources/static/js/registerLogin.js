let confirmCode = "";
//test the correction of the format of the mail address
let reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
let flag = false;

function sendMail() {
    confirmCode = "";
    if(flag){
        swal("获取验证码失败","获取频繁，请稍后再试","error");
        return;
    }
    let customerMail = document.getElementById("customerMail").value;
    if(customerMail === ""){
        alert("请输入您的邮箱!");
        return;
    }else if(!reg.test(customerMail)){
        alert("邮箱格式不正确，请重新输入!");
        return;
    }
    flag = true;
    $.ajax({
        type: "POST",
        url: "/registerLogin/sendMail",
        data: {
            customerMail : customerMail
        },
        success: function (result) {
            if(result.length === 6)
                confirmCode = result;
            else
                alert("该邮箱已被注册，请输入另一个邮箱!");
            flag = false;
        },
        error: function () {
            alert("sendMail : error!");
            flag = false;
        }
    });
}

function customerRegister() {
    let customerMail = document.getElementById("customerMail").value;
    let customerPassword = document.getElementById("customerPassword").value;
    let repeatPassword = document.getElementById("customerPasswordConfirm").value;
    let customerName = document.getElementById("customerName").value;
    let phoneNumber = document.getElementById("phoneNumber").value;

    if(customerMail === "" || customerPassword === "" || repeatPassword === "" ||
        customerName === "" || phoneNumber === ""){
        alert("请将注册信息填写完整!");
        return;
    }else if(customerPassword !== repeatPassword){
        alert("两次密码输入不一致!");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/registerLogin/customerRegister",
        data: {
            customerMail : customerMail,
            customerPassword : customerPassword,
            customerName : customerName,
            phoneNumber : phoneNumber
        },
        success: function (result) {
            if(result){
                swal({
                    title: "注册成功",
                    text: "欢迎使用本系统！",
                    type: "success"
                },function () {
                    window.location.href = "/login";
                    window.event.returnValue=false;
                });
            }
            else
                alert("注册失败!");
        },
        error: function () {
            alert("register : error!");
        }
    });
}

function login() {
    let account = document.getElementById("customerMail").value;
    let password = document.getElementById("customerPassword").value;
    let info = new User(account, password);
    $.ajax({
        type: "POST",
        url: "/user/user/login",
        contentType: "application/json",
        data: JSON.stringify(info),
        success: function (result) {
            if(result.responseCode === ResponseCode.RESPONSE_OK){
                swal({
                    title: "登录成功",
                    text: "亲爱的用户，欢迎您！",
                    type: "success"
                },function () {

                });
            }
            else
                swal("登录失败", "账号或者密码错误！", "error");
        },
        error: function () {
            alert("login : error!");
        }
    });
}

function logout() {
    $.ajax({
        type: "POST",
        url: "/registerLogin/logout",
        data: {},
        success: function (result) {
            if(result){
                swal({
                    title: "登出成功",
                    text: "欢迎再次使用本系统！",
                    type: "success"
                },function () {
                    window.location.href = "/login";
                    window.event.returnValue=false;
                });
            }else
                swal("登出失败", "登出失败！", "error");
        },
        error: function () {
            alert("login : error!");
        }
    });
}