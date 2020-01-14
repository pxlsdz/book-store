package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.ShopcarDao;
import dao.UserDao;
import entity.Book;
import entity.Shopcar;

/**
 * Servlet implementation class IndexList
 */
@WebServlet("/indexList")
public class IndexList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexList() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BookDao bookdao=new BookDao();
		Book user=new Book();
		//推荐书籍
		try {
			List<Book> tjList=bookdao.querytj();
			request.setAttribute("tjList", tjList);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//最热图书
		try {
			List<Book> zrList=bookdao.queryzr();
			request.setAttribute("zrList", zrList);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//最新图书
		try {
			List<Book> zxList=bookdao.queryzx();
			request.setAttribute("zxList", zxList);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==""||username==null)
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else 
		{
			UserDao userdao=new UserDao();
			int userid;
			try {
				userid = userdao.findUserByName1(username);
				ShopcarDao shopcardao=new ShopcarDao();
				List<Shopcar>shopcarList=shopcardao.queryByUserId(userid);
				List<Book>shopbookList=new ArrayList<Book>();
				double totPrice=0;
				for(Shopcar it:shopcarList) 
				{
					int bookid=it.getBookid();
					Book book=bookdao.findbookById(bookid);
					System.out.println(book.getBookname());
					shopbookList.add(book);
					System.out.println(book.getPrice());
					totPrice+=book.getPrice();
				}
				request.setAttribute("totPrice", totPrice);
				request.setAttribute("shopbookList", shopbookList);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
