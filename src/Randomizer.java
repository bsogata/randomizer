/**
 * This class defines methods for computing pseudo-random numbers, and it defines
 * the state variable that needs to be maintained for use by those methods.
 *
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */

public class Randomizer {
  // Carefully chosen constants from the book "Numerical Recipes in C".
  // All "static final" fields are constants.

  // The "modulus"
  private static final int MODULUS = 233280;

  // The "multiplier"
  private static final int MULTIPLIER = 9301;

  // The "increment"
  private static final int INCREMENT = 49297;

  // The state variable maintained by each Randomizer instance
  private long seed = 1;

  /**
   * Initializes the seed value for a new Randomizer instance.
   *
   * @param seed    The long equal to the seed value to use.
   *
   */

  public Randomizer(long seed) {
    this.seed = seed;
  }

  /**
   * Computes a pseudo-random number between 0 and 1 using a very simple algorithm.
   *
   * Math.random() and java.util.Random are actually a lot better at computing randomness.
   *
   * @return A float containing a random floating-point value.
   *
   */

  public float randomFloat() {
    this.seed = (this.seed * Randomizer.MULTIPLIER + Randomizer.INCREMENT) % Randomizer.MODULUS;
    return (float) this.seed / (float) Randomizer.MODULUS;
  }

  /**
   * Computes a pseudo-random integer between 0 and a specified maximum.
   * Uses randomFloat().
   *
   * @param max    The int equal to the maximum value for the integer to return.
   *
   * @return An int containing a random integer value.
   *
   */

  public int randomInt(int max) {
    return Math.round(max * randomFloat());
  }

  /**
   * A simple test program that prints 10 random integers.
   * Note how the Randomizer object is seeded using the current time.
   *
   * This should probably be a separate class, but has been left as is since I (Branden)
   * cannot find a specific coding standard that this violates.
   *
   */

  public static class Test {

    /**
     * Prints ten random integers.
     *
     * @param args    Not used.
     *
     */

    public static void main(String[] args) {
      Randomizer r = new Randomizer(new java.util.Date().getTime());

      for (int i = 0; i < 10; i++) {
        System.out.println(r.randomInt(100));
      }
    }
  }
}