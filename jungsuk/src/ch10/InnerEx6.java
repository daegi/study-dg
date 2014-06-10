package ch10;

public class InnerEx6 {

	Object iv = new Object() {
		void method() {
		}
	};
	static Object cv = new Object(){
		void method(){
			
		}
	};
	
	void myMethod6(){
		Object lv = new Object(){
			void method(){	
			}
		};
	}
}
