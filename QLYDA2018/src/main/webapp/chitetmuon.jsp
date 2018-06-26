<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
  		<title>Chi tiết phiếu mượn sách</title>
		<%@include file="template/header.jsp"%>
	</head>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
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
	              	<h2><strong>Chi tiết phiếu mượn sách</strong></h2>
	              	<hr/>
	                <span style="color:red"><i>${msg}</i></span>
	                <!-- show table-->
	                <div class="x_panel">
		                  <div class="x_title">
		                    <h2>Thông tin sinh viên</h2>
		                    
		                    <div class="clearfix"></div>
		                  </div>
		                  <div class="x_content">
		                  	<!-- search-->
					        <!-- ========================== -->
					        <div class="container">
					        	<br/>
					        	<div class="row">
					        		<div class="col-sm-6">
					        			<div class="col-sm-6">
					        				MSSV: <br/>
					        				Tên: <br/>
					        				Lớp:
					        			</div>
					        			<div class="col-sm-6">
					        				<%
					        					MuonTra mt = new MuonTraDAO().getMuonTraByID(id);
					        				%>
					        				<%=mt.getMssv() %> <br/>
					        				<%=mt.getNameSv() %> <br/>
					        				<%=mt.getLopSv() %>
					        			</div>
					        		</div>
					        		<div class="col-sm-6">
					        			<a href="#" data-toggle="modal" data-target="#modal-delete" style="float:right;" class="btn btn-primary" > Xác nhận trả đủ các sách</a>
					        			<br/>
					        			<br/>
					        			<a href="#" data-toggle="modal" data-target="#modal-add" style="float:right;" class="btn btn-primary" > Thêm sách mượn</a>
					        			
					        		</div>
					        	</div>
					        	<br/>
					        	<div class="ln_solid"></div>
					        	<br/>
				            	<div class="row">
					                <div class="col-sm-12">
					                	<table id= "datatable" class="table table-striped table-bordered dataTable no-footer">
										  <thead>
										  	<tr>
										  		<th>STT</th>
										  		<th>Tên sách</th>
										  		<th>Tác giả</th>
										  		<th>Nhà xuất bản</th>
										  		<th>Số lượng</th> 
										  		<th>Ngày mượn</th> 
										  		
										  		<th></th> 
										  		
										  	</tr>
										  </thead>
										   <tbody>
										  <%
										  	List<ChiTietMuonTra> lst = new ChiTietMuonTraDAO().getTheLoaiByID(id);
										  	if(lst!= null)
										  	{
										  		int dem=1;
										  		for(ChiTietMuonTra tl :lst)
										  		{ 
										  			if(tl.isXacNhanTra()){
										  %>
										 
										  	
										  <tr>
										    <td><%=dem %></td>
										    <td><%=tl.getSach().getName() %></td>
										    <td><%=tl.getSach().getTacGia() %></td>
										    <td><%=tl.getSach().getNhaXuatBan() %></td>
										    <td><%=tl.getSoLuong() %></td>
										    <td><%=tl.getNgayMuon() %></td>
										    
										    <td>
										    	<a href="#" data-toggle="modal" data-target="#modal-edit"  class="btn btn-primary" onclick="pass_update(<%=id %>,<%=tl.getSach().getId() %>,'<%=tl.getSach().getName() %>','<%=tl.getSach().getTacGia() %>',<%=tl.getSoLuong() %>)" > Sửa</a>
										    	
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
                          <h4 class="modal-title" id="myModalLabel">Thêm mới sách mượn: </h4>
                        </div>
                        <form action="#" method="post">
                        <div class="modal-body">
                          	 <div class='col-sm-12'>
				                   <label >Tên sách :</label>
				                    <div class="form-group" >
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="name" placeholder="Tên sách" required="required"/>
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                    <label >Tác giả :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="phone" placeholder="Tác giả" required="required" />
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Nhà xuất bản :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="username" placeholder="Nhà xuất bản" required="required"/>
				                            
				                        </div>
				                    </div>
				                </div>
				                <div class='col-sm-12'>
				                    <label >Số lượng :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="pass" placeholder="Số lượng" required="required"/>
				                            
				                        </div>
				                    </div>
				                </div>
				                
			                 
                        </div>
                        <div class="clearfix"></div>

                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                          <button type="reset" class="btn btn-info">Làm mới </button>
                          <button type="submit" onclick="alert('Chức năng đang trong thời gian hoàn thiện, Ahihi');" class="btn btn-info">Lưu </button>
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
                          <h4 class="modal-title" id="myModalLabel">Chỉnh sửa thông tin sách mượn :</h4>
                        </div>
                        <form action="trasach?action=edit" method="post">
                        <div class="modal-body">
                        	<div class="hd_id">
                        		<input type="hidden" id="pid" class="form-control" name="pid" />
                        		<input type="hidden" id="sid" class="form-control" name="sid" />
                        	</div>
                          	 <div class='col-sm-12'>
				                   <label >Tên sách :</label>
				                    <div class="form-group ">
				                        <div class="form-group code" >
				                            <input id="name" class="form-control" name="name" placeholder="Tên sách" disabled="disabled" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                    <label >Tác giả:</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" id="tg" class="form-control" name="author" placeholder="Nhà xuất bản" disabled="disabled"/>
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                <div class="form-group status">
					                <label >Số lượng :</label>
					                <div class="form-group ">
				                        <div class="form-group code" >
				                            <input id="sl" type="number" class="form-control" min="0" name="sl" placeholder="Số lượng" />
				                            
				                        </div>
				                    </div>
				                            
				                </div>
			                 </div>
			                 <div class='col-sm-12'>
				                <div class="form-group status">
					                <label >Trạng thái :</label>
					                <div class="form-group ">
				                        <div class="form-group code" >
				                            
				                            <select class="form-control" name="tt">
												  <option value="1">Chưa trả sách</option>
												  <option value="0">Đã trả đủ sách</option>
											</select>
				                        </div>
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
                          <h4 class="modal-title" id="myModalLabel">Xác nhận trả đủ sách:</h4>
                        </div>
                        
                        <div class="modal-footer">
                        	
                        		
                          		<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
                          		<a  href="trasach?action=full&did=<%=id %>" class="btn btn-info">Xác nhận </a>
                          
                          	
                        </div>

                      </div>
                    </div>
            </div>
			<!--  Delete modal -->
			<script type="text/javascript">
			    
			    function pass_update(pid,sid,name,tg,sl) {
			    	document.getElementById("pid").value = pid; 
			    	document.getElementById("sid").value = sid; 
			    	document.getElementById("name").value = name; 
			    	document.getElementById("tg").value = tg; 
			    	document.getElementById("sl").value = sl; 
			    	
			    	
			    };
			    
			</script>
					<!-- ----------------------------------------------->
			    </div>
			    
			    <%@include file="template/footer.jsp"%>
				<%@include file="template/footname.jsp"%>
			
		      </div>
		    </div>
    	
	</body>
</html>
