/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class Warmup1Test {
    @Test
    public void posNeg() {
        assertEquals(Warmup1.posNeg(-1, -1, true), true);
    }

    @Test
    public void notString() {
        assertEquals(Warmup1.notString("not bad"), "not bad");
    }

    @Test
    public void front3() {
        assertEquals(Warmup1.front3("Chocolate"), "ChoChoCho");
    }

    @Test
    public void startHi() {
        assertEquals(Warmup1.startHi("hi there"), true);
    }

    @Test
    public void in1020() {
        assertEquals(Warmup1.in1020(12, 99), true);
    }

    @Test
    public void mixStart() {
        assertEquals(Warmup1.mixStart("pix snacks"), true);
    }

    @Test
    public void startOz() {
        assertEquals(Warmup1.startOz("ozymandias"), "oz");
    }

    @Test
    public void intMax() {
        assertEquals(Warmup1.intMax(1, 2, 3), 3);
    }

    @Test
    public void stringE() {
        assertEquals(Warmup1.stringE("Heelele"), false);
    }

    @Test
    public void everyNth() {
        assertEquals(Warmup1.everyNth("Miracle", 2), "Mrce");
    }

}