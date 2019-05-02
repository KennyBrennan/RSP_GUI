import java.io.*;
import java.util.Map;

/**
 *
 * @authors Cj,Kenny,Matt
 */
public class CommandHandler implements Runnable {

    private String starName;
    private Process p;
    String[] runCommand;
    String[] reRunCommand;
    String[] envp;
    String[] args;
    File file;
    String directory;
    mesaScreen ms = new mesaScreen();
    File lastFile;
    
    public CommandHandler() {
        runCommand = new String[1];
        reRunCommand = new String[1];
        envp = new String[1];
        envp[0] = "";
        args = new String[1];
        args[0] = "";
        runCommand[0] = "./rn";
        reRunCommand[0] = "./re";
    }
    @Override
    public void run() {
        this.start();
    }
    public void reRun() {
        try {
            ms.setLocationRelativeTo(null);
            //ms.setUndecorated(true);
            ms.setVisible(true);

            lastFile = lastFileModified();

            //args[0] = lastFile.getName();
          //  reRunCommand[0] = "./re " + lastFileModified();
          //  System.out.println("file.toString() = " + file.toString());
           // String[] args = new String[] {file.toString() + "/re", lastFile.getName()};
           // System.out.println("...\n" + args[0] + args[1]);
           // Process p = new ProcessBuilder(args).start();

            System.out.println("...\n\n" + file + reRunCommand[0] + args[0] );
            System.out.println("\nFile : " + file);
            System.out.println("\nreRunCommand[0] : " + reRunCommand[0]);
            System.out.println("\nargs[0] : " + args[0]);

            p = Runtime.getRuntime().exec(reRunCommand[0] + " " + lastFile.getName(),envp,file);
           // p = Runtime.getRuntime().exec("./re " + lastFile.getName());

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
            ms.setVisible(false);

/*
            ProcessBuilder pb =
                    new ProcessBuilder("./re", lastFile.toString());
            Map<String, String> env = pb.environment();
            pb.directory(new File(file.toString()));
            File log = new File("log");
            pb.redirectErrorStream(true);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
            Process p = pb.start();
            assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert p.getInputStream().read() == -1;
*/


        }catch (IOException | InterruptedException e) {System.out.println("[Error] : " + e);}

    }
    public void start () {
        try {
            ms.setLocationRelativeTo(null);
            ms.setVisible(true);
            p = Runtime.getRuntime().exec(runCommand,envp,file);
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
            ms.setVisible(false);

        }catch (IOException | InterruptedException e) {System.out.println(e);}

        System.out.println("File Saved from most recent run : " + lastFileModified());
    }
    public File lastFileModified() {
        File fl = new File(file + "/photos");
       // System.out.println(fl);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
             //   System.out.println(file);
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;

        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastMod) {
                    choice = file;
                    lastMod = file.lastModified();
                }
            }
        }
        System.out.println("choice.getName() = " + choice.getName());
        return choice;
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