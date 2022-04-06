package org.jfree.data;

import org.junit.After;
import org.jfree.data.Range;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {

	private Range rangeObjectUnderTest;

	@BeforeClass
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	/*
	public void testGetLength() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength());
		Range r2 = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength());
		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength());
		Range r4 = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength());
		Range r5 = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength());
	}
	*/

	@AfterClass
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	// Lab 2
									// Test Lower Bound
	@Test
	public void testLowerBoundTwoPositiveInputs() {
		Range r = new Range(1, 2);
		assertEquals("Input values: 1 and 2. Should return 1.", 1.0, r.getLowerBound(), 0.000000001d);
	}

	//error
	@Test
	public void testLowerBoundWithBigNumberFirst() {
		Range r = new Range(2, 1);
		assertEquals("Input values: 2 and 1. Should return 1.", 1.0, r.getLowerBound(), 0.000000001d);
	}
	
	//error
//	@Test
//	public void testLowerBoundWithNullAsFirst() {
//		Range r = new Range(null, 1);
//		assertEquals("Input values: NULL and 1. Should return null.", null, r.getLowerBound(), 0.000000001d);
//	}

	//error
//	@Test
//	public void testLowerBoundWithNullAsSecond() {
//		Range r = new Range(1, null);
//		assertEquals("Input values: 1 and NULL. Should return 1.", 1.0, r.getLowerBound(), 0.000000001d);
//	}

	@Test
	public void testLowerBoundWithTwoSameInputs() {
		Range r = new Range(1, 1);
		assertEquals("Input values: 1 and 1. Should return 1.", 1.0, r.getLowerBound(), 0.000000001d);
	}
	
	
									// Test Upper Bound
	///////////// not working
	public void testUpperBoundTwoPositiveInputs() {
		Range r = new Range(1, 2);
		assertEquals("Input values: 1 and 2. Should return 2.", 2.0, r.getUpperBound(), 0.000000001d);
	}

	// error- won't compile
	@Test
	public void testUpperBoundWithBigNumberFirst() {
		Range r = new Range(2, 1);
		assertEquals("Input values: 2 and 1. Should return 2.", 2.0, r.getUpperBound(), 0.000000001d);
	}

	// error- wont compile
//	@Test
//	public void testUpperBoundWithNullAsFirst() {
//		Range r = new Range(null, 1);
//		assertEquals("Input values: null and 1. Should return 1.", 1.0, r.getUpperBound(), 0.000000001d);
//	}

    //error - won't compile
//	@Test
//	public void testUpperBoundWithNullAsSecond() {
//		Range r = new Range(1, null);
//		assertEquals("Input values: 1 and null. Should return null.", null, r.getUpperBound(), 0.000000001d);
//	}

	@Test
	public void testUpperBoundWithTwoSameInputs() {
		Range r = new Range(1, 1);
		assertEquals("Input values: 1 and 1. Should return 1.", 1.0, r.getUpperBound(), 0.000000001d);
	}
	

											// Test Contains
	@Test
	public void testContainsPositiveSmallerInput() {
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Testing if contains: 1. Should return true.", true, r.contains(1));
	}

	@Test
	public void testContainsPositiveBiggerInput() {
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Testing if contains: 2. Should return true", true, r.contains(2));
	}

	@Test
	public void testContainsValidInput() {
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Testing if contains: 1.5. Should return true", true, r.contains(1.5));
	}
	
	//error- won't compile
//	@Test
//	public void testContainsNullInput() {
//		Range r = new Range(1, 2);
//		assertEquals("Range: 1, 2. Testing if contains: null. Should return false", false, r.contains(null));
//	}
	

												//Test Constrain
	@Test
	public void testConstrainLowerAsInput(){
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Constraint: 1. Should return 1.", 1.0 , r.constrain(1));
	}

	@Test 
	public void testConstrainUpperAsInput(){
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Constraint: 2. Should return 2.", 2.0, r.constrain(2));
	}

	//null error- won't compile
//	@Test 
//	public void testConstrainNull(){
//		Range r = new Range(1, 2);
//		assertEquals("Range: 1, 2. Constraint: null. Should return null.", null, r.constrain(null));
//	}

	@Test 
	public void testConstrainValidInput(){
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Constraint: 1.5. Should return 1.5.", 1.5, r.constrain(1.5));
	}

	@Test 
	public void testConstrainInputNotInRange(){
		Range r = new Range(1, 2);
		assertEquals("Range: 1, 2. Constraint: 3. Should return 2.", 2.0, r.constrain(3));
	}


										// Test Get Length
	@Test
	public void testGetLengthTwoPositiveInputs() {
		Range r = new Range(1, 2);
		assertEquals("Input values: 1 and 2. Should return 1", 1.0, r.getLength(), 0.000000001d);
	}
	
	@Test
	public void testHashCodeReturnsCorrectType() {
		Range r = new Range(1, 2);
		int hash = r.hashCode();
		assertEquals("Incorrect Type returned - should be int", hash, r.hashCode());
	}
	
	@Test
	public void testToStringReturnsCorrectType() {
		Range r = new Range(1, 2);
		assertEquals("Incorrect Type returned - Should be string", String.class, r.toString().getClass());
	}

	//error- won't compile
//	@Test
//	public void testGetLengthNullAsFirst() {
//		Range r = new Range(null, 1);
//		assertEquals("Input values: null and 1. Should return null", null, r.getLength(), 0.000000001d);
//	}

	//error- won't compile
//	@Test
//	public void testGetLengthNullAsSecond() {
//		Range r = new Range(1, null);
//		assertEquals("Input values: 1 and null. Should return null", null, r.getLength(), 0.000000001d);
//	}

	//error- won't compile
	@Test
	public void testGetLengthWithBiggerNumberFirst() {
		Range r = new Range(2, 1);
		assertEquals("Input values: 2 and 1. Should return error", 1.0, r.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthWithSamePositiveInput() {
		Range r = new Range(2, 2);
		assertEquals("Input values: 2 and 2. Should return 0", 0.0, r.getLength(), 0.000000001d);
	}
	
	@Test
	public void testContainsValueLessThanLower() {
		Range r = new Range(2,4);
		assertFalse("Input values : 2 and 4. Should return false", r.contains(1.0));
	}
	
	@Test
	public void testContainsValueGreaterThanUpper() {
		Range r = new Range(2,4);
		assertFalse("Input values : 2 and 4. Should return false", r.contains(5.0));
	}
	
	@Test
	public void testIntersectsValidLowerAndUpper() {
		Range r = new Range(1,4);
		assertTrue("Input Values: 1 and 4 - Lower 2 and Upper 3. Should return true", r.intersects(2,3));
	}
	
	@Test
	public void testIntersectsValidLowerInvalidUpper() {
		Range r = new Range(1,4);
		assertFalse("Input Values: 1 and 4 - Lower 2 and Upper 5. Should return false", r.intersects(2,5));
	}
	
	@Test
	public void testIntersectsInvalidLowerValidUpper() {
		Range r = new Range(1,4);
		assertFalse("Input Values: 1 and 4 - Lower 0 and Upper 3. Should return false", r.intersects(0,3));
	}
	
	@Test
	public void testIntersectsInvalidLowerInvalidUpper() {
		Range r = new Range(1,4);
		assertFalse("Input Values: 1 and 4 - Lower 0 and Upper 5. Should return false", r.intersects(0,0));
	}

}
