package be.bbconsulting.postal;

import be.bbconsulting.postal.calculation.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostalApplicationTests {

	@Autowired
	private Calculator calculator;

	@Test
	public void contextLoads() {
	}

	@Test
	public void publishMessage(){
		calculator.publishEvent();
	}

}
