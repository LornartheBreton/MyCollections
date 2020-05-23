/*
 * Copyright Hector G. T. Torres 2020
 */
package mx.itam.com111020_02.collections.impl.arrays;

import java.util.Collection;
import mx.itam.com111020_02.collections.Stack;

/**
 *Implementation of the Stack interface ustilizing Java Arrays
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 */
public class StackArray<E> extends ArrayCollection<E> implements Stack<E>{
    /**
     * Constructor that determines the array initialSize and its growth 
     * factor.
     * 
     * @param initialSize The initial size of the internal array.
     * @param growthFactor By how much the array will increase.
     */
    public StackArray(int initialSize, float growthFactor){
        super(initialSize,growthFactor);
    }
    /**
     * Constructor that determines the array initialSize and a growth factor of 
     * 2.0.
     * 
     * @param initialSize
     */
    public StackArray(int initialSize){
        super(initialSize,2);
    }
    /**
     * Default constructor with an initial array size of 10 and a growth factor
     * of 2.0.
     */
    public StackArray(){
        super(10,2);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean push(Object newElement) {
        boolean ret=false;
        
        if (lastIndex==arr.length-1){
            increaseArraySize();
        }
        
        if(newElement !=null){
            lastIndex++;
          //  System.out.println(stack.length);
          //  System.out.println(head);
            arr[lastIndex]=(E) newElement;
            ret=true;
        }
        
        return ret;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Elliminates the element at the head of the stack.
     * 
     * @return Either the object that was removed from the stack, or
     * <code>null</code> if the stack was empty.
     */
    @Override
    public E pop() {
        E ret;
        
        if(lastIndex>-1){
            ret=arr[lastIndex];
            arr[lastIndex]=null;
            lastIndex--;
        }else{
            ret=null;
        }
        
        return ret;
    }
    //From java.util.Collection
    
    /**
     * 
     * @return Either the element at the head of the stack, or <code>null</code>
     * if the stack is empty.
     */
    @Override
    public E peek() {
        if(lastIndex<0){
            return null;
        }
        return arr[lastIndex];
    }
    /**
     * Inserts an object at the head of the stack.
     * 
     * @param e Element to be inserted.
     * @return Returns <code>true</code> if the element was inserted 
     * succesfully, <code>false</code> if otherwise.
     */
    @Override
    public boolean add(Object e) {
        return push(e);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Only the object at "
                + "the head of the stack can be elliminated."); 
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Only the object at "
                + "the head of the stack can be elliminated."); 
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Only the object at "
                + "the head of the stack can be elliminated."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Counts how many times an <code>E</code> object appears in the stack.
     *
     * @param in The object whose instances in the Stack will be counted.
     * @return The total number of instances of the object in the stack.
     */
    public int countInstances(E in){
        int counter=0;
        
        for(int i=0;i<=lastIndex;i++){
            if(arr[i].equals(in)){
                counter++;
            }
        }
        
        return counter;
    }
}
