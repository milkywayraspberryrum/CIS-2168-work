/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringcoll;


/**
 *
 * @author eschi
 */
import java.util.*;
import java.io.*;


public class MultiStringcoll {
 
    
    
    private btNode c;
    private int howmany;
    private int total;
   
 

    public MultiStringcoll(){
        c = null;
        howmany = 0;
        total = 0;
    }
    
    public void copy(MultiStringcoll obj){
        if(this != obj){
            total = obj.total;
            c = copytree(obj.c);
        }
    }
    
    public int belongs(String str){
        btNode p = c;
        while ((p!=null) && !p.info.equals(str)){
            if(p.info.compareTo(str) > 0){ //checks that the string's unicode is bigger than smaller value (the unicode of the smaller value)
                p = p.left; // p becomes the left node and searcb the left node
        }
            else p = p.right; //otherwise search the right node as the unicode value is bigger than str
        }
    
        if(p == null){ // while the binary tree is empty
            return 0;
        }
            else return p.count; // return how many times p appears in the binary tree
        }
    public void insert(String str){
        btNode pred = null; 
        btNode p = c; 
        while((p != null) && !p.info.equals(str)){ 
            pred = p; 
            if (p.info.compareTo(str) > 0){
                p = p.left; 
            }
            else p = p.right;
        }
        if (p == null){ //if p is empty
            p = new btNode(str, null, null, 1);
            if (pred != null){ 
                if(pred.info.compareTo(str) > 0){ 
                    pred.left = p;
                }
                else pred.right = p;
            }
            else c = p;
        }
        else{ total++;
        p.count++;
        }
        total++;
        howmany++;
        
    }
    public void omit(String str){
        if(belongs(str) >= 1){
		btNode pred = null; 
		btNode p = c; 
		while (!p.info.equals(str)) {
			pred = p;
			
			if (p.info.compareTo(str) > 0)
				p = p.left;
			else
				p = p.right;
		}
		
	
		if (p.count > 1) {
			p.count--;
			howmany--;
			return;
		}
		
		btNode replace = p; 

		if (p.right == null) {
			replace = p.left; 
			
		} else if (p.left == null) { 
			replace = p.right; 
		} else { 

			btNode replacel = p.left; 

			if (replacel.right == null) {
				
				replace = replacel;
				replace.right = p.right;
				
			} else {

				while (replacel.right.right != null) {
					replacel = replacel.right;
				}

				replace = replacel.right;
				replacel.right = replace.left;
				replace.right = p.right;
				replace.left = p.left;
			}
		}

		if (pred == null) {
			c = replace; 
			
		} else if (pred.right == p) {
			pred.right = replace; 
			
		} else {
			pred.left = replace; 
		}

		howmany--;
                total--;
	}
    }
   public int get_howmany(){
       return howmany;
   }
   
   public int get_total(){
       return total;
   }
   public void print(String outname) {
	try {
		PrintWriter outs = new PrintWriter(new FileOutputStream(outname));
		outs.println("The number of strings is " + total);
		outs.println();
		printtree(c, outs);
		outs.close();
	} catch(IOException ex) {

	}
        }
   public void print(){
       printtree(c);
   }
      
     
     public boolean equals(MultiStringcoll obj){
         boolean result = (howmany == obj.howmany) && (c.count == obj.c.count);
         if(result == true){
             String bst1[] = new String[howmany];
             String bst2[] = new String[howmany];
             toarray(c, bst1, 0);
             toarray(obj.c, bst2, 0);
             
             if(bst1 != null && bst2 != null){
                for(int i = 0; i < bst1.length; i++){
                    if(bst1[i].compareTo(bst2[i]) != 0){
                        result = false;
                    }
                    else{result = true;}
                }
            }
         }
         return result;
     }
     
     public static void printarray(String[] a){
         for(int i = 0; i < a.length; i++){
              System.out.println(a[i]);
         }
     
     
     }
         
     private static int toarray(btNode t, String[]a, int i){
         int num_nodes = 0;
         if(t!=null && t.count != 0){   
            num_nodes = toarray(t.left, a, i); 
            a[num_nodes + i] = t.info;
            num_nodes = num_nodes + 1 + toarray(t.right, a, num_nodes + i + 1);
         }
         return num_nodes;
     }
   private static void printtree(btNode t, PrintWriter outs) {
	if (t != null) {
            printtree(t.left, outs);
            String p = " (" + t.count + ")"; 
            outs.println(t.info + p);
            printtree(t.right, outs);
		}
	}
   private static void printtree(btNode t) {
	if (t != null) {
		printtree(t.left);
		String p = " (" + t.count + ")";
		System.out.println(t.info + p);
		printtree(t.right);
		}
	}
   private static btNode copytree(btNode t) {
	btNode root = null;

	if (t != null) {
            root = new btNode();
            root.info = t.info;
	    root.count = t.count; 
            root.left = copytree(t.left);
            root.right = copytree(t.right);
		}

        return root;
	}
 
   private static class btNode{
        String info;
        btNode left;
        btNode right;
        int count;
    
    public btNode(){
        info = "";
        left = null;
        right = null;
        count = 0;
        
    }
    
    public btNode(String str, btNode lt, btNode rt, int c){
        info = str;
        left = lt;
        right = rt;
        count = c;
    }
   }
}