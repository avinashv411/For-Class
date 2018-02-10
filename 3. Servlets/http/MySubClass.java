package http;

public abstract class MySubClass extends MySuperClass
{
	public void myMethod(Object obj1, Object obj2) 
	{
		//Some Business Logic
		System.out.println("1111111111");
		myMethod("", "");
	}//End of myMethod()
	
	public void myMethod(String str1, String str2) 
	{
		//Some Other Business Logic
		System.out.println("22222222222");
		myAnotherMethod(str1, str2);
	}//End of myMethod()
	
	public void myAnotherMethod(String str1, String str2) 
	{
		//Some More Business Logic
		System.out.println("33333333333");
	}//End of myMethod()


}//End of Class
