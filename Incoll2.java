package Intcoll2;

import java.util.*;

public class Intcoll2
{
   private int[] c;
    public Intcoll2()
   {
      	c = new int[500+1];
      	c[0] = 0;
   }

   public Intcoll2(int i)
   {
      	c = new int[i+1];
    	c[0] = 0;
   }
/* if c is not an array of object obj, 
   everything in array c in object obj 
   and is put it in array c.
   */
   public void copy(Intcoll2 obj)
   {   
      	if (this != obj){
	 c = new int[obj.c.length];
	    for (int j = 0; j < c.length; j++){
            c[j] = obj.c[j]; 
                }
            }
        
   }
   /* This method returns true if int i is in the array c,
   and returns false if it is not in the array
   */
   public boolean belongs(int i){
      	for(int j = 0; j < c.length; j++){
        if (c[j] == i){
            return true;
        } 
      }
        return false;
   }
/* This method inserts i into any space where there is a 0 in the array c */
   public void insert(int i){
       if (i > 0){ 
           for (int j = 0; j < c.length; j++){
	    if (c[j] == 0){
                    c[j] = i;
                }
            
            }
        } 
    }
   /* This method takes out any occurence of 
   int i in array c.
   */
   public void omit(int i){
       if (i > 0){
      	 for (int j = 0; j < c.length; j++){
            if (c[j] == i){
                int k = j+1;
                c[j] = c[k];
                c[k] = 0;
                    }
                }
            }
        }
    
   /*This method returns the array with int i missing from the array  
   */
   public int get_howmany(){
      	int howmany = 0;
        for (int j = 0; j < c.length; j++){
            howmany++; 
        }
      	return howmany;
   }
/*This method prints every item in the array up to 0   
   */
   public void print(){
      	System.out.println();

        for (int j= 0; j < c.length; j++){
           System.out.println(c[j]);
           j++;
      	}
   }

   public boolean equals(Intcoll2 obj)
   {
        boolean result = true;
        for (int j = 0; j < c.length; j++){
           result = obj.belongs(c[j]); 
           
      	}
      	return result;
   }
}

/*compares two arrays and sees if they are the same array*/



