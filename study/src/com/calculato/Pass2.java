package com.calculato;

public class Pass2 {
   public static void main(String [] args) {
       int x=6;
       Pass2 p = new Pass2();
       p.test(x);
       System.out.print(" main x = "+ x);
   }

   void test(int x) {
       System.out.print(" doStuffx = "+ x++);
   }
}