package main.java.controler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import main.java.DAO.*;
import main.java.model.*;


/**
 * Servlet implementation class AddChitietmuontra
 */
@WebServlet("/addchitietmuontra")
public class AddChitietmuontra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChitietmuontra() {
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
        Sach bk = new SachDAO().getSachByID(maSach);
        //MuonTra hd = new MuonTraDAO().getLast();
        MuonTra hdnew = new MuonTra(new MuonTraDAO().getLast().getId()+1);
        
        Date date = new Date();
        SimpleDateFormat datefrmat = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = datefrmat.format(date);
        try {
        	Sach hh = new SachDAO().getSachByID(maSach);
            HttpSession session = request.getSession();
            SessionMuonSach hoadon = (SessionMuonSach) session.getAttribute("hoadon");
            if (hoadon == null) {
                response.sendRedirect(request.getContextPath() +"/muonsach.jsp");
            } else {
                ChiTietMuonTra ct = new ChiTietMuonTra(hdnew, bk,datestr, 1,true);
                
                hoadon.addItem(ct);
                session.setAttribute("hoadon", hoadon);
                String txtresult = "";
                ArrayList<ChiTietMuonTra> rs = hoadon.getItems();
                
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
            }
        } catch (Exception ex) {
            response.getWriter().print("Lỗi: " + ex.getMessage());}
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
