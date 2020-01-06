package machinelearning.regression;

public interface LinearRegression {

	// h = X * theta
	public void hypothesis();
	// 1/2 * sum(h-y)^2
	public Long costFuntion();
	public void gradientDecent();
}
