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
    
    private static final String TEST_PRIMES_UI_TO_10_DATA = 
            "\t\n\t2\t3\t5\t7\t11\t13\t17\t19\t23\t29\t\n2\t4\t6\t10\t14\t22\t26\t34\t38\t46\t58\t\n3\t6\t9\t15\t21\t33\t39\t51\t57\t69\t87\t\n5\t10\t15\t25\t35\t55\t65\t85\t95\t115\t145\t\n7\t14\t21\t35\t49\t77\t91\t119\t133\t161\t203\t\n11\t22\t33\t55\t77\t121\t143\t187\t209\t253\t319\t\n13\t26\t39\t65\t91\t143\t169\t221\t247\t299\t377\t\n17\t34\t51\t85\t119\t187\t221\t289\t323\t391\t493\t\n19\t38\t57\t95\t133\t209\t247\t323\t361\t437\t551\t\n23\t46\t69\t115\t161\t253\t299\t391\t437\t529\t667\t\n29\t58\t87\t145\t203\t319\t377\t493\t551\t667\t841\t\n";
    
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

    @Test
    public void testPrimesUITo10() {
        Assert.assertEquals(
                pp.createMultiplicationTable(TEST_PRIMES_TO_10_DATA),
                TEST_PRIMES_UI_TO_10_DATA);
    }
}
