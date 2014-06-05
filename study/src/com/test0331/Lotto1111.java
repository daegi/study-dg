package com.test0331;

public class Lotto1111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= new int[6];
		int i,j,k;
		int x;
		
		for(i=0;i<6;i++){
			x=(int)(Math.random()*45)+1;
				arr[i]=x;
			}
		
		for(int j1=0; j1<5; j1++)
			
			
			System.out.println(arr[j1]);
			
		}
	}
