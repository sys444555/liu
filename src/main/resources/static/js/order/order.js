var status = {"未支付": -1,"已支付": 0, "已发货": 1}
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
                        + '<td>#{name}</td>'
                        + '<td><img src="#{pic}"/></td>'
                        + '<td>#{specification}</td>'
                        + '<td>#{createTime}</td>'
                        + '</tr>';
                    html = html.replace("#{cusId}", "cus"+i);
                    html = html.replace("#{id}", i+1);
                    html = html.replace("#{orderOn}", data.data.list[i].orderOn == null ? '' : data.data.list[i].orderOn);
                    html = html.replace("#{status}", data.data.list[i] == -1 && data.data.list[i].logisticsOrderOn == null ? "未支付" : data.data.list[i].status == 0 && data.data.list[i].logisticsOrderOn == null ? "已支付" : "已发货");
                    html = html.replace("#{linkMan}", data.data.list[i].linkMan == null ? '' : data.data.list[i].linkMan);
                    html = html.replace("#{mobile}", data.data.list[i].mobile == null ? '' : data.data.list[i].mobile);
                    html = html.replace("#{name}", data.data.list[i].name == null ? '' : data.data.list[i].name);
                    html = html.replace("#{pic}", data.data.list[i].pic == null ? '' : data.data.list[i].pic);
                    html = html.replace("#{specification}", data.data.list[i].specification == null ? '' : data.data.list[i].specification);
                    html = html.replace("#{createTime}", data.data.list[i].createTime == null ? '' : data.data.list[i].createTime);
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
                                        + '<td>#{name}</td>'
                                        + '<td><img src="#{pic}"/></td>'
                                        + '<td>#{specification}</td>'
                                        + '<td>#{createTime}</td>'
                                        + '</tr>';
                                    html = html.replace("#{cusId}", "cus"+i);
                                    html = html.replace("#{id}", i+1);
                                    html = html.replace("#{orderOn}", data.data.list[i].orderOn == null ? '' : data.data.list[i].orderOn);
                                    html = html.replace("#{status}", data.data.list[i] == -1 && data.data.list[i].logisticsOrderOn == null ? "未支付" : data.data.list[i].status == 0 && data.data.list[i].logisticsOrderOn == null ? "已支付" : "已发货");
                                    html = html.replace("#{linkMan}", data.data.list[i].linkMan == null ? '' : data.data.list[i].linkMan);
                                    html = html.replace("#{mobile}", data.data.list[i].mobile == null ? '' : data.data.list[i].mobile);
                                    html = html.replace("#{name}", data.data.list[i].name == null ? '' : data.data.list[i].name);
                                    html = html.replace("#{pic}", data.data.list[i].pic == null ? '' : data.data.list[i].pic);
                                    html = html.replace("#{specification}", data.data.list[i].specification == null ? '' : data.data.list[i].specification);
                                    html = html.replace("#{createTime}", data.data.list[i].createTime == null ? '' : data.data.list[i].createTime);
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

