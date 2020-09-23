//给每个商品sku绑定点击事件，获取商品名并通过拼接的方式传入数据库
$(function () {//$(document).ready(function(){})
    // var $aArr= $("#sku_ul li a");
    // // var $sku_ul = $("#sku_ul");
    // var i;
    // // var priceArr = [300,301,302,303,304,305,306,307,308,309,310,311,312,313,314];
    // // $sku_ul.val("【鼠】千手观音菩萨");//套餐默认第一个，防止不点击直接提交
    // for(i=0;i<$aArr.length;i++){
    //     //使用jq的attr()给自定义属性赋值取值
    //     $aArr.eq(i).attr("img-src","../img/testImg/"+i+".jpg");
    //     $aArr.eq(i).attr("price",priceArr[i]);
    //
    //     $aArr.eq(i).click(function () {
    //         //将当前点击的套餐上的imgSrc赋值给大图显示img的src
    //         $(".item_tle img").attr("src",$(this).attr("img-src"));
    //         //将当前点击的套餐上的price赋值给价格显示的text
    //         $("#item_price").text("￥"+$(this).attr("price"));
    //         //将当前点击的套餐上的text赋值给val
    //         // $sku_ul.val(this.text);
    //
    //         // console.log(this.text);
    //         // console.log($(this).attr("img-src"));
    //     });
    //
    //     // console.log($aArr.eq(i).attr("img-src"));
    // }

    findShop();
    findPrice();
    findPicture();
})

//首页默认查询每个商品的字段之后进行赋值。
function findShop(){
    $aArr= $("#sku_ul li a");
    $.ajax({
        url: "../shop/list",
        type: "get",
        data: {pageNo: 1, pageSize: 15},
        dataType: "json",
        success: function (json) {
            var shopList = json.data.list;
            $("#sku_ul").val(shopList[0].shop);//默认赋值第一个商品名
            console.log('成功');
            console.log(shopList[0].shop);

            //赋值商品名
            for(var i=0;i<15;i++){
                $aArr.eq(i).click(function () {
                    //将当前点击的套餐上的text赋值给val
                    $("#sku_ul").val(this.text);
                });
            }

            //加载页面时赋值商品名
            for(var i=0,j=15;i<15;i++,j++){
                $(".sku_ul a").eq(i).text(shopList[i].shop);
                $(".sku_ul a").eq(j).text(shopList[i].shop);
            }
        },
        error: function () {
            console.log('失败')
        }
    })
}

//首页默认查询每个商品的价格之后进行赋值。
function findPrice(){
    var $aArr= $("#sku_ul li a");
    $.ajax({
        url: "../price/list",
        type: "get",
        data: {pageNo: 1, pageSize: 15},
        dataType: "json",
        success: function (json) {
            var priceList = json.data.list;
            $("#item_price").text("￥"+priceList[0].price);//默认显示第一个商品的价格
            console.log('成功');
            console.log(priceList[0].shop);

            //赋值价格
            for(var i=0;i<15;i++){
                $aArr.eq(i).attr("price",priceList[i].price);

                $aArr.eq(i).click(function () {
                    //将当前点击的套餐上的imgSrc赋值给大图显示img的src
                    $(".item_tle img").attr("src",$(this).attr("img-src"));
                    //将当前点击的套餐上的price赋值给价格显示的text
                    $("#item_price").text("￥"+$(this).attr("price"));
                    //将当前点击的套餐上的text赋值给val
                    // $sku_ul.val(this.text);

                    // console.log(this.text);
                    // console.log($(this).attr("img-src"));
                });
            }
        },
        error: function () {
            console.log('失败')
        }
    })
}

//首页默认查询每个商品的图片之后进行赋值。
function findPicture(){
    var $aArr= $("#sku_ul li a");
    $.ajax({
        url: "../picture/list",
        type: "get",
        data: {pageNo: 1, pageSize: 15},
        dataType: "json",
        success: function (json) {
            var pictureList = json.data.list;
            $(".item_tle>img").attr("src","../img/shopImg/"+pictureList[0].pictureAddress);//默认显示第一个商品的图片
            //$(".item_tle img").attr("src","../img/1000.jpg")
            console.log('成功');

            //赋值图片
            for(var i=0;i<15;i++){
                $aArr.eq(i).attr("pictureAddress","../img/shopImg/"+pictureList[i].pictureAddress);

                $aArr.eq(i).click(function () {
                    //将当前点击的套餐上的imgSrc赋值给大图显示img的src
                    $(".item_tle img").attr("src",$(this).attr("pictureAddress"));
                });
            }
        },
        error: function () {
            console.log('失败')
        }
    })
}

