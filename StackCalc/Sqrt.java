package Factory;

import java.util.List;
import java.lang.Math;
import java.util.logging.Level;

public class Sqrt implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)throws Exception
    {
        if(commandArgs.size() != 0)
        {
            throw new StackCalculatorException("wrong number of arguments in SQRT command");
        }
        try {
            Main.LOGGER.log(Level.INFO,"pop from stack");
            Double numberFromStack = context.popFromStack();
            if (numberFromStack < 0) {
                throw new Exception("impossible to sqrt number");
            }
            Main.LOGGER.log(Level.INFO,"sqrt");
            Double res = Math.sqrt(numberFromStack);
            Main.LOGGER.log(Level.INFO,"push to stack");
            context.pushToStack(res);
        }
        catch (StackCalculatorException e)
        {
            Main.LOGGER.log(Level.INFO,"error:" + e);
            System.err.println(e);
        }
    }
}
