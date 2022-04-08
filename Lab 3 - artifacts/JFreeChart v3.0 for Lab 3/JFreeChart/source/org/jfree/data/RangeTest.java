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
		try {
		Range r = new Range(2, 1);
		fail("No exception thrown");
	}
		catch(IllegalArgumentException e) {
			assertTrue("Incorrect error thrown, should be Illegal Arugment Exception", e.getClass().equals(IllegalArgumentException.class));
		}
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
		try {
		Range r = new Range(2, 1);
		fail("No exception thrown");
	}
		catch(IllegalArgumentException e) {
			assertTrue("Incorrect error thrown, should be Illegal Arugment Exception", e.getClass().equals(IllegalArgumentException.class));
		}
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
	
	@Test
	public void testConstrainInputLessThanRange() {
		Range r = new Range(2, 5);
		assertEquals("Range: 2, 5. Constraint: 1. Should return 2.", 2.0, r.constrain(1));
				
	}


										// Test Get Length
	@Test
	public void testGetLengthTwoPositiveInputs() {
		Range r = new Range(1, 2);
		assertEquals("Input values: 1 and 2. Should return 1", 1.0, r.getLength(), 0.000000001d);
	}
	
										// Test Hash code
	@Test
	public void testHashCodeReturnsCorrectType() {
		Range r = new Range(1, 2);
		int hash = r.hashCode();
		assertEquals("Incorrect Type returned - should be int", hash, r.hashCode());
	}
	
	
										// Test to string
	@Test
	public void testToStringReturnsCorrectType() {
		Range r = new Range(1, 2);
		assertEquals("Incorrect Type returned - Should be string", String.class, r.toString().getClass());
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
		try {
			Range r = new Range(2, 1);
			r.getLength();
			fail("No Exception thrown. Should throw IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
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
		assertFalse("Input Values: 1 and 4 - Lower 0 and Upper 0. Should return false", r.intersects(0,0));
	}
	
	@Test
	public void testExpandRangeNullRange () {
		try {
			Range r = new Range(1, 4);
			Range nullRange = r.expand(null, 1,3);
			fail("No Exception Thrown - should have thrown IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testExpandValidRangeAndMargins() {
		Range r = new Range(2, 6);
		Range expandRange = new Range(1, 8);
		assertEquals("Range does not equal expected output, should return a range from 1-8", expandRange, r.expand(new Range(2, 6), 0.25, 0.5));
	}
	
	@Test
	public void testExpandToIncludeNullRange () {
		Range r = new Range (1,3);
		Range expectedRange = new Range(4,4);
		assertEquals("Range does not equal expected output, should return a range of 2 and 2", expectedRange, r.expandToInclude(null, 4));
	}
	
	@Test
	public void testExpandToIncludeValueLessThanLowerBound () {
		Range r = new Range (1,3);
		Range expectedRange = new Range(0,3);
		assertEquals("Range does not equal expected output, should return a range of 0 and 3", expectedRange, r.expandToInclude(r, 0));
	}
	
	@Test
	public void testExpandToIncludeValueMoreThanUpperBound () {
		Range r = new Range (1,3);
		Range expectedRange = new Range(1,4);
		assertEquals("Range does not equal expected output, should return a range of 1 and 4", expectedRange, r.expandToInclude(r, 4));
	}
	
	@Test
	public void testExpandToIncludeValueWithinBound () {
		Range r = new Range (1,3);
		Range expectedRange = new Range(1,3);
		assertEquals("Range does not equal expected output, should return a range of 1 and 3", expectedRange, r.expandToInclude(r, 2));
	}
	
	@Test
	public void testShiftwithNoZeroCrossingValueGreaterThan0() {
		Range r = new Range(1,3);
		Range expectedRange = new Range(3,5);
		assertEquals("Range does not equal expected output, should return a range of 1 and 3",expectedRange,r.shift(r, 2, false));
	}
	
	@Test
	public void testShiftwithNoZeroCrossingValueLessThan0() {
		Range r = new Range(-1,3);
		Range expectedRange = new Range(0,5);
		assertEquals("Range does not equal expected output, should return a range of 0 and 5",expectedRange,r.shift(r, 2, false));
	}
	
	@Test
	public void testShiftwithNoZeroCrossingValueEquals0() {
		Range r = new Range(0,0);
		Range expectedRange = new Range(2,2);
		assertEquals("Range does not equal expected output, should return a range of 2 and 2",expectedRange,r.shift(r, 2));
	}
	
	@Test
	public void testShiftAllowZeroCrossing() {
		Range r = new Range(0,0);
		Range expectedRange = new Range(2,2);
		assertEquals("Range does not equal expected output, should return a range of 2 and 2",expectedRange,r.shift(r, 2, true));
	}
	
	
}
