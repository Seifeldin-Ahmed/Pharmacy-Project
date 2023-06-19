package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.Products_Operations;
import static Control.Products_Operations.Delete_Product;
import static Control.Products_Operations.Edit_Product;
import static Control.Products_Operations.Search_Product;
import static Control.Products_Operations.get_ProductsData;
import static Control.Products_Operations.insert_ProductData;
import Modeling.DBOperation;
import Modeling.Products_Model;
import java.util.ArrayList;
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
public class Products_OperationsTest {
    
    public Products_OperationsTest() {
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
     * Test of insert_ProductData method, of class Products_Operations.
     */
   
  
  
  
  /*private boolean verifyReservationData(String med_name,int price,String expired_date,int quantity,String category,String description ) {
      boolean re = false;
        ArrayList<Products_Model> products = Products_Operations.get_ProductsData();
        for (Products_Model product : products) {
            if     (product.getMed_name()==med_name
                    && product.getPrice()== price
                    && product.getExpired_date()==expired_date
                    && product.getQuantity()== quantity
                    && product.getCategory()== category
                    && product.getDescription()==description) 
            {
                re=true;
            }
            else 
            {
                re=false;
            }
        }
        return re;
  }*/

  @Test
    public void testGet_get_Productdata() {
       ArrayList<Products_Model> expectedList = new ArrayList<>();
   Products_Model product1 =new Products_Model ("move", 70,"1/8/2030",202,"Other","hh"); 
   Products_Model product2 =new Products_Model ("namnam", 800,"11/02/2045",60,"tablet ","sddd"); 
   Products_Model product3 =new Products_Model ("paan", 100,"15/2/2029",19,"relievers","A pain reliever that helps to relieve headaches, muscle aches, and other pains."); 
   Products_Model product4 =new Products_Model ("pandol", 102,"15/10/2028",20,"Tablet","ggg"); 
   Products_Model product5 =new Products_Model ("pann", 500,"1/8/2038",300,"tables ","sddd"); 
   Products_Model product6 =new Products_Model ("samaa", 500,"12/11/2080",5,"Topical medicines ","dc"); 
   

   
   expectedList.add(product1);
    expectedList.add(product2); 
    expectedList.add(product3);
     expectedList.add(product4);
     expectedList.add(product5);
     expectedList.add(product6);

    
ArrayList<Products_Model> actualList = get_ProductsData();
assertEquals(expectedList.size(), actualList.size());
for (int i = 0; i < expectedList.size(); i++) {
Products_Model expectedModel = expectedList.get(i); 
Products_Model actualModel = actualList.get(i);

assertEquals (expectedModel.getMed_name(), actualModel.getMed_name()); 
assertEquals(expectedModel.getPrice(), actualModel.getPrice());
assertEquals(expectedModel.getQuantity(), actualModel.getQuantity());
assertEquals (expectedModel.getExpired_date(), actualModel.getExpired_date());
assertEquals(expectedModel.getCategory(), actualModel.getCategory());
assertEquals(expectedModel.getDescription(), actualModel.getDescription());

    }
    }
    @Test
    public void testGet2_get_Productdata() {
        ArrayList<Products_Model> expResult =null;
        ArrayList<Products_Model> result = Products_Operations.get_ProductsData();
        assertNotEquals(expResult, result);
    }
@Test
  public void testInsertProductData() {
    // Arrange
    String med_name = "azza";
    int price = 10;
    String expired_date = "12/8/2035";
    int quantity = 100;
    String category = "Pain relievers";
    String description = "A pain reliever that helps to relieve headaches, muscle aches, and other pains.";

         insert_ProductData(med_name, price, expired_date, quantity, category, description);

         Products_Model product = Search_Product(med_name);
         assertEquals(category, product.getCategory());
         assertEquals(description, product.getDescription());
         assertEquals(price, product.getPrice());
         assertEquals(expired_date, product.getExpired_date());
         assertEquals(quantity, product.getQuantity());
  }
  @Test
  public void testInsert2ProductData() {
    // Arrange
    String med_name = "paan";
    int price = 100;
    String expired_date = "15/2/2029";
    int quantity = 19;
    String category = "relievers";
    String description = "A pain reliever that helps to relieve headaches, muscle aches, and other pains.";

         insert_ProductData(med_name, price, expired_date, quantity, category, description);

         Products_Model product = Search_Product(med_name);
         assertEquals(category, product.getCategory());
         assertEquals(description, product.getDescription());
         assertEquals(price, product.getPrice());
         assertEquals(expired_date, product.getExpired_date());
         assertEquals(quantity, product.getQuantity());
  }
  @Test
  public void testSearch_Product() {
    // Arrange
    String med_name = "Adviffla";
    Products_Model result = Products_Operations.Search_Product(med_name);
        assertNull( result); //if it not exist
  }

  @Test
  public void testSearch2_Product() {
    // Arrange
    String med_name = "pann";
  //  ArrayList<Products_Model> expResult = null;
    Products_Model result = Products_Operations.Search_Product(med_name);
        assertNotNull( result); //if is exist
  }

  @Test
  public void testDelete_Product() {
    String med_name = "azza";
    Delete_Product(med_name);
  Products_Model result =Search_Product(med_name);
     assertNull(result);
  }
 
  @Test
  public void testEdit_Product() {
    // Arrange
    String med_name = "pann";
    int new_price = 500;
    String new_expired_date = "1/8/2038";
    int quantity = 300;

    // Act
    Edit_Product(med_name, new_price, new_expired_date, quantity);

    // Assert
    Products_Model product = Search_Product(med_name);
    assertEquals(new_price, product.getPrice());
    assertEquals(new_expired_date, product.getExpired_date());
    assertEquals(quantity, product.getQuantity());
  }
  
}
