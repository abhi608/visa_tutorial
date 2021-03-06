package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Consumer<T> {
	void accept(T obj);
}

@FunctionalInterface
interface Predicate<T> {
	boolean test(T obj);
}

public class FunctionalExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(34,67,2,78,1,98,23,15,20);
		List<Double> dlist = Arrays.asList(34.1,67.4,2.4,78.6,1.6,98.0,23.45,15.34,20.12);
		
//		List<Integer> listCopy = new ArrayList<>();
//		List<Double> dlistCopy = new ArrayList<>();
//		
//		copy(listCopy, list);
//		copy(dlistCopy, dlist);
//		
//		print(listCopy);
//		print(dlistCopy);
		
		
		
//		print(list);
//		print(dlist);
//		iterate(list, (arg) -> System.out.println(arg));
//		iterate(list, arg -> System.out.println(arg));
//		iterate(list, System.out::println);
//		iterate(dlist, System.out::println);
		
		List<Integer> even = filter(list, no -> no%2 == 0);
		print(even);
	}
	
	// High order function - should not be tightly coupled | should not modify state of object
	private static <T> List<T> filter(List<T> list, Predicate<T> pred){
		List<T> copy = new ArrayList<>();
		for(T t : list) {
			if(pred.test(t)) {
				copy.add(t);
			}
		}
		return copy;
	}
	
	private static <T> void print(List<T> list) {
		for(T obj : list) {
			System.out.println(obj);
		}
	}
	
	private static <T> void copy(List<T> list1, List<T> list2) {
		for(T obj : list2) {
			list1.add(obj);
		}
	}
	
//	private static <>
	
	private static <T> void iterate(List<? extends T> list, Consumer<? super T> cons) {
//		can store T or any of its supertype | if T is integer, ? super T includes Numbers and Object
		for(T i : list) {
			cons.accept(i);
		}
	}
}
