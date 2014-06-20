package rent;
public class Rental {//대여 클래스
	private Member member;
	private Video video;
	private Date date;
	private int rentalPeriod;
	
	public Rental(Member member, Video video, Date dateRented ,int rentalPeriod){
		this.member = member;
		this.video = video;
		this.date = dateRented;
		this.rentalPeriod = rentalPeriod;
	}	
	
	public void setMember(Member mem){
		this.member = mem;
	}
	public void setVideo(Video vdo){
		this.video = vdo;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public void setRentalPeriod(int rentalPeriod){
		this.rentalPeriod = rentalPeriod;
	}
	public Member getMember(){
		return this.member;
	}
	public Video getVideo(){
		return this.video;
	}
	public Date getDate(){
		return this.date;
	}	
	public int getRentalPeriod(){
		return this.rentalPeriod;
	}
}