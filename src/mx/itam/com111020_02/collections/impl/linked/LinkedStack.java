/*
 * Copyright Hector G. T. Torres 2020
 */
package mx.itam.com111020_02.collections.impl.linked;

import java.util.Collection;
import mx.itam.com111020_02.collections.Stack;

/**
 * An implementation of the Stack ADT utilizing linked data structured.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 */

/**
 * An implementation of the Stack ADT utilizing linked data structured.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 */
public class LinkedStack<E> extends LinkedCollection<E> implements Stack<E>{
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean push(E newElement) {
        return insertFirst(newElement);
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public E pop() {
        Node<E> head=getFirst();
        E ans=null;
        
        if(head!=null){
            ans=head.getData();
            setFirst(head.getNext());
            
            setElements(getElements()-1);
        }
        
        return ans;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public E peek() {
        Node<E> head=getFirst();
        
        return head!=null?head.getData():null;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public Object[] toArray() {
        Object[] ans=new Object[this.size()];
        int i=0;
        
        for(E e: this){
            ans[i]=e;
            i++;
        }
        
        return ans;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public <T> T[] toArray(T[] a) {
        T[] ans=(T[]) new Object[size()];
        int i=0;
        
        if(a.length>=size()){
            for(E t: this){
                a[i]=(T) t;
                i++;
            }
            return a;
        }
        
        for(E t: this){
                ans[i]=(T) t;
                i++;
            }
        return ans;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean add(E e) {
        return push(e);
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("You can only remove elements"
                + " at the head of the Stack."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("You can only remove elements"
                + " at the head of the Stack."); //To change body of generated methods, choose Tools | Templates.
    }


}
