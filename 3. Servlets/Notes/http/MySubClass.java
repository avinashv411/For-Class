package com.mycomp.myjavaapp.http;

public abstract class MySubClass extends MySuperClass
{
	@Override
	public void myMethod(Object obj1, Object obj2) {
		//Some Business Logic
		System.out.println("111111111");
		myMethod("", "");
	}
	
	public void myMethod(String str1, String str2) {
		//Some Other Business Logic
		System.out.println("2222222222");
		myAnotherMethod(str1, str2);
	}
	
	public void myAnotherMethod(String str1, String str2) {
		//Some Other Business Logic
		System.out.println("33333333333");
	}
}
