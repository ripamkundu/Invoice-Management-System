package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.DaoImpl;
import vo.ResultVO;
import vo.UserVO;

//import javax.servlet.RequestDispatcher;
//import daoImpl.DaoImpl;
//import vo.ResultVO;
//import vo.UserVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	DaoImpl daoImpl=new DaoImpl();
//	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	// From login.jsp, as a post method only the credentials are passed
	// Hence the parameters should match both in jsp and servlet and
	// then only values are retrieved properly
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// We can able to get the form data by means of the below ways.
		// Form arguments should be matched and then only they are recognised
		// login.jsp component names should match and then only
		// by using request.getParameter, it is matched
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// To verify whether entered data is printing correctly or not
		System.out.println("username.." + username);
		System.out.println("password.." + password);
		UserVO uvo=new UserVO();
		uvo.setUsername(username);
		uvo.setPassword(password);
		String res=daoImpl.Login(uvo);
		if(res.equals("true"))
		{
			HttpSession httpSession = request.getSession(true);
//			 By setting the variable in session, it can be forwarded
			httpSession.setAttribute("username", username);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
