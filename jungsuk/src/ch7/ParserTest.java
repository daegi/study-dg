/*package ch7;

import com.sun.javafx.scene.paint.GradientUtils.Parser;

interface Parseable{
	public abstract void parse(String fileName);
}

class XMLParse implements Parseable{

	@Override
	public void parse(String fileName) {
		System.out.println(fileName+"- XML parsing completed.");
	}
}

class HTMLParse implements Parseable{
	public void parse(String fileName){
		System.out.println(fileName + "-HTML parsing completed");
	}
}






class ParserManager{
	public static Parseable getParse(String fileName);
	if(type.equals("xml")){
		return new XMLParse();
	}else{
		Parseable p = new HTMLParser();
		return p;
	
	}
}


public class ParserTest {

	public static void main(String[] args) {
		Parseable parser = ParseManager.getParse("XML");
		Parser.parse("document.xml");
		parser = ParseManager.getParser("HTML");
		parser.parse("document2.html");

	}

}
*/