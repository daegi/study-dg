package model;

import java.sql.Date;
//Data Transfer Object(데이터 전달 객체)
public class GuestbookDto {
// guestbook 테이블의 각각의 컬럼 이름과 자료형에 맞게 작성
	private int idx;
	private String name;
	private String email;
	private String content;
	private Date post_date;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
}





