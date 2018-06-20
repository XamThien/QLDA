package main.java.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import main.java.DAO.ChiTietMuonTraDAO;
import main.java.DAO.MuonTraDAO;
import main.java.DAO.SachDAO;
import main.java.model.ChiTietMuonTra;
import main.java.model.MuonTra;
import main.java.model.Sach;
import main.java.model.SessionMuonSach;



/**
 * Servlet implementation class SaveBill
 */
@WebServlet("/savebill")
public class SaveBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String mssv = request.getParameter("Mssv");
		String ten = request.getParameter("Ten");
		String lop = request.getParameter("Lop");
		
        HttpSession session = request.getSession();
        SessionMuonSach hoadon = (SessionMuonSach) session.getAttribute("hoadon");
        MuonTra hd = new MuonTra(mssv,ten,lop,true);
        ArrayList<ChiTietMuonTra> list = hoadon.getItems();
        String msg = "";
        MuonTraDAO mt = new MuonTraDAO();
        SachDAO bkd = new SachDAO();
        ChiTietMuonTraDAO ctdao = new ChiTietMuonTraDAO();
        if (list.isEmpty()) {
            msg = "Không có sản phẩm nào trong hóa đơn";
        }else if(!list.isEmpty()) {
            try {
                mt.insertMuonTra(hd);
                for (ChiTietMuonTra ct : list) {
                    
                	Sach bk = bkd.getSachByID(ct.getSach().getId());
                	bk.setSoLuong(bk.getSoLuong()-ct.getSoLuong());
                	bkd.updateSach(bk);
                    ctdao.insertTheLoai(ct);
                    
                }
                session.setAttribute("hoadon", null);
                msg = "success";
            } catch (Exception ex) {
                msg = "loi: " + ex.getMessage();
            }
        }
        response.getWriter().print(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
