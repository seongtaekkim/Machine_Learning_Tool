package machinelearning.regressionMulti;


public class TrainData {
	private MakeData makeData = new MakeData();
	public TrainData() {
		MakeData data = new MakeData();
		MakeTheta theta = new MakeTheta(data.getX().get(0).length);
		
		LinearRegressionMulti lr = new LinearRegressionMulti(data.getX(),data.getY(), theta.getTheta());
//		System.out.println("cost : " + lr.costFuntion());
		Double[] h = lr.hypothesis();
		System.out.println(h[0] );
		System.out.println(h.length);
//		lr.gradientDecent();
	}
	
	public static void main(String[] args) {
		new TrainData();
		System.out.println("start");
		
	}
}
