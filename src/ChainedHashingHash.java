/*This class is used in order to demonstrate the Chained Hashing model, and contains the following
* member variables:
*
* . maxSize: the size the inner array is instantiated to, which helps indicate when the hash table is full
* . array: the inner array that contains the actual values in the hash table, this time with Nodes
* . numCollisions: the int that counts how many times we run into other values when trying to insert
*
* And the methods included are as follows:
*
* . a Constructor(): instantiates the inner array to all -1's, and sets maxSize to the passed in value
* . insert(): takes a value v and inserts it based on the hashing value, returns void
* . search(): search for a value v using the hashing function, returns void
* . hash(): creates the hash associated with the value passed in
* . getNumCollisions(): returns the total amount of collisions for the Hash Table*/
public class ChainedHashingHash {

    Node[] array;
    private int numCollisions;
    private int maxSize;

    /*Takes the paramater of an int, which is used to set the maxSize as well as instantiate the array*/
    ChainedHashingHash(int maxSize) {
        this.maxSize = maxSize;
        array = new Node[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i] = new Node(-1); //and create new Nodes at each increment with the data of 1
        }
    }


    /*This method will take a value and insert based on that value*/
    public void insert(int value) {
        int hash = hash(value); //uses the same hashing formula as the other classes
        if (array[hash].getData() == -1) { //if the value at the hashed index is -1 (meaning there is no value present yet)
            array[hash] = new Node(value); //we create a new Node with the value we want and place it there
        } else { //we reach here if we have to add the value to the linkedList, meaning that a value is already present
            Node newNode = new Node(value, array[hash]);  //so we add our value to the front of the linked list, and set it to point to the old firstValue
            array[hash] = newNode; //and now the array at that hash is the new value, pointing at the old first
        }
    }

    /*This method takes a value v, hashes it, and looks for the value at the location, which will require simply searching through
    * the Linked List*/
    public void search(int v) {
        int hash = hash(v);
        if (array[hash].getData() == v) { //if the value is at the location we expect, there are no collisions, and we can return
            return;
        } else { //else we need to search the linked list to find our value
            Node temp = array[hash]; //we copy the value of the first node into a temporary variable to search
            while ((temp.getNext() != null) && ((temp.getData() != v))) { //and while there is a next to transition to, and we haven't found our value,
                temp = temp.getNext(); //we traverse through the list to until we find our value
                numCollisions++; //and count this as a collision
            }
            /*if (temp.getData() == v) {
                System.out.println(v + " was found at hash " + hash);
            } else {
                System.out.println("Could not find the value " + v);
            }*/
        }
    }

    public int getNumCollisions() {
        return numCollisions;
    }

    private int hash(int v) {
        return (v % maxSize);
    }


}
