package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.AccessException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameter;

class CalculatorTest {

	@Test
	//Anotation
	void testAdd() {
		Calculator calc = new Calculator();
		calc.add(5, 10);
		//functionality->actual result
	   //assertions->match is expected result, actual result
	  //asstEquals
		assertEquals(15, calc.add(5,10));
		}

	@Test
	void testSub() {
	   Calculator calc = new Calculator();
	   assertEquals(-5, calc.sub(5, 10));
	}
	
	@Test
	void testConditionT() {
		Calculator calc = new Calculator();
		assertTrue(calc.add(2,9)>0);// if result is positive
	}
	@Test
	void testConditionF() {
		Calculator calc = new Calculator();
		assertFalse(calc.sub(9,8)<0);// is result is positive
	}
	// assertNull
	// assertNotNull
	@Test
	void testNull() {
		Calculator calc = new Calculator();
		assertNull(calc.add(null,null));// is result is positive
	}
	@Test
	void testNotNull() {
		Calculator calc = new Calculator();
		assertNotNull(calc.add(2,8));// is result is positive
	}
	@ParameterizedTest
	@ValueSource(ints = {12,15,16,17})
	void testAddParam(int number) {
		Calculator calc = new Calculator();
		assertEquals(number+10, calc.add(number, 10));
	}
	@ParameterizedTest
	@CsvSource({
		"5,7,12",
		"3,6,9",
		"7,5,12",
		"8, 9, 17"
		
	})
	void testAddParamCsv(int a, int b , int expected) {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.add(a, b));
	}
	//Timeouts for Test
	//few tests -> too long to run -> infinite loop, performance issues,
	//assertTimeout, Junit 4 - Test -> timeout param
	//fail -> longer time
	@Test
	void testTimeout() {
		Calculator calc = new Calculator();
		assertTimeout(java.time.Duration.ofMillis(1),() -> {
			Thread.sleep(1500);
			calc.add(2,3);
			
		});
	}
	void testException() {
        Calculator calc = new Calculator();
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calc.div(12, 0);
        });
	}

}
