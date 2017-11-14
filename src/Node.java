/*This class is used to implement ChainedHashing models, and is used for LinkedLists
*
* . data: the data int is used to store the actual value associated with the Node
* . next: is a node that is a pointer to the node that follows this
*
* And the methods included are as follows:
*
* . a Constructor(): instantiates the Node, and sets data to the passed parameter, and sets next to null
* . a Constructor(): instantiates the Node, and sets data to the passed parameter, and sets next to the second parameter
* . getData(): returns the value associated with the node
* . getNext(): returns the next Node in the sequence*/
public class Node {

    int data;
    Node next;

    /*This constructor is used when we just know the data of the node, and don't want to set the next*/
    Node(int data) {
        this.data = data;
    }

    /*This is used when we want to create a Node with the corresponding value and set the next to a Node specific*/
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /*The following are getters and setters to get and set the Data and Next variables
    *
    * */
    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public void setData(int d) {
        this.data = d;
    }

}
