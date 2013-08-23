package models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PrintOne  {
	
    @Id
    @GeneratedValue
    public long id;
   // @Required
    public String year;
    //@Required
    public String make;
    public String model;
   // @Required
    public String vin;
    public String miles;
   // @Required
    public String equipment;
   // @Required
    public String downpayment;
   // @Required
    public String youpay;
   // @Required

}
