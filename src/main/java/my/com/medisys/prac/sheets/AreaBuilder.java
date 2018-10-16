package my.com.medisys.prac.sheets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class AreaBuilder {

    public static String[] parseColumnArea(String area) {
        List<String> list = new ArrayList<>();
        String [] columns = area.split(",");
        for(String column : columns) {
            if(column.contains(":")) {
                String ranges[] = column.split(":");
                if(ranges != null && ranges.length == 2) {
                    int ini = ColumnBuilder.nameToNumber(ranges[0]);
                    int end = ColumnBuilder.nameToNumber(ranges[1]);
                    for(;ini<=end;ini++) {
                        list.add(ColumnBuilder.numberToName(ini));
                    }
                }
            } else {
                list.add(column);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static Integer[] parseRowArea(String area) {
        List<Integer> list = new ArrayList<>();
        String [] rows = area.split(",");
        for(String row : rows) {
            if(row.contains(":")) {
                String ranges[] = row.split(":");
                if(ranges != null && ranges.length == 2) {
                    int ini = Integer.parseInt(ranges[0]);
                    int end = Integer.parseInt(ranges[1]);
                    for(;ini<=end;ini++) {
                        list.add(ini);
                    }
                }
            } else {
                list.add(Integer.parseInt(row));
            }
        }
        return list.toArray(new Integer[list.size()]);
    }

}
