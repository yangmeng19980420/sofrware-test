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
	{ //�ѱ�׼���������ByteArrayOutputStream�� 
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
		System.setOut(new PrintStream(outContent)); 
		
		//ִ��Ҫ���Եĳ��� 
		homework3.printPrimes(4);
		//�Կ���̨���������ƥ�����
		assertThat(outContent.toString(), containsString("Prime: 2")); 
		assertThat(outContent.toString(), containsString("Prime: 3"));
		assertThat(outContent.toString(), containsString("Prime: 5"));
		assertThat(outContent.toString(), containsString("Prime: 7")); 
		homework3.printPrimes(5);
		} 
	}


