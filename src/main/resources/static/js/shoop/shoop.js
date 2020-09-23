$(function () {
    function showChanceList() {
        $.ajax({
            url: "../shoop/list",
            data: {pageNo: 1, pageSize: 10},
            type: "get",
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.data.list.length; i++) {
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td>#{name}</td>'
                        + '<td>#{set_meal}</td>'
                        + '<td>#{money}</td>'
                        + '<td>#{phone}</td>'
                        + '<td>#{province}</td>'
                        + '<td>#{city}</td>'
                        + '<td>#{area}</td>'
                        + '<td>#{full_address}</td>'
                        + '<td>#{leave_word}</td>'
                        + '<td>#{status}</td>'
                        + '<td>#{number}</td>'
                        + '</tr>';
                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", data.data.list[i].id);
                    html = html.replace("#{name}", data.data.list[i].name);
                    html = html.replace("#{set_meal}", data.data.list[i].setMeal);
                    html = html.replace("#{money}", data.data.list[i].money);
                    html = html.replace("#{phone}", data.data.list[i].phone);
                    html = html.replace("#{province}", data.data.list[i].province);
                    html = html.replace("#{city}", data.data.list[i].city);
                    html = html.replace("#{area}", data.data.list[i].area);
                    html = html.replace("#{full_address}", data.data.list[i].fullAddress);
                    html = html.replace("#{leave_word}", data.data.list[i].leaveWord);
                    html = html.replace("#{status}", data.data.list[i].status);
                    html = html.replace("#{number}", data.data.list[i].number);
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
                            url: "../chance/list",
                            data: {pageNo: api.getCurrent(), pageSize: 10},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                for (var i = 0; i < data.data.list.length; i++) {
                                    var html = '<tr>'
                                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                        + '<td>#{id}</td>'
                                        + '<td>#{name}</td>'
                                        + '<td>#{set_meal}</td>'
                                        + '<td>#{money}</td>'
                                        + '<td>#{phone}</td>'
                                        + '<td>#{province}</td>'
                                        + '<td>#{city}</td>'
                                        + '<td>#{area}</td>'
                                        + '<td>#{full_address}</td>'
                                        + '<td>#{leave_word}</td>'
                                        + '<td>#{status}</td>'
                                        + '<td>#{number}</td>'
                                        + '</tr>';
                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{id}", data.data.list[i].id);
                                    html = html.replace("#{name}", data.data.list[i].name);
                                    html = html.replace("#{set_meal}", data.data.list[i].setMeal);
                                    html = html.replace("#{money}", data.data.list[i].money);
                                    html = html.replace("#{phone}", data.data.list[i].phone);
                                    html = html.replace("#{province}", data.data.list[i].province);
                                    html = html.replace("#{city}", data.data.list[i].city);
                                    html = html.replace("#{area}", data.data.list[i].area);
                                    html = html.replace("#{full_address}", data.data.list[i].fullAddress);
                                    html = html.replace("#{leave_word}", data.data.list[i].leaveWord);
                                    html = html.replace("#{status}", data.data.list[i].status);
                                    html = html.replace("#{number}", data.data.list[i].number);
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
            url: "../shoop/delete/"+checkid,
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
        url: "../shoop/select/",
        data: {name:cname},
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
                console.log(json.data.name);
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td>#{name}</td>'
                        + '<td>#{set_meal}</td>'
                        + '<td>#{money}</td>'
                        + '<td>#{phone}</td>'
                        + '<td>#{province}</td>'
                        + '<td>#{city}</td>'
                        + '<td>#{area}</td>'
                        + '<td>#{full_address}</td>'
                        + '<td>#{leave_word}</td>'
                        + '<td>#{status}</td>'
                        + '<td>#{number}</td>'
                        + '</tr>';
                html = html.replace("#{cusId}", "cus"+0);
                    html = html.replace("#{id}", json.data.id);
                    html = html.replace("#{name}", json.data.name);
                    html = html.replace("#{set_meal}", json.data.setMeal);
                    html = html.replace("#{money}", json.data.money);
                    html = html.replace("#{phone}", json.data.phone);
                    html = html.replace("#{province}", json.data.province);
                    html = html.replace("#{city}", json.data.city);
                    html = html.replace("#{area}", json.data.area);
                    html = html.replace("#{full_address}", json.data.fullAddress);
                    html = html.replace("#{leave_word}", json.data.leaveWord);
                    html = html.replace("#{status}", json.data.status);
                    html = html.replace("#{number}", json.data.number);
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
        $("#province").val(data.province);

        $("#city").val(data.city);
        $("#area").val(data.area);
        $("#fullAddress").val(data.fullAddress);
        $("#status").val(data.status);
        $("#number").val(data.number);
        $("#leaveWord").val(data.leaveWord);

        //数据key 与对应的 id 进行数据绑定  包含cusId
        //提交整个ajax请求到后台 包含cusId
    }
});

$("#update_sub").click(function () {
    var forData = $("#shoop_update").serialize();
    forData = decodeURIComponent(forData, true);
    $.ajax({
        url: "../shoop/update",
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