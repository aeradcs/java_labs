package Factory;

import java.util.ArrayList;
import java.util.HashMap;

public class Context {
    private HashMap<String, Double> variables = new HashMap<>();
    private ArrayList<Double> stack = new ArrayList<>();
    public Double popFromStack() throws Exception
    {
        if(stack.size() == 0 || stack == null)
        {
            throw new StackCalculatorException("null stack");
        }
        Double res = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return res;
    }
    public void pushToStack(Double num)
    {
        stack.add(num);
    }
    public Double getFromStack() throws Exception
    {
        if(stack.size() == 0 || stack == null)
        {
            throw new StackCalculatorException("null stack");
        }
        return stack.get(stack.size() - 1);
    }
    public void printStack() throws Exception
    {
        for (double n:stack) {
            System.out.println(n);
        }
    }
    public void printVars()throws Exception
    {
        for (HashMap.Entry<String, Double> entry : variables.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }
    public void setVariable(String varName, Double value)
    {
        variables.put(varName, value);
    }
    public Double getVarValue(String varName) throws Exception
    {
        if(variables.size() == 0 ||variables == null)
        {
            throw new StackCalculatorException("null variables");
        }
        return variables.get(varName);
    }

}
