/*This class is used in order to demonstrate the Quadratic Probing hash, and contains the following
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
public class QuadraticProbingHash {

    private int maxSize;
    private int[] array;
    private int numCollisions;

    /*Takes the paramater of an int, which is used to set the maxSize as well as instantiate the array*/
    QuadraticProbingHash(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) { //we will set all values to -1 as a marker for non-used hash increments
            array[i] = -1;
        }
    }

    /*Takes a parameter int v, finds its corresponding hash, and uses Quadratic Probing to progress through the table
    * until it finds a new spot according to the quadratic probing model*/
    public void insert(int v) {
        int hash = hash(v); //returns the hash int, and this will be checked first in the following while
        int i = 1;
        while ((array[hash] != v) && (array[hash] != -1) && (hash < array.length )) { //while the array isn't -1 (meaning another value is already occupying that space), and the hash value is in the scope of the array
            hash = (hash + (i*i)) % maxSize;  //we increment the hash by adding the square of I, to search quadratically
            numCollisions++;
            i++; //we increment i here so we'll be able to square it
        }
        array[hash] = v;
    }

    /*Takes a parameter int v as an input, which will be hashed and searched for based on the hash*/
    public void search(int v) {
        int hash = hash(v);
        int i = 0;
        while ((array[hash] != v) && (array[hash] != -1) && (hash < array.length )) { //we perform the same quadratic probing to search
            hash = (hash + (i*i)) % maxSize;
            numCollisions++;
            i++;
        }
        /*if (array[hash] == v) {
            System.out.println(v + " was found at hash " + hash);
        } else {
            System.out.println(v + " was not found.");
        }*/
    }

    private int hash(int v) {
        return (v % maxSize);
    }


    public int getNumCollisions() {
        return numCollisions;
    }

}
