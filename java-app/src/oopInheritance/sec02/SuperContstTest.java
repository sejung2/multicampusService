package oopInheritance.sec02;

class A{
	public A() {
		System.out.println("기본 생성자 A");
	}
	public A(int x) {
		System.out.println("매개변수 생성자 A : " + x);
	}
}

class B extends A{
	public B() {
		System.out.println("기본 생성자 B");
	}
	public B(int x) {
		System.out.println("매개변수 생성자 B : " + x);
	}
}

class C extends B{
	public C() {
		System.out.println("기본 생성자 C");
	}
	// 생성자 오버로딩
	public C(int x) {
		super(x); // B클래스의 매개변수가 있는 생성자 선택 - 명시적 생성자 호출 - 첫행에 기술해야 함. this()도 첫행에 기술함
		System.out.println("매개변수 생성자 C : " + x);
		// super(x); // 부모클래스 생성자가 먼저 호출되어야 함
	}
	
	public void tmp() {
		// super(x); // 일반 메서드에서는 사용 불가, 생성자 내에서만 사용 가능
	}
}

public class SuperContstTest {

	public static void main(String[] args) {
		// C클래스 인스턴스 생성
		//C c = new C(); // 명시적으로 부모 클래스 생성자 호출하지 않음, 매개벼수가 없는 기본 생성자가 자동 호출 됨
		
		// C클래스 인스턴스 생성 - 매개변수가 있는 생성자 매서드 사용
		C c1 = new C(5);
	}

}
