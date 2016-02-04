package fundingcircle;

import fundingcircle.PrintPrimes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrintPrimesTest {

    //test data from https://primes.utm.edu/lists/small/10000.txt
    private static final int [] TEST_PRIMES_TO_10_DATA = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29     
    };

    //test data from https://primes.utm.edu/lists/small/10000.txt
    private static final int [] TEST_PRIMES_TO_20_DATA = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71
    };
    
    private PrintPrimes pp = null; 
    
    @Before
    public void setUp() {
        pp = new PrintPrimes();
    }    

    @Test
    public void testPrimesTo10() {
        Assert.assertArrayEquals(pp.calculatePrimes(10), TEST_PRIMES_TO_10_DATA);
    }

    @Test
    public void testPrimesTo20() {
        Assert.assertArrayEquals(pp.calculatePrimes(20), TEST_PRIMES_TO_20_DATA);
    }    
    
    @Test
    public void testPrimesTo0() {
        Assert.assertArrayEquals(pp.calculatePrimes(0), null);
    }
    
    
}
