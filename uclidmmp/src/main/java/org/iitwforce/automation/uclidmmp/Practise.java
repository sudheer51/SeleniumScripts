package org.iitwforce.automation.uclidmmp;

public class Practise {
	
	public static void main(String[] args) {
		
		String s=null;
		System.out.println(s.length());
		
		double d1= 	575.15;
		double d2 = 625.25;
		
		double change = (d2-d1)/0  * 100.0 ;
		System.out.println("value " + change);
		
		double result = Math.round(change*100.0)/100.0;
		System.out.println("after applying round::: " + result);
	}

}
