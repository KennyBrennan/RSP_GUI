import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandHandler {

    private String starName;
    private Process p;
    String[] commands;
    String[] envp;
    File file;
    String directory;
    
    public CommandHandler() {
        commands = new String[1];
        envp = new String[1];
        envp[0] = "";
        commands[0] = "./rn";
    }
    public void start () {
         try {
            p = Runtime.getRuntime().exec(commands,envp,file);
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
     public void setPath(File fpath, String path) {
        file = fpath;
        directory = path;
    }
     public void setStarName(String starName) {
        this.starName = starName;
    }
    public void changeFolder(String fileName) {
        file = new File(directory + "/star/test_suite/" + fileName);
    }




    
}