/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastrutures.ArvoreBinaria;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonh_
 */
public class ArvoreBinariaTest {
    
    public ArvoreBinariaTest() {
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
     * Test of insert method, of class ArvoreBinaria.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Object value = null;
        ArvoreBinaria instance = null;
        instance.insert((Comparable) value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class ArvoreBinaria.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        ArvoreBinaria instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
