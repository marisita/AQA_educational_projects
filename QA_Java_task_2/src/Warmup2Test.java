/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class Warmup2Test {
    @Test
    public void stringTimes() {
        assertEquals(Warmup2.stringTimes("Hi", 3), "HiHiHi");
    }

    @Test
    public void frontTimes(){
        assertEquals(Warmup2.frontTimes("Chocolate", 3), "ChoChoCho");
    }

    @Test
    public void countXX() {
        assertEquals(Warmup2.countXX("abcxxx"), 2);
    }

    @Test
    public void doubleX() {
        assertEquals(Warmup2.doubleX("axxbb"), true);
    }

    @Test
    public void stringSplosion() {
        assertEquals(Warmup2.stringSplosion("Code"), "CCoCodCode");
    }

    @Test
    public void last2()  {
        assertEquals(Warmup2.last2("xaxxaxaxx"), 1);
    }

    @Test
    public void array123() {
        assertEquals(Warmup2.array123(new int[] {1, 1, 2, 3, 1}), true);
    }

    @Test
    public void stringMatch() {
        assertEquals(Warmup2.stringMatch("abc", "abc"), 2);
    }

    @Test
    public void stringX() {
        assertEquals(Warmup2.stringX("xabxxxcdx"), "xabcdx");
    }

    @Test
    public void stringYak() {
        assertEquals(Warmup2.stringYak("yik123ya"), "123ya");
    }

}