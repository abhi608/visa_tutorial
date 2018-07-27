package com.visa.prj.util;

@FunctionalInterface //only one method is allowed to be implemented
public interface Compute<T> {
	void add(T x, T y);
	default void sub(T x, T y) {
		System.out.println("Some code");
	}
}