//将表单数据插入数据库
function insertForm() {
    var formData = $("#form_buy").serialize();
    formData = decodeURIComponent(formData);
    $.ajax({
        url: "../shoop/insert",
        data: formData + "&" + "setMeal=" + $("#sku_ul").val() + "&" + "money=" + $("#item_price").text().substring(1) + "&" + "pictureAddress="+ $(".item_tle img").attr("src"),
        type: "post",
        dataType: "json",
        success: function () {
            alert("提交成功");
            console.log(formData + "&" + "setMeal=" + $("#sku_ul").val() + "&" + "money=" + $("#item_price").text().substring(1) + "&" + "pictureAddress="+ $(".item_tle img").attr("src"));
            location.href="https://www.bengmf.com/";
        },
        error: function () {
            // console.log("---失败")
            console.log("---失败");
            console.log(formData + "&" + "setMeal=" + $("#sku_ul").val() + "&" + "money=" + $("#item_price").text().substring(1) + "&" + "pictureAddress="+ $(".item_tle img").attr("src"));
        }
    })
}


clearForm();
var vr = $("#vr").val();
function clearForm(){
    $("#phone").val("");
    $("#name").val("");
    if(vr!=1){
        $("#address").val("");
    }
    $("#item_num").val("1");
    $("#other").val("");
}

if(vr!=1){
    new PCAS("province,选省份","city,选市区","area,选区县");
}
function addNum(){
    var val = $("#item_num").val();
    val++;
    dealNum(val);
}

function delNum(){
    var val = $("#item_num").val();
    val--;
    dealNum(val);
}


function dealNum(val){
    _this = $("#item_num");
    if(!val){
        M._alert("客官至少买一件嘛");
        _this.val(1);
        return;
    }
    if(Number(val) < 1){
        M._alert("客官至少买一件嘛");
        _this.val(1);
        return;
    }
    if(isNaN(val)){
        M._alert("数量必须为数字");
        _this.val(1);
        return;
    }
    var _v = val;
    var noInt = false;
    if(_v.toString().indexOf(".") != -1){//有小数点 则先转化一下
        noInt = true;
        _v = Math.floor(val);//优化后的整数
    }
    noInt && M._alert("数量必须为整数");
    _this.val(_v);

    if($(".sku_cur").length===0){
        M._alert("请选择商品类型");
        return;
    }

    var pc = $(".sku_cur").attr("data-price");
    var fm = $(".sku_cur").attr("data-lijian");
    var countPrice=pc*_v;
    var countFreem=fm*_v;
    countPrice = Number(countPrice).toFixed(2);
    countFreem = Number(countFreem).toFixed(1);
    $("#item_price").html("￥"+ countPrice);
    $("#lijian").html(countFreem);
}

function getSelectObj(){
    var item_select = "";
    var i = 0;
    $(".item_wrap li a").each(function () {
        if ($(this).hasClass("sku_cur"))
        {
            if (i == 0) {
                item_select += $(this).html();
            } else {
                item_select += " - " + $(this).html();
            }
            i++;
            $("#item_select").val(item_select);
        }
    });
}

$(".sku_ul li").click(function () {
    var pId = $(this).parent().attr("id");
    if (pId == "skuList") {
        var money = $(this).children("a").attr('data-price');
        var skuid = $(this).children("a").attr('data-sku-id');
        var lijian = $(this).children("a").attr('data-lijian');
        $("#item_num").val(1);
        $("#item_sku_id").val(skuid);
        $("#item_price").text("￥" + money);
        $("#lijian").text(lijian);
    }
    $(this).parent().children('li').children("a").removeClass("sku_cur");
    $(this).children().addClass("sku_cur");
});

$("#item_num").bind("focusout",function(){
    dealNum($(this).val());
});


$("#buy_now").bind("click", function() {
    // console.log("==bind()");
    var isRight=true;
    var skuId=$("#item_sku_id").val();//商品ID
    var name=$("#name").val();//收货人
    var phone=$("#phone").val();//联系手机
    var province=$("#province").val();//省
    var city=$("#city").val();//市
    var area=$("#area").val();//区
    var address=$("#address").val();//区
    var rule = /^1[3-8][0-9]\d{4,8}$/;
    var captcha=$('[name="captcha"]');
    var captcha_val=captcha.val();
    if(skuId==''){
        M._alert("请选择商品类型");
        return false;
    }

    if(name==''){
        M._alert("请填写收货人");
        return false;
    }

    if(phone==''){
        M._alert("请填写联系手机");
        return false;
    }
    if(vr!=1){
        if(province=='' || city=='' || area==''){
            M._alert("请选择省市地区数据！");
            return false;
        }

        if(address==''){
            M._alert("请填写详细地址");
            return false;
        }
    }

    if(phone.length != 11 || rule.test(phone)==false){
        console.log(phone.length);
        M._alert("联系手机格式不对");
        return false;
    }

    if(captcha.is(":visible") && captcha_val.length<1){
        M._alert("请输入验证码");
        captcha.focus();
        return false;
    }

    getSelectObj();
    // $("#buy_now").unbind("click");
    insertForm();
    // saveOrder();
});

$(".js-refresh-check").click(function (event) {
    refreshCheck();
});

