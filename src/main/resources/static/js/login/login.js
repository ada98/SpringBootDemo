$(function () {
    reloadCode();
    //绑定组件事件
    $('#p').bind('input oninput', function() {
        $("#pwd_tips").css("display","none");
        if(this.value==""){
            $("#pwd_tips").css("display","block");
        }
    });
    $('#u').bind('input oninput', function() {
        $("#uin_tips").css("display","none");
        if(this.value==""){
            $("#uin_tips").css("display","block");
        }
    });
    $('#verifycode').bind('input oninput', function() {
        $("#vc_tips").css("display","none");
        if(this.value==""){
            $("#vc_tips").css("display","block");
        }
    });
    $("#verifyimgA").bind('click',function () {
        reloadCode();
    });
    $("#login_register").bind('click',function () {
        //跳转至注册界面
        window.open("/toRegister");
    });
    //登录
    $("#msgInfo").html(msgInfo);
});

/**
 * 请求二维码
 */
function reloadCode() {
    document.getElementById("verifyimg").src="../login/getSecurityCode?r=" + new Date().getTime();
    //这里为什么会加一个时间戳参数呢？  浏览器带有缓存功能
}