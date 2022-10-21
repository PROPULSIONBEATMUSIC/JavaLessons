import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.saveSystem.ReaderWriter;
import json.saveSystem.SaveSystem;

import javax.management.AttributeList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //  Класс, в котором будет показана работа и создание всех примитивов в Java

        PrimitiveTypesExample pr = new PrimitiveTypesExample();

        // Пример полиформизма (как ArrayList, LinkedList и List)
        List<Object> list = new ArrayList<Object>();
        List<Object> list1 = new LinkedList<Object>();
        List<Object> list3 = new AttributeList();


        list.addAll(List.of(pr.a,  pr.b,  pr.c,  pr.d,  pr.e,  pr.f,  pr.g, pr.h));
        list.size();
        System.out.println(list);

        System.out.println("--------------ArrayList--------------");
        list1.addAll(List.copyOf(list));
        System.out.println(list1);
        list1.size();

        System.out.println("------------AttributeList------------");
        list3.addAll(List.copyOf(list));
        System.out.println(list3);
        System.out.println("-------------------------------------");

        //  Пример upcast и downcast

        Person person = new Person(16);
        Person will = new Person("Will", "Fang"); //Upcast
        Person tom = new Person("Tom", "Trech");   //Upcast

        Student student = new Student(18, "Mark", "Luote");
        Person george = (Person) student;

        george.setName("George");               //Downcast
        george.setSurname("Javac");
        if (george instanceof Student) {
            george.sayHi();
            System.out.println(george);
        }

        tom.setAge(10);
        tom.sayHi();
//        tom.sayBye();
        will.setAge(22);
        will.sayHi();
//        will.sayBye();
        System.out.println("==========================");
        System.out.println(will);
        System.out.println(tom);

        //  Пример работы с переменными по значению и по ссылке.

        getNumber(pr.a,  pr.b,  pr.c,  pr.d,  pr.e,  pr.f,  pr.g, pr.h);
        System.out.println(
                "a:" + pr.a + "\n" + "b:" + pr.b + "\n" + "c:" + pr.c + "\n" + "d:" + pr.d + "\n" + "e:" + pr.e + "\n" + "f:" + pr.f + "\n" + "g:" + pr.g + "\n" + "h:" + pr.h + "\n"
        );

        //  Реализовать equals и hashcode
//        System.out.println("------a == b------");
//        equalsNum(1, 1);
//        equalsNum(1, 2);
//        System.out.println("-----a equals b-----");
//        equalsObj(will, tom);
//        equalsObj(person, george);

        System.out.println("equals");
        System.out.println(person.equals(person));
        System.out.println(person.equals(student));
        System.out.println(person.equals(george));
        System.out.println(person.equals(will));
        System.out.println(person.equals(tom));

        System.out.println("\nhashCode");
        System.out.println(person.hashCode());
        System.out.println(student.hashCode());
        System.out.println(george.hashCode());
        System.out.println(will.hashCode());
        System.out.println(tom.hashCode());
        System.out.println(person.hashCode());

        ReaderWriter readerWriter = new ReaderWriter();
        readerWriter.mapper();

    }

//    public static void equalsNum(int a, int b) {
//        if (a == b) {
//            System.out.println(a + " and " + b + " Are equals");
//        } else {
//            System.out.println(a + " and " + b + " Are not equals");
//        }
//    }
//
//    public static void equalsObj(Object a, Object b) {
//        if (a.equals(b)) {
//            System.out.println(a.hashCode() + " equals " + b.hashCode());
//        } else {
//            System.out.println(a.hashCode() + " not equals " + b.hashCode());
//        }
//    }


    public static void getNumber(int a, String b, byte c, long d, char e, float f, double g, boolean h) {
        a = a^3;
        b = b + "bb";
        c++;
        d = d * 2;
        e += 10;
        f = f += 2.4;
        g = g % 4;
        h = false;
        System.out.println(
                "a:" + a + "\n" + "b:" + b + "\n" + "c:" + c + "\n" + "d:" + d + "\n" + "e:" + e + "\n" + "f:" + f + "\n" + "g:" + g + "\n" + "h:" + h + "\n"
        );
    }
}