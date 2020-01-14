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
import dao.CommentDao;
import dao.ShopcarDao;
import dao.UserDao;
import entity.Book;
import entity.Comment;
import entity.Shopcar;

/**
 * Servlet implementation class SingleBook
 */
@WebServlet("/singleBook")
public class SingleBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleBook() {
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
	   	
		int bookid=Integer.parseInt(request.getParameter("bookid"));
	
		BookDao bookDao=new BookDao();
		Book book=new Book();
		try {
			 book =bookDao.findbookById(bookid);
			 request.setAttribute("book", book);
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		try {
			
			List<Book> xgList=new ArrayList<Book>();
	    	xgList =bookDao.queryxg(book.getBookid(),book.getAuthor(),book.getCategory());
			//System.out.println(xgList.size());
			request.setAttribute("xgList", xgList);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		CommentDao commentDao=new CommentDao();
		try {
			List<Comment> plList=commentDao.query(bookid);
			int plNum=plList.size();
			request.setAttribute("plNum", plNum);
			request.setAttribute("plList", plList);
			//request.getRequestDispatcher("single-book.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自动生成的 catch块
			e.printStackTrace();
		}
        //购物车
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==""||username==null)
		{
			request.getRequestDispatcher("single-book.jsp").forward(request, response);
		}
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
				int bookId=it.getBookid();
				Book books=bookDao.findbookById(bookId);
				shopbookList.add(books);
				totPrice+=books.getPrice();
				//System.out.println(book.getPrice());
			}
			request.setAttribute("totPrice", totPrice);
			request.setAttribute("shopbookList", shopbookList);
			//request.getRequestDispatcher("single-book.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("single-book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
