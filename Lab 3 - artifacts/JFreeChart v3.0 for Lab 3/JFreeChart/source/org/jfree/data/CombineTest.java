package org.jfree.data;

import org.junit.After;
import org.jfree.data.Range;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class CombineTest extends TestCase {

	private Range rangeObjectUnderTest;

	@BeforeClass
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		
	}

	
	@Test 
	public void testCombineTwoValidRanges() { 
		Range r1 = new Range(1, 2);
	 	Range r2 = new Range(3, 6);
	 	Range finalrange = new Range(1,6);
	 	assertEquals("Input values: 1, 2 and 3, 6. Should return 1-6.", finalrange, Range.combine(r1, r2)); 
	}
	 

	@Test
	public void testCombineRangeTwoNull() {
		Range r1 = new Range(1, 2);
		Range r2 = null;
		assertEquals("Input values: 1, 2 and null. Should return error.", null, Range.combine(r1, r2));
	}
	

	@Test
	public void testCombineRangeOneNull() {
		Range r1 = null;
		Range r2 = new Range(3,6);
		assertEquals("Input values: null and 3, 6. Should return error.", r2, Range.combine(r1, r2));
	}

	@Test
	public void testCombineBothRangeNull() {
		Range r1 = null;
		Range r2 = null;
		assertEquals("Input values: null and null. Should return error.", null, Range.combine(r1, r2));
	}
}
	
	
	
	
	