package Factory;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public class TestStackCalculator {
    @Test
    public void testPlus() throws Exception
    {
        CommandFactory commandFactory = new CommandFactory();

        ArrayList<String> commandArguments = new ArrayList<String>();
        Context context = new Context();
        Double a = 10.5;
        Double b = 10.0;
        Double expected = a + b;
        context.pushToStack(a);
        context.pushToStack(b);

        Base command = CommandFactory.create("+");
        command.DoWork(context, commandArguments);
        Double res = context.getFromStack();
        Assert.assertEquals(expected, res);

    }
    @Test
    public void testMinus() throws Exception
    {
        CommandFactory commandFactory = new CommandFactory();

        ArrayList<String> commandArguments = new ArrayList<String>();
        Context context = new Context();
        Double a = 10.5;
        Double b = 10.0;
        Double expected = b - a;
        context.pushToStack(a);
        context.pushToStack(b);

        Base command = CommandFactory.create("-");
        command.DoWork(context, commandArguments);
        Double res = context.getFromStack();
        Assert.assertEquals(expected, res);
    }
    @Test
    public void testMult() throws Exception
    {
        CommandFactory commandFactory = new CommandFactory();

        ArrayList<String> commandArguments = new ArrayList<String>();
        Context context = new Context();
        Double a = 10.5;
        Double b = 10.0;
        Double expected = a * b;
        context.pushToStack(a);
        context.pushToStack(b);

        Base command = CommandFactory.create("*");
        command.DoWork(context, commandArguments);
        Double res = context.getFromStack();
        Assert.assertEquals(expected, res);
    }
    @Test
    public void testDiv() throws Exception
    {
        CommandFactory commandFactory = new CommandFactory();

        ArrayList<String> commandArguments = new ArrayList<String>();
        Context context = new Context();
        Double a = 100.0;
        Double b = 10.0;
        Double expected = b / a;
        context.pushToStack(a);
        context.pushToStack(b);

        Base command = CommandFactory.create("/");
        command.DoWork(context, commandArguments);
        Double res = context.getFromStack();
        Assert.assertEquals(expected, res);
    }
    @Test
    public void testPush() throws Exception
    {
        Context context = new Context();
        Double a = 10.5;
        Double b = 10.0;
        context.pushToStack(a);

        Double res = context.getFromStack();
        Assert.assertEquals(a, res);

        context.pushToStack(b);
        res = context.getFromStack();
        Assert.assertEquals(b, res);
    }
    @Test
    public void testPop() throws Exception
    {
        Context context = new Context();
        Double a = 10.5;
        Double b = 10.0;
        context.pushToStack(a);

        Double res = context.getFromStack();
        Assert.assertEquals(a, res);

        context.pushToStack(b);
        res = context.getFromStack();
        Assert.assertEquals(b, res);

        context.popFromStack();
        res = context.getFromStack();
        Assert.assertEquals(a, res);
    }
    @Test
    public void testDefine() throws Exception
    {
        Context context = new Context();
        Double value = 5.5;
        context.setVariable("a", value);

        Double res = context.getVarValue("a");
        Assert.assertEquals(value, res);

        value = 10.0;
        context.setVariable("v", value);
        res = context.getVarValue("v");
        Assert.assertEquals(value, res);
    }
    @Test
    public void testSqrt() throws Exception
    {
        CommandFactory commandFactory = new CommandFactory();

        ArrayList<String> commandArguments = new ArrayList<String>();
        Context context = new Context();
        Double a = 81.0;
        Double expected = Math.sqrt(a);
        context.pushToStack(a);

        Base command = CommandFactory.create("SQRT");
        command.DoWork(context, commandArguments);
        Double res = context.getFromStack();
        Assert.assertEquals(expected, res);
    }
}
