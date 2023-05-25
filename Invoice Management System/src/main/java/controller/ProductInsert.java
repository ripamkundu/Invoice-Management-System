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
import vo.ProductVO;

/**
 * Servlet implementation class ProductInsert
 */
@WebServlet("/productInsert")
public class ProductInsert extends HttpServlet {
	DaoImpl daoImpl = new DaoImpl();
	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsert() {
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
			String pname = request.getParameter("pname");
			String price = request.getParameter("price");
			String pdescription = request.getParameter("pdescription");
			ProductVO uvo = new ProductVO();
			uvo.setProductname(pname);
			uvo.setPrice(price);
			uvo.setPdescription(pdescription);

			rvo = daoImpl.productInsert(uvo);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/productform.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
