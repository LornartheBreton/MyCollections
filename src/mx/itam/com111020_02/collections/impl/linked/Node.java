/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com111020_02.collections.impl.linked;

/**
 * A node for linked data structured.
 * 
 * @author <a href="mailto:hgomezt1@itam.mx"> Hector G. T. Torres (191589)</a>
 * 
 */
public class Node<E> {
    /**
     * The data stored in the Node.
     */
    private E data;
    /**
     * The next Node.
     */
    private Node<E> next;
    /**
     * Constructor that defines the data stored in the Node.
     * @param data The data stored in the Node.
     */
    public Node(E data){
        this.data=data;
        next=null;
    }
    /**
     * Constructor that defines the data stored in the Node and the next Node.
     * @param data The data stored in the Node.
     * @param next The next Node.
     */
    public Node(E data,Node<E> next){
        this.data=data;
        this.next=next;
    }
    /**
     * Returns the data in the Node.
     * 
     * @return the data 
     */
    public E getData() {
        return data;
    }
    /**
     * Sets the data in the Node.
     * 
     * @param data the data
     */
    public void setData(E data) {
        this.data = data;
    }
    /**
     * Returns the next Node.
     * 
     * @return the next Node
     */
    public Node<E> getNext() {
        return next;
    }
    /**
     * Sets the next Node.
     * 
     * @param next the next Node
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
    
}
