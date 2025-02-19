import java.util.function.Function;
import java.util.stream.*;

class Solution {
	public long solution(int r1, int r2) {
		return LongStream.rangeClosed(1, r2)
						 .map(y -> calculate(r2, y, Math::floor) - calculate(r1, y, Math::ceil) + 1
						 ).sum() * 4;
	}

	private long calculate(int r2, long y, Function<Double, Double> operator) {
		return operator.apply(Math.sqrt((long)r2 * r2 - y * y)).longValue();
	}
}
