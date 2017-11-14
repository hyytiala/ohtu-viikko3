package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;

    public void setWeek(int week) {
        this.week = week;
    }
    
    public void setHours(int hours){
        this.hours = hours;
    }
    
    public void setExercises(int[] exercises){
        this.exercises = exercises;
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

    @Override
    public String toString() {
        return "viikko "+week+ ": ";
    }
    
}