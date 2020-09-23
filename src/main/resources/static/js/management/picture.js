$(function () {
    function showChanceList() {
        $.ajax({
            url: "../picture/list",
            data: {pageNo: 1, pageSize: 20},
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log(data);
                var j=0;
                for (var i = 0; i < data.data.list.length; i++) {

                    if((data.data.list[i].type)!="home"){
                        continue;
                    }
                j+=1;
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td><img src="#{picUrl}" style="width: 54px;"></td>'
                        + '<td>#{title}</td>'
                        + '<td>#{type}</td>'
                        + '<td>#{statusStr}</td>'
                        + '<td>#{dateAdd}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", j);
                    html = html.replace("#{picUrl}", data.data.list[i].picUrl);
                    html = html.replace("#{title}", data.data.list[i].title);
                    html = html.replace("#{type}", data.data.list[i].type);
                    html = html.replace("#{statusStr}", data.data.list[i].statusStr);
                    html = html.replace("#{dateAdd}", data.data.list[i].dateAdd);
                    $("#chance_td").append(html);
                    localStorage.setItem("cus" + i, JSON.stringify(data.data.list[i]))
                }

                $(".M-box").pagination({
                    pageCount: data.data.pages,   //总页码ajax中的pages总页
                    coping: true,                 //是否开启首页和末页
                    jump: true,                   //是否开启跳页
                    homePage: '首页',
                    endPage: '末页',
                    prevContent: '上页',
                    nextContent: '下页',
                    current: data.data.pageNo,
                    callback: function (api) {
                        $("#chance_td").empty();
                        $.ajax({
                            url: "../picture/list",
                            data: {pageNo: api.getCurrent(), pageSize: 20},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                var j=0;
                                for (var i = 0; i < data.data.list.length; i++) {
                                    if(data.data.list[i].type!=home){
                                             break;
                                    }
                                    j+=1;
                                    var html = '<tr>'
                                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                        + '<td>#{id}</td>'
                                        + '<td><img src="../img/shopImg/#{picUrl}" style="width: 36px;"></td>'
                                        + '<td>#{title}</td>'
                                        + '<td>#{type}</td>'
                                        + '<td>#{statusStr}</td>'
                                        + '<td>#{dateAdd}</td>'
                                        + '</tr>';

                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{id}", j);
                                    html = html.replace("#{picUrl}", data.data.list[i].picUrl);
                                    html = html.replace("#{title}", data.data.list[i].title);
                                    html = html.replace("#{type}", data.data.list[i].type);
                                    html = html.replace("#{statusStr}", data.data.list[i].statusStr);
                                    html = html.replace("#{dateAdd}", data.data.list[i].dateAdd);
                                    $("#chance_td").append(html);
                                    localStorage.setItem("cus" + i, JSON.stringify(data.data.list[i]))
                                }
                            }
                        });
                    }
                });

            }
        })
    }

    showChanceList(6)
});

$("#picture_btn").click(function () {

    var forData = $("#picture_add").serialize();
    forData = decodeURIComponent(forData, true);
    var formData = new FormData();
    formData.append('file', $('#picUrl')[0].files[0]); // 固定格式
    formData.append("title",$("#title").val());
    formData.append("type",$("#type").val());
    formData.append("statusStr",$("#statusStr").val());
    formData.append("remark",$("#remark").val());
    formData.append("userId",1);
    formData.append("businessId",0);
    formData.append("linkUrl","跳转路径");
    formData.append("paixu",0);
    formData.append("status",0);
    console.log(formData);

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

            if (json.code == 0){
               /* var html = '<tr>'
                    + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input type="checkbox" name="checkbox"/></td>'
                    + '<td>#{picUrl}</td>'
                    + '<td>#{title}</td>'
                    + '<td>#{type}</td>'
                    + '<td>#{statusStr}</td>'
                    + '<td>#{remark}</td>'
                    + '<td>#{dateAdd}</td>'
                    + '<td>#{dateUpdate}</td>'
                    + '<td>#{userId}</td>'
                    + '</tr>';

                html = html.replace("#{picUrl}", $("#picUrl").val());
                html = html.replace("#{title}", $("#title").val());
                html = html.replace("#{type}", $("#type").val());
                html = html.replace("#{statusStr}", $("#statusStr").val());
                $("#chance_td").append(html);*/
               alert("上架成功")
                $("#cus_chance_add").modal("hide");
                window.location.reload(true);
            } else {
                alert(json.message);
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

/*
$("#update").click(function () {
    var length = 0;
    var checkId = "";
    //所有的checkbox的list集合
    var checkbox = document.getElementsByName("checkbox");

    //所以我需要先去判断现在的check到底有多少个
    //一个继续干   多个不干   没有不干
    for (var i = 0; i < checkbox.length; i++) {
        if( checkbox[i].checked){
            length++;
            checkId = checkbox[i];
        }
    }
    if(length <= 0 || length > 1 ){
        alert("请选择单条数据操作!!!")
        checkId = "";
        return;
    }else{
        $("#cus_chance_alter").modal("show")
        //获取当前被check的id  获取数据
        var data = JSON.parse(localStorage.getItem(checkId.id));
        console.log(data);

        $("#id").val(data.id);
        $("#picture_title").val(data.title);
        $("#picture_type").val(data.type);
        $("#status_str").val(data.statusStr);

    }
});


$("#update_sub").click(function () {
    var forData = $("#pic_update").serialize();
    forData = decodeURIComponent(forData, true);
    $.ajax({
        url: "../picture/update",
        data: forData,
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            if (json.code == 0) {
                alert("修改成功")
                //修改完成后
                //模态框隐藏   $("#cus_chance_alter").modal("hide")
                $("#cus_chance_alter").modal("hide");
                //局部页面刷新
                window.location.reload(true);
            } else {
                alert(json.message);
            }
        }
    })

})
*/

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
});

