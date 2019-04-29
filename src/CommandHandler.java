import java.io.*;

public class CommandHandler implements Runnable {

    private String starName;
    private Process p;
    String[] runCommand;
    String[] reRunCommand;
    String[] envp;
    File file;
    String directory;
    mesaScreen ms = new mesaScreen();
    
    public CommandHandler() {
        runCommand = new String[1];
        reRunCommand = new String[1];
        envp = new String[1];
        envp[0] = "";
        runCommand[0] = "./rn";
        reRunCommand[0] = "./re";
    }
    @Override
    public void run() {

        this.start();
    }
    public void reRun() {
        try {
            ms.setVisible(true);
            reRunCommand[0] = "./re " + lastFileModified();
            p = Runtime.getRuntime().exec(reRunCommand,envp,file);
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
    }
    public void start () {
        try {
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
    public String lastFileModified() {
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

        return choice.getName();
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