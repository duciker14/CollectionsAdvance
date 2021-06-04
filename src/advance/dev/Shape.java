package advance.dev;

public abstract class Shape {
	String name;

	public Shape(String name) {
		super();
		this.name = name;
	}
	abstract double chuVi();
	abstract double dienTich();
}
