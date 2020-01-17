package MNISTTool;

import java.util.List;

import machinelearning.regression.LinearRegression;

public class LinearRegressionMNIST implements LinearRegression {
	
	private List<Double> X;
	private Double[] theta;
	
	public LinearRegressionMNIST(List<Double> X , Double[] theta) {
		this.X = X;
		this.theta = theta;
	}
	@Override
	public void hypothesis() {
		//h = X * theta  -> m * 1
		double h = 0.0;
		for(int i=0 ; i<X.size() ; i++) {
			h += theta[0] * 1 + theta[1] * X.get(i);
		}
		System.out.println("h : " + h);
	}
	@Override
	public Long costFuntion() {
		return null;
	}
	@Override
	public void gradientDecent() {
		
	}
}
