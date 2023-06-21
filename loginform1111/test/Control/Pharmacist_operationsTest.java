/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Pharmacist_operations.Delete_Pharmacist;
import static Control.Pharmacist_operations.Search_Pharmacist;
import static Control.Pharmacist_operations.get_pharmacistData;
import static Control.Pharmacist_operations.insert_pharmacistData;
import Modeling.Pharmacist_Model;
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
public class Pharmacist_operationsTest {
    
    public Pharmacist_operationsTest() {
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
     * Test of insert_pharmacistData method, of class Pharmacist_operations.
     */
    @Test
    public void testInsert_pharmacistData() {
        System.out.println("insert_pharmacistData");
        int ID = 4;
        String firstname = "amr";
        String lastname = "zaza";
        int age = 25;
        String hired_date="18/6/2023";
        String gender = "male";
        String phonenumber = "01159875632";
        String email = "omer@gmail.com";
        String password = "12365";
        int salary = 3500;
       int mng_id=1;
       
       insert_pharmacistData( ID, firstname, lastname, gender, phonenumber, email, password, salary,  age );
      
         Pharmacist_Model pharmasist = Search_Pharmacist(ID);
         
         assertEquals(ID, pharmasist.getId());
         assertEquals(firstname, pharmasist.getFirstname());
         assertEquals(lastname, pharmasist.getLastname());
         assertEquals(gender, pharmasist.getGender());
         assertEquals(phonenumber, pharmasist.getPhonenumber());
          assertEquals(email, pharmasist.getEmail());
          assertEquals(password, pharmasist.getPassword());
          assertEquals(salary, pharmasist.getSalary());
          assertEquals(age, pharmasist.getAge());
        //  assertEquals(Hired_date,pharmasist.getHired_date() );

    }
@Test
   public void testInsert2_pharmacistData() {
        System.out.println("insert_pharmacistData");
        int ID = 5;
        String firstname = "fa";
        String lastname = "dd";
        int age = 22;
        String hired_date="18/6/2023";
        String gender = "male";
        String phonenumber = "01359875632";
        String email = "dd@gmail.com";
        String password = "123d65";
        int salary = 3500;
       int mng_id=1;
       
       insert_pharmacistData( ID, firstname, lastname, gender, phonenumber, email, password, salary,  age );
      
         Pharmacist_Model pharmasist = Search_Pharmacist(ID);
         
         assertEquals(ID, pharmasist.getId());
         assertEquals(firstname, pharmasist.getFirstname());
         assertEquals(lastname, pharmasist.getLastname());
         assertEquals(gender, pharmasist.getGender());
         assertEquals(phonenumber, pharmasist.getPhonenumber());
          assertEquals(email, pharmasist.getEmail());
          assertEquals(password, pharmasist.getPassword());
          assertEquals(salary, pharmasist.getSalary());
          assertEquals(age, pharmasist.getAge());
        //  assertEquals(Hired_date,pharmasist.getHired_date() );

    }
   
@Test
    public void testGet2_pharmacistData() {
         ArrayList<Pharmacist_Model> expectedList = new ArrayList<>();
   Pharmacist_Model pharmacist1 =new Pharmacist_Model (1,"2023/04/27 ","saif","soltan","Male","01143057909","saifsoltan18@gamil.com","saif123",3500,21); 
   Pharmacist_Model pharmacist2 =new Pharmacist_Model (1,"2023/04/27 ","saif","ahmed","Male","01146985325","saifahmed55@gmail.com","saif123",3500,21); 
   Pharmacist_Model pharmacist3 =new Pharmacist_Model (1,"2023/04/27 ","ahmed","sherif","Male","01147965832","ahmedsherif7@gmail.com","ahmed123",3500,21); 
   Pharmacist_Model pharmacist4 =new Pharmacist_Model (1,"2023/06/18 ","fa","dd","male","01359875632","dd@gmail.com","123d65",3500,22); 
   
    expectedList.add(pharmacist1);
    expectedList.add(pharmacist2); 
    expectedList.add(pharmacist3);
    expectedList.add(pharmacist4);
    

ArrayList<Pharmacist_Model> actualList = get_pharmacistData();
assertEquals(expectedList.size(), actualList.size());
for (int i = 0; i < expectedList.size(); i++) {
Pharmacist_Model expectedModel = expectedList.get(i); 
Pharmacist_Model actualModel = actualList.get(i);

//assertEquals (expectedModel.getId(), actualModel.getId()); 
assertEquals(expectedModel.getFirstname(), actualModel.getFirstname());
assertEquals(expectedModel.getLastname(), actualModel.getLastname());
assertEquals (expectedModel.getAge(), actualModel.getAge());
assertEquals(expectedModel.getHired_date(), actualModel.getHired_date());
assertEquals(expectedModel.getGender(), actualModel.getGender());
assertEquals(expectedModel.getPhonenumber(), actualModel.getPhonenumber());
assertEquals(expectedModel.getEmail(), actualModel.getEmail());
assertEquals(expectedModel.getPassword(), actualModel.getPassword());
assertEquals(expectedModel.getSalary(), actualModel.getSalary());
    }
  }
@Test
    public void testDelete_Pharmacist() {
        int id = 4;
        Delete_Pharmacist(id);
        Pharmacist_Model result =Search_Pharmacist(id);
        assertNull(result);
 }
    @Test
    public void testCheck_Pharmacist_Acc() {
        String email = "saifsoltan18@gamil.com";
        String password = "saif123";
        int expResult = 0;
        int result = Pharmacist_operations.check_Pharmacist_Acc(email, password);
        assertEquals(expResult, result); //True
    }
    @Test
    public void testCheck2_Pharmacist_Acc() {
        String email = "saifsoltan@gamil.com";
        String password = "saif+123";
        int expResult = 0;
        int result = Pharmacist_operations.check_Pharmacist_Acc(email, password);
        assertNotEquals(expResult, result); //false
    }
    @Test
    public void testSearch_Pharmacist() {
       int id = 6;
       Pharmacist_Model result = Search_Pharmacist(id);
        assertNull( result); //if it not exist
    }
    
    @Test
public void testSearch2_Pharmacist() {
       int id = 1;
       Pharmacist_Model result = Search_Pharmacist(id);
        assertNotNull( result); //if it  exist
    }
    
    @Test
    public void testGet_pharmacistData() {
         ArrayList<Pharmacist_Model> expResult =null;
        ArrayList<Pharmacist_Model> result = get_pharmacistData();
        assertNotEquals(expResult, result);
    }
    
}
