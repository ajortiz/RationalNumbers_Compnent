/*Amanda Ortiz 
 * Fall 2016 - Algorithms - Kart 
 * Rational Numbers to Continued Fractions
 */
package rationalnumbers;

import java.util.ArrayList;
import java.util.List;

public class RationalNumbersUtils 
{

	//rv is true <==> r1 = r2 as rational number
	public static boolean equal(RationalNumber r1, RationalNumber r2)
	{
		if(r1.getNumerator() == r2.getNumerator() && r1.getDenominator() == r2.getDenominator())
		{
			return true;
		}

		return false;
	}
	/*------------------------------
	* --------ADDITION-------------
	* -----------------------------
	*/
	//rv is r1 + r2, where + is regular numerical addition
	public static RationalNumber add(RationalNumber r1, RationalNumber r2)
	{
		int finalRationalNumberNumerator = getAddedRationalNumberNumerator(r1, r2);
		int finalRationalNumberDenominator = getAddedRationalNumberDenominator(r1, r2); 
		List<Integer> coefficientList  = new ArrayList<Integer>();
				
		coefficientList = coefficientArrayToList(finalRationalNumberNumerator,finalRationalNumberDenominator);
		RationalNumber additionResult = new RationalNumberImpl_Ortiz(coefficientList);
		
		System.out.println("ADD: " + additionResult.toString());
		return additionResult;
		//hi
	}

	/*------------------------------
	* --------SUBTRACTION-----------
	* ------------------------------
	*/
	//rv is r1 + r2, where + is regular numerical subtraction
	public static RationalNumber subtraction(RationalNumber r1, RationalNumber r2)
	{
		RationalNumber ratNum = add(r1, negate(r2));
		
		System.out.println("SUB: "  + ratNum.toString());
		return ratNum;
	}
	
	
	/*------------------------------
	* --------MULTIPLICAITON-----------
	* ------------------------------
	*/
	//rv is r1 + r2, where + is regular numerical multiplication
	public static RationalNumber multiplication(RationalNumber r1, RationalNumber r2)
	{
		int multipliedRationalNumberNumerator = r1.getNumerator() * r2.getNumerator();
		int multipliedRationalNumberDenominator = r1.getDenominator() * r2.getDenominator();
		
		List<Integer> coefficientList  = new ArrayList<Integer>();
		coefficientList = coefficientArrayToList(multipliedRationalNumberNumerator,multipliedRationalNumberDenominator);
		
		RationalNumber product = new RationalNumberImpl_Ortiz(coefficientList);
		System.out.println("MULT: " + product);
		return product;


	}
	
 	/*------------------------------
	* --------DIVISION--------------
	* ------------------------------
	*/
	//rv is r1 + r2, where + is regular numerical division
	public static RationalNumber divide(RationalNumber r1, RationalNumber r2)
	{

		RationalNumber reciprocatedNumber = reciprocal(r2);
		System.out.println("RECIP: " + reciprocatedNumber);
		RationalNumber dividedRationalNumber = multiplication(r1,reciprocatedNumber);
	
		System.out.println("DIV: " + dividedRationalNumber.toString());
		
		
		return dividedRationalNumber;

	}
	
	/*------------------------------
	* --------NEGATE----------------
	* ------------------------------
	*/
	//rv = -r1, where - is regular numerical addition
	public static RationalNumber negate(RationalNumber r1)
	{
		List<Integer> coefficientList  = new ArrayList<Integer>();
		
		coefficientList = coefficientArrayToList(-r1.getNumerator(), r1.getDenominator());
		RationalNumber result = new RationalNumberImpl_Ortiz(coefficientList);

		return result;

	}

	/*------------------------------
	* --------RECIPROCAL-----------
	* ------------------------------
	*/
	public static RationalNumber reciprocal(RationalNumber r1)
	{
		
		List<Integer> coefficientList  = new ArrayList<Integer>();
		
		coefficientList = coefficientArrayToList(r1.getDenominator(), r1.getNumerator());
		RationalNumber reciprocalOfRationalNumber = new RationalNumberImpl_Ortiz(coefficientList);

	
		return reciprocalOfRationalNumber;

	}
	 
	//to convert to a String so user can see results
	public static String toString(RationalNumber ratNum) 
	{ 
		if (ratNum.getDenominator() == 1) 
		{
			return ratNum.getNumerator() + "";
		}
		else          
		{
			return ratNum.getNumerator() + "/" + ratNum.getDenominator();
		}
	}
	
	//PRIVATE - NO LOOKING
	private static List<Integer> coefficientArrayToList (int numerator, int denominator)
	{
		List<Integer> coefficientList  = new ArrayList<Integer>();
		int[] coefficientArray = ContinuedFractionUtils_Ortiz.computeCoefficients(numerator, denominator);
		
		for(int i = 0; i < coefficientArray.length; i++)
		{
			coefficientList.add(coefficientArray[i]);
		}
		
		return coefficientList;
	}
	
	private static int getAddedRationalNumberDenominator(RationalNumber r1, RationalNumber r2) 
	{
		int finalRationalNumberDenominator = (r1.getDenominator() * r2.getDenominator());
		return finalRationalNumberDenominator;
	}


	private static int getAddedRationalNumberNumerator(RationalNumber r1, RationalNumber r2) 
	{
		int finalRationalNumberNumerator = (r1.getNumerator() * r2.getDenominator()) + (r2.getNumerator()* r1.getDenominator());

		return finalRationalNumberNumerator;
	}
}
