package rationalnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TESTClass {

	public static void main(String[] args) 
	{
		int[] coeffiecentArray = ContinuedFractionUtils_Ortiz.computeCoefficients(5,3);

		List<Integer> continuedFractionTerms = new ArrayList<Integer>();
		for(int i = 0; i < coeffiecentArray.length; i++)
		{
			continuedFractionTerms.add(coeffiecentArray[i]);
			System.out.println(coeffiecentArray[i]);
		}

		RationalNumber rationalNumber = new RationalNumberImpl_Ortiz(continuedFractionTerms);
		
		List<Integer> continuedFractionTerms1 = Arrays.asList(new Integer[]{5,3});
		RationalNumber rationalNumber1 = new RationalNumberImpl_Ortiz(continuedFractionTerms1);
		
		
		System.out.println("RATIONAL NUMBER1: "+rationalNumber.toString());		
		System.out.println("RATIONAL NUMBER2: "+rationalNumber1.toString());	
		System.out.print( "VALUE: " +rationalNumber.getValue());
		System.out.println("\nNumerator: " + rationalNumber.getNumerator());
		System.out.println("Denominator: " + rationalNumber.getDenominator());
		
		RationalNumbersUtils.reciprocal(rationalNumber);
		System.out.println("-------ADD-----------");
		RationalNumbersUtils.add(rationalNumber, rationalNumber1);
		System.out.println("-------SUB-----------");
		RationalNumbersUtils.subtraction(rationalNumber, rationalNumber1);
		System.out.println("-------MULTIPLY-----------");
		RationalNumbersUtils.multiplication(rationalNumber, rationalNumber1);
		System.out.println("-------DIVIDE---------");
		RationalNumbersUtils.divide(rationalNumber, rationalNumber1);
		

	}


	
	
}
