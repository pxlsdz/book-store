package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import entity.Order;

/**
 * Servlet implementation class Addorder
 */
@WebServlet("/addorder")
public class Addorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
	   	//response.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8");
	   	PrintWriter out=response.getWriter();
	   	int userid=Integer.parseInt(request.getParameter("userid"));
	   	String name=request.getParameter("name");
	   	String totPrice=request.getParameter("totPrice");
	   	String time=request.getParameter("time");
	   	String address=request.getParameter("address");
	   	double Price=Double.parseDouble(totPrice);
	   	
	   	HttpSession session=request.getSession();
	   	String flag=(String)session.getAttribute("flag");
	   	System.out.println(flag);       /*************************/
	   	Order order=new Order(userid, name, address, 1, time, Price);
	   	OrderDao orderdao=new OrderDao();
	   	try {
			orderdao.add(order);
			if(flag.equals("1"))
			{
				out.print("<script>alert('支付成功!');window.location.href='deleteCarqb?userid="+userid+"'</script>");
			}
			else 
				out.print("<script>alert('支付成功!');window.location.href='center'</script>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("<script>alert('支付失败!');window.location.href='allbooks'</script>");
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
