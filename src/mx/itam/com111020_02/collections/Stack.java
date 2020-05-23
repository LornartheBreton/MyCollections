/*
 * Copyright Hector G. T. Torres 2020 (191589)
 */
package mx.itam.com111020_02.collections;


/**
 * Interface to implement a Stack ADT
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 * @param <E> The data type the Stack will store of.
 */
public interface Stack <E>{
    /**
     * Inserts a new element at the head of the stack.
     * 
     * @param newElement the object to be inserted into the Stack.
     * @return <code> true </code> if the element was inserted successfully
     * <code> false </code> if the element could not be inserted
     */
    boolean push (E newElement);
    /**
     * Elliminates the method at the head of the stack.
     * 
     * @return The object that was elliminated. 
     */
    E pop ();
    /**
     * Returns the object at the head of the stack.
     * @return the object at the head of the stack.
     */
    E peek();
}
