package st;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testlab1 {
	@Test
    public void testAdd(){
    	lab1 tes = new lab1();
    	assertEquals(false,tes.triangle(84));
    	assertEquals(true,tes.triangle(83));
    	assertEquals(true,tes.triangle(0));
    }
}
