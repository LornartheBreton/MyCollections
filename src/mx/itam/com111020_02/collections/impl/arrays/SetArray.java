/*
 * Copyright Hector G. T. Torres 2020 (191589)
 */
package mx.itam.com111020_02.collections.impl.arrays;

import java.util.Collection;
import mx.itam.com111020_02.collections.SetITAM;

/**
 * Array implementation of a Set ADT.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 * @param <E> The data type the set will store.
 */
public class SetArray<E> extends ArrayCollection<E> implements SetITAM<E>{
    /**
     * Constructor that determines the array initialSize and its growth 
     * factor.
     * 
     * @param initialSize The initial size of the internal array.
     * @param growthFactor By how much the array will increase.
     */
    public SetArray(int initialSize, float growthFactor){
        super(initialSize,growthFactor);
    }
    /**
     * Constructor that determines the array initialSize and a growth factor of 
     * 2.0.
     * 
     * @param initialSize
     */
    public SetArray(int initialSize){
        super(initialSize,2);
    }
    /**
     * Default constructor with an initial array size of 10 and a growth factor
     * of 2.0.
     */
    public SetArray(){
        super(10,2);
    }
    /**
     * Verifies that an element is not contained already on the Set and, if not,
     * adds it.
     * 
     * @param e The object to be added.
     * @return <code> true </code> if the object was successfully added, or
     * <code> false </code> if it wasn´t.
     */
    @Override
    public boolean add(E e) {
        if(!contains(e)){
            if (lastIndex==arr.length-1){
                increaseArraySize();
            }
            
            lastIndex++;
            arr[lastIndex]=e;
            
            return true;
        }
        
        return false;
    }
    /**
     * Verifies that an element is contained on the Set. If it is, it removes
     * it.
     * 
     * @param o The object to be removed.
     * @return <code> true </code> if the object was successfully removed, or
     * <code> false </code> if it wasn't.
     */
    @Override
    public boolean remove(Object o) {
        int index=indexOf((E) o);
        
        if(index!=-1){
            for(int i=index;i<lastIndex;i++){
                arr[i]=arr[i+1];
            }
            
            lastIndex--;
            return true;
        }
        
        return false;
    }
    /**
     * Returns the index in which the element is located.
     * 
     * @param e The element to be searched for.
     * @return The index in which the element is located.
     */
    private int indexOf(E e){
        int index=-1;
        int counter=0;
        
        if(contains(e)){
            while(counter<=lastIndex&&index==-1){
                if(e.equals(arr[counter])){
                    index=counter;
                }
                counter++;
            }
        }
        
        return index;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] arrLoc=c.toArray();
        int initSize=size();
                
        for(Object o: arrLoc){
            remove(o);
        }
        
        return initSize==size();
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        E[] arrLoc = null;
        c.toArray(arrLoc);
        int initSize=size();
        
        for(Object o: arrLoc){
            
            if(!contains(o)){
                remove(o);
            }
            
        }
        
        return initSize==size();
    }
    /**
     * Returns an E[] representation of the Set.
     * 
     * @return the E[] representation of the Set. 
     */
    public E[] ultimateToArray() {
        E[] ans = (E[]) new Object[lastIndex+1];
        
        for(int i=0;i<=lastIndex;i++){
            ans[i]=arr[i];
        }
        
        return ans;
    }
   
}