$("#order_detail").click(function () {
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
        var data = JSON.parse(localStorage.getItem(checkId.id));
        $("#order_detail_alter").modal("show");
        $("#orderOn").html(data.orderOn == null ? '' : data.orderOn);
        $("#status").html(data.status == -1 && data.logisticsOrderOn == null ? "未支付" : data.status == 0 && data.logisticsOrderOn == null ? "已支付" : "已发货");
        $("#linkMan").html(data.linkMan == null ? '' : data.linkMan);
        $("#mobile").html(data.mobile == null ? '' : data.mobile);
        $("#name").html(data.name == null ? '' : data.name);
        $("#pic").attr("src",data.pic == null ? '' : data.pic);
        $("#minPrice").html(data.minPrice == null ? '' : data.minPrice);
        $("#number").html(data.number == null ? '' : data.number);
        $("#specification").html(data.specification == null ? '' : data.specification);
        $("#provinceStr").html(data.provinceStr == null ? '' : data.provinceStr);
        $("#cityStr").html(data.cityStr == null ? '' : data.cityStr);
        $("#districtStr").html(data.districtStr == null ? '' : data.districtStr);
        $("#address").html(data.address == null ? '' : data.address);
        $("#code").html(data.code == null ? '' : data.code);
        $("#goodsPrice").html(data.goodsPrice == null ? '' : data.goodsPrice);
        $("#actualPrice").html(data.actualPrice == null ? '' : data.actualPrice);
        $("#remark").html(data.remark == null ? '' : data.remark);
        $("#payId").html(data.payId == null ? '' : data.payId);
        $("#createTime").html(data.createTime == null ? '' : data.createTime);
        $("#logisticsCompany").val(data.logisticsCompany == null ? '' : data.logisticsCompany)
        $("#logisticsOrderOn").val(data.logisticsOrderOn == null ? '' : data.logisticsOrderOn)
        //获取当前被check的id  获取数据

        console.log(data.orderOn)
        //数据key 与对应的 id 进行数据绑定  包含cusId
        //提交整个ajax请求到后台 包含cusId
    }

})


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
                            + '<td>#{name}</td>'
                            + '<td><img src="#{pic}"/></td>'
                            + '<td>#{specification}</td>'
                            + '<td>#{createTime}</td>'
                            + '</tr>';
                        html = html.replace("#{cusId}", "cus"+i);
                        html = html.replace("#{id}", i+1);
                        html = html.replace("#{orderOn}", data.data.list[i].orderOn == null ? '' : data.data.list[i].orderOn);
                        html = html.replace("#{status}", data.data.list[i] == -1 && data.data.list[i].logisticsOrderOn == null ? "未支付" : data.data.list[i].status == 0 && data.data.list[i].logisticsOrderOn == null ? "已支付" : "已发货");
                        html = html.replace("#{linkMan}", data.data.list[i].linkMan == null ? '' : data.data.list[i].linkMan);
                        html = html.replace("#{mobile}", data.data.list[i].mobile == null ? '' : data.data.list[i].mobile);
                        html = html.replace("#{name}", data.data.list[i].name == null ? '' : data.data.list[i].name);
                        html = html.replace("#{pic}", data.data.list[i].pic == null ? '' : data.data.list[i].pic);
                        html = html.replace("#{specification}", data.data.list[i].specification == null ? '' : data.data.list[i].specification);
                        html = html.replace("#{createTime}", data.data.list[i].createTime == null ? '' : data.data.list[i].createTime);
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
                                            + '<td>#{name}</td>'
                                            + '<td><img src="#{pic}"/></td>'
                                            + '<td>#{specification}</td>'
                                            + '<td>#{createTime}</td>'
                                            + '</tr>';
                                        html = html.replace("#{cusId}", "cus"+i);
                                        html = html.replace("#{id}", i+1);
                                        html = html.replace("#{orderOn}", data.data.list[i].orderOn == null ? '' : data.data.list[i].orderOn);
                                        html = html.replace("#{status}", data.data.list[i] == -1 && data.data.list[i].logisticsOrderOn == null ? "未支付" : data.data.list[i].status == 0 && data.data.list[i].logisticsOrderOn == null ? "已支付" : "已发货");
                                        html = html.replace("#{linkMan}", data.data.list[i].linkMan == null ? '' : data.data.list[i].linkMan);
                                        html = html.replace("#{mobile}", data.data.list[i].mobile == null ? '' : data.data.list[i].mobile);
                                        html = html.replace("#{name}", data.data.list[i].name == null ? '' : data.data.list[i].name);
                                        html = html.replace("#{pic}", data.data.list[i].pic == null ? '' : data.data.list[i].pic);
                                        html = html.replace("#{specification}", data.data.list[i].specification == null ? '' : data.data.list[i].specification);
                                        html = html.replace("#{createTime}", data.data.list[i].createTime == null ? '' : data.data.list[i].createTime);
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




$("#update_order").click(function () {
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
    var data = JSON.parse(localStorage.getItem(checkId.id));
    var id = data.id;
    /*var forData = $("#personnel_detail").serialize();
    forData = decodeURIComponent(forData, true);*/
    var logisticsCompany = $("#logisticsCompany").val();
    var logisticsOrderOn = $("#logisticsOrderOn").val();
    console.log(logisticsCompany)
    if(logisticsCompany == null || logisticsCompany == ''){
        alert("请输入快递公司");
        return
    }
    if(logisticsOrderOn == null || logisticsOrderOn == ''){
        alert("请输入快递单号");
        return
    }
    var token=getCookie("token")
    $.ajax({
        url: "../order/goods/update",
        data: {id:id,logisticsCompany:logisticsCompany,logisticsOrderOn:logisticsOrderOn},
        type: "POST",
        dataType: "json",
        headers: {
            "token":token
        },
        async:true,
        success: function (json) {
            if (json.code == 0) {
                $("#cus_chance_alter").modal("hide");
                //局部页面刷新
                alert("已修改订单快递信息");
                window.location.reload(true);
            } else {
                alert(json.message);
                if(json.code = 401){
                    location.href="login.html";
                }
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
