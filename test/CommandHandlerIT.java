/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
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
public class CommandHandlerIT {
    
    public CommandHandlerIT() {
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
     * Test of run method, of class CommandHandler.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        CommandHandler instance = new CommandHandler();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reRun method, of class CommandHandler.
     */
    @Test
    public void testReRun() {
        System.out.println("reRun");
        CommandHandler instance = new CommandHandler();
        instance.reRun();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class CommandHandler.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        CommandHandler instance = new CommandHandler();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastFileModified method, of class CommandHandler.
     */
    @Test
    public void testLastFileModified() {
        System.out.println("lastFileModified");
        CommandHandler instance = new CommandHandler();
        File expResult = null;
        File result = instance.lastFileModified();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class CommandHandler.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        CommandHandler instance = new CommandHandler();
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPath method, of class CommandHandler.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        File fpath = null;
        String path = "";
        CommandHandler instance = new CommandHandler();
        instance.setPath(fpath, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStarName method, of class CommandHandler.
     */
    @Test
    public void testSetStarName() {
        System.out.println("setStarName");
        String starName = "";
        CommandHandler instance = new CommandHandler();
        instance.setStarName(starName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeFolder method, of class CommandHandler.
     */
    @Test
    public void testChangeFolder() {
        System.out.println("changeFolder");
        String fileName = "";
        CommandHandler instance = new CommandHandler();
        instance.changeFolder(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
