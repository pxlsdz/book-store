package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Center
 */
@WebServlet("/center")
public class Center extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Center() {
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
	   	PrintWriter out=response.getWriter();
	   	HttpSession session=request.getSession();
	   	String username=(String) session.getAttribute("username");
	   	
	   	if(username==""||username==null)
	   	{
	   		out.print("<script>alert('ÇëÏÈµÇÂ½!');window.location.href='indexList'</script>");
	   		//request.getRequestDispatcher("indexList").forward(request, response);
	   	}
	   	else 
	   	{
	   		request.setAttribute("username", username);
	   		request.getRequestDispatcher("personcenter.jsp").forward(request, response);
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
