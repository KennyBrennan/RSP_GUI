import java.io.*;
import java.util.Map;
import javax.swing.JTextArea;
/**
 *
 * @authors Cj,Kenny,Matt
 *
 */
public class CommandHandler implements Runnable {

    public int command;
    private BufferedReader br;
    private String starName;
    private Process p;
    String[] runCommand;
    String[] reRunCommand;
    String[] envp;
    String directory;
    String s;
    File mesaFile;
    File starPath;
    File lastFile;
    File choice = null;
    JTextArea textArea;
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
        switch (command) {
            case 1:
                this.start();
                break;
            case 2:
                this.reRun();
                break;
        }
      //this.start();
    }

    public void reRun() {
        try {
            System.out.println("\nreRun\n");
            // ms.setVisible(true);
            lastFile = lastFileModified();
            p = Runtime.getRuntime().exec(reRunCommand[0] + " " + lastFile.getName(), envp, starPath);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            while ((s = br.readLine()) != null) {
                //System.out.println("line: " + s);
                setText(s);
            }

            br = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((s = br.readLine()) != null) {
                //System.out.println("line: " + s);
                setText(s);
            }
            p.waitFor();
            // System.out.println("exit: " + p.exitValue());
            p.destroy();
            //ms.setVisible(false);

        } catch (IOException | InterruptedException e) { System.out.println("[Error] : " + e); }
    }

    public void start() {
        try {
            System.out.println("\nrun\n");
            //ms.setVisible(true);
            p = Runtime.getRuntime().exec(runCommand, envp, starPath);
            br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println("line: " + s);
                setText(s);
            }
            br = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            while ((s = br.readLine()) != null) {
                System.out.println("line: " + s);
                setText(s);
            }
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
            //ms.setVisible(false);
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("File Saved from most recent run : " + lastFileModified());
    }

    public File lastFileModified() {
        File fl = new File(starPath+ "/photos");
        // System.out.println(fl);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                //System.out.println(file);
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;

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

    public void setText(String text) {
        textArea = MainGui.mesaTextArea;
        String oldText = textArea.getText();
        textArea.setText(oldText + "\n" + text);
    }

    public void setPath(File mesaFile, String mesaPath) {
        this.mesaFile = mesaFile;
        directory = mesaPath;
        System.out.println("file = " + mesaFile);
        System.out.println("directory = " + directory);
    }

    public void setStarName(String starName) {
        this.starName = starName;
        System.out.println("starName =" + starName);
    }

    public void changeFolder(String starName) {
        //file = new File(directory + "/star/test_suite/" + fileName);
        starPath = new File(directory + "/star/test_suite/" + starName);
        System.out.println("directory = " + directory);
        System.out.println("starName = " + starName);
        System.out.println("starPath = " + starPath);
    }

}