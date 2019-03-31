package st;
import org.junit.Test; 
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
public class testhomework3{ 
	homework3 tes = new homework3();
	@Test 
	public void testOneParagraph () 
	{ //把标准输出定向至ByteArrayOutputStream中 
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		
		//执行要测试的程序 
		homework3.printPrimes(4);
		//对控制台的输出进行匹配断言
		assertThat(outContent.toString(), containsString("Prime: 2")); 
		assertThat(outContent.toString(), containsString("Prime: 3"));
		assertThat(outContent.toString(), containsString("Prime: 5"));
		assertThat(outContent.toString(), containsString("Prime: 7")); 
		homework3.printPrimes(5);
		} 
	}


