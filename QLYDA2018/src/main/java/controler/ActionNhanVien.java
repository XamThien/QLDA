package main.java.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.DAO.NhanVienDAO;
import main.java.model.NhanVien;

/**
 * Servlet implementation class ActionNhanVien
 */
@WebServlet("/actionnhanvien")
public class ActionNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	NhanVienDAO db = new NhanVienDAO();
		String action = request.getParameter("action");
		String message ="";
		switch(action)
		{
		case "delete":
			try
			{
				String id = request.getParameter("did");
				
				NhanVien tll = db.getNhanVienByID(Integer.parseInt(id));
				
				tll.setStatus(false);
	            
	            try
	            {
	            	db.updateNhanVien(tll);
	            	
	            	message = "Xóa nhân viên thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Xóa nhân viên không thành công .";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Xóa nhân viên không thành công .";
	        	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "edit":
			try
			{
				String id = request.getParameter("id");
				String ten = request.getParameter("name");
				String sdt = request.getParameter("phone");
				String tk = request.getParameter("username");
				String mk = request.getParameter("pass");
				String dc = request.getParameter("address");
				
				
				NhanVien tll = db.getNhanVienByID(Integer.parseInt(id));
				tll.setName(ten);
				tll.setPhone(sdt);
				tll.setUserName(tk);
				tll.setPass(mk);
				tll.setAddress(dc);
				
	            
	            try
	            {
	            	db.updateNhanVien(tll);
	            	
	            	message = "Sửa thông tin nhân viên thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sửa thông tin nhân viên không thành công 1."+e;
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sửa thông tin nhân viên không thành công 2."+e;
	        	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "add":
			try
			{
				String ten = request.getParameter("name");
				String sdt = request.getParameter("phone");
				String tk = request.getParameter("username");
				String mk = request.getParameter("pass");
				String dc = request.getParameter("address");
				
				NhanVien tl = new NhanVien(ten,sdt,tk,mk,dc,true);
	            try
	            {
	            	db.insertNhanVien(tl);
	            	
	            	message = "Thêm nhân viên thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Thêm nhân viên không thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Thêm nhân viên không thành công.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("nhanvien.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;
		}
	}

}
