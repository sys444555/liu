$(function () {
    function showChanceList() {
        $.ajax({
            url: "../goods/list",
            data: {pageNo: 1, pageSize: 20},
            type: "get",
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.data.list.length; i++) {
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td>#{goodsId}</td>'
                        + '<td>#{name}</td>'
                        + '<td>#{specification}</td>'
                        + '<td>#{colour}</td>'
                        + '<td>#{size}</td>'
                        + '<td>#{minPrice}</td>'
                        + '<td><img src="#{pic}"/></td>'
                        + '<td>#{dateAdd}</td>'
                        + '</tr>';
                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", i+1);
                    html = html.replace("#{goodsId}", data.data.list[i].id == null ? '':  data.data.list[i].id);
                    html = html.replace("#{name}", data.data.list[i].name == null ? '':  data.data.list[i].name);
                    html = html.replace("#{colour}", data.data.list[i].colour == null ? '':  data.data.list[i].colour);
                    html = html.replace("#{size}", data.data.list[i].size == null ? '':  data.data.list[i].size);
                    html = html.replace("#{specification}", data.data.list[i].specification == null ? '':  data.data.list[i].specification);
                    html = html.replace("#{minPrice}", data.data.list[i].minPrice == null ? '':  data.data.list[i].minPrice);
                    html = html.replace("#{pic}", data.data.list[i].pic == null ? '':  data.data.list[i].pic);
                    html = html.replace("#{dateAdd}", data.data.list[i].dateAdd == null ? '':  data.data.list[i].dateAdd);
                    $("#goods_td").append(html);
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
                                        + '<td>#{id}</td>'
                                        + '<td>#{goodsId}</td>'
                                        + '<td>#{specification}</td>'
                                        + '<td>#{name}</td>'
                                        + '<td>#{colour}</td>'
                                        + '<td>#{size}</td>'
                                        + '<td>#{minPrice}</td>'
                                        + '<td><img src="#{pic}"/></td>'
                                        + '<td>#{dateAdd}</td>'
                                        + '</tr>';
                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{id}", i+1);
                                    html = html.replace("#{goodsId}", data.data.list[i].id == null ? '':  data.data.list[i].id);
                                    html = html.replace("#{name}", data.data.list[i].name == null ? '':  data.data.list[i].name);
                                    html = html.replace("#{colour}", data.data.list[i].colour == null ? '':  data.data.list[i].colour);
                                    html = html.replace("#{size}", data.data.list[i].size == null ? '':  data.data.list[i].size);
                                    html = html.replace("#{specification}", data.data.list[i].specification == null ? '':  data.data.list[i].specification);
                                    html = html.replace("#{minPrice}", data.data.list[i].minPrice == null ? '':  data.data.list[i].minPrice);
                                    html = html.replace("#{pic}", data.data.list[i].pic == null ? '':  data.data.list[i].pic);
                                    html = html.replace("#{dateAdd}", data.data.list[i].dateAdd == null ? '':  data.data.list[i].dateAdd);
                                    $("#goods_td").append(html);
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

$("#personnel_btn").click(function () {
    var formData = $("#personnel_add").serialize(); //取表单值 并进行序列化；此时formData已经是乱码了
    formData = decodeURIComponent(formData, true);
    console.log(formData);

    var token=getCookie("token")
    console.log(token)
    $.ajax({
        url: "../personnel/insert",
        data: formData,
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            if (json.code == 0){
                var html = '<tr>'
                    + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input type="checkbox" name="checkbox"/></td>'
                    + '<td>#{username}</td>'
                    + '<td>#{sex}</td>'
                    + '<td>#{age}</td>'
                    + '<td>#{phone}</td>'
                    + '<td>#{qq}</td>'
                    + '<td>#{wexin}</td>'
                    + '<td>#{email}</td>'
                    + '<td>#{status}</td>'
                    + '<td>#{address}</td>'
                    + '<td>#{date}</td>'
                    + '</tr>';

                html = html.replace("#{username}", $("#username").val());
                html = html.replace("#{sex}", $("#sex").val());
                html = html.replace("#{age}", $("#age").val());
                html = html.replace("#{phone}", $("#phone").val());
                html = html.replace("#{qq}", $("#qq").val());
                html = html.replace("#{wexin}", $("#wexin").val());
                html = html.replace("#{email}", $("#email").val());
                html = html.replace("#{status}", $("#status").val());
                html = html.replace("#{address}", $("#address").val());
                html = html.replace("#{date}", $("#date").val());
                $("#chance_td").append(html);
                $("#cus_chance_add").modal("hide");
                window.location.reload(true);
            } else {
                alert(json.message);
            }
        }
    });
});

$("#delete_btn").click(function () {
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
        window.location.reload(true);
        checkId = "";
        return;
    }else {
        var data = JSON.parse(localStorage.getItem(checkId.id));
        var checkid= data.id;
        $.ajax({
            url: "../personnel/delete/"+checkid,
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

$("#bt_name").click(function () {
    var cname=$("#c_name").val();
    console.log(cname)
    var token=getCookie("token")
    console.log(token)
    $.ajax({
        url: "../personnel/select/",
        data: {name:cname},
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            console.log(json)
            if (json.code == 0) {
                if(json.data==null){
                    alert("没有这个客户信息");
                    window.location.reload(true);
                }
                $("#t_table tbody").html("");
                console.log(json.data.username);
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td>#{username}</td>'
                        + '<td>#{sex}</td>'
                        + '<td>#{age}</td>'
                        + '<td>#{phone}</td>'
                        + '<td>#{qq}</td>'
                        + '<td>#{wexin}</td>'
                        + '<td>#{email}</td>'
                        + '<td>#{status}</td>'
                        + '<td>#{address}</td>'
                        + '<td>#{date}</td>'
                        + '</tr>';
                    html = html.replace("#{cusId}", "cus"+0);
                    html = html.replace("#{id}", json.data.id);
                    html = html.replace("#{username}", json.data.username);
                    html = html.replace("#{sex}", json.data.sex);
                    html = html.replace("#{age}", json.data.age);
                html = html.replace("#{phone}", json.data.phone);
                html = html.replace("#{qq}", json.data.qq);
                html = html.replace("#{wexin}", json.data.wexin);
                html = html.replace("#{email}", json.data.email);
                html = html.replace("#{status}", json.data.status);
                html = html.replace("#{address}", json.data.address);
                html = html.replace("#{date}", json.data.date);
                    $("#chance_td").append(html);
                localStorage.setItem("cus" + 0, JSON.stringify(json.data))
            }
        }
    });
});


$("#update").click(function () {
    var length = 0;
    var checkId = "";
    //所有的checkbox的list集合
    var checkbox = document.getElementsByName("checkbox");
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

        $("#id").val(data.id);
        $("#p_username").val(data.username);
        $("#p_sex").val(data.sex);
        $("#p_age").val(data.age);
        $("#p_phone").val(data.phone);
        $("#p_date").val(data.date);
        $("#p_qq").val(data.qq);
        $("#p_wexin").val(data.wexin);
        $("#p_email").val(data.email);
        $("#p_status").val(data.status);
        $("#p_address").val(data.address);
        //数据key 与对应的 id 进行数据绑定  包含cusId
        //提交整个ajax请求到后台 包含cusId
    }
});

$("#update_sub").click(function () {
    var forData = $("#personnel_update").serialize();
    forData = decodeURIComponent(forData, true);
    var token=getCookie("token")
    console.log(token)
    $.ajax({
        url: "../personnel/update",
        data: forData,
        headers: {
            "token":token
        },
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
            if (json.code == 0) {
                $("#cus_chance_alter").modal("hide");
                //局部页面刷新
                window.location.reload(true);
            } else {
                alert(json.message);
            }
        }
    })

})
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
