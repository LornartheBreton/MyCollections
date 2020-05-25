/*
 * Copyright Hector G. T. Torres 2020
 */
package mx.itam.com111020_02.collections.impl.linked;

import java.util.Collection;
import java.util.Iterator;

/**
 * Abstract class for Collections utilizing linear linked structures.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 * @param <E> Data type stored in the Collection
 */
public abstract class LinkedCollection<E> implements Collection<E>{
    /**
     * The first Node.
     */
    private Node<E> first;
    /**
     * Number of elements in the Collection.
     */
    private int elements;
    /**
     * Default constructor with 0 elements in the Collection.
     */
    public LinkedCollection(){
        first=null;
        elements=0;
    }
    /**
     * Returns the number of elements in the Collection.
     * @return the number of element in the Collection.
     */
    protected int getElements(){
        return elements;
    }
    /**
     * Defines the number of elements in the Collection.
     * @param elements the number of elements in the Collection.
     */
    protected void setElements(int elements){
        this.elements=elements;
    }
    /**
     * Returns the first Node.
     * @return the first Node.
     */
    protected Node<E> getFirst(){
        return first;
    }
    /**
     * Sets the first node.
     * 
     * @param first The new first Node. 
     */
    protected void setFirst(Node<E> first){
        this.first=first;
    }
    /**
     * Sets a new first element in the Collection.
     * 
     * @param newElement The new first element.
     * @return true if the operation was successful. false if otherwise.
     */
    public boolean insertFirst(E newElement){
        boolean ans=(newElement!=null);
        
        if(ans){
            Node<E> newFirst=new Node<E>(newElement, first);
            
            first=newFirst;
            elements++;
        }
        
        return ans;
    }
    /**
     * Sets a new last element in the Collection.
     * 
     * @param newElement The new last element.
     * @return true if the operation was successful. false if otherwise.
     */
    public boolean insertLast(E newElement){
        boolean ans=(newElement!=null);
        
        if(ans){
            Node<E> last,current;
            
            last=current=first;
            
            while(current!=null){
                last=current;
                current=current.getNext();
            }
            
            Node<E> newLast=new Node<E>(newElement);
            
            if(last!=null){
                last.setNext(newLast);
            }else{
                first=newLast;
            }
            
            elements++;
        }
        
        return ans;
    }
    /**
     * Removes an element from the Collection.
     * 
     * @param newElement The element to be removed.
     * @return true if the operation was successful. false if otherwise.
     */
    public boolean removeElement(Object newElement){
        boolean ans=false;
        
        if(newElement!=null){
            Node<E> current,last;
            
            last=current=first;
            
            while(current!=null){
                if(newElement.equals(current.getData())){
                    if(current==first){
                        first=current.getNext();
                    }else{
                        last.setNext(current.getNext());
                    }
                    
                    elements--;
                    ans=true;
                    break;
                }
                
                last=current;
                current=current.getNext();
            }
        }
        
        return ans;
    }
    /**
     * Determines whether or not the Collection contains an element.
     * 
     * @param element The element to process.
     * @return true if the Collection contains the element. false if it doesn't.
     */
    public boolean findElement(Object element){
        boolean ans=false;
        
        if(element!=null){
            Node<E> current;
            current=first;
            
            while(current!=null){
                if(element.equals(current.getData())){
                    ans=true;
                    break;
                }
                
                current=current.getNext();
            }
        }
        return ans;
    }
    /**
     * Empties the Collection.
     */
    @Override
    public void clear(){
        first=null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return elements;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return first==null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return findElement(o);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            Node<E> current=first;
            
            @Override
            public boolean hasNext(){
                return current!=null;
            }

            @Override
            public E next() {
                E element=current.getData();
                
                current=current.getNext();
                
                return element;
            }
            
        };
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract Object[] toArray();
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract <T> T[] toArray(T[] a);
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract boolean add(E e);
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        return removeElement(o);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if(c==null||c.isEmpty()){
            return false;
        }
        for(Object e: c){
            if(!contains(e)){
                return false;
            }
        }
        
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        int size=elements;
        
        for(E e: c){
            add(e);
        }
        
        return size==elements;
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
    public abstract boolean retainAll(Collection<?> c);
    
}
