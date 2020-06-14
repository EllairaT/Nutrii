package nutrii.application.model;

import nutrii.application.model.Meal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates reports for each user
 * @author Blake & Ellaira
 */
public class Report {

    private Nutrii nutrii;
    private LocalDate today;
    private String userFile;

    public Report(Nutrii n) {
        nutrii = n;
        today = LocalDate.now();
        userFile = "usrrpt/" + nutrii.getCurrentUser().getName() + "-rpt.txt";
    }

    /**
     * creates a report file for each user.
     * if the directory for reports is not found, 
     * one is created and the report is also created.
     */
    public void createUserReport() {
        File file = new File(userFile);
        file.getParentFile().mkdirs(); //if directory already exists, it does nothing so no need to use .exists(). 
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * goes to the user's report and finds the meals with today's date.
     * @return an arraylist of meals 
     */
    public ArrayList<Meal> readTodayReport() {
        ArrayList<Meal> mealReport = new ArrayList<>();
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            
//            while ((line = reader.readLine()) != null) {
//                String[] s = line.split(",");
//                if(today.toString().equals(s[0])){
//                    mealReport.add(new Meal(line));  
//                }
//            }

        } catch (FileNotFoundException e) {
            createUserReport();
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
        return mealReport;
    }

    /**
     * writes each meal to report file
     * @param m Meal object to write to file
     */
    public void writeToReport(Meal m) {
        try (FileWriter fw = new FileWriter(userFile, true)) {
            fw.write(m.writeMeal() + "\n");
        } catch (IOException ex) {
            //if the user's file does not exist, make the file
            createUserReport(); 
            //and then call this method again to write the meal to the report
            writeToReport(m);
        }
    }
}
