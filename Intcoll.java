/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeproject;

import java.util.*;
import java.io.*;
/**
 *
 * @author eschi
 */
public class Intcoll {
    
    private int howmany;
    private btNode c;
    
    private static class btNode{
       private int info;
       private btNode left, right;
      
       public btNode(){
           info = 0;
           left = right = null;
       }
       
       public btNode(int i, btNode lt, btNode rt){
           info = i;
           left = lt;
           right = rt;
       }
   } 
    public Intcoll() {
        c = null;
        howmany = 0;
        
}
    public Intcoll(int i){
        c = null;
        howmany = 0;
    }
    private static btNode copytree(btNode t){
        btNode root = null;
        if (t != null){
            root = new btNode();
            root.info = t.info;
            root.left = copytree(t.left);
            root.right = copytree(t.right);
        }
        return root;
    }
    
    public void copy(Intcoll obj){
        if (this != obj){
            howmany = obj.howmany;
            c = copytree(obj.c);
        }
    }
    
    public void insert(int i){
        if(i > 0){
            btNode pred = null;
            btNode p = c;
            while ((p != null) && (p.info != i)){ //while there is a parent and the parent is not i
                pred = p;
                if (p.info > i) p = p.left;
                else { p =p.right;
                }
            }
            if (p == null){
                howmany++;
                p = new btNode(i, null, null);
                if (pred != null)
                {
                    if (pred.info > i){ pred.left = p;}
                    else{ pred.right = p;}
                
                }
                else { c = p;}
                }
            }            
            
        }    
  public void omit(int i){
        btNode p = c;
        btNode pred = null;
        while ((p != null) && (p.info != i)) {
            pred = p;
            if (i > p.info) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p != null) {
            if ((p.left != null) && (p.right == null)) {
                btNode replace = p.left;
                btNode predreplace = p;
                while (replace.left != null) {
                    predreplace = replace;
                    replace = replace.left;
                }
                p.info = replace.info;
                predreplace.left = replace.right;
            } else if ((p.left == null) && (p.right != null)) {
                btNode replace = p.right;
                btNode predreplace = p;
                while (replace.left != null) {
                    predreplace = replace;
                    replace = replace.left;
                }
                p.info = replace.info;
                predreplace.right = replace.right;
            } else if ((p.left == null) && (p.right == null)) {
                if (pred == null) {
                    c = null;
                } else if (p.info < pred.info) {
                    pred.left = null;
                } else {
                    pred.right = null;
                }
            } else if ((p.left != null) && (p.right != null)) {
                btNode replace = p.right;
                btNode predreplace = p;
                btNode Node = null;
                if (pred == null) {
                    while (replace.left != null) {
                        Node = replace;
                        replace = replace.left;
                    }
                    p.info = replace.info;

                    Node.left = replace.right;
                } else {
                    while (replace.left != null) {
                        predreplace = replace;
                        replace = replace.left;
                    }
                    if (predreplace == p) {
                        p.info = replace.info;
                        predreplace.right = replace.right;
                    } else {
                        p.info = replace.info;
                        predreplace.left = replace.right;

                    }
                }

            }
        }
            howmany--;
        
    
    }

   public boolean belongs(int i)
   {
      btNode p=c;
      while ((p!=null)&&(p.info!=i)) 
      {
         if (p.info>i) p=p.left;
         else p=p.right;
      }
      return (p!=null); 
   }

   public int get_howmany() {return howmany;}

   public void print(String outname)
   {
      try
      {
	 PrintWriter outs=new PrintWriter(new FileOutputStream(outname));
         outs.println("The number of integers is "+howmany);
         outs.println();
         printtree(c, outs);
         outs.close();
      }
      catch (IOException ex)
      {
      }
   }

   public void print()
   {
      printtree(c);
   }

   public boolean equals(Intcoll obj)
   {
      int j = 0; boolean result  = (howmany==obj.howmany);
      if (result)
      { 
         int[] a=new int[howmany]; 
         int[] b=new int[howmany];
         toarray(c, a, 0); toarray(obj.c, b, 0);

         j=0;
         while ((result) && (j<howmany))
         {
            result=(a[j]==b[j]); j++;
         }
      }
      return result;
   }

   private static void printtree(btNode t, PrintWriter outs)
   {   
	   if (t!=null)
	   {
		   printtree(t.left, outs);
		   outs.println(t.info);
		   printtree(t.right, outs);
	   }
   }

   private static void printtree(btNode t)
   {
      if (t!=null)
      {
          printtree(t.left);
          System.out.println(t.info);
          printtree(t.right);
      }
   }

   private static int toarray(btNode t, int[] a, int i)
   {
      int num_nodes=0;
      if (t!=null)
      {
         num_nodes=toarray(t.left, a, i);
         a[num_nodes+i]=t.info;   
         num_nodes=num_nodes+1+toarray(t.right, a, num_nodes+i+1);
      }
      return num_nodes;
   } 

}

 

