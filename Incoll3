/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Incoll3client;

/**
 *
 * @author eschi
 */
public class Intcoll3 {
   

   private boolean [] c;
   public Intcoll3()
   {
      	c = new boolean [500+1];
      	c[0] = true;
   }

   
/* if c is not an array of object obj, 
   everything in array c in object obj 
   and is put it in array c.
   */
   public void copy(Intcoll3 obj)
   {   
      	if (this != obj){
	 c = new boolean [obj.c.length];
	    for (int j = 0; j < c.length; j++){
            c[j] = obj.c[j]; 
                }
            }
        
   }
   /* This method returns true if int i is in the array c,
   and returns false if it is not in the array
   */
   public boolean belongs(boolean i){
      	for(int j = 0; j < c.length; j++){
        if (c[j] == i){
            return true;
        } 
      }
        return false;
   }
/* This method inserts i into any space where there is a 0 in the array c */
   public void insert(boolean i){ 
           for (int j = 0; j < c.length; j++){
	    if (c[j] == false){
                    c[j] = i;
                }
            
            }
        } 
    
   /* This method takes out any occurence of 
   int i in array c.
   */
   public void omit(boolean i){
        for (int j = 0; j < c.length; j++){
            if (c[j] == i){
                int k = j+1;
                c[j] = c[k];
                c[k] = false;
                    }
                }
            }
        
    
   /*This method returns 
   
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

   public boolean equals(Intcoll3 obj)
   {
        boolean result = true;
        for (int j = 0; j < c.length; j++){
           result = obj.belongs(c[j]); 
           
      	}
      	return result;
 
   }
}







