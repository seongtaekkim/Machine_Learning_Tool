package machinelearning.regressionEx;


public class MakeTheta {
	private Double[] theta = new Double[2];
	public MakeTheta() {
		theta[0] = 1.0;
		theta[1] = 1.0;
	}
	public Double[] getTheta() {
		return theta;
	}
	public void setTheta(Double[] theta) {
		this.theta = theta;
	}
	
}
