public class Student extends Person{

    public Student(int age, String name, String surname) {
        super(age, name, surname);
    }

    @Override
    public void sayHi() {
        System.out.println("Hi, said student... My name is: " + name + " and age is: " + age);
    }

    @Override
    public void sayBye() {
        System.out.println("Bye bye");
    }
}
