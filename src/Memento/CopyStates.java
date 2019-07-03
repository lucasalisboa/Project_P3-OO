package Memento;

import Entities.CommissionedWorker;
import Entities.HouristWorker;
import Entities.SalariedWorker;
import Entities.Worker;

import java.util.ArrayList;
import java.util.List;


public class CopyStates {
    List<Worker> previous ;

    public CopyStates(List <Worker> payroll)
    {
        previous = new ArrayList<>();
        for(int i=0; i<payroll.size();i++)
        {
            if(payroll.get(i) instanceof HouristWorker)
            {
                previous.add(i,new HouristWorker(payroll.get(i).id,payroll.get(i).name,payroll.get(i).getAddress(),payroll.get(i).getPayment_method(),payroll.get(i).isSyndicate(),payroll.get(i).getSyndicate_id(),payroll.get(i).getSyndicate_tax(),((HouristWorker) payroll.get(i)).getHour_salary(),((HouristWorker) payroll.get(i)).getHours()));
            }
            else if(payroll.get(i) instanceof SalariedWorker)
            {
                previous.add(i,new SalariedWorker(payroll.get(i).id,payroll.get(i).name,payroll.get(i).getAddress(),payroll.get(i).getPayment_method(),payroll.get(i).isSyndicate(),payroll.get(i).getSyndicate_id(),payroll.get(i).getSyndicate_tax(),((SalariedWorker) payroll.get(i)).getSalary()));
            }
            else if(payroll.get(i) instanceof CommissionedWorker)
            {
                previous.add(i,new CommissionedWorker(payroll.get(i).id,payroll.get(i).name,payroll.get(i).getAddress(),payroll.get(i).getPayment_method(),payroll.get(i).isSyndicate(),payroll.get(i).getSyndicate_id(),payroll.get(i).getSyndicate_tax(),((CommissionedWorker) payroll.get(i)).getBase_salary(),((CommissionedWorker) payroll.get(i)).getSales(),((CommissionedWorker) payroll.get(i)).getPercent()));
            }
        }
    }

    public void undo_redo(List <Worker> payroll)
    {
        for(int i=0; i<payroll.size();i++)
        {
            payroll.remove(i);
            if(previous.get(i) instanceof HouristWorker)
            {
                payroll.add(i,new HouristWorker(previous.get(i).id,previous.get(i).name,previous.get(i).getAddress(),previous.get(i).getPayment_method(),previous.get(i).isSyndicate(),previous.get(i).getSyndicate_id(),previous.get(i).getSyndicate_tax(),((HouristWorker) previous.get(i)).getHour_salary(),((HouristWorker) previous.get(i)).getHours()));
            }
            else if(previous.get(i) instanceof SalariedWorker)
            {
                payroll.add(i,new SalariedWorker(previous.get(i).id,previous.get(i).name,previous.get(i).getAddress(),previous.get(i).getPayment_method(),previous.get(i).isSyndicate(),previous.get(i).getSyndicate_id(),previous.get(i).getSyndicate_tax(),((SalariedWorker) previous.get(i)).getSalary()));
            }
            else if(previous.get(i) instanceof CommissionedWorker)
            {
                payroll.add(i,new CommissionedWorker(previous.get(i).id,previous.get(i).name,previous.get(i).getAddress(),previous.get(i).getPayment_method(),previous.get(i).isSyndicate(),previous.get(i).getSyndicate_id(),previous.get(i).getSyndicate_tax(),((CommissionedWorker) previous.get(i)).getBase_salary(),((CommissionedWorker) previous.get(i)).getSales(),((CommissionedWorker) previous.get(i)).getPercent()));
            }
        }
    }
}


