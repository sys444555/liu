$("#btn-login").click(function () {
    var forData = $("#form-login").serialize();
    forData = decodeURIComponent(forData, true);
    console.log($("#username").val());
    var token=getCookie("token");
    console.log(token)
    $.ajax({
        url: "../login",
        data: forData,
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        success: function (json) {
            console.log(json);

            if (json.code == 200) {

                setCookie("token",json.message);
               /* var expiresDate= new Date();
                expiresDate.setTime(expiresDate.getTime() + (60*60*1000));
                $.cookie("token",json.message,{expires:expiresDate});*/

                location.href="index.html";
            } else {
                alert(json.message);
            }
        },
        "error":function(){
            alert("您登录信息已过期，请重新登录");
            location.href="login.html";
        }
    });
});


function setCookie(name,value)
{
    var exp = new Date();
    exp.setTime(exp.getTime() + 2*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

//读取cookies
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

    if(arr=document.cookie.match(reg)){
        return unescape(arr[2]);
    }
    else{
        return null;
    }
}


