package services;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilToSql implements Serializable {

    public static java.sql.Date convert(java.util.Date fecha) {
        java.sql.Date sDate = new java.sql.Date(fecha.getTime());
        return sDate;                
    }   
    
}

