package rent;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class VideoRentalShop {//비디오 렌탈 샵 클래스
	private Vector<Member> vecMem = new Vector<Member>();	//멤버벡터
	private Vector<VideoTitle> vecVdoTt = new Vector<VideoTitle>();// 비디오 타이틀 벡터
	private Vector<Video> vecVdo = new Vector<Video>();		// 비디오 벡터
	private Vector<Rental> vecRental = new Vector<Rental>();	//비디오 대여 벡터
	
	public void rentalVideo(){//비디오 빌리기 메소드
		if(this.vecMem.isEmpty() || this.vecVdo.isEmpty()){
			System.out.println("고객이나 비디오가 등록되어잇지 않습니다.");
			return;
		}
		int memSelect;
		int videoSelect;
		int rentalDay;
		System.out.println("비디오 대여 모듈입니다.");
		printMemberList(); //멤버 등록이 안되어 있으면 등록  
		System.out.print("대여할 고객을 선택해 주세요 : ");
		memSelect = new Scanner(System.in).nextInt();
		
		printVideoList();
		
		System.out.print("대여할 비디오를 선택해 주세요 : ");
		
		while(true){//선택한 비디오가 대여되었으면 경고문 출력 아니면 루프 탈출
			videoSelect = new Scanner(System.in).nextInt();
			if(this.vecVdo.get(videoSelect).getIsRental() == true)
				System.out.println("이미 대여된 비디오입니다.");
			else
				break;
		}
		
		System.out.print("대여할 기간을 입력해 주세요 : ");
		rentalDay = new Scanner(System.in).nextInt();
		
		vecRental.add(new Rental(vecMem.get(memSelect), vecVdo.get(videoSelect), new Date(), rentalDay));//비디오 랜탈 백터에  추가
		vecVdo.get(videoSelect).rented(vecMem.get(memSelect));
		vecMem.get(memSelect).setPointUp();
		
		if(vecMem.get(memSelect).getPoint() >= GradeStandard.GOLD)			vecMem.get(memSelect).setGrade(GoldGrade.getInstance());
		else if(vecMem.get(memSelect).getPoint() >= GradeStandard.SILVER)	vecMem.get(memSelect).setGrade(SilverGrade.getInstance());
		else if(vecMem.get(memSelect).getPoint() >= GradeStandard.BRONZE)	vecMem.get(memSelect).setGrade(BronzeGrade.getInstance());
		
	}
	
	public void returnVideo(){//비디오 반납 메소드
		if(this.vecRental.isEmpty()){
			System.out.println("반납할 비디오가 없습니다.");
			return;
		}
		
		int videoSelect;
		this.printRentalList();
		System.out.print("반납할 비디오를 선택해 주세요 : ");
		videoSelect = new Scanner(System.in).nextInt();
		
		for(int i = 0; i<vecVdo.size(); i++){
			if(vecVdo.get(i).getCode().equals(vecRental.get(videoSelect).getVideo().getCode())){
				vecVdo.get(i).returned();
			}
		}		
		vecRental.remove(videoSelect);
		System.out.println("비디오가 반납되었습니다.");
	}
	
	public void printRentalList(){
		System.out.println("비디오 대여 현황입니다.");
		for(int i=0; i<vecRental.size(); i++){
			System.out.print(""+i+ ". ");
			System.out.print(vecRental.get(i).getDate().getYear()+"년 ");
			System.out.print(vecRental.get(i).getDate().getMonth()+"월 ");
			System.out.print(vecRental.get(i).getDate().getDay()+"일 ");
			System.out.print(vecRental.get(i).getVideo().getCode()+" ");
			System.out.print(vecRental.get(i).getVideo().getVideoTitle().getTitle()+" ");
			System.out.print(vecRental.get(i).getVideo().getVideoTitle().getDirector()+" ");
			if(vecVdo.get(i).getIsRental())			System.out.print("OUT  ");
			else						   			System.out.print("IN ");
			if(vecVdo.get(i).getBorrower()==null)	System.out.print("  ");
			else									System.out.print(""+vecVdo.get(i).getBorrower().getName());			System.out.println();
			System.out.println();
		}
	}
	
	
	public void addMember(){
		boolean isAdd = vecMem.add(new Member());
		if(isAdd)
			System.out.println("고객이 추가되었습니다.");
		else
			System.out.println("고객 추가를 실패했습니다.");
	}
	
	public void addVideoTitle(){
		boolean isAdd = vecVdoTt.add(new VideoTitle());
		if(isAdd)
			System.out.println("비디오 타이틀이 추가되었습니다.");
		else
			System.out.println("비디오 타이틀 추가를 실패하였습니다.");
	}
	
	public void addVideo(){
		if(this.vecVdoTt.isEmpty()){
			System.out.println("타이틀이 등록되어있지 않습니다.");
			return;
		}
		
		System.out.println("비디오 타이틀 리스트를 출력합니다.");
		this.printVideoTitleList();
		System.out.print("비디오 번호를 선택해주세요 :");
		
		int select = new Scanner(System.in).nextInt();
		boolean isAdd = vecVdo.add(new Video(vecVdoTt.get(select)));
		if(isAdd)
			System.out.println("비디오"+vecVdoTt.get(select).getTitle()+"가 추가되었습니다.");
		else
			System.out.println("비디오 추가를 실패하였습니다.");
	}
	
	public void printMemberList(){
		if(this.vecMem.isEmpty()){
			System.out.println("등록된 맴버가 없습니다. 맴버를 추가해주세요.");
			return;
		}
		
		System.out.println("번호  아이디  이름  핸드폰번호  포인트  회원등급");
		
		for(int i=0; i<vecMem.size(); i++){
			System.out.print(""+i+ ". ");
			System.out.print(vecMem.get(i).getId()+" ");
			System.out.print(vecMem.get(i).getName()+" ");
			System.out.print(vecMem.get(i).getPhoneNum()+" ");
			System.out.print(vecMem.get(i).getPoint()+" ");
			System.out.print(vecMem.get(i).getGrade().getStrGrade()+" ");
			System.out.println();
		}
	}
		
	public void printVideoTitleList(){
		if(this.vecVdoTt.isEmpty()){
			System.out.println("비디오 타이틀이 비었습니다. 비디오 타이틀을 추가해주세요.");
			return;
		}
		
		System.out.println("번호  개봉년도  비디오제목  감독");
		
		for(int i=0; i<vecVdoTt.size(); i++){
			System.out.print(""+i+ ". ");
			System.out.print(vecVdoTt.get(i).getYear()+" ");
			System.out.print(vecVdoTt.get(i).getTitle()+" ");
			System.out.print(vecVdoTt.get(i).getDirector()+" ");
			System.out.println();
		}	
	}
	
	public void printVideoList(){
		if(this.vecVdo.isEmpty()){
			System.out.println("비디오 리스트가 비었습니다. 비디오를 추가해주세요.");
			return;
		}
		System.out.println("번호  코드   개봉년도    비디오제목   감독   대여여부   대여한사람");
		for(int i=0; i<vecVdo.size(); i++){
			System.out.print(""+i+ ". ");
			System.out.print(vecVdo.get(i).getCode()+" ");
			System.out.print(vecVdo.get(i).getVideoTitle().getYear()+" ");
			System.out.print(vecVdo.get(i).getVideoTitle().getTitle()+" ");
			System.out.print(vecVdo.get(i).getVideoTitle().getDirector()+" ");
			if(vecVdo.get(i).getIsRental())			System.out.print("OUT  ");
			else						   			System.out.print("IN ");
			if(vecVdo.get(i).getBorrower()==null)	System.out.print("  ");
			else									System.out.print(""+vecVdo.get(i).getBorrower().getName());
			System.out.println();
			}
	}
	
	
	
	public static void main(String[] args){
		VideoRentalShop vrs = new VideoRentalShop();
		Scanner sc = new Scanner(System.in);
		int sltMenu = 0;
		
		while(true){
			System.out.println("");
			System.out.println("================비디오대여점=======================");
			System.out.println("(1). 비디오 대여        (2). 비디오 반납");
			System.out.println("(3). 비디오 리스트 출력 (4). 타이틀 리스트 출력");
			System.out.println("(5). 비디오 대여 현황   (6). 고객 리스트 출력");
			System.out.println("(7). 고객 추가          (8). 비디오 타이틀 추가 ");
			System.out.println("(9). 비디오 추가        (0). 프로그램 종료");
			System.out.print("*** 메뉴를 입력해주세요 *** : ");
			try{
				sltMenu = sc.nextInt();
			}catch(InputMismatchException ime){
				System.err.println("에러! 정수가 아닌 실수/문자를 입력하셨습니다.");
			}
			System.out.println("");
			
			switch(sltMenu){
			case 1: vrs.rentalVideo(); break;
			case 2: vrs.returnVideo(); break;
			case 3: vrs.printVideoList(); break;
			case 4: vrs.printVideoTitleList(); break;
			case 5: vrs.printRentalList(); break;
			case 6: vrs.printMemberList(); break;
			case 7: vrs.addMember(); break;
			case 8: vrs.addVideoTitle(); break;
			case 9: vrs.addVideo(); break;
			case 0: System.out.println("프로그램을 종료합니다...."); return;
			default : System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 선택해주세요.");
			}
		}
	}
}
