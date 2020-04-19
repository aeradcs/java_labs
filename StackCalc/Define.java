package Factory;

import java.util.List;
import java.util.logging.Level;

public class Define implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)throws Exception
    {
        if(commandArgs.size() != 2)
        {
            throw new StackCalculatorException("wrong number of arguments in DEFINE command");
        }
        String varName = commandArgs.get(0);
        Double value = Double.parseDouble(commandArgs.get(1));
        Main.LOGGER.log(Level.INFO,"set variable");
        context.setVariable(varName, value);
    }

}
