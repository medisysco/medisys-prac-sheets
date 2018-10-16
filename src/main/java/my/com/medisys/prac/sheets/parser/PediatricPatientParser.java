package my.com.medisys.prac.sheets.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import my.com.medisys.prac.sheets.CellAreaBuilder;
import my.com.medisys.prac.sheets.model.PediatricPatient;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class PediatricPatientParser {

    public static final String PEDIATRIC_PAT_COLS = "C:R";
    public static final String PEDIATRIC_PAT_ROWS = "10:31";

    public static enum Columns {
        C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R
    }

    /**
     * <ol>
     *   <li><b>C :</b> Family Name or Surname</li>
     *   <li><b>D :</b> Given Name or First Name</li>
     *   <li><b>E :</b> Given Name (2nd)</li>
     *   <li><b>F :</b> Mother Maiden Name</li>
     *   <li><b>G :</b> Date of Birth</li>
     *   <li><b>H :</b> Gender</li>
     *   <li><b>I :</b> Social Security Number</li>
     *   <li><b>J :</b> Address</li>
     *   <li><b>K :</b> City</li>
     *   <li><b>L :</b> State</li>
     *   <li><b>M :</b> Post Code</li>
     *   <li><b>N :</b> Phone</li>
     *   <li><b>O :</b> BirthOrder</li>
     *   <li><b>P :</b> Multiple Birth</li>
     *   <li><b>Q :</b> Last Update Source</li>
     *   <li><b>R :</b> Last Update Facility</li>
     * </ol>
     * @param sheet
     * @return
     */
    public static List<PediatricPatient> parse(Sheet sheet, String colArea, String rowArea){
        List<Map<String, Cell>> rows = CellAreaBuilder.cellArea(sheet, colArea, rowArea);
        List<PediatricPatient> patients = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            Map<String, Cell> row = rows.get(i);
            PediatricPatient patient = new PediatricPatient();
            patient.setFirstNameEn(row.get(Columns.D.name()).getStringCellValue());
            patient.setFamilyNameEn(row.get(Columns.C.name()).getStringCellValue());

            String motherName = row.get(Columns.F.name()).getStringCellValue();
            String[] names = motherName.split("\\^");
            patient.setMotherFirstNameEn(names[1]);
            patient.setMotherLastNameEn(names[0]);

            patient.setBirthDate(row.get(Columns.G.name()).getDateCellValue());
            patient.setGender(row.get(Columns.H.name()).getStringCellValue());
            patient.setSocialSecurityNumber((int) row.get(Columns.I.name()).getNumericCellValue());
            patient.setAddress(row.get(Columns.J.name()).getStringCellValue());
            patient.setCity(row.get(Columns.K.name()).getStringCellValue());
            patient.setState(row.get(Columns.L.name()).getStringCellValue());
            patient.setPostalCode((int) row.get(Columns.M.name()).getNumericCellValue());
            patient.setPhoneHome(row.get(Columns.N.name()).getStringCellValue());
            patient.setBirthOrder((int) row.get(Columns.O.name()).getNumericCellValue());
            patient.setMultiBirthFlag(row.get(Columns.P.name()).getStringCellValue());
            patient.setEntryDate(row.get(Columns.Q.name()).getDateCellValue());
            patient.setUpdateDate(row.get(Columns.Q.name()).getDateCellValue());
            patient.setUpdateFacility((int) row.get(Columns.R.name()).getNumericCellValue());
            //patient.setNamespaceId(namespaceId);
            //patient.setUniversalId(universalId);
            //patient.setUniversalIdType(universalIdType);
            patients.add(patient);
        }
        return patients;
    }

}
