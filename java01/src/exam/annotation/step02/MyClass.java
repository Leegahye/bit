package exam.annotation.step02;

/*기본사용*/
//배열값 설정 시 : 값을 한 개 줄때, 중괄호 생략 가능!
//@Component(value = "my1")

//배열값 설정 시 : 값을 한 개 줄때, 중괄호 생략 불가능!
//@Component(value={"my1","my2","my3"})

/* value 속성 값을 설정 할 때 속성명을 생략할 수 있다.*/
//@Component ("my1")
//@Component({"my1","my2","my3"})

/*두 개 이상의 속성을 설정 할 때는 value 이름 생략 불가!*/
//@Component("my1", url="url1") //오류!
@Component(value="my1", url="url1")
public class MyClass {

}
