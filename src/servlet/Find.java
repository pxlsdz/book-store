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
 * Servlet implementation class Find
 */
@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find() {
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
	   	
	   	
	   	String temp=request.getParameter("page-search");
	   	request.setAttribute("pageSearch",temp);
	   	//System.out.println(find);
	   	
	   	int pageSize=10;
		int pageNo=1;
		
		String str=request.getParameter("pageNo");
		 if(str!=null&&str!="")
		 {
			pageNo= Integer.parseInt(str);
		 }
	
		 
	   	String sql="where bookname like '%"+temp+"%' or author like '%"+temp+"%' or publish like'%"+temp+"%' or text like'%"+temp+"%'";
	    BookDao bookDao=new BookDao();
	   	try {
	   		int recordCount=0;
	   		
	   		if(temp==null)
	   			recordCount=bookDao.getBookNum(" ");
	   		else
	   		    recordCount=bookDao.getBookNum(sql);
	   		
	   		if(recordCount>0){
	   		    List<Book> findList=new ArrayList<Book>();
	   		    if(temp==null)
	   			   findList=bookDao.query(pageNo ,pageSize, " ");
	   		    else
	   			   findList=bookDao.query(pageNo ,pageSize, sql);
			request.setAttribute("bookList", findList);
	   		}
			
			 
			int t1=recordCount%pageSize;
			int t2=recordCount/pageSize;
			int pageCount=(t1==0?t2:t2+1);
			request.setAttribute("recordCount", recordCount);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageCount", pageCount);
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	   	
	   	//request.getRequestDispatcher("books.jsp").forward(request, response);
		
	   	//全部图书
	   	HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		if(username==""||username==null)
		{
			request.getRequestDispatcher("books.jsp").forward(request, response);
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
					int bookId=it.getBookid();
					Book books=bookDao.findbookById(bookId);
					shopbookList.add(books);
					totPrice+=books.getPrice();
					//System.out.println(book.getPrice());
				}
				request.setAttribute("totPrice", totPrice);
				request.setAttribute("shopbookList", shopbookList);
				request.getRequestDispatcher("books.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("books.jsp").forward(request, response);
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
