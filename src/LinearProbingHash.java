/*This class is used in order to demonstrate the Linear Probing Hash, and contains the following
* member variables:
*
* . maxSize: the size the inner array is instantiated to, which helps indicate when the hash table is full
* . array: the inner array that contains the actual values in the hash table
* . numCollisions: the int that counts how many times we run into other values when trying to insert
*
* And the methods included are as follows:
*
* . a Constructor(): instantiates the inner array to all -1's, and sets maxSize to the passed in value
* . insert(): takes a value v and inserts it based on the hashing value, returns void
* . search(): search for a value v using the hashing function, returns void
* . hash(): creates the hash associated with the value passed in
* . getNumCollisions(): returns the total amount of collisions for the Hash Table*/
public class LinearProbingHash {

    private int maxSize;
    private int[] array;
    private int numCollisions;

    /*Takes the paramater of an int, which is used to set the maxSize as well as instantiate the array*/
    LinearProbingHash(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) { //we will set all values to -1 as a marker for non-used hash increments
            array[i] = -1;
        }
    }

    /*Takes a parameter int v, finds its corresponding hash, and uses Linear Probing to progress through the table
    * until it finds a new spot according to the linear probing model*/
    public void insert(int v) {
        int hash = hash(v); //returns the hash int, and this will be checked first in the following while
        while ((array[hash] != -1) && (hash < array.length )) { //while the array isn't -1 (meaning another value is already occupying that space), and the hash value is in the scope of the array
            hash = (hash + 1) % maxSize; //we increment the hash by 1, to search linearly
            numCollisions++; //and count this as a collision
        }
        array[hash] = v; //and set the value at the final hash value as the passed in parameter
    }

    /*Takes a parameter int v as an input, which will be hashed and searched for based on the hash*/
    public void search(int v) {
        int hash = hash(v);
        while ((array[hash] != v) && (array[hash] != -1) && (hash < array.length )) { //we perform the same linear probing to search
            hash = (hash + 1) % maxSize;
            numCollisions++;
        }
        //and return nothing, because at this point we are just counting collisions
        /*if (array[hash] == v) { //these lines were used for debugging
            System.out.println(v + " was found at hash " + hash);
        } else {
            System.out.println(v + " was not found.");
        }*/
    }

    /*This method was used to return a hash value, which was the int passed in % maximumSize*/
    private int hash(int v) {
        return (v % maxSize);
    }


    /*Method to return total number of collisions*/
    public int getNumCollisions() {
        return numCollisions;
    }


}
