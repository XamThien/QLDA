<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
  		<title></title>
		<%@include file="template/header.jsp"%>
	</head>
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
	              	<h2><strong>Quản lý sách</strong></h2>
	              	<hr/>
	                <span style="color:red"><i>${msg}</i></span>
	                <!-- show table-->
	                <div class="x_panel">
		                  <div class="x_title">
		                    <h2>Danh sách sách</h2>
		                    
		                    <div class="clearfix"></div>
		                  </div>
		                  <div class="x_content">
		                  	<!-- search-->
					        <!-- ========================== -->
					        <div class="container">
				            	<div class="row">
					                <div class="col-sm-12">
					                	<table id= "datatable" class="table table-striped table-bordered dataTable no-footer">
										  <thead>
										  	<tr>
										  		<th>Mã sách</th>
										  		<th>Tên sách</th>
										  		<th>Thể loại</th>
										  		
										  		<th>Số lượng</th>
										  		<th>Tác giả</th>
										  		
										  		  <th><a href="#" style="color: white;" data-toggle="modal" data-target="#modal-add"  > <i class="fa fa-plus" ></i> Thêm mới</a></th> 
										  		
										  	</tr>
										  </thead>
										   <tbody>
										  <%
										  	List<Sach> lst = new SachDAO().getAllSach();
										  	if(lst!= null)
										  	{
										  		for(Sach bk :lst)
										  		{
										  			TheLoai tlk = bk.getTheLoai();
										  			if(tlk.getStatus()==true)
										  			{
										  %>
										 
										  	
										  <tr ondblclick="pass_view('<%=bk.getName()%>','<%=bk.getTheLoai().getName()%>','<%=bk.getTacGia()%>',<%=bk.getSoTrang()%>,<%=bk.getSoLuong()%>,<%=bk.getNamXuatBan()%>,'<%=bk.getNhaXuatBan()%>');">
										    <td><%=bk.getId() %></td>
										    <td><%=bk.getName() %></td>
										    <td><%=bk.getTheLoai().getName() %></td>
										   
										    <td><%=bk.getSoLuong() %></td>
										    <td><%=bk.getTacGia() %></td>
										    
										    <td>
										    	<a href="#" data-toggle="modal" data-target="#modal-edit" class="btn btn-link" onclick="pass_update(<%=bk.getId()%>,'<%=bk.getName()%>',<%=bk.getTheLoai().getId()%>,'<%=bk.getTacGia()%>',<%=bk.getSoTrang()%>,<%=bk.getSoLuong()%>,<%=bk.getNamXuatBan()%>,'<%=bk.getNhaXuatBan()%>');"> <i class="fa fa-edit"></i> Sửa</a>
										    	
										    	
										    </td>
										  </tr>
										  
										  <%
										  		}}}
										  	else
										  	{
										  		out.println("Không có dữ liệu hiển thị");
										  	}
										  %>
										  </tbody>
										</table>
					                </div>
					                <div class="clearfix"></div>
					                
	
							        <div class="ln_solid"></div>
							        
				            </div>

			        		</div>
					        <!-- ========================== -->
					      </div>
	             </div>
				 </div>
              </div>
            </div>
            <!-- Add new modal -->
           <div class="modal fade bs-example-modal-lg" id="modal-add" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-delete">
                    <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel">Thêm mới sách: </h4>
                        </div>
                        <form action="actionsach?action=add" method="post">
                        <div class="modal-body">
                          	 <div class='col-sm-12'>
				                   <label >Tên sách :</label>
				                    <div class="form-group" >
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="tensach" placeholder="Tên sách" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                    <label >Thể loại :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            
				                            <select class="form-control" name="theloai">
				                            <%
				                            	List<TheLoai> lstt = new TheLoaiDAO().getAllTheLoai();
				                            	for(TheLoai tl :lstt)
				                            	{
				                            %>
											  <option value="<%=tl.getId()%>"><%=tl.getName() %></option>
											  <%} %>
											</select>
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số trang :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="sotrang" placeholder="Số trang" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số lượng :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="soluong" placeholder="Số lượng sách" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Tác giả :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="tacgia" placeholder="Tác giả" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Năm xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="namxb" placeholder="Năm xuất bản" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Nhà xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="nxb" placeholder="Nhà xuất bản" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 
                        </div>
                        <div class="clearfix"></div>

                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          <button type="reset" class="btn btn-info">Reset </button>
                          <button type="submit" class="btn btn-info">Save </button>
                        </div>
                    	</form>
                      </div>
                    </div>
            </div>
			<!--  Add new  modal -->

			<!-- Edit modal -->
            <div class="modal fade bs-example-modal-lg" id="modal-edit" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-delete">
                      <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel">Sửa thông tin sách :</h4>
                        </div>
                        <form action="actionsach?action=edit" method="post">
                        <div class="modal-body">
                        	<div class="hd_id">
                        		<input type="hidden" id="eid" class="form-control" name="id" />
                        	</div>
                          	 <div class='col-sm-12'>
				                   <label >Tên sách :</label>
				                    <div class="form-group" >
				                        <div class="form-group" >
				                            <input type="text" id="ename" class="form-control" name="tensach" placeholder="Tên sách" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                    <label >Thể loại :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            
				                            <select class="form-control" id="ecatogery" name="theloai">
				                            <%
				                            	
				                            	for(TheLoai tlx :lstt)
				                            	{
				                            %>
											  <option value="<%=tlx.getId()%>"><%=tlx.getName() %></option>
											  <%} %>
											</select>
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số trang :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="number" id="epage" class="form-control" name="sotrang" placeholder="Số trang" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số lượng :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="number" id="enumber" class="form-control" name="soluong" placeholder="Số lượng sách" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Tác giả :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" id="eauthor" class="form-control" name="tacgia" placeholder="Tác giả" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Năm xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="number" id="eyear" class="form-control" name="namxb" placeholder="Năm xuất bản" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Nhà xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" id="enxb" class="form-control" name="nxb" placeholder="Nhà xuất bản" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                   <label >Trạng thái :</label>
				                    <div class="form-group ">
				                        <div class="form-group code" >
				                            <input id="ename" class="form-control" name="tentheloai" placeholder="Tên thể loại" />
				                            <select id="estatus" class="form-control" name="status">
				                            	<option value="1">Active</option>
  												<option value="0">Inactive</option>
				                            </select>
				                        </div>
				                    </div>
				                </div>
			                 
                        </div>
                        <div class="clearfix"></div>

                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                          <button type="reset" class="btn btn-info">Reset </button>
                          <button type="submit" class="btn btn-info">Save </button>
                          
                        </div>
                    	</form>
                      </div>
                    </div>
            </div>
			<!--  Edit modal -->
			<!-- Delete modal -->
            <div class="modal fade bs-example-modal-lg" id="modal-delete" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-sm modal-delete">
                      <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel">Xác nhận:</h4>
                        </div>
                        
                        <div class="modal-footer">
                        	<form action="actionsach?action=delete" method="post">
                        		<div class="edit">
                        			<input type="hidden" id="txtid" name="did" />
                        		</div>
                          		<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
                          		<button type="submit" class="btn btn-info">Xác nhận </button>
                          
                          	</form>
                        </div>

                      </div>
                    </div>
            </div>
			<!--  Delete modal -->
			<!-- View modal -->
           <div class="modal fade bs-example-modal-lg" id="modal-view" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-delete">
                    <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                          </button>
                          <h4 class="modal-title" id="myModalLabel">Thông tin sách: </h4>
                        </div>
                        
                        <div class="modal-body">
                        	
                          	 <div class='col-sm-12'>
				                   <label >Tên sách :</label>
				                    <div class="form-group" >
				                        <div class="form-group" >
				                            <input type="text" id="vname" class="form-control" name="tensach" placeholder="Tên sách" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                    <label >Thể loại :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" id="vcate" class="form-control" name="tentheloai" placeholder="Tên sách" />
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số trang :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="number" id="vpage" class="form-control" name="sotrang" placeholder="Số trang" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số lượng :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="number" id="vnumber" class="form-control" name="soluong" placeholder="Số lượng sách" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Tác giả :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" id="vauthor" class="form-control" name="tacgia" placeholder="Tác giả" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Năm xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="number" id="vyear" class="form-control" name="namxb" placeholder="Năm xuất bản" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Nhà xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" id="vnxb" class="form-control" name="nxb" placeholder="Nhà xuất bản" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 
                        </div>
                        <div class="clearfix"></div>

                        <div class="modal-footer">
                          <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                         
                        </div>
                    	
                      </div>
                    </div>
            </div>
			<!--  View  modal -->

        	<script type="text/javascript">
			    function pass_del(id) {
			    	
			    	document.getElementById("txtid").value = id;
			    };
			    function pass_update(id,ten,theloai,tacgia,sotrang,soluong,nam,nxb) {
			    	document.getElementById("eid").value = id; 
			    	document.getElementById("ename").value = ten; 
			    	document.getElementById("ecatogery").value = theloai; 
			    	document.getElementById("eauthor").value = tacgia; 
			    	document.getElementById("epage").value = sotrang; 
			    	document.getElementById("enumber").value = soluong; 
			    	document.getElementById("eyear").value = nam; 
			    	document.getElementById("enxb").value = nxb; 
			    	
			    };
				function pass_view(ten,theloai,tacgia,sotrang,soluong,nam,nxb) {
					document.getElementById("vname").value = ten; 
			    	document.getElementById("vcate").value = theloai; 
			    	document.getElementById("vauthor").value = tacgia; 
			    	document.getElementById("vpage").value = sotrang; 
			    	document.getElementById("vnumber").value = soluong; 
			    	document.getElementById("vyear").value = nam; 
			    	document.getElementById("vnxb").value = nxb; 
			    	$("#modal-view").modal();
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
