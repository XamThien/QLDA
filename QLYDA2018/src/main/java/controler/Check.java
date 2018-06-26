package main.java.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.DAO.MuonTraDAO;
import main.java.model.MuonTra;
/**
 * Servlet implementation class Check
 */
@WebServlet("/check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mssv = request.getParameter("mssv");
		MuonTra mt = new MuonTraDAO().getMuonTraByMSSV(mssv);
		if(mt==null)
		{
			RequestDispatcher xxx = request.getRequestDispatcher("muonsach.jsp");
			request.setAttribute("mssv", mssv );
			xxx.forward(request, response);
		}
		else
		{
			response.sendRedirect("chitetmuon.jsp?id="+mt.getId());
		}
	}

}
