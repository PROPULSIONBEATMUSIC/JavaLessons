//  Преобразование объекта в json строку, запись json в файл, чтение json из файла
package json.saveSystem;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;
        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;

public class SaveSystem {

    int day;
    int manpower;
    int budget;
    int pollution;
    int rep_gov;
    int rep_civ;
    int rep_wrk;
    int rep_sci;
    int rep_fag;
    int rep_bus;

    public SaveSystem() throws FileNotFoundException {

        this.day = 1;
        this.manpower = 100;
        this.budget = 2000;
        this.pollution = 0;
        this.rep_gov = 5;
        this.rep_civ = 5;
        this.rep_wrk = 5;
        this.rep_sci = 5;
        this.rep_fag = 5;
        this.rep_bus = 5;

    }

    public static void main(String[] args) throws FileNotFoundException {
        SaveSystem saves = new SaveSystem();

        //Saving...
        System.out.println("Saving...");
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        String savedGameJson = GSON.toJson(saves);
        //System.out.println(savedGameJson);
        File save = new File("src/main/resources/save.json");
        PrintWriter pw = new PrintWriter(save);
        pw.println("[" + '\n' + savedGameJson + '\n'+ "]");
        pw.close();

        System.out.println("Saved!");

        //--------------------------------------------

        //Loading...
        System.out.println("Loading...");
        Scanner loadGame = new Scanner(new FileInputStream("src/main/resources/save.json"));
        while (loadGame.hasNextLine()){
            System.out.println(loadGame.nextLine());
        }
    }
}