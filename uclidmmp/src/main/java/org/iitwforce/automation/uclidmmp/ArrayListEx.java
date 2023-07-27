package org.iitwforce.automation.uclidmmp;

import java.util.ArrayList;

public class ArrayListEx {

	public static void main(String[] args) {
		//Same Example with storing 5 string values
		//Example for findElements
		//add(),size(),get()
		
		
		ArrayList<Float> aList = new ArrayList<Float>();
		aList.add(12.5f);
		aList.add(10.0f);
		aList.add(12.5f);
		aList.add(10.0f);
		System.out.println("Total count of List " + aList.size());
		System.out.println("First value stored in the List" + aList.get(0));
		
		for(int i=0;i<aList.size();i++)
		{
			System.out.println(aList.get(i));
		}

		 
		
	}
	
}

//
//char ch='a';
//String s="selenium";
//int i =10;
