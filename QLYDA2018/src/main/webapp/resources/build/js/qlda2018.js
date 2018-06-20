/**
 * 
 */
function addDetail(value) {
    $("#sugges1").hide();
    $("#txtsearch1").val('');
    $.getJSON("/addchitietmuontra",
            {maSach: value},
            function (data) {
                $('#muontradetail').html(data['list']);
                
            }
    );
}
function showHint(str) {
    if (str.length == 0) {
        $('#result1').html("");
        $("#sugges1").hide();
    } else {
        $.get("/searchbook",
                {txtsearch: str},
                function (data) {
                    $('#result1').html(data);
                    $("#sugges1").show();
                }
        );
    }
}
function showHintkh(str) {
    if (str.length == 0) {
        $('#result2').html("");
        $("#suggest2").hide();
    } else {
        $.get("searchkhachhang",
                {txtsearch: str},
                function (data) {
                    $('#result2').html(data);
                    $("#suggest2").show();
                }
        );
    }
}
function addinfobill(value) {
    $("#suggest2").hide();
    $("#txtsearch2").val('');
    $.get("addcustomerbill",
            {maKH: value},
            function (data) {
                $('#infocustomer').html(data);
            }
    );
}


function addRegister() {
    var manv = $("#MaNV").val();
    var ca = $("#MaCa").val();
    var gioBD = $("#timepicker1").val();
    var gioKT = $("#timepicker2").val();
    var tienphat;
    if ($("#exampleInputAmount1").val() == '') {
        tienphat = 0;
    } else
        tienphat = $("#exampleInputAmount1").val();
    var phucap;
    if ($("#exampleInputAmount2").val() == '') {
        phucap = 0;
    } else
        phucap = $("#exampleInputAmount2").val()
    var tamung;
    if ($("#exampleInputAmount3").val() == '') {
        tamung = 0;
    } else
        tamung = $("#exampleInputAmount3").val()
    $.get("register",
            {MaCa: ca, MaNV: manv, GioBD: gioBD, GioKT: gioKT, TienPhat: tienphat, PhuCap: phucap, TamUng: tamung},
            function (data) {
                alert(data);
            }
    );

}
function addCustomer() {
    var tenkh = $("#inputText1").val();
    var sodt = $("#inputText2").val();
    var diachi = $("#inputText3").val();
    

    $.get("addcustomer",
            {TenKH: tenkh, SDT: sodt, Address: diachi},
            function (data) {
                $("#msg").html(data);
            }
    );
}

function editBill(dt) {

    var elem = $(dt).parent().parent();
    var mahh = elem.attr("for");
    var sl = elem.children().children()[0].value;
    
    $.getJSON("/editchitietmuontra",
            {MaHH: mahh, SoLuong: sl},
            function (data) {
                $('#muontradetail').html(data['list']);
                
            }
    );
}
function updateSale() {
    var sale = $("#txtinputsale").val();
    $.getJSON("updatesale",
            {Sale: sale},
            function (data) {
                $('#hoadondetail').html(data['list']);
                $('#paytotal').html(data['total']);
            }
    );
}
function removeBill(mahh) {
    $.getJSON("/removechitietmuontra",
            {maSach: mahh},
            function (data) {
                $('#muontradetail').html(data['list']);
                
            }
    );
}
function confirmremove(mahh) {
    var result = confirm("Xóa sách có mã " + mahh + " ?");
    if (result) {
        removeBill(mahh);
    } else {
        return false;
    }
}

