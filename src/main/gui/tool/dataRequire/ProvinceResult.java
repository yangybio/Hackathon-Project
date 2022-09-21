package gui.tool.dataRequire;

import java.util.ArrayList;
import java.util.Date;

public class ProvinceResult {

    public String provinceName;
    public int confirmedCount;
    public int suspectedCount;
    public int deadCount;
    public int curedCount;
    // public ArrayList<CityResult> cities;
    public String country;
    public long updateTime;


    public boolean inTimeRange(ArrayList<Date> dateRange) {
        Date curr = new Date(updateTime);
        return curr.before(dateRange.get(1)) && curr.after(dateRange.get(0));
    }
}
