package com.archive.solution.assesment.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "AddUI")
public class AddUI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String image;
    private String publicURL;
    private String authors;
    private Date article;
    private Date expiry;
    private String access;
    private String pdf;

    public AddUI( String title, String description, String access, Date article, String authors, Date expiry, String image, String pdf, String publicURL) {
        this.title = title;
        this.description = description;
        this.access = access;
        this.article = article;
        this.authors = authors;
        this.expiry = expiry;
        this.image = image;
        this.pdf = pdf;
        this.publicURL = publicURL;
    }

    public AddUI() {};

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Date getArticle() {
        return article;
    }

    public void setArticle(Date article) {
        this.article = article;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getPublicURL() {
        return publicURL;
    }

    public void setPublicURL(String publicURL) {
        this.publicURL = publicURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
