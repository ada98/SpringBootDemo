//页面初始化变量
var nickFalg=true;
var uinFalg=true;
var pwdFalg=true;
var telFalg=true;
//页面初始化绑定方法
$(function () {
    /* 昵称校验*/
    $('#nick').bind('input oninput', function() {
        checkNick(this.value);
    });
    $('#uin').bind('input oninput', function() {
        checkUin(this.value);
    });
    $('#pwd').bind('input oninput', function() {
        checkPwd(this.value);
    });
    $('#tel').bind('input oninput', function() {
        checkTel(this.value);
    });
    $('#registerForm').bind('submit', function() {
        return check();
    });

});
//校验
function check() {
    var checkFalg=true;
    if($('#nick').val()=="" || $('#uin').val()=="" || $('#pwd').val()=="" || $('#tel').val()==""){
        if(!nickFalg){
            checkFalg=false;
            checkNick($('#nick').val());
        }
        if(!uinFalg){
            checkFalg=false;
            checkUin($('#uin').val());
        }
        if(!pwdFalg){
            checkFalg=false;
            checkPwd($('#pwd').val());
        }
        if(!telFalg){
            checkFalg=false;
            checkTel($('#tel').val());
        }
    }else{
        checkFalg=false;
    }
    return checkFalg;
}

/**
 * 校验昵称
 * @param nick
 */
function checkNick(nick){
    nickFalg=true;
    $(".nickArea .inputstyle").removeClass("inputNo");
    $(".nickArea .input_tips").css("display","none");
    $('.nickArea .msg-tips').removeClass('ok');
    $('.nickArea .input-ok').css('display','none');
    if(nick==""){
        $(".nickArea .input_tips").css("display","block");
        nickFalg=false;
    }
    //昵称带空格为空
    if(nick.indexOf(" ") != -1){
        $('.nickArea .msg-tips').eq(0).addClass('ok');
        nickFalg=false;
    }
    if(nick.length>9 || nick.length<2){
        $('.nickArea .msg-tips').eq(1).addClass('ok');
        nickFalg=false;
    }
    if(nickFalg){
        reqCheckNick(nick);
    }else{
        $(".nickArea .inputstyle").addClass("inputNo");
    }
    return nickFalg;
}


/**
 * 请求后台，用户名是否存在
 */
function reqCheckNick(nick){
    var result=false;
    $.ajax({
        type: "get",
        url: "web/user/checkNick/"+nick,
        dataType: "text",
        success:function (data) {
            if(data=='200'){
                nickFalg=true;
                $('.nickArea .input-ok').css('display','block');//校验通过
            }else if(data=='201'){
                //重复
                $('.nickArea .msg-tips').eq(2).addClass('ok');
                $(".nickArea .inputstyle").addClass("inputNo");
                nickFalg=false;
            }
        }
    });
}

/**
 * 校验账号
 */
function checkUin(uin){
    uinFalg=true;
    $(".uinArea .inputstyle").removeClass("inputNo");
    $(".uinArea .input_tips").css("display","none");
    $('.uinArea .msg-tips').removeClass('ok');
    $('.uinArea .input-ok').css('display','none');
    if(uin==""){
        $(".uinArea .input_tips").css("display","block");
        uinFalg=false;
    }
    //带空格
    if(uin.indexOf(" ") != -1){
        $('.uinArea .msg-tips').eq(0).addClass('ok');
        uinFalg=false;
    }
    if(uin.length>12 || uin.length<4 ){
        $('.uinArea .msg-tips').eq(1).addClass('ok');
        uinFalg=false;
    }
    if(uinFalg){
        reqCheckUin(uin);
    }else{
        $(".uinArea .inputstyle").addClass("inputNo");
    }
    return uinFalg;
}
/**
 * 请求后台，账号是否可用
 */
function reqCheckUin(uin){
    $.ajax({
        type: "get",
        url: "web/user/checkUin/"+uin,
        dataType: "text",
        success:function (data) {
            if(data=='200'){
                uinFalg=true;
                $('.uinArea .input-ok').css('display','block');//校验通过
            }else if(data=='201'){
                //重复
                $('.uinArea .msg-tips').eq(2).addClass('ok');
                $(".uinArea .inputstyle").addClass("inputNo");
                uinFalg=false;
            }
        }
    });
}

/**
 * 校验密码
 */
function checkPwd(pwd){
    pwdFalg=true;
    $(".pwdArea .inputstyle").removeClass("inputNo");
    $(".pwdArea .input_tips").css("display","none");
    $('.pwdArea .msg-tips').removeClass('ok');
    $('.pwdArea .input-ok').css('display','none');
    if(pwd==""){
        $(".pwdArea .input_tips").css("display","block");
        pwdFalg=false;
    }
    //带空格
    if(pwd.indexOf(" ") != -1){
        $('.pwdArea .msg-tips').eq(0).addClass('ok');
        pwdFalg=false;
    }
    if(pwd.length>16 || pwd.length<8 ){
        $('.pwdArea .msg-tips').eq(1).addClass('ok');
        pwdFalg=false;
    }
    var patt=/^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)])+$).{1,}$/;
    if(!patt.test(pwd)){
        $('.pwdArea .msg-tips').eq(2).addClass('ok');
        pwdFalg=false;
    }
    if(pwdFalg){
        $('.pwdArea .input-ok').css('display','block');//校验通过
    }else{
        $(".pwdArea .inputstyle").addClass("inputNo");
    }
    return pwdFalg;
}

/**
 * 校验手机号码
 * @param tel
 * @returns {boolean}
 */
function checkTel(tel){
    telFalg=true;
    $(".telArea .inputstyle").removeClass("inputNo");
    $(".telArea .input_tips").css("display","none");
    $('.telArea .msg-tips').removeClass('ok');
    $('.telArea .input-ok').css('display','none');
    if(tel==""){
        $(".telArea .input_tips").css("display","block");
        telFalg=false;
    }
    var patt=/^((13[0-9])|(17[0-1,6-8])|(15[^4,\\D])|(18[0-9]))\d{8}$/;
    if(!patt.test(tel)){
        $('.telArea .msg-tips').eq(0).addClass('ok');
        telFalg=false;
    }
    if(telFalg){
        $('.telArea .input-ok').css('display','block');//校验通过
    }else{
        $(".telArea .inputstyle").addClass("inputNo");
    }
    return telFalg;
}