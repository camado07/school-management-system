package school.management.system;

// Teacher class inheriting from Person
class Teacher extends Person {
    private int salary;

    public Teacher(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    // Getter for salary
    public int getSalary() {
        return salary;
    }
}