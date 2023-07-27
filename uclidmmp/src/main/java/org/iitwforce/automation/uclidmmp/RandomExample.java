package org.iitwforce.automation.uclidmmp;

import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {

		String s = randomString("IITWFLName");
		System.out.println(s);
	}
	public static String randomString(String s)
	{
		Random rand = new Random();
		char uppercaseCh = (char) (65+rand.nextInt(26));
		char lowerCaseCh = (char) (97+rand.nextInt(26));
		return s+uppercaseCh+lowerCaseCh;

	}

}
