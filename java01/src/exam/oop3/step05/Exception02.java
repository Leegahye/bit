package exam.oop3.step05;
/*
 * 예외처리
 *  - 오류가 발생했을 때 시스템의 실행을 멈추지 않게하는 문법
 *  - 즉, 오류가 발생하면 적적한 조치를 취한 후 계속 실행하게 한다. 
 */
public class Exception02 {
	
	//after 예외처리
	// - 오류에 대한 정보를 값 객체에 담아서 호출자에게 던진다.
	//    Throwable 객체에 오류 정보를 담는다.
	// - 메서드 선언부에 어떤 예외를 던지는지 표시한다.
	
	public static int divide(int a, int b)throws Throwable{
		if(b == 0)
			throw new Throwable("0으로 나누지 마세요.");
		return a/b;
	}

	public static void main(String[] args) {
		//try..catch블록
		// - 정상코드와 예외처리코드를 분리하여 코드를 읽기 쉽게 한다.
		// - 리턴 값을 검사하지 않기 때문에 정상적인 값을 잘못 처리할 가능성이 없다.
		
		try{
			//예외가 발생할 수 있는 메서드 호출은 try블록에 둔다.
			int result = divide(999999,0);
		
			//항상 메서드의 리턴값을 조사해야만 했다.
			System.out.println(result);			
		}catch(Throwable e){
		 //예외가 발생했을 때 처리하는 코드를 둔다.
			System.out.println(e.getMessage());
		}
	}

}
