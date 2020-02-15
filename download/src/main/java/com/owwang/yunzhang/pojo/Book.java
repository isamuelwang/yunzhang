package com.owwang.yunzhang.pojo;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * book
 * @author 
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {
    /**
     * 条目的id，自增
     */
    @Id
    private Long id;

    /**
     * 书籍名称
     */
    private String bookname;

    /**
     * 书籍页数
     */
    private Integer bookpage;

    /**
     * 书籍介绍
     */
    private String bookintro;

    /**
     * 书籍url地址
     */
    private String bookurl;

    /**
     * 千牛云url地址
     */
    private String qianniuurl;

    /**
     * 百度云url地址
     */
    private String baiduyunurl;

    private static final long serialVersionUID = 1L;

    public Book(String bookname, Integer bookpage, String bookintro, String bookurl, String qianniuurl, String baiduyunurl) {
        this.bookname = bookname;
        this.bookpage = bookpage;
        this.bookintro = bookintro;
        this.bookurl = bookurl;
        this.qianniuurl = qianniuurl;
        this.baiduyunurl = baiduyunurl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookpage() {
        return bookpage;
    }

    public void setBookpage(Integer bookpage) {
        this.bookpage = bookpage;
    }

    public String getBookintro() {
        return bookintro;
    }

    public void setBookintro(String bookintro) {
        this.bookintro = bookintro;
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl;
    }

    public String getQianniuurl() {
        return qianniuurl;
    }

    public void setQianniuurl(String qianniuurl) {
        this.qianniuurl = qianniuurl;
    }

    public String getBaiduyunurl() {
        return baiduyunurl;
    }

    public void setBaiduyunurl(String baiduyunurl) {
        this.baiduyunurl = baiduyunurl;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}