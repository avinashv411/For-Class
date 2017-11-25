package abstraction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoreJavaAbstractionExample {
	
	public static void main(String[] args) {
		
		/*ArrayList myList = new ArrayList();
		myList.add("abc");
		myList.add("def");
		myList.add("ghi");
		myList.add("xyz");*/
		
		ArrayList<String> myList = new ArrayList<String>();
//		List<String> myList = new ArrayList<String>();
		myList.add("abc");
		myList.add("def");
		myList.add("ghi");
		myList.add("xyz");
		
		for(String val : myList){
			System.out.println(val);
		}
		
		System.out.println("--------------");
		
		Iterator<String> itr = myList.iterator();
		while(itr.hasNext()){
			String val = itr.next();
			System.out.println(val);
		}//End of while
		
	}//End of Main
}//End of Class
