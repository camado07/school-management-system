package school.management.system;

import java.util.ArrayList;

// School class
class School {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private int totalMoneyEarned;
    private int totalMoneySpent;

    public School(ArrayList<Teacher> teachers, ArrayList<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    // Getters
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    // Add a teacher to the school
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Add a student to the school
    public void addStudent(Student student) {
        students.add(student);
    }

    // Update total money earned by the school
    public void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    // Update total money spent by the school
    public void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
    }

    // Update remaining funds
    public void updateRemainingFunds(int feesPaid) {
        totalMoneyEarned -= feesPaid; // Deduct fees paid
        totalMoneySpent += feesPaid; // Update total money spent
    }
}
