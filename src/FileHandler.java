import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {

    File file = null;
    File periodFile = null;
    String directory;
    String starName;

    LinkedList<dataObject> historyData;


    public void setPath(String path) {
        directory = path;
        periodFile = new File(directory + "/star/inlist_rsp_common");
    }
    public void setText(String text){
        JTextArea textArea = MainGui.mesaTextArea;
        String oldText = textArea.getText();
        textArea.setText(oldText + "\n" + text);
    }
/*
    public FileHandler(String fileName) {
        file = new File(directory + "/star/test_suite/" + fileName);
    }
*/
    public void ChangeFile(String fileName) {
        file = new File(directory + "/star/test_suite/" + fileName);
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public void UpdatePeriods(String periods) {
    LinkedList<String> plist = new LinkedList();
    Scanner inPFile = null;
    FileWriter outPFile = null;
   // System.out.println("1");
    try {
        inPFile = new Scanner(periodFile);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    int pindex = 0;
    while (inPFile.hasNext()) {
        String ptemp = inPFile.nextLine();
        ptemp = ptemp + System.lineSeparator();
        plist.add(pindex, ptemp);
        pindex++;
       // System.out.println(pindex);
    }

    inPFile.close();

    //System.out.println("List size: " + list.size());
    int i = 0;
    while (i < plist.size()) {
        String temp = plist.get(i);
        //System.out.println("I: "+ i + " Temp2: " +temp);
        if (temp.contains("RSP_max_num_periods = ")) {
            if (!periods.equals("")) {
                temp = temp.replaceAll(temp, "         RSP_max_num_periods = " + periods + System.lineSeparator());
                plist.set(i, temp);
                setText("Periods set to : " + periods);
            }
        }
        i++;
    }

    try {
        outPFile = new FileWriter(periodFile);
    } catch (IOException ex) {
        Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
    }

    for(String s : plist){
        try {
            outPFile.write(s);
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    try {
        outPFile.close();
    } catch (IOException ex) {
        Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public void UpdateFile(String exptText,String checkText, String mass, String temperature, String l, String x, String z) {
        LinkedList<String> list = new LinkedList();
        Scanner inFile = null;
        FileWriter outFile = null;
        try {
            inFile = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        int index = 0;
        while (inFile.hasNext()) {
            String temp = inFile.nextLine();
            temp = temp + System.lineSeparator();
            list.add(index, temp);
            index++;
        }
        inFile.close();
        //System.out.println("File closed");
        //System.out.println("List size: " + list.size());
        int i = 0;
        while (i < list.size()) {
            String temp = list.get(i);
            //System.out.println("I: "+ i + " Temp2: " +temp);
            if (temp.contains("RSP_mass")) {
                if (!mass.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_mass = " + mass + System.lineSeparator());
                    list.set(i, temp);
                    setText("Mass set to : " + mass);
                }
            } else if (temp.contains("RSP_Teff")) {
                if (!temperature.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_Teff = " + temperature + System.lineSeparator());
                    list.set(i, temp);
                    setText("Temp set to : " + temperature);
                }
            } else if (temp.contains("RSP_L")) {
                if (!l.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_L = " + l + System.lineSeparator());
                    list.set(i, temp);
                    setText("L set to : " + l);
                }
            } else if (temp.contains("RSP_X")) {
                if (!x.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_X = " + x + System.lineSeparator());
                    list.set(i, temp);
                    setText("X set to : " + x);
                }
            } else if (temp.contains("RSP_Z")) {
                if (!z.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_Z = " + z + System.lineSeparator());
                    list.set(i, temp);
                    setText("Z set to : " + z);
                }
            } else if (temp.contains("x_integer_ctrl(1) = ")) {
                if (!checkText.equals("")) {
                    temp = temp.replaceAll(temp, "         x_integer_ctrl(1) = " + checkText + " ! which period to check " + System.lineSeparator());
                    list.set(i, temp);
                    setText("Period to check set to : " + checkText);
                }
            } else if (temp.contains("x_ctrl(1) = ")) {
                if (!exptText.equals("")) {
                    temp = temp.replaceAll(temp, "         x_integer_ctrl(1) = " + exptText + " ! expected period (in days) " + System.lineSeparator());
                    list.set(i, temp);
                    setText("Expected Period set to : " + exptText);
                }
            }  else {
            }
            i++;
        }
        //System.out.println("List modified");
        try {
            outFile = new FileWriter(file);
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String s : list) {
            try {
                outFile.write(s);
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            outFile.close();
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public LinkedList<dataObject> ParseHistory() {
        File history;
        Scanner in;
        historyData = new LinkedList();
        try {
           // history = new File("history.data"); //todo: Update to real file path
            history = new File(directory + "/star/test_suite/" + starName + "/LOGS/history.data");
           // System.out.println("\n\nhistory = " + history);
            in = new Scanner(history);

            if (in.hasNext()){
                for (int i = 0; i < 81; i++) {
                    //System.out.println(i + " : " + in.next());
                    in.next();
                }
            }
            while (in.hasNext()) {
                dataObject o = new dataObject();
                o.modelNumber = in.next();
                o.starAge= in.next();
                o.starAgeDay= in.next();
                o.rspPhase= in.next();
                o.rspGreekM= in.next();
                o.rspGreekMAA= in.next();
                o.rspDeltaR= in.next(); 
                o.rspDeltaMag= in.next(); 
                o.rspPeriodDays= in.next(); 
                o.rspNumPeriods= in.next();
                o.logDtSec= in.next();
                o.radius= in.next();
                o.logR= in.next();
                o.vSurfKmS= in.next();
                o.vSurfDivEsc= in.next();
                o.vDivSurf= in.next(); 
                o.vDivMax= in.next(); 
                o.maxAbsVDiv= in.next(); 
                o.dtDiv= in.next(); 
                o.luminosity= in.next(); 
                o.logL= in.next(); 
                o.effectiveT= in.next(); 
                o.logG= in.next();
                o.logTeff= in.next();
                o.photosphereL= in.next();
                o.photosphereR= in.next(); 
                o.photosphereT= in.next(); 
                o.photosphereKms= in.next(); 
                o.photosphereDivCs= in.next(); 
                o.numRetries= in.next();
                historyData.add(o);
            }
           // System.out.println("");
           // System.out.println("Printing Data: ");
            //for(dataObject o : historyData){
            //    o.printData();
            //}

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historyData;
    }

}
