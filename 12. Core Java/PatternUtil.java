package com.mycomp.myjavaapp.common;

public class PatternUtil {
	
	private PatternUtil(){}
	
	private static final String STAR = "* ";
	private static final String SPACE = "  ";
	
	public static void printPattern(int[][] pattern){
		for(int[] row : pattern){
			printRow(row);
		}
	}//End of printPattern
	
	private static void printRow(int[] rowData){
		
		for(int data : rowData){
			String str = (data==1) ? STAR : SPACE;
			System.out.print(str);
//			System.out.print((data==1) ? STAR : SPACE);
		}
		System.out.println();
	}//End of printRow
	
}//End of Class






