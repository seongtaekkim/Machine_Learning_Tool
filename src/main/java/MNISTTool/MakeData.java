package MNISTTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import oracle.jrockit.jfr.parser.Parser;

public class MakeData {

	private List<Double> X = new ArrayList<Double>();
	private List<Double> Y = new ArrayList<Double>();

	public MakeData() {
		ClassPathResource resource = new ClassPathResource("\\data\\ex1data1.txt");
		try {
			Path path = Paths.get(resource.getURI());
			List<String> content = Files.readAllLines(path);
			String[] tmpStr = new String[2];
			for(int i=0 ; i<content.size() ; i++) {
				tmpStr = content.get(i).split(",");
				X.add(Double.parseDouble(tmpStr[0]));
				Y.add(Double.parseDouble(tmpStr[1]));
			}
			System.out.println("X size is "+X.size());
			System.out.println("Y size is "+Y.size());
		} catch (IOException e) {
			System.out.println(e);
		}
	}	
	public List<Double> getX() {
		return X;
	}

	public void setX(List<Double> x) {
		X = x;
	}

	public List<Double> getY() {
		return Y;
	}

	public void setY(List<Double> y) {
		Y = y;
	}

}
