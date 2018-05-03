package com.thomas.products.jdk8;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerDemo {

    public static void main(String[] args) {

        Student stu = new Student(90);
        stu = updateStudentFee(stu,
                student -> student.grade > 80,
                student -> student.discount = 0.2);
        System.out.println(stu);

    }

    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer){
        if ( predicate.test(student)){
            consumer.accept(student);
        }
        return student;
    }

}
class Student{
    Double discount = 0.0;
    Double fee = 20000.0;
    Integer grade ;

    public Student(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "discount=" + discount +
                ", fee=" + fee +
                '}';
    }
}