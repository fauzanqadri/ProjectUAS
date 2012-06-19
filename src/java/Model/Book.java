/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;



/**
 *
 * @author fauzan
 */

public class Book{
    
    private Long id;
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
    private Author author;
    private Publisher publisher;
    private Set<Category> categories = new HashSet<Category>(0);

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    
    public Book() {
    }

    public Book(String title, String isbn_issn, String note, String image_path, Date input_date, Date last_data_update, int stock, String book_location, Author author, Publisher publisher) {
        this.title = title;
        this.isbn_issn = isbn_issn;
        this.note = note;
        this.image_path = image_path;
        this.input_date = input_date;
        this.last_data_update = last_data_update;
        this.stock = stock;
        this.book_location = book_location;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String title, String isbn_issn, String note, String image_path, Date input_date, Date last_data_update, int stock, String book_location, Author author, Publisher publisher, Set<Category> categories) {
        this.title = title;
        this.isbn_issn = isbn_issn;
        this.note = note;
        this.image_path = image_path;
        this.input_date = input_date;
        this.last_data_update = last_data_update;
        this.stock = stock;
        this.book_location = book_location;
        this.author = author;
        this.publisher = publisher;
        this.categories = categories;
    }

    
    
    
}
