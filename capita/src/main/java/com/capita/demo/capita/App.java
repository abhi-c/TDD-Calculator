package com.capita.demo.capita;

import java.io.InputStreamReader;
import java.util.Scanner;

import com.capita.demo.capita.util.Validator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Calculator" );
        
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("How many expressions you want to solve?");
        String no = scanner.nextLine();
        for(int i=0; i<Validator.getValidNumber(no);i++)
        {
        	System.out.println("Please enter your expression: ");
            String expression = scanner.nextLine();
            Calculator cal = new Calculator();
            String postfix = cal.convertToPostFixExpression(expression);
        }
        scanner.close();
      }
}
