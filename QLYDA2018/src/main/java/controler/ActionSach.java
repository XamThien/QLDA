package main.java.controler;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.DAO.SachDAO;
import main.java.DAO.TheLoaiDAO;
import main.java.model.Sach;
import main.java.model.TheLoai;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionSach
 */
@WebServlet("/actionsach")
public class ActionSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionSach() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	SachDAO db = new SachDAO();
		String action = request.getParameter("action");
		String message ="";
		switch(action)
		{
		case "delete":
			try
			{
				String id = request.getParameter("did");
				
				Sach tll = db.getSachByID(Integer.parseInt(id));
				
				tll.setTrangThai(false);
	            
	            try
	            {
	            	db.updateSach(tll);
	            	
	            	message = "Xóa sách thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Xóa sách không thành công .";
	            	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Xóa sách không thành công .";
	        	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "edit":
			try
			{
				String id = request.getParameter("id");
				String ten = request.getParameter("tensach");
				int tl = Integer.parseInt(request.getParameter("theloai"));
				int st = Integer.parseInt(request.getParameter("sotrang"));
				int sl = Integer.parseInt(request.getParameter("soluong"));
				String tg = request.getParameter("tacgia");
				int nam = Integer.parseInt(request.getParameter("namxb"));
				String nxb = request.getParameter("nxb");
				int stt = Integer.parseInt(request.getParameter("status"));
				TheLoai tll = new TheLoaiDAO().getTheLoaiByID(tl);
				Sach book = db.getSachByID(Integer.parseInt(id));
				book.setName(ten);
				book.setTheLoai(tll);
				book.setSoTrang(st);
				book.setSoLuong(sl);
				book.setTacGia(tg);
				book.setNamXuatBan(nam);
				book.setNhaXuatBan(nxb);
				book.setTrangThai((stt==1)? true:false);
				
	            try
	            {
	            	db.updateSach(book);
	            	
	            	message = "Sua thong tin sach thanh cong.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Sua thong tin sach khong thanh cong."+e;
	            	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Sua thong tin sach khong thanh cong."+e;
	        	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "add":
			try
			{
				String ten = request.getParameter("tensach");
				int tl = Integer.parseInt(request.getParameter("theloai"));
				int st = Integer.parseInt(request.getParameter("sotrang"));
				int sl = Integer.parseInt(request.getParameter("soluong"));
				String tg = request.getParameter("tacgia");
				int nam = Integer.parseInt(request.getParameter("namxb"));
				String nxb = request.getParameter("nxb");
				
				TheLoai tll = new TheLoaiDAO().getTheLoaiByID(tl);
				
				Sach book = new Sach(tll,ten,sl,st,nam,nxb,tg,true);
	            try
	            {
	            	db.insertSach(book);
	            	
	            	message = "Them sach thanh cong.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Them sach khong thanh cong.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Them sach khong thanh cong.";
	        	RequestDispatcher xxx = request.getRequestDispatcher("sach.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			break;
		default:
			break;
		}
	}

}
