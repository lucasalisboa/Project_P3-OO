package Entities;

import java.util.Scanner;

public class SalariedWorker extends Worker {
    private double salary;

    @Override
    public void addWorker()
    {
        super.addWorker();
        Scanner sc = new Scanner(System.in);
        System.out.println("WHAT'S THE SALARY?");
        salary = sc.nextDouble();
    }
}
