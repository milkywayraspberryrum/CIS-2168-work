/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intcoll5;

import java.util.LinkedList;

/**
 *
 * @author eschi
 */
public class Intcoll5 {
    private LinkedList c;
    public Intcoll5(int i){
        c = new LinkedList();
    }
    
    public void insert(int i){
        Integer I = new Integer(i);
        if((i > 0) && (!c.contains(i))){
            c.addFirst(I);
        }
    }
    
    public void copy(){
       
    }
}
