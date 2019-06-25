package Entities;

import java.util.Scanner;

public class CommissionedWorker extends Worker {
    private double base_salary;
    private int sales;
    private double percent;

    @Override
    public void addWorker()
    {
        super.addWorker();
        Scanner sc = new Scanner(System.in);
        sales = 0;
        System.out.println("WHAT'S THE BASE SALARY?");
        base_salary = sc.nextDouble();
        System.out.println("HOW MANY PERCENTS FOR SALE?");
        percent = sc.nextDouble();
    }
}
