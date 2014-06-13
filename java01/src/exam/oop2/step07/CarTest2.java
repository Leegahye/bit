package exam.oop2.step07;

public class CarTest2 {

	public static void main(String[] args) {
		Car car = new Car();
		Truck truck = new Truck();
		Suv suv = new Suv();
		
		Car[] cars = new Car[10];
		cars[0] = car;
		cars[1] = truck;
		cars[2] = suv;
	}
}
