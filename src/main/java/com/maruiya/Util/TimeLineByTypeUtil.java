package com.maruiya.Util;


import com.maruiya.pojo.TimeLine;

import java.util.*;

/**
 * @Author MaRuiYa
 * @Date 2020/8/3 12:59
 */
public class TimeLineByTypeUtil {
    public static HashMap<String, ArrayList<TimeLine>> getTimeLineByType(List<TimeLine> timeLines){
        HashMap<String, ArrayList<TimeLine>> stringTimeHashMap = new HashMap<>();
        Calendar c = Calendar.getInstance();
        for (TimeLine timeLine : timeLines) {
            c.setTime(timeLine.getTime());
            if (stringTimeHashMap.get(String.valueOf(c.get(Calendar.YEAR))) == null){
                stringTimeHashMap.put(String.valueOf(c.get(Calendar.YEAR)), new ArrayList<TimeLine>());
            }
            stringTimeHashMap.get(String.valueOf(c.get(Calendar.YEAR))).add(timeLine);
        }
        Object[] objects = stringTimeHashMap.keySet().toArray();
        Arrays.sort(objects, Collections.reverseOrder());

        LinkedHashMap<String, ArrayList<TimeLine>> linkedHashMap = new LinkedHashMap<>();
        for (Object object : objects) {
            linkedHashMap.put((String) object, stringTimeHashMap.get((String) object));
        }
        return linkedHashMap;
    }
}
