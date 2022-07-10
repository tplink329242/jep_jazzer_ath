import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import jep.Interpreter;
import jep.SubInterpreter;
import jep.JepConfig;
import java.io.File;

public class JepJazzerTest {
    
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {

        File pwd = new File(".");

        try (Interpreter interp = new SubInterpreter(new JepConfig().addIncludePaths(pwd.getAbsolutePath()))) {

            int input = data.consumeInt();

            interp.exec("import pyTest");
            // any of the following work, these are just pseudo-examples
        
            // using exec(String) to invoke methods
            interp.set("arg1", input);
            interp.set("arg2", input + 2);
            interp.exec("x = pyTest.calc_add(arg1, arg2)");
            interp.getValue("x");
        
        }
        catch (Exception e) 
        {
            System.out.println("An error has occored" + e);
            return;
        }

    }

}
