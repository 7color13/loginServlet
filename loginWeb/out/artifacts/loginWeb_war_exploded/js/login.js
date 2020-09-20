
function changeCode() {
    var codeImg = document.getElementById("verifyCode");
//这里URL后追加随机数，使程序每次访问的都是不同的资源，防止浏览器缓存，即产生不同的验证码
    codeImg.src = "servlet/CreateVerifyCodeImage?t=" + Math.random();
}
