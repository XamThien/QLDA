<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
  		<title>Mượn sách</title>
		<%@include file="template/header.jsp"%>
	</head>
	<%
	 	SessionMuonSach hoadon = new SessionMuonSach();
    	session.setAttribute("hoadon", hoadon);
	%>
	<body >
			<div class="nav-md">
		    <div class="container body">
		      <div class="main_container"> 
		            
		    	<%@include file="template/navbar.jsp"%>
				
				<%@include file="template/topnav.jsp"%>
				
				<div class="right_col" role="main">
					<!-- ----------------------------------------------->
					<div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
	              	<h2><strong>Mượn sách</strong></h2>
	              	<hr/>
	                <span style="color:red"><i>${msg}</i></span>
	                <!-- show table-->
	                <div class="x_panel">
		                  <div class="x_title">
		                    <h2>Thêm mới sách mượn</h2>
		                    
		                    <div class="clearfix"></div>
		                  </div>
		                  <div class="x_content">
		                  	<!-- search-->
					        <!-- ========================== -->
					        <div class="container">
				            	<div class="row">
					                <div class="col-md-9 col-sm-9 col-xs-12">
					                	<div class="box-header with-border">
					                        <input type="text" name="txtsearchproc" class="form-control" placeholder="Tìm kiếm sách" id="txtsearch1" onkeyup ="showHint(this.value);">
					                    </div>
					                    <div class="box-body suggest" id="sugges1">
					                        <ul class="list-suggest" id="result1"></ul>
					                    </div>
					                	<table id= "table" class="table table-striped table-bordered dataTable no-footer">
										  <thead>
										  	<tr>
										  		<th>STT</th>
										  		<th>Tên sách</th>
										  		<th>Tác giả</th>
										  		<th>Nhà xuất bản</th>
										  		<th style="width: 126px;">Số lượng</th>
										  		<th>Action</th>

										  		
										  	</tr>
										  </thead>
										   <tbody id="muontradetail" onload="editBill();"></tbody>
										</table>
					                </div>
					                <div class="col-md-3 col-sm-3 col-xs-12">
					                	<div class="x_panel">
					                		<div class="x_title">
							                  	<h4><font style="vertical-align: inherit;">
							                  			Thông tin sinh viên: 
							                  				
							                  	</font></h4>
							                  
							                  <div class="clearfix"></div>
							                </div>
							                <div class="x_content">

							                	<div class='col-sm-12'>
								                    <label >MSSV :</label>
								                    <div class="form-group">
								                        <div class="form-group" >
								                            <input type="text" id="mssv" class="form-control" name="mssv" placeholder="MSSV" value="${mssv}" required="required" />
								                        </div>
								                    </div>
								                </div>
							                	<div class='col-sm-12'>
								                    <label >Tên Sinh viên :</label>
								                    <div class="form-group">
								                        <div class="form-group" >
								                            <input type="text" id="ten" class="form-control" name="tensv" placeholder="Tên sinh viên" required="required" />
								                        </div>
								                    </div>
								                </div>
							                	<div class='col-sm-12'>
								                    <label >Lớp quản lý :</label>
								                    <div class="form-group">
								                        <div class="form-group" >
								                            <input type="text" id ="lop" class="form-control" name="lopsv" placeholder="Lớp quản lý" required="required" />
								                    </div>
								                </div>
							                </div>
					                	</div>
					                	
					                </div>
					                <div class="clearfix"></div>      
							       
				            </div>
				            <button type="button" style="float: right;width: 91px;margin-right: 26px;" class="btn btn-primary" onclick="saveBill();"> Lưu</button>
			        		</div>
					        <!-- ========================== -->
					      </div>
	             </div>
				 </div>
              </div>
            </div>



        	<script type="text/javascript">
			    function pass_del(id) {
			    	
			    	document.getElementById("txtid").value = id;
			    };
			    function pass_update(id,name,phone,username,pass,address) {
			    	document.getElementById("eid").value = id; 
			    	document.getElementById("ename").value = name; 
			    	document.getElementById("ephone").value = phone; 
			    	document.getElementById("eusername").value = username;
			    	document.getElementById("epass").value = pass;
			    	document.getElementById("eaddress").value = address;
			    	
			    };
			    
			</script>
					<!-- ----------------------------------------------->
			    </div>
			    
			    <%@include file="template/footer.jsp"%>
				<%@include file="template/footname.jsp"%>
			
		      </div>
		    </div>
    	</div>
	</body>
</html>
