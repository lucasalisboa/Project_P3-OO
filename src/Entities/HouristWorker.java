package Entities;

import java.util.Scanner;

public class HouristWorker extends Worker {
    private double hour_salary;
    private double hours;

    @Override
    public void addWorker()
    {
        super.addWorker();
        Scanner sc = new Scanner(System.in);
        hours = 0;
        System.out.println("WHAT'S THE HOUR WORKED SALARY?");
        hour_salary = sc.nextDouble();
    }
}
