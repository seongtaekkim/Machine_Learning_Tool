package MNISTTool;

import java.util.List;

import machinelearning.regression.LinearRegression;

public class LinearRegressionMNIST implements LinearRegression {
	
	private List<MNISTData> X;
	private MNISTTheta theta;
	public LinearRegressionMNIST(List<MNISTData> X , MNISTTheta theta) {
		this.X = X;
		this.theta = theta;
	}
	@Override
	public void hypothesis() {
		//h = X * theta  -> m * 1
		
	}
	@Override
	public Long costFuntion() {
		return null;
	}
	@Override
	public void gradientDecent() {
		
	}
}
