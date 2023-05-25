package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.DaoImpl;
import vo.ResultVO;
import vo.CustomerVO;

/**
 * Servlet implementation class CustomerUpdate
 */
@WebServlet("/CustomerUpdate")
public class CustomerUpdate extends HttpServlet {
	DaoImpl daoImpl=new DaoImpl();
	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdate() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String country = request.getParameter("country");
			
			CustomerVO cvo = new CustomerVO();
			cvo.setFirstname(fname);
			cvo.setLastname(lname);
			cvo.setEmail(email);
			cvo.setPhone(phone);
			cvo.setAddress(address);
			cvo.setCountry(country);
			cvo.setId(id);
			
			rvo = daoImpl.customerUpdate(cvo);
		 	RequestDispatcher rd = getServletContext().getRequestDispatcher("/showcustomerdata");
			rd.include(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
