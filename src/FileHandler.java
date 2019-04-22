import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    File file;


    public FileHandler (String fileName) {
        file = new File(fileName);
    }
    
    public void ChangeFile(String fileName){
        file = new File(fileName);
    }
    
    public void UpdateFile(String mass, String temperature, String l, String x, String z){
        LinkedList<String> list = new LinkedList();
        Scanner inFile = null;
        FileWriter outFile = null;
        try {
            inFile = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        int index = 0;
        while(inFile.hasNext()){
            String temp = inFile.nextLine();
            temp = temp +  System.lineSeparator();
            list.add(index,temp);
            index++;
        }
        inFile.close();
        //System.out.println("File closed");
        //System.out.println("List size: " + list.size());
        int i = 0;
        while(i< list.size()){
            String temp = list.get(i);
            //System.out.println("I: "+ i + " Temp2: " +temp);
            if(temp.contains("RSP_mass")) {
                if (!mass.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_mass = " + mass + System.lineSeparator());
                    list.set(i, temp);
                }
            }
            else if(temp.contains("RSP_Teff")) {
                if (!temperature.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_Teff = " + temperature + System.lineSeparator());
                    list.set(i, temp);
                }
            }
            else if(temp.contains("RSP_L")) {
                if (!l.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_L = " + l + System.lineSeparator());
                    list.set(i, temp);
                }
            }
            
            else if(temp.contains("RSP_X")) {
                if (!x.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_X = " + x + System.lineSeparator());
                    list.set(i, temp);
                }
            }
            else if (temp.contains("RSP_Z")) {
                if (!z.equals("")) {
                    temp = temp.replaceAll(temp, "   RSP_Z = " + z + System.lineSeparator());
                    list.set(i, temp);
                }
            }
            else{}
           i++;
        }
        //System.out.println("List modified");
        try {
            outFile = new FileWriter(file);
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(String s : list){
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
            
            

}
