<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="main.java.model.*"%>
<%@page import="java.util.List"%>
<%@page import="main.java.DAO.*"%>
<!-- top navigation -->
	        <div class="top_nav">
	          <div class="nav_menu">
	            <nav>
	             
	              <%
		             try
		             {
		            	 HttpSession sess = request.getSession();
		            	 if(sess.getAttribute("login")!= null)
		            	 {
		            		 NhanVien nv = (NhanVien)sess.getAttribute("login");
		            	 
			             
		             
	            	%>
		             
	          
	
	              <ul class="nav navbar-nav navbar-right">
	                <li class="">
	                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
	                    <img src="resources/production/images/img.jpg" alt=""/><%=nv.getName() %>
	                    <span class=" fa fa-angle-down"></span>
	                  </a>
	                  <ul class="dropdown-menu dropdown-usermenu pull-right">
	                    <li><a href="javascript:;"> Thông tin cái nhân</a></li>
	                    <li>
	                      <a href="javascript:;">
	                        <span class="badge bg-red pull-right">50%</span>
	                        <span>Cài đặt</span>
	                      </a>
	                    </li>
	                    <li><a href="javascript:;">Trợ giúp</a></li>
	                    <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Đăng xuất</a></li>
	                  </ul>
	                </li>
	
	                <!-- 
	                <li role="presentation" class="dropdown">
	                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
	                    <p>Thông báo </p>
	                    <span class="badge bg-green">6</span>
	                  </a>
	                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
	                    <li>
	                      <a>
	                        <span class="image"><img src="resources/production/images/img.jpg" alt="Profile Image" /></span>
	                        <span>
	                          <span>John Smith</span>
	                          <span class="time">3 mins ago</span>
	                        </span>
	                        <span class="message">
	                          Film festivals used to be do-or-die moments for movie makers. They were where...
	                        </span>
	                      </a>
	                    </li>
	                    <li>
	                      <a>
	                        <span class="image"><img src="resources/production/images/img.jpg" alt="Profile Image" /></span>
	                        <span>
	                          <span>John Smith</span>
	                          <span class="time">3 mins ago</span>
	                        </span>
	                        <span class="message">
	                          Film festivals used to be do-or-die moments for movie makers. They were where...
	                        </span>
	                      </a>
	                    </li>
	                    <li>
	                      <a>
	                        <span class="image"><img src="resources/production/images/img.jpg" alt="Profile Image" /></span>
	                        <span>
	                          <span>John Smith</span>
	                          <span class="time">3 mins ago</span>
	                        </span>
	                        <span class="message">
	                          Film festivals used to be do-or-die moments for movie makers. They were where...
	                        </span>
	                      </a>
	                    </li>
	                    <li>
	                      <a>
	                        <span class="image"><img src="resources/production/images/img.jpg" alt="Profile Image" /></span>
	                        <span>
	                          <span>John Smith</span>
	                          <span class="time">3 mins ago</span>
	                        </span>
	                        <span class="message">
	                          Film festivals used to be do-or-die moments for movie makers. They were where...
	                        </span>
	                      </a>
	                    </li>
	                    <li>
	                      <div class="text-center">
	                        <a>
	                          <strong>See All Alerts</strong>
	                          <i class="fa fa-angle-right"></i>
	                        </a>
	                      </div>
	                    </li>
	                  </ul>
	                </li>
	                 -->
	              </ul>
	             <%}}
	              catch(Exception e)
	              {
	            	  response.sendRedirect("login.jsp");
	              }%>
	            </nav>
	          </div>
	        </div>
	        <!-- /top navigation -->
</body>
</html>	    	        