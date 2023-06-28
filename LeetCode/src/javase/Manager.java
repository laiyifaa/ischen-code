package javase;

public class Manager  extends  Employee{
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day, double bonus) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getSalary(){
        double salary = super.getSalary();
        return bonus+salary;
    }
}
