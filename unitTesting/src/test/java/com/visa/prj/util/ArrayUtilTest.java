package com.visa.prj.util;

import static org.junit.Assert.*;import java.lang.reflect.Array;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {4,5,1,10};
		int expected = 20;
		assertEquals(expected, ArrayUtil.getSum(data));
		
		int[] values = {-1,0,1};
		expected = 0;
		assertEquals(expected, ArrayUtil.getSum(values));
	}

	@Test
	public void testGetOccuranceCount() {
		int[] data = {5,2,3,5,6,5,1,8};
		int expected = 3;
		assertEquals(expected, ArrayUtil.getOccuranceCount(data, 5));
	}

	@Test
	public void testSort() {
		int[] data = {4,5,1,10};
		int[] expected = {1,4,5,10};
		ArrayUtil.sort(data);
		assertArrayEquals(expected, data);
 	}

}
