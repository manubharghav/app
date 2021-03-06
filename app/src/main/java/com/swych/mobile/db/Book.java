package com.swych.mobile.db;

import java.util.List;
import com.swych.mobile.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table BOOK.
 */
public class Book {

    private Long id;
    /** Not-null value. */
    private String title;
    private Long author_id;
    private String author_name;
    private java.util.Date last_modified_date;
    private String imageUrl;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BookDao myDao;

    private List<Version> bookVersions;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    public Book(Long id, String title, Long author_id, String author_name, java.util.Date last_modified_date, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author_id = author_id;
        this.author_name = author_name;
        this.last_modified_date = last_modified_date;
        this.imageUrl = imageUrl;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getTitle() {
        return title;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public java.util.Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(java.util.Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Version> getBookVersions() {
        if (bookVersions == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionDao targetDao = daoSession.getVersionDao();
            List<Version> bookVersionsNew = targetDao._queryBook_BookVersions(id);
            synchronized (this) {
                if(bookVersions == null) {
                    bookVersions = bookVersionsNew;
                }
            }
        }
        return bookVersions;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetBookVersions() {
        bookVersions = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
