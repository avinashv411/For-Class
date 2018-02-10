package com.mycomp.myjavaapp.common;

public class PatternExample {
	
	public static void main(String[] args) {
		/*int[][] pattern = {
							{0, 0, 1, 0, 0},
							{0, 1, 0, 1, 0},
							{1, 1, 1, 1, 1},
						  };*/
		
		int[][] pattern = {
							{0, 0, 0, 0, 1, 0, 0},
							{0, 0, 0, 0, 1, 1, 0},
							{1, 1, 1, 1, 1, 1, 1},
							{0, 0, 0, 0, 1, 1, 0},
							{0, 0, 0, 0, 1, 0, 0},
						};
		
		PatternUtil.printPattern(pattern);
		
	}//End of Main
	
}//End of Class
