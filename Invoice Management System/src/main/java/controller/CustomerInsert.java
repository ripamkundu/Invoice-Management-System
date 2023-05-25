package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import daoImpl.DaoImpl;
import vo.ResultVO;
import vo.UserVO;
import vo.CustomerVO;

/**
 * Servlet implementation class CustomerInsert
 */
@WebServlet("/customerInsert")
public class CustomerInsert extends HttpServlet {
	DaoImpl daoImpl = new DaoImpl();
	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String country = request.getParameter("country");
			CustomerVO uvo = new CustomerVO();
			uvo.setFirstname(fname);
			uvo.setLastname(lname);
			uvo.setEmail(email);
			uvo.setPhone(phone);
			uvo.setAddress(address);
			uvo.setCountry(country);

			rvo = daoImpl.customerInsert(uvo);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerform.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
