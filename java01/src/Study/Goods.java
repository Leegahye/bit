package Study;

import java.util.Scanner;

public class Goods {
	private String name;
	private int price;
	private int numberOfStock;
	private int sold;
	
	Goods(){
		
	}
	Goods(String name, int price, int numberOfStock, int sold){
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = sold;
	}
	String getName(){
		return name;
	}
	int getPrice(){
		return price;
	}
	int getNumverOfStock(){
		return numberOfStock;
	}
	int getSold(){
		return sold;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Goods[] good = new Goods[3];
		Goods g; 
		for(int i=0; i<good.length; i++){
			g = new Goods();
			System.out.print("이름?");
			g.name = sc.nextLine();
			System.out.print("가격?");
			g.price = Integer.parseInt(sc.nextLine());
			System.out.print("재고수량?");
			g.numberOfStock = Integer.parseInt(sc.nextLine());
			System.out.print("팔린수량?");
			g.sold = Integer.parseInt(sc.nextLine());
			
			good[i] = new Goods(g.name,g.price,g.numberOfStock,g.sold);
		}
		for(int i=0; i<good.length; i++){
			System.out.println(good[i].getName()+","+good[i].getPrice()+","
												+good[i].getNumverOfStock()+","+good[i].getSold());

		}
	}
	/*public static void main(String[] args) {
		
		Goods camera = new Goods();
		camera.name = "Nikon";
		camera.price = 400000;
		camera.numberOfStock = 30;
		camera.sold = 50;
		
		System.out.println("상품이름 : "+camera.name);
		System.out.println("값 : "+camera.price);
		System.out.println("재고 개수 : "+camera.numberOfStock);
		System.out.println("팔린 개수 : "+camera.sold);

	}*/

}

/*public class MyExp{
	private int base;
	private int exp;
	
	int getValue(){
		
		int result = 1;
		for(int i=0; i<exp; i++){
			result = result*base;
		}
		return result;
	}
	public static void main(String[] args) {
		MyExp m = new MyExp();
		m.base = 3;
		m.exp = 3;
		System.out.println(m.base+"의"+m.exp+"승?"+m.getValue());
  }
	
}
*/