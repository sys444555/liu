$(function () {
    function showChanceList() {
        $.ajax({
            url: "../personnel/list",
            data: {pageNo: 1, pageSize: 20},
            type: "get",
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.data.list.length; i++) {
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
                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", i);
                    html = html.replace("#{username}", data.data.list[i].username);
                    html = html.replace("#{sex}", data.data.list[i].sex);
                    html = html.replace("#{age}", data.data.list[i].age);
                    html = html.replace("#{phone}", data.data.list[i].phone);
                    html = html.replace("#{qq}", data.data.list[i].qq);
                    html = html.replace("#{wexin}", data.data.list[i].wexin);
                    html = html.replace("#{email}", data.data.list[i].email);
                    html = html.replace("#{status}", data.data.list[i].status);
                    html = html.replace("#{address}", data.data.list[i].address);
                    html = html.replace("#{date}", data.data.list[i].date);
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
                            url: "../personnel/list",
                            data: {pageNo: api.getCurrent(), pageSize: 20},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                for (var i = 0; i < data.data.list.length; i++) {
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
                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{id}", i);
                                    html = html.replace("#{username}", data.data.list[i].username);
                                    html = html.replace("#{sex}", data.data.list[i].sex);
                                    html = html.replace("#{age}", data.data.list[i].age);
                                    html = html.replace("#{phone}", data.data.list[i].phone);
                                    html = html.replace("#{qq}", data.data.list[i].qq);
                                    html = html.replace("#{wexin}", data.data.list[i].wexin);
                                    html = html.replace("#{email}", data.data.list[i].email);
                                    html = html.replace("#{status}", data.data.list[i].status);
                                    html = html.replace("#{address}", data.data.list[i].address);
                                    html = html.replace("#{date}", data.data.list[i].date);
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

$("#delete_btn").click(function () {
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
    $.ajax({
        url: "../personnel/select/",
        data: {username:cname},
        type: "POST",
        dataType: "json",
        async:true,
        success: function (json) {
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
        $("#name").val(data.name);
        $("#phone").val(data.phone);
        $("#fullAddress").val(data.fullAddress);

        //数据key 与对应的 id 进行数据绑定  包含cusId
        //提交整个ajax请求到后台 包含cusId
    }
});

$("#update_sub").click(function () {
    var forData = $("#shoop_update").serialize();
    forData = decodeURIComponent(forData, true);
    $.ajax({
        url: "../personnel/update",
        data: forData,
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