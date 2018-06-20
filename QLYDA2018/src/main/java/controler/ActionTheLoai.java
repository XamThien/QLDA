package main.java.controler;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import main.java.DAO.*;
import main.java.model.*;

/**
 * Servlet implementation class ActionTheLoai
 */
@WebServlet("/actiontheloai")
public class ActionTheLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionTheLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	TheLoaiDAO db = new TheLoaiDAO();
		String action = request.getParameter("action");
		String message ="";
		switch(action)
		{
		case "delete":
			try
			{
				String id = request.getParameter("did");
				
				TheLoai tll = db.getTheLoaiByID(Integer.parseInt(id));
				
				tll.setStatus(false);
	            
	            try
	            {
	            	db.updateTheLoai(tll);
	            	
	            	message = "Xóa thể loại sách thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Xóa thể loại sách không thành công .";
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Xóa thể loại sách không thành công .";
	        	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "edit":
			try
			{
				String id = request.getParameter("id");
				String ten = request.getParameter("tentheloai");
				String gc = request.getParameter("ghichu");
				
				
				TheLoai tll = db.getTheLoaiByID(Integer.parseInt(id));
				tll.setName(ten);
				tll.setNote(gc);
				
	            
	            try
	            {
	            	db.updateTheLoai(tll);
	            	
	            	message = "Sửa thể loại sách thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa thể loại sách không thành công 1."+e;
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa thể loại sách không thành công 2."+e;
	        	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "add":
			try
			{
				String ten = request.getParameter("tentheloai");
				
				String gc = request.getParameter("ghichu");
				
				TheLoai tl = new TheLoai(ten,gc,true);
	            try
	            {
	            	db.insertTheLoai(tl);
	            	
	            	message = "Thêm thể loại sách thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm thể loại sách không thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm thể loại sách không thành công.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("danhmucsach.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;
		}
	}

}
