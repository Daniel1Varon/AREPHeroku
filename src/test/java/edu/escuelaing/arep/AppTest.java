package edu.escuelaing.arep;

import edu.escuelaing.arep.recursos.Calculator;
import edu.escuelaing.arep.recursos.LinkedList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    public void testMean() throws Exception {
        LinkedList lista = new LinkedList();
        lista.addNode(160);
        lista.addNode(591);
        lista.addNode(114);
        lista.addNode(229);
        lista.addNode(230);
        lista.addNode(270);
        lista.addNode(128);
        lista.addNode(1657);
        lista.addNode(624);
        lista.addNode(1503);
        lista.restartView();
        assertEquals(Calculator.mean(lista), 550.6);
        lista = new LinkedList();
        lista.addNode(15.0);
        lista.addNode(69.9);
        lista.addNode(6.5);
        lista.addNode(22.4);
        lista.addNode(28.4);
        lista.addNode(65.9);
        lista.addNode(19.4);
        lista.addNode(198.7);
        lista.addNode(38.8);
        lista.addNode(138.2);
        assertEquals(Calculator.mean(lista), 60.32);
    }

    public void testDeviation() throws Exception {
        LinkedList lista = new LinkedList();
        lista.addNode(160);
        lista.addNode(591);
        lista.addNode(114);
        lista.addNode(229);
        lista.addNode(230);
        lista.addNode(270);
        lista.addNode(128);
        lista.addNode(1657);
        lista.addNode(624);
        lista.addNode(1503);
        lista.restartView();
        assertEquals(Calculator.deviation(lista,Calculator.mean(lista)),572.03);
        lista = new LinkedList();
        lista.addNode(15.0);
        lista.addNode(69.9);
        lista.addNode(6.5);
        lista.addNode(22.4);
        lista.addNode(28.4);
        lista.addNode(65.9);
        lista.addNode(19.4);
        lista.addNode(198.7);
        lista.addNode(38.8);
        lista.addNode(138.2);
        assertEquals(Calculator.deviation(lista,Calculator.mean(lista)),62.26);
    }
}
