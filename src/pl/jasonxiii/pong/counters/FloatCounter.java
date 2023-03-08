package pl.jasonxiii.pong.counters;

public class FloatCounter extends Counter<Float> {
	public FloatCounter() {
		this(0f);
	}

	public FloatCounter(Float value) {
		super(value);
	}

	@Override
	public final void increaseBy(Float n) {
		value += n;
	}

	@Override
	public final void decreaseBy(Float n) {
		value -= n;
	}

	@Override
	public final boolean isLessThanOrEqualTo(Float n) {
		return value <= n;
	}

	@Override
	public final boolean isGreaterThanOrEqualTo(Float n) {
		return value >= n;
	}
}