$('#skuList li').eq(0).find('a').click();
function refreshCheck() {
    var url = SITE_PUBLIC + "/captcha/getcode";
    $('.check-code').attr('src', url + '?t=' + new Date().getTime());
    $('#checkCode').val('').focus();
}

$("#query_now").click(function (event) {
    queryOrderInfo();
});


//查询订单信息
function queryOrderInfo(){
    var bmobile = $("#bmobile").val();
    var captcha = $("#checkCode").val();
    if(bmobile==''||bmobile==null){
        M._alert("请先输入订单对应的手机号!");
        $('#bmobile').focus();
        return false;
    }
    if(captcha==''||captcha==null){
        M._alert("请先输入查询验证码!");
        $('#checkCode').focus();
        return false;
    }
    var target = $('#dingdanString');
    target.html("");
    $("#dingdanDiv").css('display','none');
    //开始查询
    $("#query_now").unbind("click");
    $("#query_now").text("查询中...");
    $.ajax({
        url:SITE_PUBLIC+"/order/query",
        type:"POST",
        async:true,
        data: {mobilePhone:bmobile,captcha:captcha},
        dataType:"json",
        success:function(data){
            $("#query_now").bind("click",function(){
                queryOrderInfo();
            });
            if ("1" != data.res) {
                M._alert(data.resMsg);
                $("#query_now").text("提交查询");
                $("#dingdanDiv").css('display','none');
                refreshCheck();
                return false;
            }else{
                //解析数据
                var resObj =data.obj;
                var htmlString = "";
                if(resObj!='' && resObj[0].orderId!=undefined){
                    for (var i = 0; i < resObj.length; i++) {
                        var orderString = '<div class="ddlist"><div class="dtit">'+(i+1)+'.订单信息 [ '+resObj[i].orderState+' ] </div>';
                        orderString+='<div class="dz"><p class="ziku">单号编号：</p><span id="orderId">'+resObj[i].orderId+'</span></div>';
                        orderString+='<div class="dz"><p class="ziku">商品名称：</p><span id="orderGood">'+resObj[i].orderGood+'</span></div>';
                        orderString+='<div class="dz"><p class="ziku">选择套餐：</p><span id="orderSku">'+resObj[i].orderSku+'</span></div>';
                        orderString+='<div class="dz"><p class="ziku">购买数量：</p><span id="orderNum">'+resObj[i].orderNum+'</span></div>';
                        orderString+='<div class="dz"><p class="ziku">订单价格：</p><span id="orderPrice">￥'+resObj[i].orderPrice+'</span></div>';
                        orderString+='<div class="dz"><p class="ziku">下单时间：</p><span id="orderTime">'+resObj[i].orderTime+'</span></div>';
                        orderString+='</div>';
                        //解析物流信息
                        var gsmc = resObj[i].gsmc;
                        var wldh = resObj[i].wldh;
                        var wlxx = resObj[i].wlxx;
                        if(wlxx!='' && wlxx!=null){
                            var html = '<ul>';
                            var orderExpString = '<div class="ddlist"><div class="dtit">物流信息</div>';
                            orderExpString+='<div class="dz">快递公司：'+gsmc+'  &nbsp;&nbsp; 快递单号：'+wldh+'</div>';
                            orderExpString+=' <div id="wuLiu" class="col-xs-10 info-detail"><div class="order-step">';
                            var senderInfo = JSON.parse(wlxx);
                            if (senderInfo.Traces == '' || senderInfo.Traces == undefined) {
                                if(senderInfo.Reason==''||senderInfo.Reason==null){
                                    html = '很抱歉，暂无物流信息!';
                                }else{
                                    html = "很抱歉 , "+senderInfo.Reason+"!";
                                }
                            } else {
                                for (var j = 0; j < senderInfo.Traces.length; j++) {
                                    var obj = senderInfo.Traces[j];
                                    if (j == senderInfo.Traces.length-1) {
                                        html+= '<li class="wl-stream-last">';
                                    } else {
                                        html+= '<li class>';
                                    }
                                    html+= ' <span class="wl-stream-time">'+obj.AcceptTime.substring(0,16)+'</span>';
                                    html+= ' <span class="wl-stream-text">'+obj.AcceptStation+'</span>';
                                    html+=  '</li>'
                                }
                            }
                            html+= '</ui>';
                            //拼接字符串
                            orderExpString+=html;
                            orderExpString+='</div></div></div>';
                        }else{
                            orderExpString="";
                        }
                        htmlString += orderString + orderExpString;
                    }
                    //插入内容
                    $("#dingdanDiv").css('display','block');
                    target.html(htmlString);
                    $("#query_now").text("提交查询");
                    refreshCheck();
                }else{
                    M._alert("没有查询到数据!");
                    $("#query_now").text("提交查询");
                    $("#dingdanDiv").css('display','none');
                    refreshCheck();
                }
            }
        }
    });
}