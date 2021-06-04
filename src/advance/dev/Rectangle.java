package advance.dev;

public class Rectangle extends Shape {
	double chieuDai, chieuRong;
	
	

	public Rectangle(String name, double chieuDai, double chieuRong) {
		super(name);
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	double chuVi() {
		// TODO Auto-generated method stub
		return 2 * (chieuDai + chieuRong);
	}

	@Override
	double dienTich() {
		// TODO Auto-generated method stub
		return chieuDai * chieuRong;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Hinh chu nhat: %s, do dai 2 canh %f %f", name,chieuDai,chieuRong);
	}

}
