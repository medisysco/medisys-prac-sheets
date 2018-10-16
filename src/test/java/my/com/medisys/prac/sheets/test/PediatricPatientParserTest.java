package my.com.medisys.prac.sheets.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import my.com.medisys.prac.sheets.model.PediatricPatient;
import my.com.medisys.prac.sheets.parser.PediatricPatientParser;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class PediatricPatientParserTest {

    private static final Logger log = LoggerFactory.getLogger(PediatricPatientParserTest.class);
    public static final String PAT_COLS = PediatricPatientParser.PEDIATRIC_PAT_COLS; //"C:R";
    public static final String PAT_ROWS = PediatricPatientParser.PEDIATRIC_PAT_ROWS; //"10:31";

    private File excel = null;
    private Sheet sheet = null;

    @Before
    public void setUp() throws Exception {
        try {
            Resource resource = new ClassPathResource("application.properties");
            Properties prop = PropertiesLoaderUtils.loadProperties(resource);
            String path = (String) prop.get("medisys.prac.pediatric.patients");
            if(StringUtils.startsWithIgnoreCase(path, "classpath:")) {
                resource = new ClassPathResource(path.replaceAll("classpath:", ""));
                Workbook workbook = WorkbookFactory.create((excel=resource.getFile()));
                sheet = workbook.getSheet("TwinData");
            }
        } catch(IOException e) {}
    }

    @Test
    public void hasExcel() throws Exception {
        Assert.assertNotNull(excel);
        Assert.assertEquals(excel.exists(), true);
        Assert.assertNotNull(sheet);
    }

    @Test
    public void readPatient() throws Exception {
        List<PediatricPatient> patients = PediatricPatientParser.parse(sheet, PAT_COLS, PAT_ROWS);
        for(PediatricPatient pat : patients) {
            log.info("Name: {} {}", pat.getFirstNameEn(), pat.getFamilyNameEn());
        }
    }

}
