package com.swych.mobile.db;

import java.util.List;
import com.swych.mobile.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table VERSION.
 */
public class Version {

    private long id;
    /** Not-null value. */
    private String language;
    /** Not-null value. */
    private java.util.Date date;
    /** Not-null value. */
    private String description;
    private long book_id;
    /** Not-null value. */
    private String title;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient VersionDao myDao;

    private Book book;
    private Long book__resolvedKey;

    private List<Sentence> sentences;
    private List<Structure> structure;

    public Version() {
    }

    public Version(long id) {
        this.id = id;
    }

    public Version(long id, String language, java.util.Date date, String description, long book_id, String title) {
        this.id = id;
        this.language = language;
        this.date = date;
        this.description = description;
        this.book_id = book_id;
        this.title = title;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getVersionDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getLanguage() {
        return language;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setLanguage(String language) {
        this.language = language;
    }

    /** Not-null value. */
    public java.util.Date getDate() {
        return date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

    /** Not-null value. */
    public String getDescription() {
        return description;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDescription(String description) {
        this.description = description;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    /** Not-null value. */
    public String getTitle() {
        return title;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTitle(String title) {
        this.title = title;
    }

    /** To-one relationship, resolved on first access. */
    public Book getBook() {
        long __key = this.book_id;
        if (book__resolvedKey == null || !book__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookDao targetDao = daoSession.getBookDao();
            Book bookNew = targetDao.load(__key);
            synchronized (this) {
                book = bookNew;
            	book__resolvedKey = __key;
            }
        }
        return book;
    }

    public void setBook(Book book) {
        if (book == null) {
            throw new DaoException("To-one property 'book_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.book = book;
            book_id = book.getId();
            book__resolvedKey = book_id;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Sentence> getSentences() {
        if (sentences == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SentenceDao targetDao = daoSession.getSentenceDao();
            List<Sentence> sentencesNew = targetDao._queryVersion_Sentences(id);
            synchronized (this) {
                if(sentences == null) {
                    sentences = sentencesNew;
                }
            }
        }
        return sentences;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetSentences() {
        sentences = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Structure> getStructure() {
        if (structure == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StructureDao targetDao = daoSession.getStructureDao();
            List<Structure> structureNew = targetDao._queryVersion_Structure(id);
            synchronized (this) {
                if(structure == null) {
                    structure = structureNew;
                }
            }
        }
        return structure;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetStructure() {
        structure = null;
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

}
