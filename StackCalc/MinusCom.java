package Factory;

import java.util.List;
import java.util.logging.Level;

public class MinusCom implements Base{
    @Override
    public void DoWork(Context context, List<String> commandArgs)throws Exception
    {

        if(commandArgs.size() != 0)
        {
            throw new StackCalculatorException("wrong number of arguments in MINUS command");
        }
        try
        {
            Main.LOGGER.log(Level.INFO,"get first num");
            Double firstNum = context.popFromStack();
            Main.LOGGER.log(Level.INFO,"get second num");
            Double secondNum = context.popFromStack();
            Main.LOGGER.log(Level.INFO,"push res to stack");
            context.pushToStack(firstNum - secondNum);
        }
        catch (StackCalculatorException e)
        {
            Main.LOGGER.log(Level.INFO,"error: " + e);
            System.err.println(e);
        }
    }
}
