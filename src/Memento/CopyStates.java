package Memento;

import Entities.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CopyStates {
    List<Worker> previous = new ArrayList<>();

    public CopyStates(List <Worker> payroll)
    {
        copy(payroll);
    }

    public void copy(List <Worker> payroll)
    {
        previous = payroll.stream().collect(Collectors.toList());
    }
    public List<Worker> undo(List<CopyStates> stack, int stack_index)
    {
        return (List<Worker>) stack.get(stack_index);
    }
    public List<Worker> redo(List<CopyStates> stack, int stack_index)
    {
        return (List<Worker>) stack.get(stack_index);
    }
}
