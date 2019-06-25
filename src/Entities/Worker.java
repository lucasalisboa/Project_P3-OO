package Entities;

import java.util.Scanner;

public abstract class Worker {
    public String id;
    public String name;
    private String address;
    private String payment_method;
    private String syndicate_id;
    private double syndicate_tax;

    public Worker() { addWorker(); }

    public void addWorker()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WHAT'S THE WORKER ID?");
        id = sc.nextLine();
        System.out.println("WHAT'S THE WORKER NAME?");
        name = sc.nextLine();
        System.out.println("WHAT'S THE WORKER ADDRESS?");
        address = sc.nextLine();
        System.out.println("WHAT'S THE PAYMENT METHOD");
        payment_method = sc.nextLine();
        System.out.println("DOES THE WORKER IS SYNDICATED?");
        System.out.println("Y - YES / N - NO");
        String aux = sc.next();
        if(aux == "N")
        {
            syndicate_id = null;
            syndicate_tax = 0;
        }
        else
        {
            System.out.println("WHAT'S THE SYNDICATE ID?");
            syndicate_id = sc.nextLine();
            System.out.println("WHAT'S THE SYNDICATE TAX?");
            syndicate_tax = sc.nextDouble();
            sc.nextLine();
        }
    }

    public String toString()
    {
        return name;
    }

}
