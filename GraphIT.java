/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CJ
 */
public class GraphIT {
    
    public GraphIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initUI method, of class Graph.
     */
    @Test
    public void testInitUI() {
        System.out.println("initUI");
        Graph instance = new Graph();
        instance.initUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetXData method, of class Graph.
     */
    @Test
    public void testSetXData() {
        System.out.println("SetXData");
        Graph instance = new Graph();
        instance.SetXData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetYData method, of class Graph.
     */
    @Test
    public void testSetYData() {
        System.out.println("SetYData");
        Graph instance = new Graph();
        instance.SetYData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetX method, of class Graph.
     */
    @Test
    public void testSetX() {
        System.out.println("SetX");
        LinkedList x = null;
        Graph instance = new Graph();
        instance.SetX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetY method, of class Graph.
     */
    @Test
    public void testSetY() {
        System.out.println("SetY");
        LinkedList y = null;
        Graph instance = new Graph();
        instance.SetY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetTitle method, of class Graph.
     */
    @Test
    public void testSetTitle() {
        System.out.println("SetTitle");
        String title = "Test Title";
        Graph instance = new Graph();
        instance.SetTitle(title);
        System.out.println(instance.title);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of SetXAxis method, of class Graph.
     */
    @Test
    public void testSetXAxis() {
        System.out.println("SetXAxis");
        String xAxis = "Test X";
        Graph instance = new Graph();
        instance.SetXAxis(xAxis);
        System.out.println(instance.xAxis);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of SetYAxis method, of class Graph.
     */
    @Test
    public void testSetYAxis() {
        System.out.println("SetYAxis");
        String yAxis = "Test Y";
        Graph instance = new Graph();
        instance.SetYAxis(yAxis);
        System.out.println(instance.yAxis);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of SetLegend method, of class Graph.
     */
    @Test
    public void testSetLegend() {
        System.out.println("SetLegend");
        String legend = "Test Legend";
        Graph instance = new Graph();
        instance.SetLegend(legend);
        System.out.println(instance.legend);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
}
