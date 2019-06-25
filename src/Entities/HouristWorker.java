package Entities;

import java.util.Scanner;

public class HouristWorker extends Worker {
    private double hour_salary;
    private double hours;

    public HouristWorker(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax) {
        changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
    }

    public HouristWorker() {
        addWorker();
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
        hours = 0;
        System.out.println("WHAT'S THE HOUR WORKED SALARY?");
        hour_salary = sc.nextDouble();
    }
}
