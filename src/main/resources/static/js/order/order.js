$(function () {
    function showChanceList() {
        $.ajax({
            url: "../order/list",
            data: {pageNo: 1, pageSize: 20},
            type: "get",
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.data.list.length; i++) {
                    var html = '<tr>'
                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                        + '<td>#{id}</td>'
                        + '<td>#{orderOn}</td>'
                        + '<td>#{status}</td>'
                        + '<td>#{linkMan}</td>'
                        + '<td>#{mobile}</td>'
                        + '<td>#{provinceStr}</td>'
                        + '<td>#{cityStr}</td>'
                        + '<td>#{districtStr}</td>'
                        + '<td>#{address}</td>'
                        + '<td>#{code}</td>'
                        + '<td>#{goodsPrice}</td>'
                        + '<td>#{actualPrice}</td>'
                        + '<td>#{remark}</td>'
                        + '<td>#{payId}</td>'
                        + '<td>#{createTime}</td>'
                        + '</tr>';
                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", i+1);
                    html = html.replace("#{orderOn}", data.data.list[i].orderOn);
                    html = html.replace("#{status}", data.data.list[i].status);
                    html = html.replace("#{linkMan}", data.data.list[i].linkMan);
                    html = html.replace("#{mobile}", data.data.list[i].mobile);
                    html = html.replace("#{provinceStr}", data.data.list[i].provinceStr);
                    html = html.replace("#{cityStr}", data.data.list[i].cityStr);
                    html = html.replace("#{districtStr}", data.data.list[i].districtStr);
                    html = html.replace("#{address}", data.data.list[i].address);
                    html = html.replace("#{code}", data.data.list[i].code);
                    html = html.replace("#{goodsPrice}", data.data.list[i].goodsPrice);
                    html = html.replace("#{actualPrice}", data.data.list[i].actualPrice);
                    html = html.replace("#{remark}", data.data.list[i].remark);
                    html = html.replace("#{payId}", data.data.list[i].payId);
                    html = html.replace("#{createTime}", data.data.list[i].createTime);
                    $("#order_td").append(html);
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
                        $("#order_td").empty();
                        $.ajax({
                            url: "../order/list",
                            data: {pageNo: api.getCurrent(), pageSize: 20},
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                for (var i = 0; i < data.data.list.length; i++) {
                                    var html = '<tr>'
                                        + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                        + '<td>#{id}</td>'
                                        + '<td>#{orderOn}</td>'
                                        + '<td>#{status}</td>'
                                        + '<td>#{linkMan}</td>'
                                        + '<td>#{mobile}</td>'
                                        + '<td>#{provinceStr}</td>'
                                        + '<td>#{cityStr}</td>'
                                        + '<td>#{districtStr}</td>'
                                        + '<td>#{address}</td>'
                                        + '<td>#{code}</td>'
                                        + '<td>#{goodsPrice}</td>'
                                        + '<td>#{actualPrice}</td>'
                                        + '<td>#{remark}</td>'
                                        + '<td>#{payId}</td>'
                                        + '<td>#{createTime}</td>'
                                        + '</tr>';
                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{id}", i+1);
                                    html = html.replace("#{orderOn}", data.data.list[i].orderOn);
                                    html = html.replace("#{status}", data.data.list[i].status);
                                    html = html.replace("#{linkMan}", data.data.list[i].linkMan);
                                    html = html.replace("#{mobile}", data.data.list[i].mobile);
                                    html = html.replace("#{provinceStr}", data.data.list[i].provinceStr);
                                    html = html.replace("#{cityStr}", data.data.list[i].cityStr);
                                    html = html.replace("#{districtStr}", data.data.list[i].districtStr);
                                    html = html.replace("#{address}", data.data.list[i].address);
                                    html = html.replace("#{code}", data.data.list[i].code);
                                    html = html.replace("#{goodsPrice}", data.data.list[i].goodsPrice);
                                    html = html.replace("#{actualPrice}", data.data.list[i].actualPrice);
                                    html = html.replace("#{remark}", data.data.list[i].remark);
                                    html = html.replace("#{payId}", data.data.list[i].payId);
                                    html = html.replace("#{createTime}", data.data.list[i].createTime);
                                    $("#order_td").append(html);
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
    var searchName =$("#c_name").val();
    if(searchName == null){
        console.log("null")
        window.location.reload(true);
    }else{
        $.ajax({
            url: "../order/search",
            data: {searchName:searchName,pageNo: 1, pageSize: 20},
            type: "GET",
            dataType: "json",
            async:true,
            success: function (data) {
                if (data.code == 0) {
                    debugger
                    $("#order_td").empty();
                    for (var i = 0; i < data.data.list.length; i++) {
                        var html = '<tr>'
                            + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                            + '<td>#{id}</td>'
                            + '<td>#{orderOn}</td>'
                            + '<td>#{status}</td>'
                            + '<td>#{linkMan}</td>'
                            + '<td>#{mobile}</td>'
                            + '<td>#{provinceStr}</td>'
                            + '<td>#{cityStr}</td>'
                            + '<td>#{districtStr}</td>'
                            + '<td>#{address}</td>'
                            + '<td>#{code}</td>'
                            + '<td>#{goodsPrice}</td>'
                            + '<td>#{actualPrice}</td>'
                            + '<td>#{remark}</td>'
                            + '<td>#{payId}</td>'
                            + '<td>#{createTime}</td>'
                            + '</tr>';
                        html = html.replace("#{cusId}", "cus" + i);
                        html = html.replace("#{id}", i + 1);
                        html = html.replace("#{orderOn}", data.data.list[i].orderOn);
                        html = html.replace("#{status}", data.data.list[i].status);
                        html = html.replace("#{linkMan}", data.data.list[i].linkMan);
                        html = html.replace("#{mobile}", data.data.list[i].mobile);
                        html = html.replace("#{provinceStr}", data.data.list[i].provinceStr);
                        html = html.replace("#{cityStr}", data.data.list[i].cityStr);
                        html = html.replace("#{districtStr}", data.data.list[i].districtStr);
                        html = html.replace("#{address}", data.data.list[i].address);
                        html = html.replace("#{code}", data.data.list[i].code);
                        html = html.replace("#{goodsPrice}", data.data.list[i].goodsPrice);
                        html = html.replace("#{actualPrice}", data.data.list[i].actualPrice);
                        html = html.replace("#{remark}", data.data.list[i].remark);
                        html = html.replace("#{payId}", data.data.list[i].payId);
                        html = html.replace("#{createTime}", data.data.list[i].createTime);
                        $("#order_td").append(html);
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
                            $("#order_td").empty();
                            $.ajax({
                                url: "../order/search",
                                data: {searchName: searchName,pageNo: api.getCurrent(), pageSize: 20},
                                type: "get",
                                dataType: "json",
                                success: function (data) {
                                    for (var i = 0; i < data.data.list.length; i++) {
                                        var html = '<tr>'
                                            + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{cusId}" type="checkbox" name="checkbox"/></td>'
                                            + '<td>#{id}</td>'
                                            + '<td>#{orderOn}</td>'
                                            + '<td>#{status}</td>'
                                            + '<td>#{linkMan}</td>'
                                            + '<td>#{mobile}</td>'
                                            + '<td>#{provinceStr}</td>'
                                            + '<td>#{cityStr}</td>'
                                            + '<td>#{districtStr}</td>'
                                            + '<td>#{address}</td>'
                                            + '<td>#{code}</td>'
                                            + '<td>#{goodsPrice}</td>'
                                            + '<td>#{actualPrice}</td>'
                                            + '<td>#{remark}</td>'
                                            + '<td>#{payId}</td>'
                                            + '<td>#{createTime}</td>'
                                            + '</tr>';
                                        html = html.replace("#{cusId}", "cus"+i);
                                        html = html.replace("#{id}", i+1);
                                        html = html.replace("#{orderOn}", data.data.list[i].orderOn);
                                        html = html.replace("#{status}", data.data.list[i].status);
                                        html = html.replace("#{linkMan}", data.data.list[i].linkMan);
                                        html = html.replace("#{mobile}", data.data.list[i].mobile);
                                        html = html.replace("#{provinceStr}", data.data.list[i].provinceStr);
                                        html = html.replace("#{cityStr}", data.data.list[i].cityStr);
                                        html = html.replace("#{districtStr}", data.data.list[i].districtStr);
                                        html = html.replace("#{address}", data.data.list[i].address);
                                        html = html.replace("#{code}", data.data.list[i].code);
                                        html = html.replace("#{goodsPrice}", data.data.list[i].goodsPrice);
                                        html = html.replace("#{actualPrice}", data.data.list[i].actualPrice);
                                        html = html.replace("#{remark}", data.data.list[i].remark);
                                        html = html.replace("#{payId}", data.data.list[i].payId);
                                        html = html.replace("#{createTime}", data.data.list[i].createTime);
                                        $("#order_td").append(html);
                                        localStorage.setItem("cus" + i, JSON.stringify(data.data.list[i]))
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
    }

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
