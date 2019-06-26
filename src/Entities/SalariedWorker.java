package Entities;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SalariedWorker extends Worker {
    private double salary;

    public SalariedWorker(Date today)
    {
        addWorker();
        newPayDay(today);
    }
    public SalariedWorker(String id, String name, String address, String payment_method, boolean syndicate, String syndicate_id, double syndicate_tax, Date today) {
        changeType(id,name,address,payment_method,syndicate, syndicate_id, syndicate_tax);
        newPayDay(today);
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
    public void newPayDay(Date today)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        int week = checkDay(cal);
        pay_day = cal;
        pay_day.add(Calendar.DAY_OF_MONTH,week);
    }
    private void updatePayment()
    {
        pay_day.add(Calendar.MONTH,1);
        pay_day.set(Calendar.DAY_OF_MONTH, pay_day.getActualMaximum(Calendar.DAY_OF_MONTH));
        int week = checkDay(pay_day);
        pay_day.add(Calendar.DAY_OF_MONTH,week);
    }

    private int checkDay(Calendar cal)
    {
        int week = cal.get(Calendar.DAY_OF_WEEK);
        if(week == 7)
        {
            return -1;
        }
        else if(week == 1)
        {
            return -2;
        }
        return 0;
    }

    @Override
    public void payment()
    {
        System.out.println("PAYMENT: " +(salary - (salary*getSyndicate_tax()/100) ));
        updatePayment();
    }

    @Override
    public String toString() {
        return  super.toString() +
                "SalariedWorker{" +
                "salary=" + salary +
                '}';
    }
}
