package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.JdbcUtil;

public class UserDao {
	// �����ݿ�������û���¼�ķ���add()
	public void add(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into user  values (NULL,?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// ����idɾ���û�
	public void delete(int userId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from user where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}


	// ����id��ѯ�û��ķ���findUserById()
				public User findUserByName(String name) throws Exception {
					Connection conn = null;
					PreparedStatement ps = null;
					ResultSet rs = null;
					User user = null;
					try {
						conn = JdbcUtil.getConnection();
						String sql = "select * from user where username=? ";
						ps = conn.prepareStatement(sql);
						ps.setString(1, name);
						rs = ps.executeQuery();
						if (rs.next()) {
							user = new User();
							user.setUserid(rs.getInt(1));
							user.setUsername(rs.getString(2));
							user.setPassword(rs.getString(3));
						}
					} finally {
						JdbcUtil.free(rs, ps, conn);
					}
					return user;
				}



	// ����id��ѯ�û��ķ���findUserById()
			public int  findUserByName1(String name) throws Exception {
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				User user = null;
				try {
					conn = JdbcUtil.getConnection();
					String sql = "select * from user where username=? ";
					ps = conn.prepareStatement(sql);
					ps.setString(1, name);
					rs = ps.executeQuery();
					if (rs.next()) {
						user = new User();
						user.setUserid(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setPassword(rs.getString(3));
					}
				} finally {
					JdbcUtil.free(rs, ps, conn);
				}
				return user.getUserid();
			}

	// ��ѯȫ���û��ķ���
	public List<User> query() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> UserList = new ArrayList<User>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from user ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User User = new User();
				User.setUserid(rs.getInt(1));
				User.setUsername(rs.getString(2));
				User.setPassword(rs.getString(3));
				UserList.add(User);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return UserList;
	}

	// �޸�����
	public void update(int userId, String password) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update user set password=? where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, userId);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// �޸��û���Ϣ
	public void update(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update user set username=?,password=? where userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserid());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}
	//�޸�����
		public void update(String username, String userPwd) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "update user set password=? where username=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, userPwd);
				ps.setString(2, username);
				ps.executeUpdate();
				
			} finally {
				JdbcUtil.free(null, ps, conn);
			}
		}

}
