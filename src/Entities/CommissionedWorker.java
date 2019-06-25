package Entities;

import java.util.Scanner;

public class CommissionedWorker extends Worker {
    private double base_salary;
    private int sales;
    private double percent;

    public CommissionedWorker()
    {
        addWorker();
    }

    public CommissionedWorker(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax) {
        changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
    }

    @Override
    public void changeType(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax)
    {
        super.changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
        newType();
    }

    @Override
    public void addWorker()
    {
        super.addWorker();
        newType();
    }

    public void newType()
    {
        Scanner sc = new Scanner(System.in);
        sales = 0;
        System.out.println("WHAT'S THE BASE SALARY?");
        base_salary = sc.nextDouble();
        System.out.println("HOW MANY PERCENTS FOR SALE?");
        percent = sc.nextDouble();
    }
}
