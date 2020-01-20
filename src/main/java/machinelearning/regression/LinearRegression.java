package machinelearning.regression;

public interface LinearRegression {

	// h = X * theta
	public Double[] hypothesis();
	// 1/2 * sum(h-y)^2
	public Double costFuntion();
	public void gradientDecent();
}
