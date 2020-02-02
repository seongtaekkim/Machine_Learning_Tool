package machinelearning.regressionMulti;

import java.util.List;

import machinelearning.regression.LinearRegression;

/**
 * 
 * @author kim
 * input : [m * 1]
 * theta : [1 * 1]
 * output : [m * 1]
 * 단변량 Linear Regression 학습구현.
 *
 */
public class LinearRegressionMulti implements LinearRegression {

	private List<Double> X; 
	private List<Double> Y;
	private Double[] theta;
	
	public LinearRegressionMulti(List<Double> X ,List<Double> Y, Double[] theta) {
		this.X = X;
		this.Y = Y;
		this.theta = theta;
	}
	@Override
	public Double[] hypothesis() {
		//h = X * theta  -> m * 1
		Double[] h = new Double[X.size()];
		for(int i=0 ; i<X.size() ; i++) {
			h[i] = theta[0] * 1.0 + theta[1] * X.get(i);
		}
		return h;
	}
	@Override
	public Double costFuntion() {
		Double[] h = null;
		Double cost = 0.0;
		h = hypothesis();
		for(int i=0; i<X.size() ; i++) {
			cost += (h[i] - Y.get(i)) *(h[i] - Y.get(i));
		}
		cost = cost/X.size();
		cost = cost/2;
		
		return cost;
	}
	@Override
	public void gradientDecent() { 
		Double[] error = {0.0, 0.0};
		Double[] h = null;	
		
		for(int i=0 ; i<50 ; i++) {
			h = hypothesis();
			error[0] = 0.0;
			error[1] = 0.0;
			
			for(int j=0; j<X.size() ; j++) {
				error[0] += (h[j] - Y.get(j));
				error[1] += (h[j] - Y.get(j))* X.get(j);
			}
			
			theta[0] = theta[0] - 0.01/X.size() * error[0];
			theta[1] = theta[1] - 0.01/X.size() * error[1];
			System.out.println("cost : " + costFuntion());
		}
		System.out.println(theta[0]*1  + theta[1]*3.5);
	}
	
}
