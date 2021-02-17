package edu.escuelaing.arep.recursos;

/**
 * Is a structure that we use to save the values of the LinkedList
 */
public class Node {
    public double value;
    public Node next;

    public Node(double value){
        this.value = value;
        this.next = null;
    }

    /**
     * Change the node it points to to the right
     * @param node A Node that is the next of the same node
     */
    public void changeNext(Node node){
        next = node;
    }
}
