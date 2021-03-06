package pilsner.dwt;

import java.io.IOException;
import org.junit.Test;
import pilsner.utils.DataLoader;
import static org.junit.Assert.*;

/**
 * Test metody FastDaubechies4.
 *
 * @author Jiri Novotny
 */
public class FastDaubechies4Test {

    private double DELTA = 1E-14;
    private double DELTA_I = 2;

    /**
     * Test of transform method, of class FastDaubechies4.
     */
    @Test
    public void testTransform() {
        System.out.println("transform fast daubechies 4");
        double[] inputSignal = null, expResult = null;
        try {
            inputSignal = DataLoader.load("test/data/dwt/src_signal.txt");
            expResult = DataLoader.load("test/data/dwt/sig_db4.txt");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        double[] result = FastDaubechies4.transform(inputSignal);
        assertArrayEquals(expResult, result, DELTA);
    }

    /**
     * Test of invTransform method, of class FastDaubechies4.
     */
    @Test
    public void testInvTransform() {
        System.out.println("invTransform fast daubechies 4");
        double[] inputSignal = null, expResult = null;
        try {
            inputSignal = DataLoader.load("test/data/dwt/sig_db4.txt");
            expResult = DataLoader.load("test/data/dwt/src_signal.txt");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        double[] result = FastDaubechies4.invTransform(inputSignal);
        assertArrayEquals(expResult, result, DELTA_I);
    }

}