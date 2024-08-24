/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** Buggy implementation of nextNumber!
     *  Depending on whether n is odd or not.
     *  Return a different computation for n
     * @param n
     * @return
     */
    public static int nextNumber(int n) {
        if (n % 2 != 0) {
            return 3 * n + 1;
        } else if (n == 1) {
            return n;
        } else {
            return n / 2;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

