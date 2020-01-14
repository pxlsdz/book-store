package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class modipwd
 */
@WebServlet("/modipwd")
public class modipwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modipwd() {
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

	    HttpServletRequest requ = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
	    HttpSession session = requ.getSession(true);
	    String username=(String) session.getAttribute("username");
        String userPwd=request.getParameter("pwd1");
        UserDao userdao=new UserDao();
        PrintWriter out = response.getWriter();
        try {
			userdao.update(username,userPwd);
			request.setAttribute("updateans", "修改成功");
			//out.print("修改密码成功");
		
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			request.setAttribute("updateans", "修改失败");
		}
        request.getRequestDispatcher("UpdatePwd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
