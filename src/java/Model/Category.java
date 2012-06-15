/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author fauzan
 */
public class Category {
    private int id;
    private String name;
    private Date input_date;
    private Date last_update;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInput_date() {
        return input_date;
    }

    public void setInput_date(Date input_date) {
        this.input_date = input_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Category(String name, Date input_date, Date last_update, String note) {
        this.name = name;
        this.input_date = input_date;
        this.last_update = last_update;
        this.note = note;
    }

    public Category() {
    }
    
    
    
}