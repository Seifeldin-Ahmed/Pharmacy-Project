/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFunctions;

import Control.Products_Operations;
import Modeling.Products_Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import loginform.products;
import Control.Products_Operations;
import Modeling.Products_Model;

/**
 *
 * @author lenovo
 */
public class GuiSetStockValidate {

    public String DatePattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public boolean SetStock_validateFields(String prod_name, String pri, String quan, String ex_date) {
        String med_name = prod_name;
        String price = pri;
        String quantity = quan;
        String expired_date = ex_date;
        return !expired_date.equals("") && !quantity.equals("") && !price.equals("") && !med_name.equals("");
    }

    public boolean vaildate_ExpiredDate(Products_Model old_Product, Products_Model new_Product) {
        boolean vaild = false;
        String old_date = old_Product.getExpired_date();
        String new_date = new_Product.getExpired_date();
        StringTokenizer old = new StringTokenizer(old_date, "/");
        StringTokenizer New = new StringTokenizer(new_date, "/");
        int DayOld = Integer.parseInt(old.nextToken());
        int MonthOld = Integer.parseInt(old.nextToken());
        int YearOld = Integer.parseInt(old.nextToken());
        int DayNew = Integer.parseInt(New.nextToken());
        int MonthNew = Integer.parseInt(New.nextToken());
        int YearNew = Integer.parseInt(New.nextToken());
        if (YearNew > YearOld) // Expired
        {
            vaild = true;
        } else if (YearNew == YearOld) {
            if (MonthNew > MonthOld) {
                vaild = true;
            } else if (MonthNew == MonthOld) {
                if (DayNew >= DayOld) {
                    vaild = true;
                }
            }
        }
        return vaild;
    }

    public boolean IsExpired(Products_Model Product) {
        boolean expired = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String old_date = Product.getExpired_date();
        StringTokenizer old = new StringTokenizer(old_date, "/");
        StringTokenizer Now = new StringTokenizer(dtf.format(now), "/");
        int DayOld = Integer.parseInt(old.nextToken());
        int MonthOld = Integer.parseInt(old.nextToken());
        int YearOld = Integer.parseInt(old.nextToken());
        int YearNow = Integer.parseInt(Now.nextToken());
        int MonthNow = Integer.parseInt(Now.nextToken());
        int DayNow = Integer.parseInt(Now.nextToken());

        if (YearNow > YearOld) // Expired
        {
            expired = true;
        } else if (YearNow == YearOld) {
            if (MonthNow > MonthOld) {
                expired = true;
            } else if (MonthNow == MonthOld) {
                if (DayNow >= DayOld) {
                    expired = true;
                }
            }
        }
        return expired;
    }

    public boolean EditStock(String productName, int new_quantity, String date) {

        int Price, last_quantity;
        String NewExpiredDate;
        Products_Model obj = Products_Operations.Search_Product(productName);
        if (obj == null) {
            return false;
        }
        Price = obj.getPrice();
        /*-----FOR QUANTITY------*/
        
        if (IsExpired(obj)) {
            last_quantity = 0;
        } else {
            last_quantity = Products_Operations.Search_Product(productName).getQuantity();
        }
        int total_quantity = new_quantity + last_quantity;
        /*-----FOR Expired Date------*/
        if (vaildate_ExpiredDate(obj, date)) {
            NewExpiredDate = date;
        } else {
            NewExpiredDate = obj.getExpired_date();
        }
        Products_Operations.Edit_Product(productName, Price, NewExpiredDate, total_quantity);
        /*-----------------------------------*/

        JOptionPane.showMessageDialog(null, "Data is updated", "Message", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public boolean vaildate_ExpiredDate(Products_Model old_Product, String newDate) {
        boolean vaild = false;
        String old_date = old_Product.getExpired_date();
        StringTokenizer old = new StringTokenizer(old_date, "/");
        StringTokenizer New = new StringTokenizer(newDate, "/");
        int DayOld = Integer.parseInt(old.nextToken());
        int MonthOld = Integer.parseInt(old.nextToken());
        int YearOld = Integer.parseInt(old.nextToken());
        int DayNew = Integer.parseInt(New.nextToken());
        int MonthNew = Integer.parseInt(New.nextToken());
        int YearNew = Integer.parseInt(New.nextToken());
        if (YearNew > YearOld) // Expired
        {
            vaild = true;
        } else if (YearNew == YearOld) {
            if (MonthNew > MonthOld) {
                vaild = true;
            } else if (MonthNew == MonthOld) {
                if (DayNew >= DayOld) {
                    vaild = true;
                }
            }
        }
        return vaild;
    }
}
