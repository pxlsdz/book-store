package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.catalina.User;

import dao.OrderDao;
import dao.UserDao;
import entity.Order;

/**
 * Servlet implementation class QueryByPageno
 */
@WebServlet("/queryByPageno")
public class QueryByPageno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryByPageno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("username");
		 UserDao userdao=new UserDao();
		int userid=0;
		 try {
			 
			userid=userdao.findUserByName1(username);
			
		} catch (Exception e1) {
			out.print("<script>alert('Äú»¹Ã»ÓÐµÇÂ½!');window.location.href='indexList'</script>");
		}
		 
		  OrderDao orderdao=new OrderDao();
		  //System.out.println(userid);
				try {
					List<Order>orderList=orderdao.query1(userid);
					request.setAttribute("orderList", orderList);
					request.getRequestDispatcher("look.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("look.jsp").forward(request, response);
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
