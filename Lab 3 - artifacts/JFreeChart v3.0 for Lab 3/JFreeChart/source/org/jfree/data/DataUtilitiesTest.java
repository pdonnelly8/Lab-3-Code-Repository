package org.jfree.data;

import java.lang.IllegalArgumentException;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {

	private Values2D values2DPos;
	private Values2D values2DNeg;
	private Values2D values2DMix;
	private KeyedValues keyedValuesPos;
	private KeyedValues keyedValuesNeg;
	private KeyedValues keyedValuesMix;
	private double[] data;
	private double[][] arr;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		DefaultKeyedValues2D testValuesNeg = new DefaultKeyedValues2D();
		DefaultKeyedValues2D testValuesMix = new DefaultKeyedValues2D();
		DefaultKeyedValues testKeyed = new DefaultKeyedValues();
		DefaultKeyedValues testKeyedNeg = new DefaultKeyedValues();
		DefaultKeyedValues testKeyedMix = new DefaultKeyedValues();
		values2DPos = testValues;
		values2DNeg = testValuesNeg;
		values2DMix = testValuesMix;
		keyedValuesPos = testKeyed;
		keyedValuesNeg = testKeyedNeg;
		keyedValuesMix = testKeyedMix;		
		/*
		 * values2DPos should look like:
		 *    col 0 1
		 * row 0[[1 2]
		 *     1 [3 4]]
		 */
		testValues.addValue(1,  0,  0);
		testValues.addValue(2,  0,  1);
		testValues.addValue(3,  1,  0);
		testValues.addValue(4,  1,  1);
		/*
		 * values2DNeg should look like:
		 *     col 0  1
		 * row 0[[-1 -2]
		 *     1 [-3 -4]]
		 */
		testValuesNeg.addValue(-1,  0,  0);
		testValuesNeg.addValue(-2,  0,  1);
		testValuesNeg.addValue(-3,  1,  0);
		testValuesNeg.addValue(-4,  1,  1);
		/*
		 * values2DMix should look like:
		 *     col 0 1
		 * row 0[[-1 2]
		 *     1[3 -4]]
		 */
		testValuesMix.addValue(-1,  0,  0);
		testValuesMix.addValue(2,  0,  1);
		testValuesMix.addValue(3,  1,  0);
		testValuesMix.addValue(-4,  1,  1);
		/*
		 * keyedValuesPos should look like:
		 * key	value
		 * 0	5
		 * 1	9
		 * 2	2
		 */
		testKeyed.addValue("0", 5);
		testKeyed.addValue("1", 9);
		testKeyed.addValue("2", 2);
		/*
		 * keyedValuesNeg should look like:
		 * key	value
		 * 0	-5
		 * 1	-9
		 * 2	-2
		 */
		testKeyedNeg.addValue("0", -5);
		testKeyedNeg.addValue("1", -9);
		testKeyedNeg.addValue("2", -2);
		/*
		 * keyedValuesMix should look like:
		 * key	value
		 * 0	5
		 * 1	-9
		 * 2	2
		 */
		testKeyedMix.addValue("0", 5);
		testKeyedMix.addValue("1", -9);
		testKeyedMix.addValue("2", 2);
		/*
		 * data should look like:
		 * [10.0 20.0 30.0]
		 */
		data = new double[3];
		data[0] = 10.0;
		data[1] = 20.0;
		data[2] = 30.0;
		/*
		 * arr should look like:
		 * [[1.0 2.0 3.0]
		 *  [4.0 5.0 6.0]
		 *  [7.0 8.0 9.0]]
		 */
		arr = new double[3][3];
		arr[0][0] = 1.0;
		arr[0][1] = 2.0;
		arr[0][2] = 3.0;
		arr[1][0] = 4.0;
		arr[1][1] = 5.0;
		arr[1][2] = 6.0;
		arr[2][0] = 7.0;
		arr[2][1] = 8.0;
		arr[2][2] = 9.0;
	}

	@After
	protected void tearDown() throws Exception {
		values2DPos = null;
		values2DNeg = null;
		values2DMix = null;
		keyedValuesPos = null;
		keyedValuesNeg = null;
		keyedValuesMix = null;
		data = null;
		arr = null;
	}

	@Test
	public void testCalculateColumnTotalPositiveCorrectDataAndCol() {
		assertEquals("Wrong Sum Returned. It should be 4.0", 4.0, DataUtilities.calculateColumnTotal(values2DPos, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalPositiveCorrectDataNegativeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DPos, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateColumnTotalPositiveCorrectDataTooLargeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DPos, 20), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateColumnTotalNegativeCorrectDataAndCol() {
		assertEquals("Wrong Sum Returned. It should be -4.0", -4.0, DataUtilities.calculateColumnTotal(values2DNeg, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalNegativeCorrectDataNegativeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DNeg, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateColumnTotalNegativeCorrectDataTooLargeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DNeg, 20), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateColumnTotalMixedCorrectDataAndCol() {
		assertEquals("Wrong Sum Returned. It should be -4.0", 2.0, DataUtilities.calculateColumnTotal(values2DMix, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalMixedCorrectDataNegativeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DMix, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateColumnTotalMixCorrectDataTooLargeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DMix, 20), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateColumnTotalNullDataValidCol() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalNullDataNegativeCol() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, -1);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotalNullDataTooLargeCol() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, 20);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalPositiveCorrectDataAndRow() {
		assertEquals("Wrong Sum Returned. It should be 3.0", 3.0, DataUtilities.calculateRowTotal(values2DPos, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalPositiveCorrectDataNegativeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DPos, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateRowTotalPositiveCorrectDataTooLargeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DPos, 20), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}	
	}
	
	@Test
	public void testCalculateRowTotalNegativeCorrectDataAndRow() {
		assertEquals("Wrong Sum Returned. It should be -3.0", -3.0, DataUtilities.calculateRowTotal(values2DNeg, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalNegativeCorrectDataNegativeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DNeg, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateRowTotalNegativeCorrectDataTooLargeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DNeg, 20), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}	
	}
	
	@Test
	public void testCalculateRowTotalMixCorrectDataAndRow() {
		assertEquals("Wrong Sum Returned. It should be 1.0", 1.0, DataUtilities.calculateRowTotal(values2DMix, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotalMixCorrectDataNegativeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DMix, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}
	}
	
	@Test
	public void testCalculateRowTotalMixCorrectDataTooLargeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DMix, 20), 0.0000001d);
		} catch (Exception e) {
			fail("Exception should not be thrown - Invalid Index must return 0 as per Method Specification");
		}	
	}
	
	@Test
	public void testCalculateRowTotalNullDataValidRow() {
		try 
		{
			DataUtilities.calculateRowTotal(null, 0);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalNullDataNegativeRow() {
		try 
		{
			DataUtilities.calculateRowTotal(null, -1);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotalNullDataTooLargeRow() {
		try 
		{
			DataUtilities.calculateRowTotal(null, 20);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayNullInput() {
		try {
			DataUtilities.createNumberArray(null);
			fail("TC2 Failed. No Exception was thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("TC2 Failed. Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayValidDataNotOnBoundary() {
		assertEquals("TC3 Failed. Incorrect Middle Value - Expected 20", 20.0, DataUtilities.createNumberArray(data)[1]);
	}
	
	@Test
	public void testCreateNumberArrayValidDataOnLeftBoundary() {
		assertEquals("TC4 Failed. Incorrect Left Boundary Value - Expected 10", 10.0, DataUtilities.createNumberArray(data)[0]);
	}
	
	@Test
	public void testCreateNumberArrayValidDataOnRightBoundary() {
		assertEquals("TC5 Failed. Incorrect Right Boundary Value - Expected 30", 30.0, DataUtilities.createNumberArray(data)[2]);
	}
	
	
	@Test
	public void testCreateNumberArrayValidDataPastLeftBoundary() {
		try {
			Number pastleft = DataUtilities.createNumberArray(data)[-1];
			fail("TC6 Failed. No Exception was thrown for index past left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC6 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayValidDataPastRightBoundary() {
		try {
			Number pastRight = DataUtilities.createNumberArray(data)[3];
			fail("TC6 Failed. No Exception was thrown for index past right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC7 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DNullInput() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("TC2 Failed. No Exception was thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("TC2 Failed. Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DNotOnBoundary() {
		assertEquals("TC3 Failed. Incorrect Middle Value - Expected 5", 5.0, DataUtilities.createNumberArray2D(arr)[1][1]);
	}
	
	@Test
	public void testCreateNumberArray2DOnLeftBoundary() {
		assertEquals("TC4 Failed. Incorrect Left Value - Expected 4", 4.0, DataUtilities.createNumberArray2D(arr)[1][0]);
	}
	
	@Test
	public void testCreateNumberArray2DOnRightBoundary() {
		assertEquals("TC5 Failed. Incorrect Right Value - Expected 6", 6.0, DataUtilities.createNumberArray2D(arr)[1][2]);
	}
	
	@Test
	public void testCreateNumberArray2DOnTopBoundary() { 
		assertEquals("TC6 Failed. Incorrect Top Value - Expected 2", 2.0, DataUtilities.createNumberArray2D(arr)[0][1]);
	}
	
	@Test
	public void testCreateNumberArray2DOnBottomBoundary() {
		assertEquals("TC7 Failed. Incorrect Bottom Value - Expected 8", 8.0, DataUtilities.createNumberArray2D(arr)[2][1]);
	}
	
	@Test
	public void testCreateNumberArray2DOnTopLeftBoundary() {
		assertEquals("TC8 Failed. Incorrect Top-Left Value - Expected 5", 1.0, DataUtilities.createNumberArray2D(arr)[0][0]);
	}
	
	@Test
	public void testCreateNumberArray2DOnBottomLeftBoundary() {
		assertEquals("TC9 Failed. Incorrect Bottom-Left Value - Expected 7", 7.0, DataUtilities.createNumberArray2D(arr)[2][0]);
	}
	
	@Test
	public void testCreateNumberArray2DOnTopRightBoundary() {
		assertEquals("TC10 Failed. Incorrect Top-Right Value - Expected 3", 3.0, DataUtilities.createNumberArray2D(arr)[0][2]);
	}
	
	@Test
	public void testCreateNumberArray2DOnBottomRightBoundary() {
		assertEquals("TC11 Failed. Incorrect Bottom-Left Value - Expected 9", 9.0, DataUtilities.createNumberArray2D(arr)[2][2]);
	}
	
	@Test
	public void testCreateNumberArray2DPastLeftBoundary() {
		try {
			Number pastLeft = DataUtilities.createNumberArray2D(arr)[1][-1];
			fail("TC12 Failed. No Exception was thrown for index past left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC12 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastRightBoundary() {
		try {
			Number pastRight = DataUtilities.createNumberArray2D(arr)[1][3];
			fail("TC13 Failed. No Exception was thrown for index past right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC13 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastTopBoundary() {
		try {
			Number pastTop = DataUtilities.createNumberArray2D(arr)[-1][1];
			fail("TC14 Failed. No Exception was thrown for index past top boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC14 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastBottomBoundary() {
		try {
			Number pastBottom = DataUtilities.createNumberArray2D(arr)[3][1];
			fail("No Exception was thrown for index past bottom boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastTopLeftBoundary() {
		try {
			Number pastTopLeft = DataUtilities.createNumberArray2D(arr)[-1][-1];
			fail("No Exception was thrown for index past top-left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastBottomLeftBoundary() {
		try {
			Number paatBottomLeft = DataUtilities.createNumberArray2D(arr)[3][-1];
			fail("No Exception was thrown for index past bottom-left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastTopRightBoundary() {
		try {
			Number pastTopRight = DataUtilities.createNumberArray2D(arr)[-1][3];
			fail("No Exception was thrown for index past top-right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DPastBottomRightBoundary() {
		try {
			Number pastBottomRight = DataUtilities.createNumberArray2D(arr)[3][3];
			fail("No Exception was thrown for index past bottom-right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesNullData() {
		try {
			KeyedValues nullPercentages = DataUtilities.getCumulativePercentages(null);
			fail("No Exception was thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesPositiveOnLeftBoundary() {
		assertEquals("Incorrect Percentage - Expected 0.3125", 0.3125, (double)DataUtilities.getCumulativePercentages(keyedValuesPos).getValue("0"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesPositiveNotOnBoundary() {
		assertEquals("Incorrect Percentage - Expected 0.875", 0.875, (double)DataUtilities.getCumulativePercentages(keyedValuesPos).getValue("1"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesPositiveOnRightBoundary() {
		assertEquals("Incorrect Percentage - Expected 1.0", 1.0, (double)DataUtilities.getCumulativePercentages(keyedValuesPos).getValue("2"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesNegativeOnLeftBoundary() {
		assertEquals("Incorrect Percentage - Expected 0.3125", 0.3125, (double)DataUtilities.getCumulativePercentages(keyedValuesNeg).getValue("0"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesNegativeNotOnBoundary() {
		assertEquals("Incorrect Percentage - Expected 0.875", 0.875, (double)DataUtilities.getCumulativePercentages(keyedValuesNeg).getValue("1"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesNegativeOnRightBoundary() {
		assertEquals("Incorrect Percentage - Expected 1.0", 1.0, (double)DataUtilities.getCumulativePercentages(keyedValuesNeg).getValue("2"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesMixOnLeftBoundary() {
		assertEquals("Incorrect Percentage - Expected 0.3125", 0.3125, (double)DataUtilities.getCumulativePercentages(keyedValuesMix).getValue("0"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesMixNotOnBoundary() {
		assertEquals("Incorrect Percentage - Expected -0.875", 0.875, (double)DataUtilities.getCumulativePercentages(keyedValuesMix).getValue("1"), 0.00000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesMixOnRightBoundary() {
		assertEquals("Incorrect Percentage - Expected -1.0", 1.0, (double)DataUtilities.getCumulativePercentages(keyedValuesMix).getValue("2"), 0.00000000001d);
	}
}
