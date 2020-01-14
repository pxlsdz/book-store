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
import dao.UserDao;

/**
 * Servlet implementation class Addinfo
 */
@WebServlet("/addinfo")
public class Addinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	   	request.setCharacterEncoding("UTF-8");
	   	response.setCharacterEncoding("UTF-8");
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
			String flag=request.getParameter("flag");
			session.setAttribute("flag", flag);
			UserDao userdao=new UserDao();
			OrderDao orderdao=new OrderDao();
			
			//ShopcarDao shopcardao=new ShopcarDao();
			int userid=0;
			String time="";
			request.setAttribute("totPrice", request.getParameter("totPrice"));
			
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
