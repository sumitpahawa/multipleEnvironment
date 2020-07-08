package managers;

import java.util.Arrays;
import java.util.HashMap;

import org.testng.annotations.Test;

public class StringJava {
	@Test
	public void test22() {
		// TODO Auto-generated method stub
		String S1 = " Today is Sunday and it Holiday";
		String reverse = "";
		char[] str = S1.toCharArray();
		for (int i = str.length; i <= 1; i--) {
			reverse = reverse + S1.charAt(i);

		}
		System.out.println(reverse);
	}

	@Test
	public void test() {
		// TODO Auto-generated method stub
		String S1 = " Selenium java";
		String S2 = "Webdriver";
		String S3 = S1.replaceAll("java", "webdriver") + S2.replaceAll("Webdriver", " java");
		System.out.println(S3);
	}

	@Test
	public void test2() {
		// TODO Auto-generated method stub
		String S1 = " Today is Sunday and it Holiday";
		StringBuffer s2 = new StringBuffer(S1);
		String s3 = s2.reverse().toString();
		System.out.println(s3);

	}

	@Test
	public void test4() {
		System.out.println(reverse("reverseString"));
		System.out.println(checkAnagram("abced","bcaed"));
		swap(5,4);
		 int a[] = { 1, 2, 4, 5, 6 };
		miisingNumber(a);
		countCharInString("adbbbdbdbbdhhhvggghjh");

	}

	public String reverse(String str) {
		if ((str == null) || (str.length() <= 1))
			return str;
		else {
	
			return reverse(str.substring(1))+str.charAt(0);
		}
	}

	public boolean checkAnagram(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		if (n1 != n2)
			return false;
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();

		Arrays.sort(array1);
		Arrays.sort(array2);
		for (int i = 0; i < n1; i++) 
			if (array1[i] != array2[i])
				return false;
			
				return true;
			

		
		
	}
	
	public void swap(int a, int b) {
		int sum = a+b ;
		b = sum-b;
		a = sum -a;
		
		System.out.println("After swaping : "+a + "and" + b);
	}

	
	public void miisingNumber(int[]number) {
		int n = number.length+1;
		int sumofAllNumber= (n*(n+1))/2;
		
		int sumOfArray = 0;
		for(int i=0 ;i<number.length;i++ ) {
			sumOfArray +=  number[i];
			
		}
		int missing = sumofAllNumber - sumOfArray;
		System.out.println(missing);
	}
	
	public void countCharInString(String sgtr) {
		
		char [] array= sgtr.toCharArray();
		
		HashMap<Character,Integer> hmap = new HashMap<Character, Integer>();
		for (char c : array) {
			if(hmap.containsKey(c)) {
				hmap.put(c,hmap.get(c)+1);
			
			}
			else
			{
				hmap.put(c,1);
			}
		}
		
		System.out.println(hmap);
		
	}
}
