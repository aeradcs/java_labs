package Factory;

import java.util.List;

public class Define implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)
    {
        String varName = commandArgs.get(0);
        Double value = Double.parseDouble(commandArgs.get(1));
        context.setVariable(varName, value);
    }

}
