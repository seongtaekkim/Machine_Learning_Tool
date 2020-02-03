package machinelearning.regressionMulti;


public class MakeTheta {
	private Double[] theta; 
	
	public MakeTheta(int nodeSize) {
		theta = new Double[nodeSize];
		setTheta(theta);
	}
	public Double[] getTheta() {
		return theta;
	}
	public void setTheta(Double[] theta) {
		for(int i=0 ; i<theta.length ; i++) {
			theta[i] = 0.0;
		}
	}
	
}
