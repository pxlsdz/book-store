package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import util.JdbcUtil;

public class BookDao {
	// �����ݿ������book��¼�ķ���add()
	public void add(Book book) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into book(bookname,cover,author,publish,category,price,tjsm,synopsis) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getCover());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublish());
			ps.setString(5, book.getCategory());
			ps.setDouble(6, book.getPrice());
			ps.setInt(7, book.getTjsm());
			ps.setString(8, book.getText());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// ����idɾ��ͼ��
	public void delete(int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from book where bookid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// ����id��ѯbook�ķ���findBookById()
	public Book findbookById(int bookId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from book where bookid= ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setCover(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPublish(rs.getString(5));
				book.setCategory(rs.getString(6));
				book.setPrice(rs.getDouble(7));
				book.setTjsm(rs.getInt(8));
				book.setText(rs.getString(9));
				book.setBuy_nummber(rs.getInt(10));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return book;
	}

	// ��ѯȫ��book�ķ���
	public List<Book> query() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from book ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setCover(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setPublish(rs.getString(5));
				book.setCategory(rs.getString(6));
				book.setPrice(rs.getDouble(7));
				book.setTjsm(rs.getInt(8));
				book.setText(rs.getString(9));
				book.setBuy_nummber(rs.getInt(10));
				bookList.add(book);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return bookList;
	}
	
	
	// �������ߺ�����ѯ�Ƽ�����鼮
				public List<Book> queryxg(int bookid,String author,String category) throws Exception {
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					List<Book> bookList = new ArrayList<Book>();
					try {
						conn = JdbcUtil.getConnection();
						String sql = "select * from book where author=? or category=?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, author);
						ps.setString(2, category);
						rs = ps.executeQuery();
						int cnt = 0;
						while (rs.next()&&(cnt++)<8) {
							if(rs.getInt(1)==bookid)
								continue;
							Book book = new Book();
							book.setBookid(rs.getInt(1));
							book.setBookname(rs.getString(2));
							book.setCover(rs.getString(3));
							book.setAuthor(rs.getString(4));
							book.setPublish(rs.getString(5));
							book.setCategory(rs.getString(6));
							book.setPrice(rs.getDouble(7));
							book.setTjsm(rs.getInt(8));
							book.setText(rs.getString(9));
							book.setBuy_nummber(rs.getInt(10));
							//System.out.println(book.getBookname());
							bookList.add(book);
						}
					}
					finally {
						JdbcUtil.free(rs, ps, conn);
					}
					//System.out.println(bookList.size());
					return bookList;
				}


	
	// ��ѯ�Ƽ�book�ķ���
		public List<Book> querytj() throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Book> bookList = new ArrayList<Book>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from book where tjsm=1";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Book book = new Book();
					book.setBookid(rs.getInt(1));
					book.setBookname(rs.getString(2));
					book.setCover(rs.getString(3));
					book.setAuthor(rs.getString(4));
					book.setPublish(rs.getString(5));
					book.setCategory(rs.getString(6));
					book.setPrice(rs.getDouble(7));
					book.setTjsm(rs.getInt(8));
					book.setText(rs.getString(9));
					book.setBuy_nummber(rs.getInt(10));
					bookList.add(book);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return bookList;
		}
	// ɾ������book��¼
	public void delete(int[] ids) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		String str = "id=" + ids[0];
		for (int i = 1; i < ids.length; i++) {
			str += " or " + "id=" + ids[i];
		}
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from Book where " + str;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// ��ѯ����book�ķ���
			public List<Book> queryzr() throws Exception {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				List<Book> bookList = new ArrayList<Book>();
				try {
					conn = JdbcUtil.getConnection();
					String sql = "select * from book order by buy_number desc";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					int cnt=0;
					while (rs.next()) {
						if(cnt>=4) break;
						cnt++;
						Book book = new Book();
						book.setBookid(rs.getInt(1));
						book.setBookname(rs.getString(2));
						book.setCover(rs.getString(3));
						book.setAuthor(rs.getString(4));
						book.setPublish(rs.getString(5));
						book.setCategory(rs.getString(6));
						book.setPrice(rs.getDouble(7));
						book.setTjsm(rs.getInt(8));
						book.setText(rs.getString(9));
						book.setBuy_nummber(rs.getInt(10));
						bookList.add(book);
					}
				} finally {
					JdbcUtil.free(rs, ps, conn);
				}
				return bookList;
			}
	//��ѯ����ͼ��
			public List<Book> queryzx() throws Exception {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				List<Book> bookList = new ArrayList<Book>();
				try {
					conn = JdbcUtil.getConnection();
					String sql = "select * from book order by bookid desc";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					int cnt=0;
					while (rs.next()) {
						if(cnt>=4) break;
						cnt++;
						Book book = new Book();
						book.setBookid(rs.getInt(1));
						book.setBookname(rs.getString(2));
						book.setCover(rs.getString(3));
						book.setAuthor(rs.getString(4));
						book.setPublish(rs.getString(5));
						book.setCategory(rs.getString(6));
						book.setPrice(rs.getDouble(7));
						book.setTjsm(rs.getInt(8));
						book.setText(rs.getString(9));
						book.setBuy_nummber(rs.getInt(10));
						bookList.add(book);
					}
				} finally {
					JdbcUtil.free(rs, ps, conn);
				}
				return bookList;
			}
			
			// ��ҳģ����ѯ(strΪ��ѯ����������Ϊ�մ�)
			public List<Book> query(int pageNo, int pageSize, String str) throws Exception {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				List<Book> bookList = new ArrayList<Book>();
				try {
					conn = JdbcUtil.getConnection();
					String sql = "select * from book " + str + " order by bookid limit ?,? ";
//					 (pageNo - 1) * 20 + "," + 20;
					ps = conn.prepareStatement(sql);
					ps.setInt(1, (pageNo - 1) * pageSize);
					ps.setInt(2, pageSize);
					rs = ps.executeQuery();
					while (rs.next()) {
						Book book = new Book();
						book.setBookid(rs.getInt(1));
						book.setBookname(rs.getString(2));
						book.setCover(rs.getString(3));
						book.setAuthor(rs.getString(4));
						book.setPublish(rs.getString(5));
						book.setCategory(rs.getString(6));
						book.setPrice(rs.getDouble(7));
						book.setTjsm(rs.getInt(8));
						book.setText(rs.getString(9));
						book.setBuy_nummber(rs.getInt(10));
						bookList.add(book);
					}
				} finally {
					JdbcUtil.free(rs, ps, conn);
				}
				return bookList;
			}

			// ��ѯ��¼����(strΪ��ѯ����������Ϊ�մ�)
			public int getBookNum(String str) throws Exception {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				int num = 0;
				try {
					conn = JdbcUtil.getConnection();
					String sql = "select count(*) from Book " + str;
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						num = rs.getInt(1);
					}
				} finally {
					JdbcUtil.free(rs, ps, conn);
				}
				return num;
			}

			// ��ѯҳ��(strΪ��ѯ����������Ϊ�մ�)
			public int getPageCount(String str, int pagesize) throws Exception {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				int count = 0, t1 = 0, t2 = 0;
				try {
					conn = JdbcUtil.getConnection();
					String sql = "select count(*) from Book " + str;
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						count = rs.getInt(1);
						t1 = count % pagesize;
						t2 = count / pagesize;
					}
				} finally {
					JdbcUtil.free(rs, ps, conn);
				}
				return t1 == 0 ? t2 : t2 + 1;
			}

	// ��ѯҳ��
	public int getPageCount(String str) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0, t1 = 0, t2 = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from Book " + str;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
				t1 = count % 10;
				t2 = count / 10;
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return t1 == 0 ? t2 : t2 + 1;
	}
}
