$("#btn-reg").click(function () {
    var forData = $("#form-reg").serialize();
    forData = decodeURIComponent(forData, true);
    console.log(forData)
    var token=getCookie("token")
    console.log(token)
    $.ajax({
        url: "../user/reg",
        data:forData,
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            console.log(json);
            if (json.code ==200) {
                alert("注册成功");
                location.href="index.html";
                // window.location.reload(true);
            } else {
                alert(json.message);
            }
        },
        "error":function(){
            alert("注册失败");
            location.href="reg.html";
        }
    });
});


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

/*
function getToken(){
    var strcookie = document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split("; ");//分割
    //遍历匹配
    for ( var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] == "token"){
            return arr[1];
        }
    }
    return "";
}
*/




