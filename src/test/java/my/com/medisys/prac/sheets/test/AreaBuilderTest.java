package my.com.medisys.prac.sheets.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.com.medisys.prac.sheets.AreaBuilder;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
public class AreaBuilderTest {
    
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(AreaBuilderTest.class);

    @Before
    public void setUp() throws Exception {}

    @Test
    public void simpleRange() throws Exception {
        Assert.assertArrayEquals(AreaBuilder.parseColumnArea("C:F"), new String[]{"C", "D", "E", "F"});
        Assert.assertArrayEquals(AreaBuilder.parseRowArea("10:15"), new Integer[]{10, 11, 12, 13, 14, 15});
    }

    @Test
    public void complexRange() throws Exception {
        Assert.assertArrayEquals(AreaBuilder.parseColumnArea("A,C:F,K"), new String[]{"A", "C", "D", "E", "F", "K"});
        Assert.assertArrayEquals(AreaBuilder.parseRowArea("5,10:15,20"), new Integer[]{5, 10, 11, 12, 13, 14, 15, 20});
    }

    @Test
    public void moreComplexRange() throws Exception {
        Assert.assertArrayEquals(AreaBuilder.parseColumnArea("A,CD:CF,CK"), new String[]{"A", "CD", "CE", "CF", "CK"});
        Assert.assertArrayEquals(AreaBuilder.parseRowArea("115,110:115,120"), new Integer[]{115, 110, 111, 112, 113, 114, 115, 120});
    }

}
