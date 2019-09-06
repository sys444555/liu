$(function () {
    function showChanceList() {
        $.ajax({
            url: "../goods/list",
            data: {pageNo: 1, pageSize: 20},
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log(data);

                for (var i = 0; i < data.data.list.length; i++) {

                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{xuhao}</td>'
                        + '<td>#{id}</td>'
                        + '<td>#{name}</td>'
                        + '<td>#{category}</td>'
                        + '<td>#{size}</td>'
                        + '<td>#{min_price}</td>'
                        + '<td><img src="#{pic}" style="width: 54px;"></td>'
                        + '<td>#{dateAdd}</td>'
                        + '</tr>';

                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{xuhao}", i);
                    html = html.replace("#{id}", data.data.list[i].id);
                    html = html.replace("#{name}", data.data.list[i].name);
                    html = html.replace("#{category}", data.data.list[i].category);
                    html = html.replace("#{size}", data.data.list[i].size);
                    html = html.replace("#{min_price}", data.data.list[i].minPrice);
                    html = html.replace("#{pic}", data.data.list[i].pic);
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
                            url: "../goods/list",
                            data: {pageNo: api.getCurrent(), pageSize: 20},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                for (var i = 0; i < data.data.list.length; i++) {
                                    var html = '<tr>'
                                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                        + '<td>#{xuhao}</td>'
                                        + '<td>#{id}</td>'
                                        + '<td>#{name}</td>'
                                        + '<td>#{category}</td>'
                                        + '<td>#{size}</td>'
                                        + '<td>#{min_price}</td>'
                                        + '<td><img src="#{pic}" style="width: 54px;"></td>'
                                        + '<td>#{dateAdd}</td>'
                                        + '</tr>';

                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{xuhao}", i);
                                    html = html.replace("#{id}", data.data.list[i].id);
                                    html = html.replace("#{name}", data.data.list[i].name);
                                    html = html.replace("#{category}", data.data.list[i].category);
                                    html = html.replace("#{size}", data.data.list[i].size);
                                    html = html.replace("#{min_price}", data.data.list[i].minPrice);
                                    html = html.replace("#{pic}", data.data.list[i].pic);
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
    var formData = new FormData();
    formData.append('file', $('#pic')[0].files[0]); // 固定格式
    formData.append("name",$("#name").val());
    formData.append("category",$("#category").val());
    formData.append("colour",$("#colour").val());
    formData.append("size",$("#size").val());
    formData.append("min_price",$("#min_price").val());
    formData.append("dateAdd",0);
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
              alert("添加成功")
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
                    alert("删除成功");
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

