//yeah, yeah, no explicit package, but this is a sample that should be easily runnable without putting in a 
//fully qualified classpath

public class PrintPrimes {

    private static final int MAX_ARRAY_SIZE = 1024 * 1024; //don't use over 1M of memory for seive array and limit exec time
    private static final int FIRST_PRIME = 2;
    
    public static void main(String [] args) {
        if (args.length == 1) {
            try {
                int numberOfPrimes = Integer.parseInt(args[0]);
                int [] primes = calculatePrimes(numberOfPrimes);

                if (primes == null) {
                    System.exit(1);
                }

                /*
                for (int i = 0; i < primes.length; ++i) {
                    System.out.print(primes[i]);
                    System.out.print(" ");
                }
                System.out.println("");
                */

                printMultiplicationTable(primes);
                System.exit(0);
            }
            catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                System.out.println("Come on! We want an integer!");
                System.exit(1);
            }
            catch (Exception exc) {
                exc.printStackTrace();
                System.exit(1);
            }
        }
        
        System.out.println("Please, just give me the number of primes you want to print, okay?");
    }
    
    private static void printMultiplicationTable(int [] numbers) {
        if (numbers == null) return;

        StringBuffer buffer = new StringBuffer();
        
        //rows
        for (int row = 0; row < numbers.length; ++row) {
            //colls
            for (int col = 0; col < numbers.length; ++col) {
                buffer.append(printCell(row, col));
            }
        }
        
        System.out.println(buffer);
    }
    
    private static String printCell(int row, int col) {
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < row; ++i) {
            buffer.append("\n");
        }
        
        for (int i = 0; i < col; ++i) {
            buffer.append(" ");
        }
        
        buffer.append("2");

        return buffer.toString();
    }
    
    private static int [] calculatePrimes(int numberOfPrimesToCalculate) {        
        //array holds all numbers starting with first prime (2) up to the MAX_ARRAY_SIZE + 1
        byte [] array = new byte[MAX_ARRAY_SIZE];

        //first prime number
        int nextPrime = 2;
        int lastIndex = 0;
        
        while (true) {
            if ((nextPrime - FIRST_PRIME) >= array.length) {
                break;
            }
            
            int multiplier = 1;
            for (int tmp = nextPrime; tmp - FIRST_PRIME < array.length; tmp = nextPrime * multiplier) {
                //mark as NOT prime using '1' as flag
                if (tmp > nextPrime) {
                    array[tmp - FIRST_PRIME] = 1;
                }
                ++multiplier;
            }

            int lastNextPrime = nextPrime;
            
            //find next prime to use for creating next layer of seive
            for (int x = nextPrime - FIRST_PRIME + 1; x < array.length; ++x) {
                if (array[x] != 1) {
                    nextPrime = FIRST_PRIME + x;
                    break;
                }
            }
            
            if (lastNextPrime == nextPrime) {
                //everything left in array is not prime so break out
                break;
            }
        }
        
        //create prime list
        int [] primes = new int[numberOfPrimesToCalculate];
        int primeCounter = 0;        
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != 1) {
                primes[primeCounter] = i + 2;
                ++primeCounter;
                if (primeCounter == numberOfPrimesToCalculate) {
                    break;
                }
            }
        }

        if (primes[numberOfPrimesToCalculate - 1] == 0) {
            System.out.println("Sorry, I just couldn't calculate all those primes.");
            return null;
        }
        
        return primes;
    }    
}
