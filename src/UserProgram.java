import java.util.*;
/* Daniel Frost
 * CSC501
 * Data Structures and Computer Systems
 * April, 2017
 *
 * HASH TABLE IMPLEMENTATION
 *
 * This assignment was developed in order to demonstrate the use of Hash Tables and the different
 * hashing methods.  The assignment was to generate 75 random numbers between 0 and 999,999.  These numbers will
 * then be added to a temporary array instantiated to 75.
 *
 * The five classes included in this project are:
 * . UserProgram: This class is used for the main method, that performs the instantiation of the classes
 * . LinearProbingHash: This class demonstrates the linearProbing method for adding and searching in a Hash Table
 * . QuadraticProbingHash: This class demonstrates the quadraticProbing method for adding and searching in a Hash table
 * . ChainedHashingHash: This class demonstrates the chainedHashing method for adding and searching in a Hash Table
 * . Node: This class is used for the Chained Hashing implementation which relies on linked lists.
 *
 * The three different implementations of the Hash Table will be Linear Probing, Quadratic Probing, and Chained Hashing.
 * Each of these will contain a member variable numCollisions which will be used to benchmark efficiency in hash tables.
 * A collision will be counted as any time there was already a value present when attempting to add to a table.
 * After adding the values to the various hash tables, we will print out the number of collisions, then search the hash tables
 * for the values in the array, and then print out the number of collisions again.*/
public class UserProgram {


    public static void main(String[] args) {
        Random rand = new Random();
        int[] numberArray = new int[75];
        int i = 0;
        LinearProbingHash lph = new LinearProbingHash(101); //we instantiate these to 101, 101 and 31 because of instruction
        QuadraticProbingHash qph = new QuadraticProbingHash(101);
        ChainedHashingHash chh = new ChainedHashingHash(31);

        while (i != 75) { // we will generate 75 values between 0 and 999,999 by using Java.Util.Random
            numberArray[i] = rand.nextInt(999999);
            i++; //and increment i so we add the new random value to the first empty spot
        }

        for (int j = 0; j < numberArray.length; j++) {
            lph.insert(numberArray[j]); //we loop through and for each increment of j, we add the associated value to each of the three hash tables
            qph.insert(numberArray[j]);
            chh.insert(numberArray[j]);
        }
        System.out.println("\nInserts:"); //and we print out their corresponding collisions
        System.out.println("LPH Collisions: " + lph.getNumCollisions());
        System.out.println("QPH Collisions: " + qph.getNumCollisions());
        System.out.println("CHH Collisions: " + chh.getNumCollisions() + "\n");
        for (int f = 0; f < numberArray.length; f++) {
            lph.search(numberArray[f]); //and search the same values in the hash tables
            qph.search(numberArray[f]);
            chh.search(numberArray[f]);
        }
        System.out.println("\nInserts & Searches:"); //we will not reset numCollisions between inserts and searches so we see the total number of collisions
        System.out.println("LPH Collisions: " + lph.getNumCollisions());
        System.out.println("QPH Collisions: " + qph.getNumCollisions());
        System.out.println("CHH Collisions: " + chh.getNumCollisions() + "\n");

    }

}
