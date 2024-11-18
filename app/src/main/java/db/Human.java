package db;

import org.jetbrains.annotations.Contract;

public class Human {


    private String Id;
    public String getId() {return Id;}
    public void setId(String newProperty){Id = newProperty;}

    private String Date;
    public String getDate() {return Date;}
    public void setDate(String newProperty){Date = newProperty;}

    private String Full_name;
    public String getFull_name() {return Full_name;}
    public void setFull_name(String newProperty){Full_name = newProperty;}
}
