package Menu;

import Entities.CommissionedWorker;
import Entities.HouristWorker;
import Entities.SalariedWorker;
import Entities.Worker;

import java.util.ArrayList;
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
        System.out.println("11- FINISH THE DAY");

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
                payroll.add(new HouristWorker());
            }
            else if(type.equals("S"))
            {
                payroll.add(new SalariedWorker());
            }
            else
            {
                payroll.add(new CommissionedWorker());
            }
        }
        else if (operation == 11)
        {
            calendar.finishDay();
        }
        else if (payroll.isEmpty())
        {
            System.out.println("THE LIST IS EMPTY");
        }
        else if(operation == 2)
        {
                System.out.println("WHAT'S THE WORKER ID?");
                sc.nextLine();
                String worker_id = sc.nextLine();
                for(int i = 0; i < payroll.size(); i++)
                {
                    if(payroll.get(i).id.equals(worker_id))
                    {
                        String worker_name = payroll.get(i).name;
                        payroll.remove(i);
                        System.out.println("THE WORKER " + worker_name + " WAS REMOVED");
                        break;
                    }
                    else if(i + 1 == payroll.size())
                    {
                        System.out.println("THE WORKER DOESN'T EXIST");
                        break;
                    }
                }
        }
        else if(operation == 7)
        {
            System.out.println("PLEASE, ENTER WITH THE EMPLOYER'S ID");
            String worker_id;
            sc.nextLine();
            worker_id = sc.nextLine();
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

            for(int i = 0; i < payroll.size(); i++)
            {
                if(payroll.get(i).id.equals(worker_id))
                {
                    if(info == 1)
                    {
                        payroll.get(i).changeName();
                    }
                    else if(info == 2)
                    {
                        payroll.get(i).changeAddress();
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
                            payroll.add(new HouristWorker(payroll.get(i).id,payroll.get(i).name,payroll.get(i).getAddress(),payroll.get(i).getPayment_method(),payroll.get(i).isSyndicate(),payroll.get(i).getSyndicate_id(),payroll.get(i).getSyndicate_tax()));
                        }
                        else if(type.equals("S"))
                        {
                            payroll.add(new SalariedWorker(payroll.get(i).id,payroll.get(i).name,payroll.get(i).getAddress(),payroll.get(i).getPayment_method(),payroll.get(i).isSyndicate(),payroll.get(i).getSyndicate_id(),payroll.get(i).getSyndicate_tax()));
                        }
                        else
                        {
                            payroll.add(new CommissionedWorker(payroll.get(i).id,payroll.get(i).name,payroll.get(i).getAddress(),payroll.get(i).getPayment_method(),payroll.get(i).isSyndicate(),payroll.get(i).getSyndicate_id(),payroll.get(i).getSyndicate_tax()));
                        }
                    }
                    else if(info == 4)
                    {
                        payroll.get(i).changePayMethod();
                    }
                    else if(info == 5)
                    {
                        payroll.get(i).changeSyndicate();
                    }
                    else if(info == 6)
                    {
                        payroll.get(i).changeSyndicateId();
                    }
                    else
                    {
                        payroll.get(i).changeSyndicateTax();
                    }

                    break;
                }
                else if(i + 1 == payroll.size())
                {
                    System.out.println("THE WORKER DOESN'T EXIST");
                    break;
                }
            }

        }


        System.out.println();
        action(calendar, payroll);

    }
}
