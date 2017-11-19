/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author Otto
 */
public class Info {
    
    private String _id;
    private String name;
    private String term;
    private String url;
    private int week;
    private int[] exercises;
    
    
    public void setId(String _id){
        this._id = _id;
    }
    
    public void setName (String name){
        this.name = name;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public String getUrl() {
        return url;
    }

    public int getWeek() {
        return week;
    }

    public int[] getExercises() {
        return exercises;
    }
    
    
}
