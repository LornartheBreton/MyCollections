/*
 * Copyright Hector G. T. Torres 2020 (191589)
 */
package mx.itam.com111020_02.collections.impl.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Abstract class for Collections that use arrays.
 * @author <a href="mailto:hgomezt1@itam.mx"> Héctor G. T. Torres (191589)</a>
 */
public abstract class ArrayCollection<E> implements Collection<E> {
    /**
     * Main array.
     */
    protected E[] arr;
    /**
     * The last index with elements.
     */
    protected int lastIndex;
    /**
     * By how much the array will grow.
     */
    protected float growthFactor;
    /**
     * Constructor that indicates the Collection's initialSize and its growthFactor.
     * @param initialSize The stack's initial array size.
     * @param growthFactor The amount by which the array increases when pushing
     * an element.
     */
    public ArrayCollection(int initialSize, float growthFactor) {
        if(growthFactor>1){
            this.growthFactor=growthFactor;
        }else{
            throw new IllegalArgumentException("Invalid growth factor");
        }
        
        if (initialSize<0){
            initialSize=-initialSize;
        }
        
        arr=(E[]) new Object[initialSize];
        
        lastIndex=-1;
    }
     
    /**
     * Constructor that only requires the Collection's array's initialSize, with a 
     * default growth factor of 2.
     * @param initialSize The initial size of the stack's array.
     */
    public ArrayCollection(int initialSize) {
        this(initialSize,2);
    }
    /**
     * Default constructor, with an initial stack array size of 10 and a growth
     * factor of 2.
     */
    public ArrayCollection(){
        this(10,2);
    }
    /**
     * Increases the Collection's array size.
     */
    protected void increaseArraySize(){
        if(arr.length!=0){
            arr=Arrays.copyOf(arr, (int)(arr.length*growthFactor));
        }else{
            arr=(E[]) new Object[(int) growthFactor];
        }
    } 
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return lastIndex+1;
    }
    /**
     * Returns <code>true</code> if the Collection has no elements, and 
     * <code>false</code> if the Collection has 1 or more elements.
     */
    @Override
    public boolean isEmpty() {
        return lastIndex==-1;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean contains(Object o) {
        boolean ans=false;
        int counter=0;
        E e=(E) o;
        
        if(o!=null){
            while(!ans&&counter<=lastIndex){
                ans=arr[counter].equals(e);
                counter++;
            }
        }else{
            while(!ans&&counter<=lastIndex){
                ans=arr[counter]==null;
                counter++;
            }
        }
        
        return ans;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
       return new Iterator<E>() {
            /**
             * The iterable index.
             */
            private int index=lastIndex;
            /**
            * {@inheritDoc}
            */
            @Override
            public boolean hasNext() {
                return index>=0;
            }
            /**
            * {@inheritDoc}
            */
            @Override
            public E next() {
                if(index>0){
                    throw new NoSuchElementException("The stack has no more elements");
                }
                index--;
                return arr[index];
            }


       };
    }
    /**
     * Returns the Collection´s elements as an Array.
     */
    @Override
    public Object[] toArray() {        
        return Arrays.copyOf(arr, lastIndex+1);
    }
    /**
     * {@inheritDoc } 
     */
    @Override 
    public <T> T[] toArray(T[] a) { 

        if (a.length < lastIndex + 1) 
            a = Arrays.copyOf(a, lastIndex + 1); 

        int i = 0; 

        for (E objeto : this) 
            a[i++] = (T) objeto; 

        for (int j = i; j < a.length; ++j) 
            a[j] = null; 

        return a; 
    } 
    /**
     * {@inheritDoc}
     */
    @Override
    abstract public boolean add(E e);
    /**
     * {@inheritDoc}
     */
    @Override
    abstract public boolean remove(Object o);

    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean containsAll(Collection c) {
        Object[] e = c.toArray();
        
        for(int i=0;i<e.length;i++){
            if(!contains(e[i])){
                return false;
            }
        }
        
        return true;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean addAll(Collection c) {
        boolean ans=true;
        Object[] arr2=c.toArray();
        
        for(int i=0;i<c.size();i++){
            ans=add((E) arr2[i]);
        }
        
        return ans;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract boolean removeAll(Collection<?> c);
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Completely empties the stack and resets its size to 0.
     */
    @Override
    public void clear() {
        arr=(E[]) new Object[0];
        lastIndex=-1;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        StringBuilder build=new StringBuilder();
        
        for(int i=0;i<=lastIndex;i++){
            build.append(arr[i].toString());
            build.append("--");
        }
        
        return build.toString();
    }
}
