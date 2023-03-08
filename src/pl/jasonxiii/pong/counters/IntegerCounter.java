package pl.jasonxiii.pong.counters;

public class IntegerCounter extends Counter<Integer> {
	public IntegerCounter() {
		this(0);
	}

	public IntegerCounter(int value) {
		super(value);
	}

	@Override
	public final void increaseBy(Integer n) {
		value += n;
	}

	@Override
	public final void decreaseBy(Integer n) {
		value -= n;
	}

	@Override
	public final boolean isLessThanOrEqualTo(Integer n) {
		return value <= n;
	}

	@Override
	public final boolean isGreaterThanOrEqualTo(Integer n) {
		return value >= n;
	}
}