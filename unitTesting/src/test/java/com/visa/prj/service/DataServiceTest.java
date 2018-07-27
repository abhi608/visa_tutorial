package com.visa.prj.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

public class DataServiceTest {
	
	@Mock
	private List<String> list = Mockito.mock(List.class);

	private DataService dataService;
	
	@Before
	public void setUp() throws Exception {
		dataService = new DataService();
		list.add("first");
		dataService.setList(list);
	}

	@After
	public void tearDown() throws Exception {
		dataService = null;
	}

	@Test
	public void testAdd() {
		String[] s1 = {"second", "third"}; 
		
		try {
			when(list.add(anyString())).thenReturn(true);
			when(list.size()).thenReturn(3);
			dataService.add(s1);
			verify(list, times(3)).add(anyString());
			assertEquals(3, dataService.getSize());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemove() {
		String s1 = "first";
		when(list.remove(anyString())).thenReturn(true);
		when(list.size()).thenReturn(1);
		dataService.remove(s1);
		verify(list, times(1)).remove(anyString());
		assertEquals(1, dataService.getSize());
	}

}
