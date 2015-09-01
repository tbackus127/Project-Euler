//===========================================================================================
// Project Euler - Problem 1
//-------------------------------------------------------------------------------------------
// Multiples of 3 and 5
// Find the sum of all the multiples of 3 or 5 below 1000.
//===========================================================================================

import java.util.HashSet;

public class Euler1 {
  
  // And NOT including
  private static final int UPPER_LIMIT = 10;
  
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
  
  private static int bruteForce(int limit) {
    int result = 0;
    for(int i = 3; i < limit; i++) {
      if(i % 3 == 0 || i % 5 == 0)
        result += i;
    }
    return result;
  }
  
  private static int usingSets(int limit) {
    int result = 0;
    HashSet<Integer> multiples = new HashSet<Integer>();
    for(int i = 3; i < limit; i *= 3)
      multiples.add(i);
    for(int i = 5; i < limit; i *= 5)
      multiples.add(i);
    for(int i : multiples)
      result += i;
    return result;
  }
}