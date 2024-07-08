package javase;


import java.time.LocalDate;

public class Employee   {
   private static int nextId = 1;

   private String name;
   private double salary;
   private LocalDate hireDay;

   public Employee(String name, double salary, int year,int month,int day) {
      this.name = name;
      this.salary = salary;
      this.hireDay = LocalDate.of(year,month,day);
   }

   private int id;

   Employee(){

   }
   Employee(String n ,double s){
      this();
      name = n;
      salary = s;
      id = 0;
   }

   public static int getNextId() {
      return nextId;
   }

   public static void setNextId(int nextId) {
      Employee.nextId = nextId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      id  = nextId;
      nextId++;
   }

   public static  void swap(Employee x,Employee y){
      Employee temp = x;
      x = y;
      y = temp;
   }

   public LocalDate getHireDay() {
      return hireDay;
   }

   public void setHireDay(LocalDate hireDay) {
      this.hireDay = hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent/100;
      salary += raise;
   }
   public static void tripleSalary(Employee x){
      x.raiseSalary(200);
   }

   @Override
   public String toString() {
      return "Employee{" +
              "name='" + name + '\'' +
              ", salary=" + salary +
              ", id=" + id +
              '}';
   }

   public static void main(String[] args){

   }
}


