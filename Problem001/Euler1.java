//===========================================================================================
// Project Euler - Problem 1
// Tim Backus - tbackus127@gmail.com
//-------------------------------------------------------------------------------------------
// Multiples of 3 and 5
// Find the sum of all the multiples of 3 or 5 below 1000.
//===========================================================================================

import java.util.HashSet;

public class Euler1 {
  
  // Upper limit (and not inclusive) for the multiples sum.
  private static final int UPPER_LIMIT = 1000;
  
  /**
   * Main method. Executes the two methods of finding the sum of all multiples of 3 and 5, 
   * and outputs the result and how long it took to compute.
   * @param args runtime arguments (not used).
   */
  public static void main(String[] args) {
    long timeStart = System.nanoTime();
    int result = bruteForce(UPPER_LIMIT);
    long timeEnd = System.nanoTime();
    long timeDelta = timeEnd - timeStart;
    System.out.println("Result (brute-force): " + result + ". Completed in " + ((double)timeDelta / 1000000) + "ms.");
    timeStart = System.nanoTime();
    result = usingSets(UPPER_LIMIT);
    timeEnd = System.nanoTime();
    timeDelta = timeEnd - timeStart;
    System.out.println("Result (using sets): " + result + ". Completed in " + ((double)timeDelta / 1000000) + "ms.");
  }
  
  /**
   * Brute-force method. Will iterate through all numbers from 3 to UPPER_LIMIT, checking
   * if each one is divisible by 3 or 5, and accumulating the value.
   * @param limit the highest number (minus one) that the loop should reach.
   * @return an int with the sum of all multiples.
   */
  private static int bruteForce(int limit) {
    int result = 0;
    for(int i = 3; i < limit; i++)
      if(i % 3 == 0 || i % 5 == 0)
        result += i;
    return result;
  }
  
  /**
   * Multiplicative method using sets. Will only add all numbers that are multiples of 3
   * or five instead of iterating through the entire span.
   * @param limit the highest number (minus one) that the loop should reach.
   * @return an int with the sum of all multiples.
   */
  private static int usingSets(int limit) {
    int result = 0;
    HashSet<Integer> multiples = new HashSet<Integer>();
    for(int i = 3; i < limit; i += 3)
      multiples.add(i);
    for(int i = 5; i < limit; i += 5)
      multiples.add(i);
    for(int i : multiples)
      result += i;
    return result;
  }
}