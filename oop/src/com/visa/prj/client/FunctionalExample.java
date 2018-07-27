package com.visa.prj.client;

import java.util.function.BiFunction;

import com.visa.prj.util.Compute;

public class FunctionalExample {
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Double> f = (x, y) -> {
			return (double)(x/y);
		};
		
		System.out.println("Bifunction-1 " + f.apply(8, 6));
		
		Compute<Integer> c = (x, y) -> {
			int z = x + y;
			System.out.println(z);
		};
		c.add(4, 5);
	}
}
