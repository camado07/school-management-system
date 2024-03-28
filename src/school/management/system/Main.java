package school.management.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create initial lists for teachers and students
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        // Create a school
        School school = new School(teachers, students);

        // Interactive menu
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add a teacher");
            System.out.println("2. Add a student");
            System.out.println("3. Pay fees for a student");
            System.out.println("4. Pay salaries to teachers");
            System.out.println("5. Display school status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTeacher(school, scanner);
                    break;
                case 2:
                    addStudent(school, scanner);
                    break;
                case 3:
                    payFees(school, scanner);
                    break;
                case 4:
                    paySalaries(school);
                    break;
                case 5:
                    displaySchoolStatus(school);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }

    // Method to add a teacher interactively
    public static void addTeacher(School school, Scanner scanner) {
        System.out.print("Enter teacher ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();

        System.out.print("Enter teacher salary: ");
        int salary = scanner.nextInt();

        Teacher teacher = new Teacher(id, name, salary);
        school.addTeacher(teacher);
        System.out.println("Teacher added successfully!");
    }

    // Method to add a student interactively
    public static void addStudent(School school, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student grade: ");
        int grade = scanner.nextInt();

        System.out.print("Enter total fees for the student: ");
        int feesTotal = scanner.nextInt();

        Student student = new Student(id, name, grade, feesTotal);
        school.addStudent(student);
        System.out.println("Student added successfully!");
    }

    // Method to pay fees for a student interactively
    public static void payFees(School school, Scanner scanner) {
        System.out.print("Enter student ID to pay fees: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter fees amount: ");
        int feesAmount = scanner.nextInt();

        // Find the student by ID
        for (Student student : school.getStudents()) {
            if (student.getId() == studentId) {
                student.payFees(feesAmount);
                school.updateTotalMoneyEarned(feesAmount); // Update total money earned by the school
                school.updateTotalMoneySpent(feesAmount); // Update total money spent by the school
                System.out.println("Fees paid successfully for student " + student.getName());
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    // Method to pay salaries to teachers
    public static void paySalaries(School school) {
        int totalSalary = 0;
        for (Teacher teacher : school.getTeachers()) {
            totalSalary += teacher.getSalary();
        }
        school.updateTotalMoneySpent(totalSalary);
        System.out.println("Salaries paid successfully to all teachers!");
    }

    // Method to display the school status
    public static void displaySchoolStatus(School school) {
        System.out.println("\nSchool Status:");
        System.out.println("Total Money Earned: $" + school.getTotalMoneyEarned());
        int totalMoneySpent = 0; // Initialize total money spent
        for (Teacher teacher : school.getTeachers()) {
            totalMoneySpent += teacher.getSalary(); // Add teacher salaries to total money spent
        }
        System.out.println("Total Money Spent: $" + totalMoneySpent);
        System.out.println("Remaining Funds: $" + (school.getTotalMoneyEarned() - totalMoneySpent));

        System.out.println("\nTeachers:");
        for (Teacher teacher : school.getTeachers()) {
            System.out.println(teacher.getName() + " - Salary: $" + teacher.getSalary());
        }

        System.out.println("\nStudents:");
        for (Student student : school.getStudents()) {
            int feesTotal = student.getFeesTotal() - student.getFeesPaid(); // Calculate total fees dynamically
            System.out.println(student.getName() + " - Grade: " + student.getGrade() + ", Fees Paid: $" + student.getFeesPaid() + ", Fees Total: $" + feesTotal);
        }
    }

}

