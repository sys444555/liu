$(function () {
    debugger;
    var token=getCookie("token")
    console.log(token)
    $.ajax({
        url: "../customer/getVipList",
        // data: {pageNo: 1, pageSize: 10},
        type: "get",
        dataType: "json",
        success: function (data) {
            for (var i = 0; i < data.data.length; i++) {
                var html = '<tr>'
                    + '<td class="bs-checkbox"  style="width: 36px;" data-field="state" tabindex="0"><input id="#{id}" type="checkbox" name="checkbox"/></td>'
                    + '<td>#{openId}</td>'
                    + '<td>#{name}</td>'
                    + '<td>#{sName}</td>'
                    + '<td>#{sPhone}</td>'
                    + '<td>#{gender}</td>'
                    + '<td>#{status}</td>'
                    + '</tr>';
                html = html.replace("#{id}",   i);
                html = html.replace("#{openId}", data.data[i].openId);
                html = html.replace("#{name}", "超级合伙人");
                html = html.replace("#{sName}", data.data[i].sname);
                html = html.replace("#{sPhone}", data.data[i].sphone);
                html = html.replace("#{gender}", data.data[i].gender == 0? "保密" :data.data[i].gender == 1?"男":"女");
                html = html.replace("#{status}", data.data[i].vip == 1 ? "合伙人" : "非合伙人");
                $("#vip_td").append(html);
                //     localStorage.setItem("cus" + i, JSON.stringify(data.data.list[i]))
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
