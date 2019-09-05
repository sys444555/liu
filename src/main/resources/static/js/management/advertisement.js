$(function () {
    console.log("开始渲染页面");
    showList();
    function showList() {
        $.ajax({
            url:"../advertisement/list",
            type: "get",
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.data.length; i++) {
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td><img src="#{picUrl}" style="width: 54px;"></td>'
                        + '<td><img src="#{pic_url}" style="width: 54px;"></td>'
                        + '<td>#{theme}</td>'
                        + '<td>#{details}</td>'
                        + '<td>#{statusStr}</td>'
                        + '<td>#{dateAdd}</td>'
                        + '<td>#{dateUpdate}</td>'
                        + '<td>#{userId}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", i);
                    html = html.replace("#{picUrl}", data.data[i].picUrl);
                    html = html.replace("#{pic_url}", data.data[i].pic_url);
                    html = html.replace("#{theme}", data.data[i].theme);
                    html = html.replace("#{details}", data.data[i].details);
                    html = html.replace("#{statusStr}", data.data[i].statusStr);
                    html = html.replace("#{dateAdd}", data.data[i].dateAdd);
                    html = html.replace("#{dateUpdate}", data.data[i].dateUpdate);
                    html = html.replace("#{userId}", data.data[i].userId);
                    $("#chance_td").append(html);
                    localStorage.setItem("cus" + i, JSON.stringify(data.data[i]))
                }
            }
        })
    }
});

$("#advertisement_btn").click(function () {
    var formData = new FormData();
    formData.append('file', $('#banner_pic')[0].files[0]); // 固定格式
    formData.append("title","");
    formData.append("type","hot");
    formData.append("statusStr","显示");
    formData.append("remark","");
    formData.append("userId",1);
    formData.append("businessId",0);
    formData.append("linkUrl","../Advertisement/Advertisement");
    formData.append("paixu",0);
    formData.append("status",0);

    var token=getCookie("token")
    console.log(token)
    $.ajax({
        url: "../upload/fileUpload",
        data: formData,
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        async:true,
        processData: false,		//用于对data参数进行序列化处理 这里必须false
        cache:false,
        contentType: false,
        mimeType:"multipart/form-data",
        success: function (json) {
            console.log(json)
            if (json.code == 0){
                advertisement(json.data);
                alert("上架成功")
                window.location.reload(true);
            }
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
function advertisement(id) {
    var token=getCookie("token")
    console.log(token)
    var formData = new FormData();
    formData.append('file', $('#advertisement_pic')[0].files[0]); // 固定格式
    formData.append("bannerId",id);
    formData.append("details",$("#details").val());
    formData.append("theme",$("#theme").val());
    formData.append("status",0);
    formData.append("statusStr","显示");
    formData.append("shopId",id);

    $.ajax({
        url: "../advertisement/insert",
        data: formData,
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        async:true,
        processData: false,		//用于对data参数进行序列化处理 这里必须false
        cache:false,
        contentType: false,
        mimeType:"multipart/form-data",
        success: function (json) {
            if (json.code == 0){
               /* window.location.reload(true);*/
            }
        }
    });
}

$("#updown_btn").click(function () {
    var token=getCookie("token")
    console.log(token)
    var checkboxs=document.getElementsByName("checkbox");
    for (var i = 0; i < checkboxs.length; i++) {
        if( checkboxs[i].checked){
            length++;
            checkId = checkboxs[i];
        }
    }
    if(length <= 0 || length > 1 ){
        alert("请选择单条数据操作!!!")
        checkId = "";
        return;
    }else {
        var data   = JSON.parse(localStorage.getItem(checkId.id));
        var checkid= data.id;
        debugger;
        $.ajax({
            url: "../picture/updown/"+checkid,
            headers: {
                "token":token
            },
            type: "POST",
            dataType: "json",
            async:true,
            success: function (json) {
                if (json.code == 0) {
                    alert("下架成功");
                    $("#cus_chance_delete").modal("hide");
                    //局部页面刷新
                    window.location.reload(true);
                }else{
                    alert("删除失败");
                }
            }
        });
    }
})



