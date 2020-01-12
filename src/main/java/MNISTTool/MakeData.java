package MNISTTool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MakeData {

	private List<Long[]> X = new ArrayList<Long[]>();
	private List<Long> Y = new ArrayList<Long>();

	public MakeData() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder documentBuilder  = factory.newDocumentBuilder();
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("ex1data1.txt");
			int singleCh = 0;
			try {
				while((singleCh = is.read()) != -1){
					System.out.print((char)singleCh);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("is");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();

		}
			
		try{
			//파일 객체 생성

			File file = new File("\\data\\ex1data1.txt");


			
				//입력 스트림 생성
				FileReader filereader = new FileReader(file);
				int singleCh = 0;
				System.out.println("file : " + file.getName());
				while((singleCh = filereader.read()) != -1){
					System.out.print((char)singleCh);
				}
				filereader.close();
			}catch (FileNotFoundException e) {
				// TODO: handle exception
				System.out.println(e);
			}catch(IOException e){
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
