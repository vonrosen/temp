package fundingcircle;

public class PrintPrimes {

    private static final int MAX_ARRAY_SIZE = 1024 * 1024; // don't use over 1MB
                                                           // of memory for
                                                           // seive array and
                                                           // limit exec time
    private static final int FIRST_PRIME = 2;
    private static final String USAGE = "Usage: \"java PrintPrimes 10\" to print a multiplication table using the first 10 primes";
    
    public static void main(String [] args) {
        if (args.length == 1) {
            try {
                int numberOfPrimes = Integer.parseInt(args[0]);
                if (numberOfPrimes <= 0) {
                    System.exit(0);
                }
                
                int [] primes = calculatePrimes(numberOfPrimes);

                if (primes == null) {
                    System.exit(1);
                }

                System.out.println(createMultiplicationTable(primes));
                System.exit(0);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Come on! We want an integer!");
                System.out.println(USAGE);
                System.exit(1);
            }
            catch (Exception exc) {
                exc.printStackTrace();
                System.exit(1);
            }
        }
        
        System.out.println(USAGE);
        System.exit(1);
    }
    
    public static String createMultiplicationTable(int [] numbers) {
        if (numbers == null) return "";

        StringBuffer buffer = new StringBuffer("\t\n\t");
        
        for (int row = 0; row <= numbers.length; ++row) {
            if (row == 0) {
                for (int col = 0; col < numbers.length; ++col) {
                    buffer.append(numbers[col]);
                    buffer.append("\t");
                }
            }
            else {
                for (int col = 0; col <= numbers.length; ++col) {
                    if (col == 0) {
                        buffer.append(numbers[row - 1]);
                    }
                    else {
                        buffer.append(numbers[row - 1] * numbers[col - 1]);
                    }
                    buffer.append("\t");
                }
            }
            buffer.append("\n");
        }
        
        return buffer.toString();
    }
    
    public static int [] calculatePrimes(int numberOfPrimesToCalculate) {        
        if (numberOfPrimesToCalculate <= 0) {
            return null;
        }
        
        //array holds all numbers starting with first prime (2) up to the MAX_ARRAY_SIZE + 1
        byte [] array = new byte[MAX_ARRAY_SIZE];

        //first prime number
        int nextPrime = FIRST_PRIME;
        
        while (true) {
            if ((nextPrime - FIRST_PRIME) >= array.length) {
                break;
            }
            
            int multiplier = 1;
            for (int tmp = nextPrime; tmp - FIRST_PRIME < array.length; tmp = nextPrime * multiplier) {
                //mark as NOT prime using '1' as flag, print will be marked with '0'
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
                primes[primeCounter] = i + FIRST_PRIME;
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