function saveBill() {
	var mssv = $("#mssv").val();
    var ten = $("#ten").val();
    var lop = $("#lop").val();
    if(mssv != null && ten!=null && lop!=null)
    	{
    		$.get("/savebill",
        		{Mssv: mssv, Ten: ten, Lop: lop},
                function (data) {
                    if (data == "success") {
                        alert("Lưu thành công phiếu mượn");
                        location.reload();
                    } else {
                        alert(data);
                    }
                });
    	}
    else
    	{
    		alert("Nhập đầy đủ thông tin sinh viên.");
    	}
}
function confirmDelete(mahh) {
    var select = confirm("Xóa sản phẩm có mã " + mahh + "vĩnh viễn?");
    if (select) {
        deleteHangHoa(mahh);
    } else {
        return false;
    }

}
function deleteHangHoa(mah) {
    $.get("hanghoa/delete",
            {mahh: mah},
            function (data) {
                if (data == "success") {
                    alert("Đã xóa sản phẩm có mã " + mah);
                } else {
                    alert(data);
                }
            });
}
function saveHangHoa(mah){
    var tenh= $("#inputText1").val();
    var nhomh = $("#inputText2").val();
    var giaban=$("#inputText7").val(); 
    var gianhap =$("#inputText8").val();
    var thuoctinh =$("#inputText4").val();
    var soluong =$("#inputText5").val();
    var dv= $("#inputText6").val();
    var mancc= $("#inputText3").val();
    var ghichu = $("#inputText9").val();
    $.get("/hanghoa/save",
    {
        primproduct:mah, productname:tenh, category:nhomh, outprice:giaban, inprice:gianhap,
        attribute1:thuoctinh,sl:soluong, dvt:dv, vendor:mancc, attribute2:ghichu
    },
    function(data){
        alert(data);
        $("#comeback").html("Trở về");
    });
}
function addProduct(){
    var tenh = $("#inputText1").val();
    var nhomh = $("#inputText2").val();
    var ncc =$("#inputText3").val();
    var thuoctinh=$("#inputText4").val();
    var soluong=$("#inputText5").val();
    var dv=$("#inputText6").val();
    var giaban=$("#inputText7").val();
    var gianhap=$("#inputText8").val();
    var ghichu=$("#inputText9").val();
    $.get("/addnewproduct",{
        productname:tenh, category:nhomh, outprice:giaban, inprice:gianhap,
        attribute1:thuoctinh, sl:soluong, dvt:dv, vendor: ncc, attribute2:ghichu
    },function(data){
        $("#msg").html(data);
    });
}
function dhsearchProduct(str) {
    if (str.length == 0) {
        $('#result1').html("");
        $("#sugges1").hide();
    } else {
        $.get("/PainGain2017/donhang/search",
                {txtsearch: str},
                function (data) {
                    $('#result1').html(data);
                    $("#sugges1").show();
                }
        );
    }
}
function dhthemSanpham(mahh){
    $("#sugges1").hide();
    $("#txtsearch1").val('');
    $.getJSON("donhang/add",
            {maHH: mahh},
            function (data) {
                $('#hoadondetail').html(data['list']);
                $("#paytotal").html(data['total']);
            }
    );
}
function confirmDHRemove(mah){
    $.getJSON("/PainGain2017/donhang/remove",
            {MaHH: mah},
            function (data) {
                $('#hoadondetail').html(data['list']);
                $('#paytotal').html(data['total']);
            }
    );
}
function donhangEdit(dt){
    var elem = $(dt).parent().parent();
    var mahh = elem.attr("for");
    var dg = elem.children().children()[0].value;
    var sl = elem.children().children()[1].value;
    $.getJSON("/PainGain2017/donhang/edit",
            {MaHH: mahh, DonGia: dg, SoLuong: sl},
            function (data) {
                $('#hoadondetail').html(data['list']);
                $('#paytotal').html(data['total']);
            }
    );
}
function saveDonDatHang() {
    $.get("/PainGain2017/donhang/save",
            function (data) {
                if (data == "success") {
                    alert("Lưu thành công hóa đơn");
                    location.reload();
                } else {
                    alert(data);
                }
            });
}
function capnhatDonHang(madh){
    $.get("/PainGain2017/donhang/updatettdondathang",
    {MaDDH:madh},
    function(data){
        alert(data);
    }
    );
}
