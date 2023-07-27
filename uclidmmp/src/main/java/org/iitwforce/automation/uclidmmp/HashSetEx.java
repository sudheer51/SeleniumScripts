package org.iitwforce.automation.uclidmmp;

import java.util.HashSet;

public class HashSetEx {
	public static void main(String[] args) {
		//add() , size()
		//driver.getWindowHandles() -> Set
		HashSet<String> setEx = new HashSet<String>();
		setEx.add("James");
		setEx.add("John");
		setEx.add("Charlie");
		setEx.add("James");
		setEx.add("John");
		System.out.println("Number of the elements in size  ::: " + setEx.size());
		for(String s: setEx)
		{
			System.out.println(s);
		}
		
	}

}
