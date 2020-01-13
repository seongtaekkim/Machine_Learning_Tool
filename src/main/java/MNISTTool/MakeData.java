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

public class MakeData {

	private List<Long[]> X = new ArrayList<Long[]>();
	private List<Long> Y = new ArrayList<Long>();

	public MakeData() {
		ClassPathResource resource = new ClassPathResource("\\data\\ex1data1.txt");

		try {
			Path path = Paths.get(resource.getURI());
			List<String> content = Files.readAllLines(path);
			content.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e);
		}
	}	
	public List<Long[]> getX() {
		return X;
	}

	public void setX(List<Long[]> x) {
		X = x;
	}

	public List<Long> getY() {
		return Y;
	}

	public void setY(List<Long> y) {
		Y = y;
	}

}
