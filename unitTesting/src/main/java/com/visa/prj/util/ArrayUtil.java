package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {
	public static int getSum(int[] elems) {
		int sum = 0;
		for(Integer i : elems) {
			sum = sum + i;
		}
		return sum;
	}
	
	public static int getOccuranceCount(int[] elems, int no) {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(Integer i : elems) {
			if(i == no) {
				count++;
			}
		}
		return count;
	}
	
	public static void sort(int[] elems) {
		Arrays.sort(elems);
	}
}
