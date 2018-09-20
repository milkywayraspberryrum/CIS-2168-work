/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringcoll;

import java.util.Scanner;

/**
 *
 * @author eschi
 */
public class MultiStringcollclient {
    public static final String SENTINEL = "###";

	public static void main(String[] args) {
		String value; 
		Scanner keyboard = new Scanner(System.in);
		MultiStringcoll P = new MultiStringcoll(), N = new MultiStringcoll(), L = new MultiStringcoll();

		System.out.println("Enter a String to be inserted or ### to quit:");
		value=keyboard.next();
		
		while(!value.equals(SENTINEL)) {
			if (value.charAt(0) == '+') { // add string into collection
				P.insert(value.substring(1)); // using substring because + and - are not a part of the string
				L.insert(value.substring(1));
			} 
			else if (value.charAt(0) == '-') { // remove string from collection
				N.insert(value.substring(1));
				L.omit(value.substring(1));
			}
			
			System.out.println("Enter next String to be inserted or ### to quit:");
			value = keyboard.next();
		}
		System.out.println("\nThe values in collection P are:");
		P.print();
		System.out.println("\nThe values in collection N are:");
		N.print();
		System.out.println("\nThe values in collection L are:");
                L.print();
		if (P.equals(N)) System.out.println("\nN and L are equal.");
		else System.out.println("\nN and L are NOT equal.");
		MultiStringcoll A=new MultiStringcoll(); A.copy(L);
		System.out.println("\nThe values in the copy of L are:\n");
		A.print();
		System.out.println();
	}
}

