package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.OrderDao;
import dao.UserDao;
import entity.Book;

/**
 * Servlet implementation class Buy
 */
@WebServlet("/buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8");
	   	
	   	HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==""||username==null)
		{
			PrintWriter out=response.getWriter();
			out.print("<script>alert('请先登录!');window.location.href='indexList'</script>");
		}
		else 
		{
			UserDao userdao=new UserDao();
			OrderDao orderdao=new OrderDao();
			
			//ShopcarDao shopcardao=new ShopcarDao();
			int userid=0;
			String time="";
			int bookid=Integer.parseInt(request.getParameter("bookid"));
			
			BookDao bookdao=new BookDao();
			try {
				Book book=bookdao.findbookById(bookid);
				request.setAttribute("totPrice", book.getPrice());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				userid=userdao.findUserByName1(username);
			  	time=orderdao.getTime();//获取下单时间	
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("userid", userid);
			request.setAttribute("time", time);
			try {
				String address=orderdao.querydz(userid);
				if(address!=null||address!="")
				{
					request.setAttribute("address", address);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("info.jsp").forward(request, response);
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
