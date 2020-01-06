package MNISTTool;

import java.util.List;

import machinelearning.regression.LinearRegression;

public class LinearRegressionMNIST implements LinearRegression {
	
	private List<MNISTData> X;
	private Object theta;
	public LinearRegressionMNIST(List<MNISTData> X , Object theta) {
		this.X = X;
		this.theta = theta;
	}
	@Override
	public void hypothesis() {
	}
	@Override
	public Long costFuntion() {
		return null;
	}
	@Override
	public void gradientDecent() {
		
	}
}
