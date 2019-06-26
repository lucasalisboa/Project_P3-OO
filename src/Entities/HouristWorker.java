package Entities;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HouristWorker extends Worker {
    private double hour_salary;
    private int hours;
    Scanner sc = new Scanner(System.in);

    public HouristWorker(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax) {
        changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
    }

    public HouristWorker(Date today) {
        addWorker();
        newPayDay(today);
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
        hours = 0;
        System.out.println("WHAT'S THE HOUR WORKED SALARY?");
        hour_salary = sc.nextDouble();
    }
    public void point()
    {
        System.out.println("HOW MANY HOURS THE WORKER WORKED TODAY?");
        int new_hours = sc.nextInt();
        hours += new_hours;
    }
    @Override
    public void newPayDay(Date today)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int week = 6 - cal.get(Calendar.DAY_OF_WEEK);
        pay_day.setTime(today);
        if(week > 0)
        {
            pay_day.add(Calendar.DAY_OF_MONTH,week);
        }
        else
        {
            pay_day.add(Calendar.DAY_OF_MONTH,7 + week);
        }

    }

    private void updatePayment()
    {
        pay_day.add(Calendar.DAY_OF_MONTH,7);
    }

    @Override
    public void payment()
    {
        double salary = hours * hour_salary;
        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
        updatePayment();
    }

    @Override
    public String toString() {
        return super.toString() +
                "HouristWorker{" +
                "hour_salary=" + hour_salary +
                ", hours=" + hours +
                '}';
    }
}
