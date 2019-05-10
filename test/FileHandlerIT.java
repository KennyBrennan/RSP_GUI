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
public class FileHandlerIT {
    
    public FileHandlerIT() {
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
     * Test of setPath method, of class FileHandler.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String path = "/Users/christiandevito/Desktop/programs/CSC380/mesa-r11554";
        FileHandler instance = new FileHandler();
        instance.setPath(path);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ChangeFile method, of class FileHandler.
     */
    @Test
    public void testChangeFile() {
        System.out.println("ChangeFile");
        String fileName = "rsp_RR_Lyrae/inlist_rsp_RR_Lyrae";
        FileHandler instance = new FileHandler();
        instance.ChangeFile(fileName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setStarName method, of class FileHandler.
     */
    @Test
    public void testSetStarName() {
        System.out.println("setStarName");
        String starName = "rsp_RR_Lyrae";
        FileHandler instance = new FileHandler();
        instance.setStarName(starName);
            if (instance.starName.equals(starName)){
                System.out.println(starName);
            }
    }

    /**
     * Test of UpdatePeriods method, of class FileHandler.
     *
     *    RSP_mass = 0.65d0
     *    RSP_Teff = 6500d0
     *    RSP_L = 60d0
     *    RSP_X = 0.75d0
     *    RSP_Z = 0.0004d0
     *
     *
     */
    @Test
    public void testUpdatePeriods() {
        System.out.println("UpdatePeriods");
        String periods = "1000";
        FileHandler instance = new FileHandler();
        instance.UpdatePeriods(periods);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateFile method, of class FileHandler.
     */
    @Test
    public void testUpdateFile() {
        System.out.println("UpdateFile");
        String exptText = "0.71262d0";
        String checkText = "10";
        String mass = "0.65d0";
        String temperature = "6500d0";
        String l = "60d0";
        String x = "0.75d0";
        String z = "0.004d0";
        FileHandler instance = new FileHandler();
        instance.UpdateFile(exptText, checkText, mass, temperature, l, x, z);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ParseHistory method, of class FileHandler.
     */
    @Test
    public void testParseHistory() {
        System.out.println("ParseHistory");
        FileHandler instance = new FileHandler();
        LinkedList<dataObject> expResult = null;
        LinkedList<dataObject> result = instance.ParseHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
