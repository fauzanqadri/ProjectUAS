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
public class Publisher {
    private long id;
    private String name;
    private String note;
    private Date input_date;
    private Date last_update;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Publisher() {
    }

    public Publisher(String name, String note, Date input_date, Date last_update) {
        this.name = name;
        this.note = note;
        this.input_date = input_date;
        this.last_update = last_update;
    }
    
    
    
    
}
