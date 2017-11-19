package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private int exemax;

    public void setWeek(int week) {
        this.week = week;
    }
    
    public void setHours(int hours){
        this.hours = hours;
    }
    
    public void setExercises(int[] exercises){
        this.exercises = exercises;
    }
    
    public void setExemax(int exemax){
        this.exemax = exemax;
    }

    public int getWeek() {
        return week;
    }
    
    public int getHours(){
        return hours;
    }

    public int getExercisesCount(){
        return exercises.length;
    }
    
    public String exercises(){
        StringBuilder builder = new StringBuilder();
        for (int tehtava : exercises){
            builder.append(tehtava+" ");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "tehtyja tehtavia yhteensa: "+exercises.length+" (maksimi: "+ exemax +"), aikaa kului: "+hours+" tuntia, tehdyt tehtavat: "+exercises();
    }
    
}