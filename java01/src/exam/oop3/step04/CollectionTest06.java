package exam.oop3.step04;

import java.util.Stack;

/* Collection API 
 * - 값 목록을 다루는 객체
 * 
 * Stack
 *  - 데이터 목록을 다루는 것.
 *  - 먼저 들어간 데이터가 나중에 나온다.(First in Last out)
 *  - push() / pop()
 */
public class CollectionTest06 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("111");
		stack.push("222");
		stack.push("333");
		stack.push("444");
		
		System.out.println("-----------------------");
		for(String value : stack){			
			System.out.println(value);
		}
		//peek() => 스택에서 맨위의 값을 꺼낸다. 단 삭제하지않는다
		System.out.println("-----------------------");
		for(int i=0; i<stack.size(); i++){
			while(!stack.empty()){
				System.out.println(stack.peek());
			}
		}
		
		//pop() => 스택에서 맨 위의 값을 꺼낸다. 단 꺼낸값은 그택에서 삭제한다.
		System.out.println("-----------------------");
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
		
		//위에서 삭제했기 때문에 스택에는 더이상 값이 없다.
		System.out.println("-----------------------");
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
	}
}











