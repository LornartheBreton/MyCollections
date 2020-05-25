/*
 * Copyright Hector G. T. Torres 2020
 */
package mx.itam.com111020_02.collections.impl.linked;

import java.util.Collection;
import mx.itam.com111020_02.collections.Queue;

/**
 * An implementation of the Queue ADT utilizing linked data structures.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 */
public class LinkedQueue<E> extends LinkedCollection<E> implements Queue<E>{
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
        return enqueue(e);
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("You can only remove the first"
                + " element added to the Queue."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("You can only remove the first"
                + " element added to the Queue."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean enqueue(E newElement) {
        return insertLast(newElement);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E dequeue() {
        Node<E> f=getFirst();
        E ans=null;
    
        if(f!=null){
            ans=f.getData();
            setFirst(f.getNext());
            
            setElements(getElements()-1);
        }
        
        return ans;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E last() {
        Node<E> current,last;
        current=last=getFirst();
        
        while(current!=null){
            last=current;
            
            current=current.getNext();
        }
        
        return last.getData();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E first() {
        return getFirst().getData();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public E[] multiDequeue(int n) {
        E[] ans=(E[]) new Object[n];
        
        for(int i=0; i<n;i++){
            ans[i]=dequeue();
        }
        
        return ans;
    }
    
}
