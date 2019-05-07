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
    File file;
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
        this.start();
    }

    public void reRun() {
        try {
            // ms.setVisible(true);
            lastFile = lastFileModified();
            p = Runtime.getRuntime().exec(reRunCommand[0] + " " + lastFile.getName(), envp, file);
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
            //ms.setVisible(true);
            p = Runtime.getRuntime().exec(runCommand, envp, file);
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
        File fl = new File(file + "/photos");
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
