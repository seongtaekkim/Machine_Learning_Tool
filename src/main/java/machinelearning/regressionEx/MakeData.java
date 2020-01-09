package machinelearning.regressionEx;

import java.util.ArrayList;
import java.util.List;

public class MakeData {

	private List<String[]> X = new ArrayList<String[]>();
	private List<Integer> Y = new ArrayList<Integer>();
	
	public List<String[]> getX() {
		return X;
	}

	public void setX(List<String[]> x) {
		X = x;
	}

	public List<Integer> getY() {
		return Y;
	}

	public void setY(List<Integer> y) {
		Y = y;
	}

	public MakeData() {
		/* 
		 * 합계가 100은 1 나머지는 0으로 데이터를 맞춤
		 */
		X.add(new String[]{"50","50"});	Y.add(1);
		X.add(new String[]{"60","40"});	Y.add(1);
		X.add(new String[]{"70","30"});	Y.add(1);
		X.add(new String[]{"80","20"});	Y.add(1);
		X.add(new String[]{"90","10"});	Y.add(1);
		X.add(new String[]{"100","0"});	Y.add(1);
		X.add(new String[]{"20","50"});	Y.add(0);
		X.add(new String[]{"30","50"});	Y.add(0);
		X.add(new String[]{"50","60"});	Y.add(0);
		X.add(new String[]{"50","90"});	Y.add(0);
	}
}
