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
        System.out.println("\nStaff Info:");
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
    }
    void displayIncomeInfo(){
        System.out.println("\nIncome Info:");
        System.out.println("Income type: "+income.getIncomeType());
        System.out.printf("Income amount : RM"+"%.2f",income.getAmount());
        System.out.println("\nIncome tax : "+income.getTax()+"%");
        System.out.printf("Total income tax : RM"+"%.2f",income.getTotalTax());
        System.out.printf("\nTotal net income : RM"+"%.2f",calculateNetIncome());
    }
}