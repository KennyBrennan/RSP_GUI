import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandHandler {

    private String starName;
    private Process p;
    String[] commands;
    String[] envp;
    File f;
    
    public CommandHandler() {
      
        
        commands = new String[1];
        envp = new String[1];
        envp[0] = "";
        commands[0] = "ls";
    }
    public void start () {
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
     public void setPath(File path) {
          f = path;
    }
     public void setStarName(String starName) {
        this.starName = starName;
    }


    
}