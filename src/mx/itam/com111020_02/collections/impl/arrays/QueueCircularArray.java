/*
 * Copyright Hector G. T. Torres 2020 (191589)
 */
package mx.itam.com111020_02.collections.impl.arrays;

import java.util.Collection;
import mx.itam.com111020_02.collections.Queue;

/**
 * An Implementation of the Queue ADT utilizing circular arrays.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 * @param <E> An object
 */
public class QueueCircularArray<E> extends ArrayCollection<E> implements Queue<E>{
    /**
     * Counts the number of indexes in the array that are filled with an element.
     */
    private int filledIndexes;
    /**
     * The first index of the array with an element.
     */
    private int firstIndex;
    /**
     * Constructors that defines both the initialSize and the growthFactor
     * @param initialSize the initial size of the queue
     * @param growthFactor by how much it will increase the internal array in
     * size
     */
    public QueueCircularArray (int initialSize, float growthFactor){
        super(initialSize, growthFactor);
        filledIndexes=0;
        firstIndex=lastIndex;
    }
    /**
     * Constructors that only defines the initialSize of the queue and takes
     * a growth factor of 2.
     * @param initialSize the initial size of the queue
     */
    public QueueCircularArray(int initialSize){
        this(initialSize,2);
    }
    /**
     * The default constructor, with an initialSize of 10 and a growthFactor
     * of 2.
     */
    public QueueCircularArray(){
        this(10,2);
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
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("We can only remove the elements"
                + " at the end of the queue."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("We can only remove the elements"
                + " at the end of the queue."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean enqueue(E newElement) {
        
        if(arr.length==filledIndexes){
            increaseArraySize();
        }
        
        if(newElement!=null){
            lastIndex = updateIndex(lastIndex);
            arr[lastIndex]=newElement;
            filledIndexes++;
            
            if(firstIndex<0)
                firstIndex=0;
            
            return true;
        }
 
        return false;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public E dequeue() {
        if(filledIndexes>0){
            
            E ans=arr[firstIndex];
            arr[firstIndex]=null;
            filledIndexes--;
            
            if(filledIndexes>0){
                firstIndex = updateIndex(firstIndex);
            } else{
                lastIndex--;
                firstIndex=lastIndex;
            }
            return ans;
        }
        
        return null;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public E last() {
        return arr[lastIndex];
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public E first() {
        return arr[firstIndex];
    }
    /**
     * Returns an updated index according to the specification of a circular
     * array.
     * 
     * @param index the index to be updated
     * @return the updated index
     */
    private int updateIndex(int index){
        return (index+1)%arr.length;
    }
    /**
     * Returns the Set´s elements as an Array.
     * @return an array with the Set's elements
     */
    @Override
    public Object[] toArray() {        
        Object[] ans;
        
        if(firstIndex==0){
            return super.toArray();
        }else{
            ans=new Object[filledIndexes];
            int i=firstIndex;
            int o=0;
            
            while(i<arr.length){
                ans[i]=arr[i];
                i++;
            }
            
            while(arr[o]!=null&&o<firstIndex){
                ans[i]=arr[o];
                o++;
                i++;
            }
        }
        
        return ans;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public E[] multiDequeue(int n) {
        E[] arr = (E[])new Object[n];
        
        if(n==1){
            arr[0]=dequeue();
            return arr;
        }
        
        arr=multiDequeue(n-1);
        
        return arr;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    protected void increaseArraySize() {
        E[] back = (E[])(new Object[(int)(arr.length*this.growthFactor)]);
        
        for(int i=0; i<filledIndexes; ++i){
            back[i]=arr[firstIndex];
            firstIndex = updateIndex(firstIndex);
        }
        
        firstIndex = 0;
        lastIndex = filledIndexes-1;
        
        arr=back;
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public String toString(){
        StringBuilder build=new StringBuilder();
        
        if(filledIndexes==0){
            return "Empty queue";
        }
        
        if(firstIndex<=lastIndex){
            for(int i=firstIndex;i<=lastIndex;i++){
                build.append(arr[i].toString());
                build.append("--");
            }
        }else{
            for(int i=firstIndex;i<arr.length;i++){
                build.append(arr[i].toString());
                build.append("--");
            }
            for(int i=0;i<lastIndex;i++){
                build.append(arr[i].toString());
                build.append("--");
            }
        }
        return build.toString();
    }
}
