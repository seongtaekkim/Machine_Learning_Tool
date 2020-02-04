package machinelearning.regressionMulti;


public class MakeTheta {
	private Double[] theta; 
	private static int biasSize = 1;
	public MakeTheta(int nodeSize) {
		theta = new Double[nodeSize+biasSize];
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
