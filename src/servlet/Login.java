package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		PrintWriter out=response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("userpwd");
		UserDao userdao=new UserDao();
		
		try {
			User user=userdao.findUserByName(username);
			if(user.getPassword().equals(password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				out.print("<script>alert('登录成功!');window.location.href='indexList'</script>");
			}
			else 
			{
				out.print("<script>alert('密码错误!');window.location.href='indexList'</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("<script>alert('用户不存在!');window.location.href='indexList'</script>");
		}
		
	}

	private char[] alert(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
