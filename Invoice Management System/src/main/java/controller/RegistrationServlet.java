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


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
	DaoImpl daoImpl=new DaoImpl();
	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			UserVO uvo=new UserVO();
			uvo.setUsername(username);
			uvo.setPassword(password);
			
			rvo = daoImpl.dataInsert(uvo);
			RequestDispatcher rd= getServletContext().getRequestDispatcher("/login.jsp");
			rd.include(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
