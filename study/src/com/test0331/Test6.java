package com.test0331;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] a={{1,2,3},{5,4,6,7},{5,7}};
		
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[i].length;j++){
				System.out.printf("%4d",a[i][j]);
			}
			System.out.println();
		}

	}

}
