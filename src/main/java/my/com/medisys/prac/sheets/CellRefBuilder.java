package my.com.medisys.prac.sheets;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class CellRefBuilder {

    public static CellReference getCellReference(String name) {
        return new CellReference(name);
    }

    public static String getCellNameByPosition(String column, int row) {
        return String.format("%s%d", column, row);
    }

    public static CellReference getCellReference(String column, int row) {
        String name = getCellNameByPosition(column, row);
        return getCellReference(name);
    }

    public static Cell getCellByPosition(Sheet sheet, String column, int row) {
        return getCellByReference(sheet, getCellReference(column, row));
    }

    public static Cell getCellByReference(Sheet sheet, String name) {
        return getCellByReference(sheet, getCellReference(name));
    }

    public static Cell getCellByReference(Sheet sheet, CellReference ref) {
        Row row = getRowByCellReference(sheet, ref);
        return row.getCell(ref.getCol());
    }

    private static Row getRowByCellReference(Sheet sheet, CellReference ref) {
        return sheet.getRow(ref.getRow());
    }

}
