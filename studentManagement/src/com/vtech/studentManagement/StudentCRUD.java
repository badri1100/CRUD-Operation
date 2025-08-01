package com.vtech.studentManagement;

import java.util.Scanner;
import com.vtech.studentManagement.models.Student;
import com.vtech.studentManagement.service.StudentService;

public class StudentCRUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n---- Student Management System ----");
            System.out.println("1: Add Student");
            System.out.println("2: View Students");
            System.out.println("3: Update Student");
            System.out.println("4: Delete Student");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter ID: ");
                    long id = sc.nextLong(); // Make sure this matches your model
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    service.addStudent(new Student(id, name, age));
                    break;
                }

                case 2: {
                    service.viewStudent();
                    break;
                }

                case 3: {
                    System.out.print("Enter the student ID to update: ");
                    long id = sc.nextLong();
                    System.out.print("Enter new name: ");
                    String newName = sc.next();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    service.updateStudent(new Student(id, newName, newAge));
                    break;
                }

                case 4: {
                    System.out.print("Enter student ID to delete: ");
                    long deleteId = sc.nextLong();
                    service.deleteStudent(deleteId);
                    break;
                }

                case 5:
                    System.out.println("Exiting from the console...");
                    break;

                default:
                    System.out.println("Invalid Choice. Try Again.");
                    break;
            }

        } while (choice != 5);

        sc.close();
    }
}
