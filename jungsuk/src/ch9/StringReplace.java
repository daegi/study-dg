package ch9;

public class StringReplace {
	private String source = "";        //000111222333111222333
	private int length;
	private StringBuffer buffer;

	//생성자 
	public StringReplace(String source) {	//000111222333111222333
		this.source = source;	
		length = source.length();	// 문자열 길이 21
		buffer = new StringBuffer(length + 100); // 21+100= 121
	}
	
	public int length() {
		return length;
	}

	public String replace(String old, String nw) {
		return replace(old, nw, 0);
	}

	public String replace(String old, String nw, int pos) {
		int index = 0;
		if (old == null || nw == null)
			return "null";
		if ((index = source.indexOf(old, pos)) != -1) {
			buffer.append(source.substring(pos, index));
			buffer.append(nw);

			replace(old, nw, index + old.length());
		} else {
			buffer.append(source.substring(pos));
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		
		String str = "000111222333111222333";
		System.out.println(str);
		StringReplace sr = new StringReplace(str);
		System.out.println(sr.replace("111", "AAA"));

	}

}
