package ch12;

public class ThreadEx4 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i =0; i <300; i++){
			System.out.print("-");
		}
		System.out.print("소요시간 1:"+(System.currentTimeMillis()-startTime));
		System.out.println();
		
		for(int i=0; i<300; i++){
			System.out.print("|");
		}
		System.out.print("소요시간2:"+(System.currentTimeMillis() - startTime));
	}
}
