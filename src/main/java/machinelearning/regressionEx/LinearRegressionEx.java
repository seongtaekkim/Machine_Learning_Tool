package machinelearning.regressionEx;

import java.util.List;

import machinelearning.regression.LinearRegression;

public class LinearRegressionEx implements LinearRegression {

	private List<Double> X;
	private Double[] theta;
	
	public LinearRegressionEx(List<Double> X , Double[] theta) {
		this.X = X;
		this.theta = theta;
	}
	@Override
	public void hypothesis() {
		//h = X * theta  -> m * 1
		double h = 0.0;
		for(int i=0 ; i<X.size() ; i++) {
			System.out.println(X.get(i));
			h += theta[0] * 1.0 + theta[1] * X.get(i);
		}
		System.out.println("h : " + h);
	}
	@Override
	public Double costFuntion() {
		Double h = 0.0;
		for(int i=0 ; i<X.size() ; i++) {
			System.out.println(X.get(i));
			h += theta[0] * 1.0 + theta[1] * X.get(i);
		}
		h = h/X.size();
		h = h/2;
		System.out.println("h : " + h);
		
		return h;
	}
	@Override
	public void gradientDecent() {
		
	}
	
}
