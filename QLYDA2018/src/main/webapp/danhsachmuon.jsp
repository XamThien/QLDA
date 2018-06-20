<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
  		<title>Danh sách phiếu mượn sách</title>
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
	              	<h2><strong>Danh sách phiếu mượn sách</strong></h2>
	              	<hr/>
	                <span style="color:red"><i>${msg}</i></span>
	                <!-- show table-->
	                <div class="x_panel">
		                  <div class="x_title">
		                    <h2>Danh sách</h2>
		                    
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
										  		<th>Mã phiếu mượn</th>
										  		<th>Mã sinh viên</th>
										  		<th>Tên sinh viên</th>
										  		<th>Lớp quản lý</th>
										  		<th>Chi tiết</th> 
										  		
										  	</tr>
										  </thead>
										   <tbody>
										  <%
										  	List<MuonTra> lst = new MuonTraDAO().getAllMuonTra();
										  	if(lst!= null)
										  	{
										  		for(MuonTra tl :lst)
										  		{
										  %>
										 
										  	
										  <tr>
										    <td><%=tl.getId() %></td>
										    <td><%=tl.getMssv() %></td>
										    <td><%=tl.getNameSv() %></td>
										    <td><%=tl.getLopSv() %></td>
										    
										    <td>
										    	<a href="chitetmuon.jsp?id=<%=tl.getId() %>">Chi tiết</a>
										    	
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
            
					<!-- ----------------------------------------------->
			    </div>
			    
			    <%@include file="template/footer.jsp"%>
				<%@include file="template/footname.jsp"%>
			
		      </div>
		    </div>
    	</div>
	</body>
</html>
