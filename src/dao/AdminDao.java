package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;
import util.JdbcUtil;

public class AdminDao {
		// �����ݿ�����ӹ���Ա��¼�ķ���add()
		public void add(Admin admin) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "insert into admin  values (NULL,?,?) ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, admin.getAdminname());
				ps.setString(2, admin.getPassword());
				ps.executeUpdate();
			} finally {
				JdbcUtil.free(null, ps, conn);
			}
		}
		//����idɾ������Ա
		public void delete(int adminId) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "delete from admin where adminid=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, adminId);
				ps.executeUpdate();
			} finally {
				JdbcUtil.free(null, ps, conn);
			}
		}
		//�޸�����
		public void update(int adminId, String password) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "update admin set Adminpwd=? where Adminid=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, password);
				ps.setInt(2, adminId);
				ps.executeUpdate();

			} finally {
				JdbcUtil.free(null, ps, conn);
			}

		}
		// �޸Ĺ���Ա��Ϣ
		public void update(Admin Admin) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "update Admin set Adminname=?,password=? where Adminid=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, Admin.getAdminname());
				ps.setString(2, Admin.getPassword());
				ps.setInt(3, Admin.getAdminid());
				ps.executeUpdate();
			} finally {
				JdbcUtil.free(null, ps, conn);
			}
		}
		// ����id��ѯ����Ա�ķ���findAdminById()
		public Admin findAdminById(int adminId) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Admin admin = null;
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from admin where adminid=? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, adminId);
				rs = ps.executeQuery();
				if (rs.next()) {
					admin = new Admin();
					admin.setAdminid(rs.getInt(1));
					admin.setAdminname(rs.getString(2));
					admin.setPassword(rs.getString(3));
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return admin;
		}
		// ��ѯȫ������Ա�ķ���
		public List<Admin> query() throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Admin> adminList = new ArrayList<Admin>();
			try {
				conn = JdbcUtil.getConnection();
				String sql = "select * from admin ";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Admin admin = new Admin();
					admin.setAdminid(rs.getInt(1));
					admin.setAdminname(rs.getString(2));
					admin.setPassword(rs.getString(3));
					adminList.add(admin);
				}
			} finally {
				JdbcUtil.free(rs, ps, conn);
			}
			return adminList;
		}
}
