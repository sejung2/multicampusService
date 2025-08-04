package oopException.sec01;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class ClassCastException {
    public static void main(String[] args) {
        // 사용자 정의 클래스에 대해 강제 형변환 연산을 진행할 때
        Dog dog = new Dog();
        changeDog(dog);
        Cat cat = new Cat();
    }

    public static void changeDog(Animal animal) {
        Dog dog = (Dog) animal; // Cat 타입을 Dog 타입으로 변환 시도
    }
}