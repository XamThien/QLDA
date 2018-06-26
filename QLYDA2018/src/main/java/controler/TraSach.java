package main.java.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.DAO.*;
import main.java.model.*;

/**
 * Servlet implementation class TraSach
 */
@WebServlet("/trasach")
public class TraSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	
    	
		String action = request.getParameter("action");
		String message ="";
		switch(action)
		{
		case "full":
			try
			{
				int id = Integer.parseInt(request.getParameter("did"));
				
				
				MuonTra mt = new MuonTraDAO().getMuonTraByID(id);
				mt.setStatus(false);
	            
	            try
	            {
	            	new MuonTraDAO().updateMuonTra(mt);
	            	
	            	message = "Xác nhận trả sách thành công.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("danhsachmuon.jsp");
					request.setAttribute("msg", message );
					xxx.forward(request, response);
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Xác nhận trả sách không thành công .";
	            	RequestDispatcher xxx = request.getRequestDispatcher("chitetmuon.jsp?id="+id);
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Xác nhận trả sách không thành công .";
	        	RequestDispatcher xxx = request.getRequestDispatcher("danhsachmuon.jsp");
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		case "edit":
			int pid = Integer.parseInt(request.getParameter("pid"));
			try
			{
				
				int sid = Integer.parseInt(request.getParameter("sid"));
				int sl = Integer.parseInt(request.getParameter("sl"));
				if(sl<=0)
				{
					message = "Số lượng sách phải là số nguyên dương.";
	            	RequestDispatcher xxx = request.getRequestDispatcher("chitetmuon.jsp?id="+pid);
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
				int tt = Integer.parseInt(request.getParameter("tt"));
				boolean status = (tt==0)? false:true;
				try
	            {
					ChiTietMuonTra ctmt = new ChiTietMuonTraDAO().getByID(pid,sid);
					
					Sach bk = new SachDAO().getSachByID(sid);
					bk.setSoLuong(bk.getSoLuong()+ctmt.getSoLuong()-sl);
					new SachDAO().updateSach(bk);
					
					ctmt.setSoLuong(sl);
					ctmt.setXacNhanTra(status);
					new ChiTietMuonTraDAO().updateTheLoai(ctmt);
					
					List<ChiTietMuonTra> lst = new ChiTietMuonTraDAO().getTheLoaiByID(pid);
					if(lst.size()!=0)
					{
						message = "Chỉnh sửa thông tin sách mượn thành công.";
		            	RequestDispatcher xxx = request.getRequestDispatcher("chitetmuon.jsp?id="+pid);
						request.setAttribute("msg", message );
						xxx.forward(request, response);
					}
					else
					{
						MuonTra mt = new MuonTraDAO().getMuonTraByID(pid);
						mt.setStatus(false);
						new MuonTraDAO().updateMuonTra(mt);
						message = "Sinh viên đã trả đủ sách phiếu vừa xong.";
		            	RequestDispatcher xxx = request.getRequestDispatcher("danhsachmuon.jsp");
						request.setAttribute("msg", message );
						xxx.forward(request, response);
						
					}
	            	
	            	
	            }
	            catch(Exception e)
				{
	            	message = "Chỉnh sửa thông tin sách mượn không thành công ."+e;
	            	RequestDispatcher xxx = request.getRequestDispatcher("chitetmuon.jsp?id="+pid);
					request.setAttribute("msg", message );
					xxx.forward(request, response);
				}
			}
			catch(Exception e)
			{
				message = "Chỉnh sửa thông tin sách mượn không thành công ."+e;
	        	RequestDispatcher xxx = request.getRequestDispatcher("chitetmuon.jsp?id="+pid);
				request.setAttribute("msg", message );
				xxx.forward(request, response);
			}
			
			break;
		
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
