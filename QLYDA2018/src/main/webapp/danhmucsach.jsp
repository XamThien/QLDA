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
	              	<h2><strong>Quản lý thư mục sách</strong></h2>
	              	<hr/>
	                <span style="color:red"><i>${msg}</i></span>
	                <!-- show table-->
	                <div class="x_panel">
		                  <div class="x_title">
		                    <h2>Danh sách thư mục sách</h2>
		                    
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
										  		<th>Mã thể loại sách</th>
										  		<th>Tên thể loại sách</th>
										  		<th>Ghi chú</th>
										  		  <th><a href="#" style="color: white;" data-toggle="modal" data-target="#modal-add"  > <i class="fa fa-plus" ></i> Thêm mới</a></th> 
										  		
										  	</tr>
										  </thead>
										   <tbody>
										  <%
										  	List<TheLoai> lst = new TheLoaiDAO().getAllTheLoai();
										  	if(lst!= null)
										  	{
										  		for(TheLoai tl :lst)
										  		{
										  %>
										 
										  	
										  <tr>
										    <td><%=tl.getId() %></td>
										    <td><%=tl.getName() %></td>
										    <td><%=tl.getNote() %></td>
										    <td>
										    	<a href="#" data-toggle="modal" data-target="#modal-edit" class="btn btn-link" onclick="pass_update(<%=tl.getId()%>,'<%=tl.getName()%>','<%=tl.getNote()%>');"> <i class="fa fa-edit"></i> Sửa</a>
										    	<a href="#" data-toggle="modal" data-target="#modal-delete" class="btn btn-link" onclick="pass_del(<%=tl.getId()%>);"> <i class="fa fa-trash-o" ></i> Xóa</a>
										    	
										    </td>
										  </tr>
										  
										  <%
										  		}}
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
                          <h4 class="modal-title" id="myModalLabel">Thêm mới thể loại sách: </h4>
                        </div>
                        <form action="actiontheloai?action=add" method="post">
                        <div class="modal-body">
                          	 <div class='col-sm-12'>
				                   <label >Tên thể loại :</label>
				                    <div class="form-group" >
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="tentheloai" placeholder="Tên thể loại" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 <div class='col-sm-12'>
				                    <label >Ghi chú :</label>
				                    <div class="form-group">
				                        <div class="form-group" >
				                            <input type="text" class="form-control" name="ghichu" placeholder="Ghi chú" />
				                            
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
                          <h4 class="modal-title" id="myModalLabel">Sửa thông tin thể loại sách :</h4>
                        </div>
                        <form action="actiontheloai?action=edit" method="post">
                        <div class="modal-body">
                        	<div class="hd_id">
                        		<input type="hidden" id="eid" class="form-control" name="id" />
                        	</div>
                          	 <div class='col-sm-12'>
				                   <label >Tên thể loại :</label>
				                    <div class="form-group ">
				                        <div class="form-group code" >
				                            <input id="ename" class="form-control" name="tentheloai" placeholder="Tên thể loại" />
				                            
				                        </div>
				                    </div>
				                </div>
			                 
			                 <div class='col-sm-12'>
				                <div class="form-group status">
					                <label >Ghi chú :</label>
					                <div class="form-group ">
				                        <div class="form-group code" >
				                            <input id="enote" class="form-control" name="ghichu" placeholder="Ghi chú" />
				                            
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
                          <h4 class="modal-title" id="myModalLabel">Xác nhận:</h4>
                        </div>
                        
                        <div class="modal-footer">
                        	<form action="actiontheloai?action=delete" method="post">
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

        	<script type="text/javascript">
			    function pass_del(id) {
			    	
			    	document.getElementById("txtid").value = id;
			    };
			    function pass_update(id,name,note) {
			    	document.getElementById("eid").value = id; 
			    	document.getElementById("ename").value = name; 
			    	
			    	document.getElementById("enote").value = note; 
			    	
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
