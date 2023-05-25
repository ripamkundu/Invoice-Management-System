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
import vo.ProductVO;
/**
 * Servlet implementation class ProductUpdate
 */
@WebServlet("/ProductUpdate")
public class ProductUpdate extends HttpServlet {
	DaoImpl daoImpl=new DaoImpl();
	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdate() {
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
			String pname = request.getParameter("pname");
			String pdescription = request.getParameter("pdescription");
			String price = request.getParameter("price");
			
			ProductVO cvo = new ProductVO();
			cvo.setProductname(pname);
			cvo.setPdescription(pdescription);
			cvo.setPrice(price);
			cvo.setId(id);
			
			rvo = daoImpl.productUpdate(cvo);
		 	RequestDispatcher rd = getServletContext().getRequestDispatcher("/showproductdata");
			rd.include(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
