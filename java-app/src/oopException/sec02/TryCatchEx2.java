package oopException.sec02;

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

public class TryCatchEx2 {

    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        try {
            changeDog(dog);
            changeCat(cat);
        } catch (ClassCastException e) {
            System.out.println("변할 수 없는 타입입니다." + e);
        }
    }

    private static void changeDog(Animal animal) {
        Dog dog = (Dog) animal;
    }

    private static void changeCat(Animal animal) {
        Cat cat = (Cat) animal;
    }
}
