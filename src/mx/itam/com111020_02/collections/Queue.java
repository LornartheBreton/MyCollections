/*
 * Copyright Hector G. T. Torres 2020 (191589)
 */
package mx.itam.com111020_02.collections;

/**
 * An interface of the Queue ADT.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 */
public interface Queue<E> {
    /**
     * Adds en element to the end of the queue.
     * 
     * @param newElement The element to be added
     * @return If the element was added success
     */
    public boolean enqueue(E newElement);
    /**
     * Removes the first element added to the queue.
     * 
     * @return the element removed 
     */
    public E dequeue();
    /**
     * Returns the last element added to the queue.
     * 
     * @return the last element added to the queue. 
     */
    public E last();
    /**
     * Returns the first element on the queue.
     * 
     * @return the first element on the queue. 
     */
    public E first();
    /**
     * Dequeues elements from the Queue n amount of times.
     * 
     * @param n number of elements to dequeue
     * @return an array with the dequeued elements
     */
    public E[] multiDequeue(int n);
}
