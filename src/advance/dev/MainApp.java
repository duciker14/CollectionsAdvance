package advance.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class MainApp {
	static List<Shape> readFromFile(String fileName) throws Exception{
		List<Shape> arrList  = new LinkedList<Shape>();
		
		FileInputStream fts = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fts));
		String strLine;
		
		while((strLine = br.readLine()) != null) {
			if(strLine.indexOf("#rec") == 0){
				String name = strLine.substring(1,strLine.length());
				double chieuDai = Double.parseDouble(br.readLine());
				double chieuRong = Double.parseDouble(br.readLine());
				Shape rec = new Rectangle(name,chieuDai, chieuRong);
				arrList.add(rec);
			}
			if(strLine.indexOf("#cir") == 0){
				String name = strLine.substring(1,strLine.length());
				double banKinh = Double.parseDouble(br.readLine());
				Shape cir = new Circle(name, banKinh);
				arrList.add(cir);
			}
			if(strLine.indexOf("#tri") == 0){
				String name = strLine.substring(1,strLine.length());
				double a = Double.parseDouble(br.readLine());
				double b = Double.parseDouble(br.readLine());
				double c = Double.parseDouble(br.readLine());
				Shape tri = new Triangle(name, a, b, c);
				arrList.add(tri);
			}
		}
		
		return arrList;
	}
	static void print(List<Shape> shapes) {
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext()) {
			Shape shape =  it.next();
			if (shape instanceof Circle) {
				Circle cir = (Circle) shape;
				System.out.println(cir.toString());
			}else if (shape instanceof Rectangle) {
				Rectangle rect = (Rectangle) shape;
				System.out.println(rect.toString());	
			}else {
				Triangle tg = (Triangle) shape;
				System.out.println(tg.toString());
			}
		}
	}
	
	static void findMaxAll(List<Shape> shapes) {
		Iterator<Shape> it = shapes.iterator();
		Shape preMax = shapes.get(0);
		while (it.hasNext()) {
			Shape shape = it.next();
			if (preMax.dienTich() < shape.dienTich()) {
				preMax = shape;
			}
		}
		if (preMax instanceof Circle) {
			System.out.printf("Hinh tron %s co dien tich lon nhat: %f\n",preMax.name, preMax.dienTich());
		}else if (preMax instanceof Rectangle) {
			System.out.printf("Hinh chu nhat %s co dien tich lon nhat: %f\n",preMax.name, preMax.dienTich());
		}else {
			System.out.printf("Hinh tam giac %s co dien tich lon nhat: %f\n",preMax.name, preMax.dienTich());
		}
	}
	
	static void findMax(List<Shape> shapes) {
		Iterator<Shape> it = shapes.iterator();
		
		Shape preMaxCircle = shapes.get(0);
		Shape preMaxRect = shapes.get(0);
		Shape preMaxTg = shapes.get(0);
		
		while (it.hasNext()) {
			Shape shape = it.next();
			if (shape instanceof Circle && shape.dienTich() > preMaxCircle.dienTich()) {
				preMaxCircle = shape;
			}else if (shape instanceof Rectangle && shape.dienTich() > preMaxRect.dienTich()) {
				preMaxRect = shape;
			}else if (shape.dienTich() > preMaxTg.dienTich()) {
				preMaxTg = shape;
			}
		}
		String strC = String.format("Hinh tron co dien tich lon nhat la: %s - %f", preMaxCircle.name,preMaxCircle.dienTich());
		String strR = String.format("Hinh chu nhat co dien tich lon nhat la: %s - %f", preMaxRect.name,preMaxRect.dienTich());
		String strT = String.format("Hinh tam giac co dien tich lon nhat la: %s - %f", preMaxTg.name,preMaxTg.dienTich());
		System.out.println(strC);
		System.out.println(strR);
		System.out.println(strT);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Shape> shapes = new ArrayList<Shape>();
		List<Shape> shapesLinked = new LinkedList<Shape>();
		
		try {
			//ArrayList
			shapes = readFromFile("input.txt");
			long begin = System.currentTimeMillis();
			System.out.println("==============");
			findMax(shapes);
			System.out.println("=============");
			findMaxAll(shapes);
			long end = System.currentTimeMillis();
			long timeArraylist = end - begin;
			//LinkedList
			shapes = readFromFile("input.txt");
			long beginLinked = System.currentTimeMillis();
			System.out.println("==============");
			findMax(shapes);
			System.out.println("=============");
			findMaxAll(shapes);
			long endLinked = System.currentTimeMillis();
			long timeLinked = endLinked - beginLinked;
			//Sosanh
			System.out.printf("Chay bang ArrayList ton: %d milis, Chay bang LinkedList ton: %d milis",timeArraylist,timeLinked);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
