package Factory;

import java.util.List;

public class MultCom implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)
    {

        Double firstNum = context.popFromStack();
        Double secondNum = context.popFromStack();
        context.pushToStack(firstNum * secondNum);
    }
}
