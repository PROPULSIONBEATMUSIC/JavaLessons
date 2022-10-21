//  Преобразование объекта в json строку, запись json в файл, чтение json из файла
package json.saveSystem;

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

    public SaveSystem(int day, int manpower, int budget, int pollution, int rep_gov, int rep_civ, int rep_wrk, int rep_sci, int rep_fag, int rep_bus) {
        this.day = day;
        this.manpower = manpower;
        this.budget = budget;
        this.pollution = pollution;
        this.rep_gov = rep_gov;
        this.rep_civ = rep_civ;
        this.rep_wrk = rep_wrk;
        this.rep_sci = rep_sci;
        this.rep_fag = rep_fag;
        this.rep_bus = rep_bus;
    }

}