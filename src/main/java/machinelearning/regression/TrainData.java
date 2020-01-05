package machinelearning.regression;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class TrainData {
	private MakeData makeData = new MakeData();
	public TrainData() {
		System.out.println( makeData.getX().get(0)[0]);
	}
	
	
	public static void main(String[] args) {
		new TrainData();
	}
}
