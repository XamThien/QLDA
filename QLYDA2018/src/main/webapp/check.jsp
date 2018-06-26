<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kiểm tra MSSV</title>
	<link href="${pageContext.request.contextPath}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="${pageContext.request.contextPath}/resources/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/resources/build/css/custom.min.css" rel="stylesheet">
  </head>
 <!-- href="${pageContext.request.contextPath}/src/main/webapp/resources/vendors/-->
  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="/check" method="post">
              <h2>Nhập MSSV để kiểm tra</h2>
              <span style="color:red"><i>${msg}</i></span>
              <label>MSSV:</label>
              <div>
                <input type="text" class="form-control" name="mssv" placeholder="MSSV" required="" />
              </div>
              
              <div>
               
                <button type="submit" class="btn btn-primary submit">Kiểm tra</button>
                
              </div>

              <div class="clearfix"></div>

              <div class="separator">
               
                <br />

                <div>
                  
                  <p>Phần mềm quản lý thư viện trường . Đồ án tổng hợp ©2018.</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        
      </div>
    </div>
  </body>
</html>