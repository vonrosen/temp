
public class Sieve {

    public static void main(String [] args) {
        if (args.length == 1) {
            int topLimit = Integer.parseInt(args[0]);

            printPrimes(topLimit);
        }        
    }
    
    private static void printPrimes(int topLimit) {        
        int [] array = new int[topLimit + 1];
        
        int i = 2;
        
        while (true) {
            if (i == topLimit) break;

            //calculate all not-primes
            int multiplier = 1;
            for (int tmp = i; tmp <= topLimit; tmp = i * multiplier) {
                if (tmp > i) {
                    //mark as NOT prime
                    array[tmp] = 1;
                }
                
                ++multiplier;
            }

            for (int x = i + 1; x <= topLimit; ++x) {
                if (array[x] != 1 || x == topLimit) {
                    i = x;
                    break;
                }
            }
        }
        
        //print that list
        for (int tmp = 2; tmp < topLimit; ++tmp) {
            if (array[tmp] == 0) {
                System.out.print(tmp);
                System.out.print(" ");
            }
        }
    }    
}
