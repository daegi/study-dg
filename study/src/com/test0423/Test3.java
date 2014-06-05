package com.test0423;

public class Test3 {

	public static void main(String[] args) {
		byte[] b;

		String name = new String("대한민국"), s;

		try {
			// 디폴트 캐릭터 셋
			s = System.getProperty("file. encoding");
			System.out.println("디폴트 캐릭터셋 : " + s + "\n");

			// 디폴트 캐릭터셋으로 바이트 배열 리턴
			b = name.getBytes();
			System.out.println("디폴트 길이 : " + b.length + "\n");
			for (byte bb : b) {
				String ss = Integer.toHexString(bb);
				ss = ss.substring(ss.length() - 2);
				System.out.print(ss + "  ");
			}
			System.out.println();

			// utf-8로 변환

			b = name.getBytes("utf-8");
			System.out.println("UTF-8 길이 : " + b.length);
			for (byte bb : b) {
				String ss = Integer.toHexString(bb);
				ss = ss.substring(ss.length() - 2);
				System.out.println(ss + " ");
			}

			System.out.println();
			// utf-8로 저장된 바이트 배열을 String 객체로
			// 파라미터 값으로 "utf-8" 을 주고 생성
			// utf-8을 주지 않으면 글자가 깨짐
			System.out.println("val1:" + new String(b, "utf-8"));
			System.out.println("vaa2" + new String(b));
			System.out.println();

			/*
			 * euc-kr을 utf-8로 변환한다고 아래와 같이 코딩하면 이러한 변환 때문에 바이트 배열이 깨져서 euc-kr이든
			 * utf-8이든 어떠한 바이트 배열로 읽어오든 깨져있는 것을 확인할 수 있다. 이미 깨져서 생성된 String 객체의
			 * 바이트 배열은 어떻게든 복구가 불가능 하다.
			 */
			String con = new String(s.getBytes("euc-kr"), "utf-8");
			System.out.println(con);
			b = con.getBytes();
			System.out.println("Length : " + b.length);
			b = con.getBytes("utf-8");
			System.out.println("Length : " + b.length);
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
