package machinelearning.regressionMulti;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class MakeData {

	private List<Double[]> X = new ArrayList<Double[]>();
	private List<Double> Y = new ArrayList<Double>();

	public MakeData() {
		ClassPathResource resource = new ClassPathResource("\\data\\ex1data2.txt");
		try {
			Path path = Paths.get(resource.getURI());
			List<String> content = Files.readAllLines(path);
			String[] tmpStr ;
			for(int i=0 ; i<content.size() ; i++) {
				tmpStr = content.get(i).split(",");
				Double[] tmpFeature = new Double[tmpStr.length-1]; 
				for(int j=0; j<tmpStr.length-2 ; j++) {
					tmpFeature[j] = Double.parseDouble(tmpStr[j]);
				}
				X.add(tmpFeature);
				Y.add(Double.parseDouble(tmpStr[tmpStr.length-1]));
			}
			System.out.println("X size is "+X.size());
			System.out.println("Y size is "+Y.size());
		} catch (IOException e) {
			System.out.println(e);
		}
	}	
	public List<Double[]> getX() {
		return X;
	}

	public void setX(List<Double[]> x) {
		X = x;
	}

	public List<Double> getY() {
		return Y;
	}

	public void setY(List<Double> y) {
		Y = y;
	}
}
