package school.management.system;

// Student class inheriting from Person
class Student extends Person {
    private int grade;
    private int feesPaid;
    private int feesTotal;

    public Student(int id, String name, int grade, int feesTotal) {
        super(id, name);
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = feesTotal;
    }

    // Getters for grade, feesPaid, feesTotal
    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    // Method to pay fees
    public void payFees(int fees) {
        feesPaid += fees;
        feesTotal -= fees; // Deduct fees paid from total fees
    }
}
