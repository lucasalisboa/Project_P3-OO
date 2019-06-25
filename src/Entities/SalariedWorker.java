package Entities;

import java.util.Scanner;

public class SalariedWorker extends Worker {
    private double salary;

    public SalariedWorker()
    {
        addWorker();
    }
    public SalariedWorker(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax) {
        changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
    }

    @Override
    public void changeType(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax)
    {
        super.changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
        newType();
    }
    public void newType()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WHAT'S THE SALARY?");
        salary = sc.nextDouble();
    }

    @Override
    public void addWorker()
    {
        super.addWorker();
        newType();
    }

    @Override
    public String toString() {
        return  super.toString() +
                "SalariedWorker{" +
                "salary=" + salary +
                '}';
    }
}
