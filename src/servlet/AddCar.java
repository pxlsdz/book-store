package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShopcarDao;
import dao.UserDao;
import entity.Shopcar;

/**
 * Servlet implementation class AddCar
 */
@WebServlet("/addCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
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
	   	response.setContentType("text/html;charset=utf-8");
	   	int bookid=Integer.parseInt(request.getParameter("bookid"));
	   	
	   	HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==""||username==null)
		{
			PrintWriter out=response.getWriter();
			out.print("<script>alert('请先登录!');window.location.href='singleBook?bookid="+bookid+"'</script>");
		}
		else
		{
			UserDao userdao=new UserDao();
			try {
				int userid=userdao.findUserByName1(username);
				ShopcarDao shopcardao=new ShopcarDao();
				Shopcar shopcar=new Shopcar();
				
				shopcar.setBookid(bookid);
				shopcar.setUserid(userid);
				//System.out.println(shopcar.getBookid()+"     "+shopcar.getUserid());
				shopcardao.add(shopcar);
				PrintWriter out=response.getWriter();
				out.print("<script>alert('添加购物车成功!');window.location.href='singleBook?bookid="+bookid+"'</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
