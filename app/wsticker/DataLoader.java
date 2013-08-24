package wsticker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Inventory;

import play.db.jpa.*;

/**
 * @author: Rick Chen
 * Date: 8/19/13
 * Time: 1:33 PM
 */
public class DataLoader {

    static final String TRANSMISSION = "transmission";
    static final String MAKE = "make";
    static final String MODEL = "model";
    static final String OPTIONS = "options";
    static final String VCLASS = "Class";
    static final String VIN = "vin";
    static final String DEALER_ID = "dealer_id";
    static final String COLOR = "color";
    static final String ENGINE = "engine";
    static final String LOCATION = "location";
    static final String STOCK = "stock";
    static final String YEAR = "year";
    static final String MILEAGE = "mileage";
    static final String RETAILPRICE = "retailprice";
    static final String BODYTYPE = "bodytype";

    public static void load() {
        //String csvFile = "I:\\WorkExt\\clalleyvw\\docs\\Inventory.txt";
        String csvFile = "C:\\Users\\calley\\Documents\\FromRick\\Inventory.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            List<Map<String, String>> inventoryList  = new ArrayList< Map<String, String>>();
            List<String> keys = new ArrayList<String>();
            //String[] keysArr = null;
            br = new BufferedReader(new FileReader(csvFile));
            if(null != (line = br.readLine())) {
                String[] keysArr = line.split(cvsSplitBy);
                for(String t: keysArr) {
                    System.out.println(t.replaceAll("\"", ""));
                    keys.add(t.replaceAll("\"", ""));
                }
            }

            line = null;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] values = line.split(cvsSplitBy);
                Map<String, String> row = new HashMap<String, String>();
                for(int i =0, len = keys.size(); i < len; i ++) {
                    row.put(keys.get(i), values[i].replaceAll("\"", ""));
                }
                inventoryList.add(row);
            }


            for (Map<String, String> row: inventoryList) {
                Inventory inv = new Inventory();
                System.out.println("rich: " + row);
                inv.bodytype = row.get(BODYTYPE);
                inv.color = row.get(COLOR);
                inv.dealerId = row.get(DEALER_ID);


                //inv.downpayment = row.get(PAY)

                inv.engine = row.get(ENGINE);
                //inv.equipment = row.get(EQUIP)
                inv.location = row.get(LOCATION);
                inv.make = row.get(MAKE);
                inv.mileage = row.get(MILEAGE);
                inv.model = row.get(MODEL);
                inv.options = row.get(OPTIONS);
                inv.retailprice = row.get(RETAILPRICE);
                inv.stock = row.get(STOCK);
                inv.transmission = row.get(TRANSMISSION);
                inv.vclass = row.get(VCLASS);
                inv.vin = row.get(VIN);
                inv.year = row.get(YEAR);

                //inv.youpay = row.get(PAY)
                System.out.println(inv);
                JPA.em().persist(inv);

            }


        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");


    }
}
