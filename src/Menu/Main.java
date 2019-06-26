package Menu;

import Entities.CommissionedWorker;
import Entities.HouristWorker;
import Entities.SalariedWorker;
import Entities.Worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("WELCOME\n");
        MyCalendar calendar = new MyCalendar();
        List<Worker> payroll = new ArrayList<>();
        action(calendar,payroll);
    }

    public static void action(MyCalendar calendar, List <Worker> payroll)
    {
        System.out.println("TODAY IS:");
        System.out.println(calendar.data.format(calendar.today) + "," + calendar.dayWeek());
        System.out.println();
        System.out.println("CHOOSE YOUR OPERATION:");
        System.out.println("1- ADD NEW EMPLOYER");
        System.out.println("2- REMOVE A EMPLOYER");
        System.out.println("3- PUT THE POINT CARD");
        System.out.println("4- PUT THE SALE'S RESULT");
        System.out.println("5- PUT THE SERVICE TAX");
        System.out.println("6- CHANGE THE EMPLOYER INFORMATIONS");
        System.out.println("7- RUN THE PAYROLL");
        System.out.println("8- UNDO/REDO");
        System.out.println("9- SHOW THE PAYMENT SCHEDULE");
        System.out.println("10- CREATE A NEW PAYMENT SCHEDULE");
        System.out.println("11 - SHOW THE WORKER INFORMATIONS");
        System.out.println("12- FINISH THE DAY");

        int operation;
        Scanner sc = new Scanner(System.in);
        operation = sc.nextInt();

        if(operation == 1)
        {
            String type;
            System.out.println("WHAT'S THE WORKER TYPE?");
            System.out.println("H- HOURLY; S- SALARIED; C- COMMISSIONED");
            type = sc.next();
            sc.nextLine();

            if (type.equals("H"))
            {
                payroll.add(new HouristWorker(calendar.today));
            }
            else if(type.equals("S"))
            {
                payroll.add(new SalariedWorker(calendar.today));
            }
            else
            {
                payroll.add(new CommissionedWorker(calendar.today));
            }
        }
        else if (operation == 12)
        {
            calendar.finishDay();
        }
        else if (payroll.isEmpty())
        {
            System.out.println("THE LIST IS EMPTY");
        }
        else if(operation == 2)
        {
                int index = search(payroll);
                if (index != -1)
                {
                    remove(payroll,index);
                }
        }

        else if(operation == 3)
        {
            int index = search(payroll);
            if(index != -1)
            {
                if(payroll.get(index) instanceof HouristWorker)
                {
                    ((HouristWorker) payroll.get(index)).point();
                }
                else
                {
                    System.out.println("THIS WORKER IS NOT A HOURIST");
                }
            }
        }
        else if(operation == 4)
        {
            int index = search(payroll);
            if(index != -1)
            {
                if(payroll.get(index) instanceof CommissionedWorker)
                {
                    ((CommissionedWorker) payroll.get(index)).newSale();
                }
                else
                {
                    System.out.println("THIS WORKER IS NOT A COMMISSIONED");
                }
            }
        }
        else if(operation == 5)
        {
            int index = search(payroll);
            if(index != -1)
            {
                if(payroll.get(index) instanceof CommissionedWorker)
                {
                    ((CommissionedWorker) payroll.get(index)).setPercent();
                }
                else
                {
                    System.out.println("THIS WORKER IS NOT A COMMISSIONED");
                }
            }
        }

        else if(operation == 6)
        {
            int index = search(payroll);

            System.out.println("WHAT INFORMATION YOU WANT TO CHANGE?");
            System.out.println("1- NAME");
            System.out.println("2- ADDRESS");
            System.out.println("3- TYPE");
            System.out.println("4- PAYMENT METHOD");
            System.out.println("5- SYNDICATED");
            System.out.println("6- SYNDICATE IDENTIFICATION");
            System.out.println("7- SYNDICATE TAX");
            sc.nextLine();
            int info = sc.nextInt();

            if(info == 1)
            {
                payroll.get(index).changeName();
            }
            else if(info == 2)
            {
                payroll.get(index).changeAddress();
            }
            else if(info == 3)
            {
                String type;
                System.out.println("WHAT'S THE WORKER TYPE?");
                System.out.println("H- HOURLY; S- SALARIED; C- COMMISSIONED");
                type = sc.next();
                sc.nextLine();

                if (type.equals("H"))
                {
                    payroll.add(new HouristWorker(payroll.get(index).id,payroll.get(index).name,payroll.get(index).getAddress(),payroll.get(index).getPayment_method(),payroll.get(index).isSyndicate(),payroll.get(index).getSyndicate_id(),payroll.get(index).getSyndicate_tax(),calendar.today));
                }
                else if(type.equals("S"))
                {
                    payroll.add(new SalariedWorker(payroll.get(index).id,payroll.get(index).name,payroll.get(index).getAddress(),payroll.get(index).getPayment_method(),payroll.get(index).isSyndicate(),payroll.get(index).getSyndicate_id(),payroll.get(index).getSyndicate_tax(),calendar.today));
                }
                else
                {
                    payroll.add(new CommissionedWorker(payroll.get(index).id,payroll.get(index).name,payroll.get(index).getAddress(),payroll.get(index).getPayment_method(),payroll.get(index).isSyndicate(),payroll.get(index).getSyndicate_id(),payroll.get(index).getSyndicate_tax(),calendar.today));
                }
                payroll.remove(index);
            }
            else if(info == 4)
            {
                payroll.get(index).changePayMethod();
            }
            else if(info == 5)
            {
                payroll.get(index).changeSyndicate();
            }
            else if(info == 6)
            {
                payroll.get(index).changeSyndicateId();
            }
            else
            {
                payroll.get(index).changeSyndicateTax();
            }
        }

        else if(operation == 7)
        {
            int c = 0;
            for(int i = 0; i < payroll.size(); i++)
            {
                if(calendar.cal.compareTo(payroll.get(i).getPay_day()) == 0 )
                {
                    System.out.println("ID: " + payroll.get(i).id);
                    System.out.println("NAME: " + payroll.get(i).name);
                    payroll.get(i).payment();
                    c++;
                    System.out.println();
                }
            }
            System.out.println(c + " WORKERS WERE PAID TODAY");
        }

        if(operation == 11)
        {
            int index = search(payroll);
            if(index != -1)
            {
                System.out.println(payroll.get(index).toString());
            }
        }

        System.out.println();
        action(calendar, payroll);

    }

    public static void remove(List <Worker> payroll, int i)
    {
        String worker_name = payroll.get(i).name;
        payroll.remove(i);
        System.out.println("THE WORKER " + worker_name + " WAS REMOVED");
    }
    public static int search(List <Worker> payroll)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WHAT'S THE WORKER ID?");
        String worker_id = sc.nextLine();
        for(int i = 0; i < payroll.size(); i++)
        {
            if(payroll.get(i).id.equals(worker_id))
            {
                return i;
            }
        }
        System.out.println("THE WORKER DOESN'T EXIST");
        return -1;
    }
}
