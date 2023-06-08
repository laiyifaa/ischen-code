package javase;

public class Manager  extends  Employee{
    private double bonus;

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getSalary(){
        double salary = super.getSalary();
        return bonus+salary;
    }
}
