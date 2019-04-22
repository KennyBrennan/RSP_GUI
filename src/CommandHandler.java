import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandHandler {

    private String starName;
    private Process p;
    
    public CommandHandler(String starName) {
        this.starName = starName;
        
        String[] commands = new String[1];
        String[] envp = new String[1];
        envp[0] = "";
        commands[0] = "ls";
        File f = new File(System.getProperty("user.home")+"/mesa/star/test_suite/"+this.starName);
        try {
            p = Runtime.getRuntime().exec(commands,envp,f);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println("line: " + s);
            }
            br = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((s = br.readLine()) != null) {
                System.out.println("line: " + s);
            }
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (IOException | InterruptedException e) {System.out.println(e);}
    
    }
    
}