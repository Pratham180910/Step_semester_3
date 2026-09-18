class EmployeeAndCompany {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeAndCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeAndCompany("Arjun", 50000);
        new EmployeeAndCompany("Priya", 60000);
        new EmployeeAndCompany("Rahul", 55000);

        EmployeeAndCompany.printCompanyInfo();
    }
}