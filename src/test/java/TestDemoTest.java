import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

class TestDemoTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void testassertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if(!expectException) {
			org.assertj.core.api.Assertions.assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			org.assertj.core.api.Assertions.assertThatThrownBy(()->{testDemo.addPositive(a, b);})
			.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	public static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				Arguments.of(2,3,5,false),
				Arguments.of(2,-1,1,true),
				Arguments.of(-12,1,-11,true),
				Arguments.of(-2,-21,1,true)
				);
	}
	

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = Mockito.spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		org.assertj.core.api.Assertions.assertThat(fiveSquared).isEqualTo(25);
	}
	
}

	
