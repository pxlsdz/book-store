package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Order;
import util.JdbcUtil;

public class OrderDao {
	
	
	// 获取当前时间
		public String getTime() throws Exception {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(new Date());
		}

	// 向数据库中添加order记录的方法add()
	public void add(Order orde) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into orde values(NULL,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orde.getUserid());
			ps.setString(2, orde.getName());
			ps.setString(3, orde.getAddress());
			ps.setInt(4, orde.getPay());
			ps.setString(5, getTime());
			ps.setDouble(6, orde.getPrice());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}
	
	// 修改订单信息
	public void update(Order orde) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update orde set userid=?,name=?,address=?,pay=?,time=?,price=? where orderid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orde.getUserid());
			ps.setString(2, orde.getName());
			ps.setString(3, orde.getAddress());
			ps.setInt(4, orde.getPay());
			ps.setString(5, getTime());
			ps.setDouble(6, orde.getPrice());
			ps.setInt(7, orde.getOrderid());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// 根据id删除订单
	public void delete(int orderId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from orde where orderid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// 根据id查询order的方法findOrderById()
	public Order findOrderById(int orderId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order orde = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from orde where orderid=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			if (rs.next()) {
				orde = new Order();
				orde.setOrderid(rs.getInt(1));
				orde.setUserid(rs.getInt(2));
				orde.setName(rs.getString(3));
				orde.setAddress(rs.getString(4));
				orde.setPay(rs.getInt(5));
				orde.setTime(rs.getString(6));
				orde.setPrice(rs.getDouble(7));
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return orde;
	}
	
		public List<Order> query() throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Order> orderList = new ArrayList<Order>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from  orde";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Order orde = new Order();
					orde = new Order();
					orde.setOrderid(rs.getInt("orderid"));
					orde.setUserid(rs.getInt("userid"));
					orde.setName(rs.getString("name"));
					orde.setAddress(rs.getString("address"));
					orde.setPay(rs.getInt("pay"));
					orde.setTime(rs.getString("time"));
					orde.setPrice(rs.getDouble("price"));
					orderList.add(orde);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return orderList;
		}
		//通过id查找
		public List<Order> query1(int userid) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Order> orderList = new ArrayList<Order>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from orde where userid=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				rs = ps.executeQuery();
				while (rs.next()) {
					Order orde = new Order();
					orde = new Order();
					orde.setOrderid(rs.getInt("orderid"));
					orde.setUserid(rs.getInt("userid"));
					orde.setName(rs.getString("name"));
					orde.setAddress(rs.getString("address"));
					orde.setPay(rs.getInt("pay"));
					orde.setTime(rs.getString("time"));
					orde.setPrice(rs.getDouble("price"));
					orderList.add(orde);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return orderList;
		}
		
		//通过id查找最后的订单信息
				public String querydz(int userid) throws Exception {
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					List<Order> orderList = new ArrayList<Order>();
					try {
						conn = JdbcUtil.getConnection();
						String sql = "select * from orde where userid=? order by orderid desc";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, userid);
						rs = ps.executeQuery();
						while (rs.next()) {
							return rs.getString("address");
							/*Order orde = new Order();
							orde = new Order();
							orde.setOrderid(rs.getInt("orderid"));
							orde.setUserid(rs.getInt("userid"));
							orde.setName(rs.getString("name"));
							orde.setAddress(rs.getString("address"));
							
							orde.setPay(rs.getInt("pay"));
							orde.setTime(rs.getString("time"));
							orde.setPrice(rs.getDouble("price"));
							orderList.add(orde);*/
						}
					} finally {
						JdbcUtil.free(rs, ps, conn);
					}
					return null;
				}
		
		public List<Order> query(String fieldName,String fieldValue) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Order> orderList = new ArrayList<Order>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from  orde where "+fieldName+" like ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+fieldValue+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					Order orde=new Order();
					orde.setOrderid(rs.getInt("orderid"));
					orde.setUserid(rs.getInt("userid"));
					orde.setName(rs.getString("name"));
					orde.setAddress(rs.getString("address"));
					orde.setPay(rs.getInt("pay"));
					orde.setTime(rs.getString("time"));
					orde.setPrice(rs.getDouble("price"));
					orderList.add(orde);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			
			
			
			return orderList;
		}
		public int getRecordCount(String condition) throws Exception{
			 
			 Connection conn = null;
			 PreparedStatement pst = null;
			 ResultSet rs = null;
			int recordcount=0;
			try {
					conn = JdbcUtil.getConnection();
					String sql = "select count(*) from orde "+condition; 
					
					System.out.println(sql);
					
					pst = conn.prepareStatement(sql);
					rs=pst.executeQuery();
					rs.next();
					recordcount=rs.getInt(1);
					
					System.out.println(recordcount);
					
				}finally {
					JdbcUtil.free(rs, pst, conn);
				}
				return recordcount;
			 
		}
		public List<Order> query(String condition,int pageNo,int pageSize) throws Exception{
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Order> orderList=new ArrayList<Order>();
			int startrecno=(pageNo-1)*pageSize;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from orde "+condition+"  limit ?,? ";
				System.out.println("SQL语句："+sql);
				ps=conn.prepareStatement(sql);
				ps.setInt(1, startrecno);
				ps.setInt(2, pageSize);
				rs=ps.executeQuery();
				while(rs.next()){
					Order orde=new Order();
					orde.setOrderid(rs.getInt("orderid"));
					orde.setUserid(rs.getInt("userid"));
					orde.setName(rs.getString("name"));
					orde.setAddress(rs.getString("address"));
					orde.setPay(rs.getInt("pay"));
					orde.setTime(rs.getString("time"));
					orde.setPrice(rs.getDouble("price"));
					orderList.add(orde);
				}
			}finally {JdbcUtil.free(rs, ps, conn);}
			return orderList;
		}
		public void update(String userId, String userAddress) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "update orde set userAddress=? where userid=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, userAddress);
				ps.setString(2, userId);
				ps.executeUpdate();				
			} finally {
				JdbcUtil.free(null, ps, conn);
			}
		}
		
	
}
