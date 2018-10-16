package my.com.medisys.prac.sheets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class AreaRefBuilder {

    public static List<Map<String, String>> cellAreaNames(String colArea, String rowArea){
        String[] columns = AreaBuilder.parseColumnArea(colArea);
        Integer[] rows = AreaBuilder.parseRowArea(rowArea);
        List<Map<String, String>> matrix = new ArrayList<>();

        for(Integer row : rows) {
            Map<String, String> record = new TreeMap<>();
            for(String column : columns) {
                String name = CellRefBuilder.getCellNameByPosition(column, row);
                record.put(column, name);
            }
            matrix.add(record);
        }
        return matrix;
    }

    public static List<Map<String, CellReference>> cellAreaRefs (String colArea, String rowArea){
        List<Map<String, String>> rows = cellAreaNames(colArea, rowArea);
        List<Map<String, CellReference>> matrix = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);
            Map<String, CellReference> record = new TreeMap<>();
            row.forEach((key, name) -> record.put(key, CellRefBuilder.getCellReference(name)));
            matrix.add(record);
        }
        return matrix;
    }

    public static List<Map<String, Cell>> cellArea (Sheet sheet, String colArea, String rowArea){
        List<Map<String, CellReference>> rows = cellAreaRefs(colArea, rowArea);
        List<Map<String, Cell>> matrix = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            Map<String, CellReference> row = rows.get(i);
            Map<String, Cell> record = new TreeMap<>();
            row.forEach((key, ref) -> record.put(key, CellRefBuilder.getCellByReference(sheet, ref)));
            matrix.add(record);
        }
        return matrix;
    }

}
