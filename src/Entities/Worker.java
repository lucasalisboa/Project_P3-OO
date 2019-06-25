package Entities;

import java.util.Scanner;

public abstract class Worker {
    public String id;
    public String name;
    private String address;
    private String payment_method;
    private boolean syndicate;
    private String syndicate_id;
    private double syndicate_tax;
    Scanner sc = new Scanner(System.in);

    public void addWorker()
    {
        System.out.println("WHAT'S THE WORKER ID?");
        id = sc.nextLine();
        changeName();
        changeAddress();
        changePayMethod();
        System.out.println("DOES THE WORKER IS SYNDICATED?");
        System.out.println("Y - YES / N - NO");
        String aux = sc.next();
        if(aux == "N")
        {
            notSyndicated();
        }
        else
        {
            beSyndicated();
        }
    }

    public void changeType(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.payment_method = payment_method;
        this.syndicate = syndicate;
        this.syndicate_id = syndicate_id;
        this.syndicate_tax = syndicate_tax;
    }

    public String getAddress() {
        return address;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public boolean isSyndicate() {
        return syndicate;
    }

    public String getSyndicate_id() {
        return syndicate_id;
    }

    public double getSyndicate_tax() {
        return syndicate_tax;
    }

    public void changeName()
    {

        System.out.println("WHAT'S THE WORKER NEW NAME?");
        name = sc.nextLine();
    }
    public void changeAddress()
    {
        System.out.println("WHAT'S THE WORKER NEW ADDRESS?");
        address = sc.nextLine();
    }
    public void changePayMethod()
    {
        System.out.println("WHAT'S THE WORKER NEW PAYMENT METHOD?");
        payment_method = sc.nextLine();
    }
    public void changeSyndicateId()
    {
        System.out.println("WHAT'S THE SYNDICATE ID?");
        sc.nextLine();
        syndicate_id = sc.nextLine();
    }
    public void changeSyndicateTax()
    {
        System.out.println("WHAT'S THE SYNDICATE TAX?");
        syndicate_tax = sc.nextDouble();
    }

    public void beSyndicated()
    {
        syndicate = true;
        changeSyndicateId();
        changeSyndicateTax();
        sc.nextLine();
    }
    public void notSyndicated()
    {
        syndicate = false;
        syndicate_id = null;
        syndicate_tax = 0;
    }

    public void changeSyndicate()
    {
      if(syndicate == true)
      {
          notSyndicated();
      }
      else {
          beSyndicated();
      }
    }

    public String toString()
    {
        return name;
    }

}
