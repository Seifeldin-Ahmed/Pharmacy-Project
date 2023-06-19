package GuiFunctions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GuiFunctions.GuiSetStockValidate;
import Modeling.Products_Model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lenovo
 */
public class GuiSetStockValidateTest {
    
    public GuiSetStockValidateTest() {
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
     * Test of SetStock_validateFields method, of class GuiSetStockValidate.
     */
    @Test
    public void testSetStock_validateFields() {
         System.out.println("Empty fields");
        String prod_name = "";
        String pri = "";
        String quan = "";
        String ex_date = "";
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.SetStock_validateFields(prod_name, pri, quan, ex_date);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetStock2_validateFields() {
         System.out.println("Empty fields");
        String prod_name = "alva";
        String pri = "50";
        String quan = "";
        String ex_date = "";
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.SetStock_validateFields(prod_name, pri, quan, ex_date);
        assertEquals(expResult, result);
    }
     @Test
    public void testSetStock3_validateFields() {
         System.out.println("not Empty fields");
        String prod_name = "alvantern";
        String pri = "70";
        String quan = "50";
        String ex_date = "20/12/2026";
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.SetStock_validateFields(prod_name, pri, quan, ex_date);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetStock4_validateFields() {
         System.out.println("not Empty fields");
        String prod_name = "alvantern";
        String pri = "70";
        String quan = "50";
        String ex_date = "";
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.SetStock_validateFields(prod_name, pri, quan, ex_date);
        assertEquals(expResult, result);
    }
    @Test
    public void testSetStock5_validateFields() {
         System.out.println("not Empty fields");
        String prod_name = "alvantern";
        String pri = "";
        String quan = "";
        String ex_date = "";
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.SetStock_validateFields(prod_name, pri, quan, ex_date);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testVaildate_ExpiredDate() {
        System.out.println("vaildate_ExpiredDate");
        Products_Model old_product =new Products_Model ("move", 70,"1/8/2010",202,"Other","hh"); 
        Products_Model new_product =new Products_Model ("move", 70,"1/8/2020",202,"Other","hh"); 
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.vaildate_ExpiredDate(old_product,new_product);
        assertEquals(expResult, result);
    }
        @Test
    public void testVaildate_ExpiredDate2() {
        System.out.println("vaildate_ExpiredDate");
        Products_Model old_product =new Products_Model ("move", 70,"1/8/2020",202,"Other","hh"); 
        Products_Model new_product =new Products_Model ("move", 70,"1/8/2010",202,"Other","hh"); 
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.vaildate_ExpiredDate(old_product,new_product);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testVaildate_ExpiredDate3() {
        System.out.println("vaildate_ExpiredDate");
        Products_Model old_product =new Products_Model ("move", 70,"1/5/2020",202,"Other","hh"); 
        Products_Model new_product =new Products_Model ("move", 70,"1/8/2020",202,"Other","hh"); 
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.vaildate_ExpiredDate(old_product,new_product);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testVaildate_ExpiredDate4() {
        System.out.println("vaildate_ExpiredDate");
        Products_Model old_product =new Products_Model ("move", 70,"1/8/2020",202,"Other","hh"); 
        Products_Model new_product =new Products_Model ("move", 70,"1/5/2020",202,"Other","hh"); 
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.vaildate_ExpiredDate(old_product,new_product);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testVaildate_ExpiredDate5() {
        System.out.println("vaildate_ExpiredDate");
        Products_Model old_product =new Products_Model ("move", 70,"1/8/2020",202,"Other","hh"); 
        Products_Model new_product =new Products_Model ("move", 70,"15/8/2020",202,"Other","hh"); 
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.vaildate_ExpiredDate(old_product,new_product);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testVaildate_ExpiredDate6() {
        System.out.println("vaildate_ExpiredDate");
        Products_Model old_product =new Products_Model ("move", 70,"15/8/2020",202,"Other","hh"); 
        Products_Model new_product =new Products_Model ("move", 70,"1/8/2020",202,"Other","hh"); 
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.vaildate_ExpiredDate(old_product,new_product);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testIsExpired() {
        System.out.println("IsnotExpired");
        Products_Model product =new Products_Model ("move", 70,"1/8/2030",202,"Other","hh"); 
       // Products_Model Product = null;
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.IsExpired(product);
        assertEquals(expResult, result);
       
    }
     @Test
    public void testIsExpired2() {
        System.out.println("IsExpired");
        Products_Model product =new Products_Model ("move", 70,"1/8/2022",202,"Other","hh"); 
       // Products_Model Product = null;
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.IsExpired(product);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsExpired3() {
        System.out.println("IsExpired");
        Products_Model product =new Products_Model ("move", 70,"1/8/2023",202,"Other","hh"); 
       // Products_Model Product = null;
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.IsExpired(product);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsExpired4() {
        System.out.println("IsExpired");
        Products_Model product =new Products_Model ("move", 70,"1/1/2023",202,"Other","hh"); 
       // Products_Model Product = null;
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.IsExpired(product);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsExpired5() {
        System.out.println("IsExpired");
        Products_Model product =new Products_Model ("move", 70,"30/6/2023",202,"Other","hh"); 
       // Products_Model Product = null;
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = false;
        boolean result = instance.IsExpired(product);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsExpired6() {
        System.out.println("IsExpired");
        Products_Model product =new Products_Model ("move", 70,"1/6/2023",202,"Other","hh"); 
       // Products_Model Product = null;
        GuiSetStockValidate instance = new GuiSetStockValidate();
        boolean expResult = true;
        boolean result = instance.IsExpired(product);
        assertEquals(expResult, result);
    }
   
}
