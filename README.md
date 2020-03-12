# Code
```java
import java.util.Scanner;
public class StaffincomeReport{
    public static void main(String[]args){
   
        Scanner sc= new Scanner(System.in);
        System.out.print("Staff name : ");
        String name = sc.nextLine();
        System.out.print("ID : ");
        String id = sc.nextLine();
        System.out.print("Income type (Active/Passive/Portfolio) : ");
        String incomeType = sc.nextLine();
        System.out.print("Income amount : ");
        double amount = sc.nextDouble();
        System.out.print("Income tax percentage : ");
        double tax = sc.nextDouble();

        Income your = new Income(incomeType,amount,tax);
        Staff my = new Staff(name,id,your);
       
        my.displayStaffInfo();
        my.displayIncomeInfo();
    }
}

class Income{
    private String incomeType;
    private double amount;
    private double tax;
    private double totalTax;

    Income(String incomeType,double amount, double tax){
        this.incomeType = incomeType;
        this.amount =amount;
        this.tax = tax;
    }
    String getIncomeType(){
        return incomeType;
    }
    double getAmount(){
        return amount;
    }
    double getTax(){
        return tax;
    }
    double getTotalTax(){
        totalTax = (tax/100)*amount;
        return totalTax;
    }
}

class Staff{
    private String name;
    private String id;
    private Income income;

    Staff(String name, String id,Income income){
        this.name=name;
        this.id=id;
        this.income=income;
    }
    String getName(){
        return name;
    }
    String getId(){
        return id;
    }
    double calculateNetIncome(){
        return income.getAmount()-income.getTotalTax();
    }
    void displayStaffInfo(){
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
    }
    void displayIncomeInfo(){
        System.out.println("Income type: "+income.getIncomeType());
        System.out.println("Income amount : RM"+income.getAmount());
        System.out.println("Income tax : "+income.getTax()+"%");
        System.out.println("Total income tax : RM"+income.getTotalTax());
        System.out.println("Total net income : RM"+calculateNetIncome());
    }
}
```
## Output
![image](https://user-images.githubusercontent.com/55395418/76524176-9676be80-64a4-11ea-81e5-a55986f61363.png)


