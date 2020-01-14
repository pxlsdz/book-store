package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Shopcar;
import util.JdbcUtil;

public class ShopcarDao {
	// 添加一条购物车记录
	public void add(Shopcar shopcar) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into shopcar values (null,?,null,?,null,null,null,null) ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, shopcar.getUserid());
			//ps.setString(2, shopcar.getUsername());
			String temp=String.valueOf(shopcar.getBookid());
			ps.setString(2, temp);
			/*ps.setString(4, shopcar.getBookname());
			ps.setDouble(5, shopcar.getUnitprice());
			ps.setInt(6, shopcar.getNumber());
			ps.setDouble(7, shopcar.getTotalprice());*/
			System.out.println(shopcar.getUserid()+" "+temp);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// 根据bookid删除一条信息
	public void delete(String bookId ,int userid) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from shopcar where bookid= ? and userid= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookId);
			ps.setInt(2, userid);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}
	
	// 根据bookid删除全部购物车信息
		public void deleteqb(int userid) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "delete from shopcar where userid= ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				ps.executeUpdate();
			} finally {
				JdbcUtil.free(null, ps, conn);
			}
		}
	
	// 查询某一用户所有购物车记录的方法
	public List<Shopcar> query() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Shopcar> shopcarList = new ArrayList<Shopcar>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from shopcar ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Shopcar shopcar = new Shopcar();
				shopcar.setUserid(rs.getInt(1));
				shopcar.setUsername(rs.getString(2));
				shopcar.setBookid(rs.getInt(3));
				shopcar.setBookname(rs.getString(4));
				shopcar.setUnitprice(rs.getDouble(5));
				shopcar.setNumber(rs.getInt(6));
				shopcar.setTotalprice(rs.getDouble(7));
				shopcarList.add(shopcar);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return shopcarList;
	}
	// 查询某一用户所有购物车记录的方法
		public List<Shopcar> queryByUserId(int userid) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Shopcar> shopcarList = new ArrayList<Shopcar>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from shopcar where userid= ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userid);
				rs = ps.executeQuery();
				while (rs.next()) {
					Shopcar shopcar = new Shopcar();
					shopcar.setBookid(rs.getInt(1));
					shopcar.setUserid(rs.getInt(2));
					shopcar.setUsername(rs.getString(3));
					shopcar.setBookid(rs.getInt(4));
					shopcar.setBookname(rs.getString(5));
					shopcar.setUnitprice(rs.getDouble(6));
					shopcar.setNumber(rs.getInt(7));
					shopcar.setTotalprice(rs.getDouble(8));
					shopcarList.add(shopcar);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return shopcarList;
		}
}
