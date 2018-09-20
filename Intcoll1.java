package intcoll1;

import java.util.*;

public class Intcoll1
{
   private int[] c;

   public Intcoll1()
   {
      	c = new int[2];
      	c[0] = 0;
   }

   public Intcoll1(int i)
   {
      	c = new int[i+1];
    	c[0] = 0;
   }

   public void copy(Intcoll1 obj)
   {
      	if (this != obj)
      	{
	    c = new int[obj.c.length];
	    int j = 0;
	    while (obj.c[j] != 0)
	    {
		c[j] = obj.c[j]; j++;
	    }
	    c[j] = 0;
	}
   }

   public boolean belongs(int i)
   {
      	int j = 0;
      	while ((c[j] > 0)&&(c[j] != i)){
            j++;
        }     
      	return (c[j] != 0);
   }

   public void insert(int i)
   {
      	if (i > 0)
	{
	    int j = 0;
	    while ((c[j] != 0) && (c[j] != i)) j++;
	    if (c[j] == 0)
	    {
		if (j == c.length - 1)
		{
                    

		}
		c[j] = i; c[j + 1] = 0;
	    }
	}
   }

   public void omit(int i)
   {
       if (i>0)
       {
      	  int j = 0;
      	  while ((c[j] != 0)&&(c[j] != i)) j++;
      	  if (c[j] == i)
      	  {
             int k = j+1;
             while (c[k] != 0) k++;
             c[j] = c[k-1]; c[k-1]=0;
      	  }
       }
   }

   public int get_howmany()
   {
      	int j=0, howmany=0;

      	while (c[j]!=0) {howmany++; j++;}
      	return howmany;
   }

   public void print()
   {
      	int j = 0;
      	System.out.println();
      	while (c[j] != 0)
      	{
           System.out.println(c[j]); j++;
      	}
   }

   public boolean equals(Intcoll1 obj)
   {
      	int j = 0; boolean result = true;
      	while ((c[j] != 0)&&result)
      	{
           result = obj.belongs(c[j]); j++;
      	}
      	j = 0;
      	while ((obj.c[j] != 0)&&result)
      	{
           result = belongs(obj.c[j]); j++;
      	}
      	return result;
   }
}




