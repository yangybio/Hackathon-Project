package gui.tool;

import gui.tool.dataRequire.OverallResult;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;

public class DetailEvent extends EventObject {
    OverallResult overallResult;
    String ss;
    ArrayList<Date> days;

    public DetailEvent(Object source, OverallResult overallResult,String s,String day) throws ParseException {
        super(source);
        this.overallResult = overallResult;
        ss = s;
        days = overallResult.getDateRange(day);
    }

    public String getData() {
        System.out.println("reach hear get data");
        String result1 = "Wuhan:        " + overallResult.collectRegionalData("Wuhan",ss,days);
        String result2 = "SouthWest:    " + overallResult.collectRegionalData("SouthWest",ss,days);
        String result3 = "SouthEast:    " + overallResult.collectRegionalData("SouthEast",ss,days);
        String result4 = "NorthWest:    " + overallResult.collectRegionalData("NorthWest",ss,days);
        String result5 = "NorthEast:    " + overallResult.collectRegionalData("NorthEast",ss,days);
        return result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5;
    }

    public void getItemList(){
        //stub
    }
}
