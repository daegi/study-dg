package rent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Video {//비디오 클래스
	private String code;
	private VideoTitle vdoTt;
	private boolean isRantal;
	private Member borrower;
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	public Video(VideoTitle vdoTt){
		this.vdoTt = vdoTt;		
		try {
		System.out.print("비디오 코드를 입력하세요 : ");
			code = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.print("비디오 생성중 오류");
			e.printStackTrace();
		}		
		this.isRantal = false;
		this.borrower = null;
	}
		
	public void setCode(String code){
		this.code = code;
	}
	
	public void rented(Member mem){
		borrower = mem;
		isRantal = true;
	}
	
	public void returned(){
		borrower = null;
		isRantal = false;
	}
	
	
	public String getCode(){
		return this.code;
	}
	
	public VideoTitle getVideoTitle(){
		return this.vdoTt;
	}
	
	public boolean getIsRental(){
		return this.isRantal;
	}
	
	public Member getBorrower(){
		return borrower;
	}
}
