package edu.escuelaing.arep.recursos;


/**
 * Is a data structure implemented from 0 in this project
 */
public class LinkedList {
    public Node head;
    public Node previousNode;
    public Node nowNode;
    public int size;

    public LinkedList(){
        head = null;
        nowNode = null;
        previousNode = null;
        size = 0;
    }

    /**
     * Go to the index 0 or head of the Linkedlist
     */
    public void restartView(){

        nowNode = head;
    }

    /**
     * Add a new node to the LinkedList, this node have a double value
     * @param value is a double value that we save in the node
     */
    public void addNode(double value){
        Node nodoTMP = new Node(value);
        if(head == null){
            head = nodoTMP;

        } else {
            previousNode = nowNode;
            nowNode.changeNext(nodoTMP);
        }
        nowNode = nodoTMP;
        size++;
    }

    /**
     * Remove the actual Node of the LinkedList
     * @throws Exception
     */
    public void removeNode() throws Exception {
        if(nowNode==null){
            throw new Exception("Its no a next node");
        } else if(head == nowNode) {
            head = null;
            nowNode = null;
            previousNode = null;

        } else {
            previousNode.changeNext(null);
            nowNode = previousNode;
        }
        size--;
    }

    /**
     * Go the next node of the linkedlist (the right node)
     * @return Return the next node of the linkedlist
     * @throws Exception
     */
    public Node nextNode() throws Exception {
        if(nowNode.next == null){
            throw new Exception("Its no a next node");
        } else {
            previousNode = nowNode;
            nowNode = nowNode.next;
        }
        return nowNode;
    }

    /**
     * Get the actual node of the LinkedList
     * @return Return the actual node
     */
    public Node getNowNode(){
        return nowNode;
    }


}
