package machinelearning.regressionEx;


public class TrainData {
	private MakeData makeData = new MakeData();
	public TrainData() {
		MakeData data = new MakeData();
		MakeTheta theta = new MakeTheta();
		
		LinearRegressionEx lr = new LinearRegressionEx(data.getX(),data.getY(), theta.getTheta());
		System.out.println("cost : " + lr.costFuntion());
		lr.hypothesis();
		lr.gradientDecent();
	}
	
	public static void main(String[] args) {
		new TrainData();
		System.out.println("start");
		
	}
}
