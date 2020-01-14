package entity;

public class Comment {
int commentid,bookid;
String username,text,time;
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getCommentid() {
	return commentid;
}
public void setCommentid(int commentid) {
	this.commentid = commentid;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
}
