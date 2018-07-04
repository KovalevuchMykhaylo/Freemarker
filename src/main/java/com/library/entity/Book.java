package com.library.entity;

import com.library.entity.abstractClasses.AbstractNameWithId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends AbstractNameWithId {

    @ManyToMany(mappedBy = "books", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public Book(String name) {
        super(name);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
