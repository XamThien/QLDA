package main.java.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import main.java.DAO.SachDAO;
import main.java.model.Sach;
import main.java.model.TheLoai;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/searchbook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
        String str = request.getParameter("txtsearch");
        SachDAO db = new SachDAO();
        try {
            List<Sach> rs = db.getLikeString(str);
//            if(rs!= null)
//		  	{
//		  		for(Sach bk :rs)
//		  		{
//		  			TheLoai tlk = bk.getTheLoai();
//		  			if(tlk.getStatus()==false)
//		  			{
//		  				rs.remove(bk);
//		  			}
//		  		}
//		  	}
            String strtext = "";
            for (Sach hh : rs) {
                strtext += "<li class=\"suggest-col\" value=\"" + hh.getId() + "\" onclick=\"addDetail(" + hh.getId() + ");\">"
                        + "<span class=\"fa fa-tags fa-custom\"></span>"
                        + "<span class=\"fa-custom text-muted\">Tên sách: <b>" + hh.getName() + "</b></span>"
                        + "<span class=\"fa-custom text-muted\">Tác giả: <b>" + hh.getTacGia() + "</b></span>"
                        + "<span class=\"fa-custom text-muted\">Năm xuất bản: <b>" + hh.getNhaXuatBan() + "</b> </span>"
                        + "<span class=\"text-muted\">Số lượng hiện có: <b>" + hh.getSoLuong() + "</b></span>"
                        + "</li>";
            }
            response.getWriter().print(strtext);
        } catch (Exception ex) {
            response.getWriter().print("Lỗi truy vấn dữ liệu : " + ex.getMessage());
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
