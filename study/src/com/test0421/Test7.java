package com.test0421;







import java.io.FileInputStream;

public class Test7 {

	public static void main(String[] args) {
		int data;

		try {
			// 파일이 존재하지 않으면 FileNoFoundException이 발생
			FileInputStream fis = new FileInputStream("test.txt");
			
			while ((data = fis.read()) != -1) {
				System.out.write(data);
			}
			System.out.flush(); //출력 스트림을 close하거나
			//출력스트림에서 flush() 하지 않으면
			//마지막 줄은 결과에 반영되지 않는다.
			//이유는 출력 버퍼가 차지않는 상태에서
			//버퍼의 내용을 출력 장치로 보내지 않기때문이다.
			//이런경우 flush() 를 호출하여 버퍼의 내용을
			//출력 장치로 보내면 간단하게 해결한다. 또는
			//출력장치를close()한다
			
			fis.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
