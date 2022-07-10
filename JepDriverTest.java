import jep.Interpreter;
import jep.SubInterpreter;
import jep.JepConfig;

import java.io.File;

public class JepDriverTest {

    public static void main(String argv[]) throws Throwable 
    {
        File pwd = new File(".");

        try (Interpreter interp = new SubInterpreter(new JepConfig().addIncludePaths(pwd.getAbsolutePath()))) {
            interp.exec("import pyTest");
            // any of the following work, these are just pseudo-examples
        
            // using exec(String) to invoke methods
            interp.set("arg1", 1);
            interp.set("arg2", 2);
            interp.exec("x = pyTest.calc_add(arg1, arg2)");
            Object result1 = interp.getValue("x");

            //System.out.println("testMethod res:   " + result1);
        
        }
        catch (Exception e) 
        {
            System.out.println("An error has occored" + e);
            return;
        }
        // try (Interpreter interp = new SharedInterpreter()) {
        //     interp.exec("from java.lang import System");
        //     interp.exec("s = 'Hello World'");
        //     interp.exec("System.out.println(s)");
        //     interp.exec("print(s)");
        //     interp.exec("print(s[1:-1])");
        // }
    }
    
}
