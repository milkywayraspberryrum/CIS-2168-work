/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll4;

/**
 *
 * @author eschi
 */
public class Intcoll4 {
    private int howmany;
    private ListNode c;

    
    private class ListNode{
     private int info;
     private ListNode link;
     
     public ListNode(){
         info = 0;
         link = null;
     
         
     }
      public ListNode(int i, ListNode p){
          info = i;
          link = p;
      }
    }
      public void copy(Intcoll4 obj){
          if (this != obj){
              howmany = obj.howmany;
          }
          else{
              c = new ListNode(obj.c.info, null);
              ListNode p = c;
              ListNode q = obj.c;
          
          while (q.link != null){
              q = q.link;
              p.link = new ListNode(q.info, null);
              p = p.link;
              
          }
          }
      }
          
    
      public boolean belongs(int i){
          ListNode p = c;
          while ( p != null && p.info != i){
              p = p.link;
              
          }
          return (p != null);
      }
      
      public void insert(int i){
          if (i > 0){
              ListNode p = c;
              while (p != null && p.info != i){
                  p = p.link;
              } 
              if (p == null){
                 p = new ListNode();
                 p.link = c;
                 p.info = i;
                 c = p;
                 howmany++;
              }
          }
      }
      public void omit(int i){
          if (i > 0){
              ListNode p = c;
              ListNode pred = null;
              while ((p != null) && (p.info != i)){
                  pred = p; 
                  p = p.link;
                  if (p != null){
                      howmany--;
                  if (pred != null){
                      pred.link = p.link;}
                  else{
                      c = p.link;
                      howmany--;
                      }
                  }
              }
          }
      }
      public int get_howmany(){
          ListNode p = c;
          while (p != null){
              p = p.link;
              howmany++;
          }
          return howmany;
      }
      
      public void print(){
          ListNode p = c;
          while (p != null){
              System.out.print(p.info);
              p = p.link;
              
          }
          
      }
      
      public boolean equals(Intcoll4 obj){
          ListNode p = c;
          boolean result = (howmany == obj.howmany);
          while((p!=null)&& result){
              result = obj.belongs(p.info);
              p = p.link;
      }
          return result;
      }
}
