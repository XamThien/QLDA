package main.java.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


import main.java.model.ChiTietMuonTra;
import main.java.model.SessionMuonSach;

/**
 * Servlet implementation class Removechitietmuontra
 */
@WebServlet("/removechitietmuontra")
public class Removechitietmuontra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Removechitietmuontra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        int maSach = Integer.parseInt(request.getParameter("maSach"));
        HttpSession session = request.getSession();
        SessionMuonSach hoadon = (SessionMuonSach) session.getAttribute("hoadon");
        ChiTietMuonTra ct = hoadon.getItem(maSach);
        hoadon.remove(ct);
        session.setAttribute("hoadon", hoadon);
        try {
        	ArrayList<ChiTietMuonTra> rs = hoadon.getItems();
        	String txtresult = "";
            int i=1;
            
            for (ChiTietMuonTra ctiet : rs) {
                
                
                txtresult += "<tr for=\""+ctiet.getSach().getId()+"\">"
                        + "<td>"+i+"</td>"
                        + "<td>"+ctiet.getSach().getName()+"</td>"
                        + "<td>"+ctiet.getSach().getTacGia()+"</td>"
                        + "<td>"+ctiet.getSach().getNamXuatBan()+"</td>"
                        		+ "<td><input type=\"number\" style=\"text-align: center;\" class=\"form-control soluong\" value=\""+ctiet.getSoLuong()+"\" onchange= \"editBill(this);\"></td>"
                        
                        + "<td><a href=\"#\" onclick=\"confirmremove(\'"+ ctiet.getSach().getId() +"\');\"><span style=\"font-size: 30px; \"  class=\" fa fa-times-circle delproc\" ></span></a></td>"
                        + "</tr>";
                i++;
                
            }
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("list", txtresult);
            
            response.getWriter().print(jsonobject.toJSONString());
        } catch (Exception e) {
            response.getWriter().print("loi: "+ e.getMessage());
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
