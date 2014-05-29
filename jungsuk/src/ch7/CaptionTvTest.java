package ch7;

public class CaptionTvTest {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.caption);
		//System.out.println(ctv.power);
		System.out.println(ctv.channel);
		
		//ctv.displayCaption("hhh");
		ctv.caption = true;
		ctv.displayCaption("hhh");
		
		
		
		
		

	}

}

class Tv0 {
	boolean power;
	int channel;

	void power() {
		power = !power;
	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}
}

class CaptionTv extends Tv0 {
	boolean caption;

	void displayCaption(String text) {
		if(caption){
			System.out.println(text);
		}

	}
}
