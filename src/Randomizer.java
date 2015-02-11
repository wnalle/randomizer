/**
 * This class defines methods for computing pseudo-random numbers, and it defines
 * the state variable that needs to be maintained for use by those methods.
 **/
public class Randomizer {
    // Carefully chosen constants from the book "Numerical Recipes in C".
    // All "static final" fields are constants.
    private static final int MOD = 233280;  // the "modulus"
    private static final int MULT = 9301;    // the "multiplier"
    private static final int INC = 49297;   // the "increment"

    // The state variable maintained by each Randomizer instance
    private long seed = 1;

  /**
   * The constructor for the Randomizer() class.  It must be passed some
   * arbitrary initial value or "seed" for its pseudo-randomness.
   *
   * @param seed the seed value for the random generator
   **/
  public Randomizer(long seed) {
    this.seed = seed;
  }

  /**
   * This method computes a pseudo-random number between 0 and 1 using a very
   * simple algorithm.  Math.random() and java.util.Random are actually a lot
   * better at computing randomness.
   *
   * @return a random float value.
   **/
  public float randomFloat() {
      seed = (seed * MULT + INC) % MOD; return (float) seed / (float) MOD;
  }

  /**
   * This method computes a pseudo-random integer between 0 and specified
   * maximum.  It uses randomFloat() above.
   *
   * @param max the maximum of the random value
   * @return a random integer value between 0 and max
   *
   **/
  public int randomInt(int max) {
      return Math.round(max * randomFloat());
  }

  /**
   * This nested class is a simple test program: it prints 10 random integers.
   * Note how the Randomizer object is seeded using the current time.
   *
   **/
  public static class Test {
    /**
     * Generate 10 random values to test the Randomizer class.
     * @param args ignored
     */
      public static void main(String[] args) {
        Randomizer r = new Randomizer(new java.util.Date().getTime());
        for (int i = 0; i < 10; i++) {
          System.out.println(r.randomInt(100));
        }
      }
  }
}