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
import vo.InvoiceVO;
/**
 * Servlet implementation class InvoiceInsert
 */
@WebServlet("/InvoiceInsert")
public class InvoiceInsert extends HttpServlet {
	DaoImpl daoImpl=new DaoImpl();
	ResultVO rvo = new ResultVO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceInsert() {
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
			String invoiceDate=request.getParameter("invoiceDate");
			String dueDate=request.getParameter("dueDate");
			String invoiceNo=request.getParameter("invoiceNo");
			String invoiceStatus=request.getParameter("invoiceStatus");
			String product=request.getParameter("product");
			String customer=request.getParameter("customer");
			String quantity=request.getParameter("quantity");
			String price=request.getParameter("price");
			String discount=request.getParameter("discount");
			String shippingCost=request.getParameter("shippingCost");
			InvoiceVO ivo=new InvoiceVO();
			ivo.setInvoiceDate(invoiceDate);
			ivo.setDueDate(dueDate);
			ivo.setInvoiceNo(invoiceNo);
			ivo.setInvoiceStatus(invoiceStatus);
			ivo.setProduct(product);
			ivo.setCustomer(customer);
			ivo.setQuantity(quantity);
			ivo.setPrice(price);
			ivo.setDiscount(discount);
			ivo.setShippingCost(shippingCost);
			
			rvo = daoImpl.invoiceInsert(ivo);
			RequestDispatcher rd= getServletContext().getRequestDispatcher("/chooseinvoice");
			rd.include(request, response);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
