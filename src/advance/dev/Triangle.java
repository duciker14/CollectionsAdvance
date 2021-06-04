package advance.dev;

public class Triangle extends Shape {
	double a,b,c;
	

	public Triangle(String name, double a, double b, double c) {
		super(name);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return a + b +c;
	}

	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		double p = chuVi() /2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Hinh Tam giac: %s, do dai ba canh %s %s %s", name, a,b,c);
	}

}
