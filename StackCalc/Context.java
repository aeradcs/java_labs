package Factory;

import java.util.ArrayList;
import java.util.HashMap;

public class Context {
    private HashMap<String, Double> variables = new HashMap<>();
    private ArrayList<Double> stack = new ArrayList<>();
    public Double popFromStack()
    {
        Double res = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return res;
    }
    public void pushToStack(Double num)
    {
        stack.add(num);
    }
    public void printStack()
    {
        System.out.println("stack___________");
        for (double n:stack) {
            System.out.println(n);
        }
    }
    public void printVars()
    {
        System.out.println("vars");
        for (HashMap.Entry<String, Double> entry : variables.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }
    public void setVariable(String varName, Double value)
    {
        variables.put(varName, value);
    }
    public Double getVarValue(String varName)
    {
        return variables.get(varName);
    }

}
