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

public class Book{
    
    private long id;
    private String title;
    private String isbn_issn;
    private String note;
    private int publisher_id;
    private int author_id;
    private String image_path;
    private Date input_date;
    private Date last_data_update;
    private int stock;
    private String book_location;

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getBook_location() {
        return book_location;
    }

    public void setBook_location(String book_location) {
        this.book_location = book_location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Date getInput_date() {
        return input_date;
    }

    public void setInput_date(Date input_date) {
        this.input_date = input_date;
    }

    public Date getLast_data_update() {
        return last_data_update;
    }

    public void setLast_data_update(Date last_data_update) {
        this.last_data_update = last_data_update;
    } 
    
    public String getIsbn_issn() {
        return isbn_issn;
    }

    public void setIsbn_issn(String isbn_issn) {
        this.isbn_issn = isbn_issn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(long id, String title, String isbn_issn, String note, int publisher_id, int author_id, String image_path, Date input_date, Date last_data_update, int stock, String book_location) {
        this.id = id;
        this.title = title;
        this.isbn_issn = isbn_issn;
        this.note = note;
        this.publisher_id = publisher_id;
        this.author_id = author_id;
        this.image_path = image_path;
        this.input_date = input_date;
        this.last_data_update = last_data_update;
        this.stock = stock;
        this.book_location = book_location;
    }
    
    
    
    public Book() {
    }
    
    
}
