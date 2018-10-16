package my.com.medisys.prac.sheets.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.com.medisys.prac.sheets.AreaRefBuilder;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class CellRefBuilderTest {
    
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(CellRefBuilderTest.class);

    @Before
    public void setUp() throws Exception {}

    @Test
    public void simpleRange() throws Exception {
        List<String> names = new ArrayList<>();
        AreaRefBuilder.cellAreaNames("C:F", "10:15").get(0).forEach((key, val)->names.add(val));
        Assert.assertArrayEquals(names.toArray(new String[names.size()]), new String[]{"C10", "D10", "E10", "F10"});
    }

    @Test
    public void complexRange() throws Exception {
        List<String> names = new ArrayList<>();
        AreaRefBuilder.cellAreaNames("A,C:F,K", "5,10:15,20").get(2).forEach((key, val)->names.add(val));
        Assert.assertArrayEquals(names.toArray(new String[names.size()]), new String[]{"A11", "C11", "D11", "E11", "F11", "K11"});
    }

    @Test
    public void moreComplexRange() throws Exception {
        List<String> names = new ArrayList<>();
        AreaRefBuilder.cellAreaNames("A,CD:CF,CK", "115,110:115,120").get(4).forEach((key, val)->names.add(val));
        Assert.assertArrayEquals(names.toArray(new String[names.size()]), new String[]{"A113", "CD113", "CE113", "CF113", "CK113"});
    }

}
