package com.vtech.studentManagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import com.vtech.studentManagement.Student;

public class StudentService {

    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student data added successfully.");
    }

    public void viewStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student List:");
            studentList.forEach(s -> System.out.println(s));
        }
    }

    public void updateStudent(Student student) {
        boolean found = false;
        for (Student s : studentList) {
            if (student.getStudentId() == s.getStudentId()) {
                s.setName(student.getName());
                s.setAge(student.getAge());
                System.out.println("Data updated: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID " + student.getStudentId());
        }
    }

    public void deleteStudentById(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (id == s.getStudentId()) {
                iterator.remove();
                System.out.println("Deleted student with ID: " + id);
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }
}
