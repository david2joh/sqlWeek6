import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return (a+b);
		} else throw new IllegalArgumentException("Both Parameters must be Positive ! ");
	}
	
	public int randomNumberSquared() {
		int ran = 0;
		ran = getRandomInt();
		return (ran*ran);
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10)+1;
	}
}
