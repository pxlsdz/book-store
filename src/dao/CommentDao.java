package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Comment;
import util.JdbcUtil;

public class CommentDao {
	// 向数据库中添加comment记录的方法add()
	public void add(Comment comment) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into comment values(NULL,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, comment.getUsername());
			ps.setInt(2, comment.getBookid());
			ps.setString(3, comment.getText());
			ps.setString(4, getTime());
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// 根据id删除评论
	public void delete(int commentId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from comment where commentid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, commentId);
			ps.executeUpdate();
		} finally {
			JdbcUtil.free(null, ps, conn);
		}
	}

	// 根据bookid查询全部comment的方法
	public List<Comment> query(int bookid) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Comment> commentList = new ArrayList<Comment>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from comment where bookid ="+bookid;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCommentid(rs.getInt(1));
				comment.setBookid(rs.getInt(2));
				comment.setUsername(rs.getString(3));
				comment.setText(rs.getString(4));
				comment.setTime(rs.getString(5));
				commentList.add(comment);
			}
		} finally {
			JdbcUtil.free(rs, ps, conn);
		}
		return commentList;
	}

	// 获取当前时间
	public  String getTime() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
}
