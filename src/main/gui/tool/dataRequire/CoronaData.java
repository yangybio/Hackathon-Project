package gui.tool.dataRequire;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CoronaData {
    public Map<String, Map> serialData;
    public Map<String, ArrayList> regionalData;

    public OverallResult overallResult;


    public CoronaData(OverallResult overall) {
        this.regionalData = new HashMap<>();
        this.serialData = new HashMap<>();

        this.overallResult = overall;

        ArrayList NElist = new ArrayList();
        ArrayList NWlist = new ArrayList();
        ArrayList SElist = new ArrayList();
        ArrayList SWlist = new ArrayList();


        this.regionalData.put("NorthEast", NElist);
        this.regionalData.put("NorthWest", NWlist);
        this.regionalData.put("SouthEast", SElist);
        this.regionalData.put("SouthWest", SWlist);

        HashMap<String, Integer> fieldPair = new HashMap();

        fieldPair.put("Confirmed", 0);
        fieldPair.put("Death", 0);
        fieldPair.put("Cured", 0);
        fieldPair.put("Suspected", 0);
    }

//    public int collectRegionalData(String region, String criteria, ArrayList<Date> date) {
//        int headCount = 0;
//        if (region == "Wuhan") {
//            headCount += overallResult.filter("湖北省", criteria, date);
//
//        } else if (region == "NorthEast") {
//            headCount += overallResult.filter("北京市", criteria, date);
//            headCount += overallResult.filter("河北省", criteria, date);
//            headCount += overallResult.filter("天津市", criteria, date);
//            headCount += overallResult.filter("陕西省", criteria, date);
//
//        } else if (region == "NorthWest") {
//            headCount += overallResult.filter("甘肃省", criteria, date);
//            headCount += overallResult.filter("宁夏回族自治区", criteria, date);
//            headCount += overallResult.filter("青海省", criteria, date);
//
//        } else if (region == "SouthEast") {
//            headCount += overallResult.filter("重庆市", criteria, date);
//            headCount += overallResult.filter("广西壮族自治区", criteria, date);
//            headCount += overallResult.filter("湖南省", criteria, date);
//            headCount += overallResult.filter("安徽省", criteria, date);
//            headCount += overallResult.filter("江苏省", criteria, date);
//            headCount += overallResult.filter("上海市", criteria, date);
//            headCount += overallResult.filter("浙江省", criteria, date);
//            headCount += overallResult.filter("江西省", criteria, date);
//            headCount += overallResult.filter("福建省", criteria, date);
//            headCount += overallResult.filter("广东省", criteria, date);
//            headCount += overallResult.filter("香港", criteria, date);
//            headCount += overallResult.filter("澳门", criteria, date);
//            headCount += overallResult.filter("海南省", criteria, date);
//
//        } else if (region == "SouthWest") {
//            headCount += overallResult.filter("西藏自治区", criteria, date);
//            headCount += overallResult.filter("四川省", criteria, date);
//            headCount += overallResult.filter("云贵省", criteria, date);
//
//        }
//        return headCount;
//    }
}
