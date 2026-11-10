class Employee
{  
    private int sal;
    String classname;
    Employee()
    {
        sal=10000;
        classname="Employee";
    }
    Employee(int sal,String classname)
    {
        this.sal=sal;
        this.classname=classname;
    }
    protected void display()
    {
        System.out.println("Name of class is "+classname);
    }
    protected void calcSalary()
    {
        System.out.println("Salary of employee is "+sal);        
    }
    
}

class Engineer extends Employee
{
    public Engineer()
    {
        super(20000,"Engineer");
    }
}


public class Inheritance
{
    public static void main(String args[])
    {
        Employee emp=new Employee();
        emp.display();
        emp.calcSalary();
        Engineer eng=new Engineer();
        eng.display();
        eng.calcSalary();
    }    
}
