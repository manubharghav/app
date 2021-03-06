package com.swych.mobile.db;

import com.swych.mobile.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table BOOKMARK.
 */
public class Bookmark {

    private long id;
    private int mode;
    private int book_position;
    /** Not-null value. */
    private java.util.Date last_modified_date;
    private long version1_id;
    private Long version2_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BookmarkDao myDao;

    private Version nativeVersion;
    private Long nativeVersion__resolvedKey;

    private Version foreignVersion;
    private Long foreignVersion__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Bookmark() {
    }

    public Bookmark(long id) {
        this.id = id;
    }

    public Bookmark(long id, int mode, int book_position, java.util.Date last_modified_date, long version1_id, Long version2_id) {
        this.id = id;
        this.mode = mode;
        this.book_position = book_position;
        this.last_modified_date = last_modified_date;
        this.version1_id = version1_id;
        this.version2_id = version2_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookmarkDao() : null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getBook_position() {
        return book_position;
    }

    public void setBook_position(int book_position) {
        this.book_position = book_position;
    }

    /** Not-null value. */
    public java.util.Date getLast_modified_date() {
        return last_modified_date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setLast_modified_date(java.util.Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public long getVersion1_id() {
        return version1_id;
    }

    public void setVersion1_id(long version1_id) {
        this.version1_id = version1_id;
    }

    public Long getVersion2_id() {
        return version2_id;
    }

    public void setVersion2_id(Long version2_id) {
        this.version2_id = version2_id;
    }

    /** To-one relationship, resolved on first access. */
    public Version getNativeVersion() {
        long __key = this.version1_id;
        if (nativeVersion__resolvedKey == null || !nativeVersion__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionDao targetDao = daoSession.getVersionDao();
            Version nativeVersionNew = targetDao.load(__key);
            synchronized (this) {
                nativeVersion = nativeVersionNew;
            	nativeVersion__resolvedKey = __key;
            }
        }
        return nativeVersion;
    }

    public void setNativeVersion(Version nativeVersion) {
        if (nativeVersion == null) {
            throw new DaoException("To-one property 'version1_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.nativeVersion = nativeVersion;
            version1_id = nativeVersion.getId();
            nativeVersion__resolvedKey = version1_id;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Version getForeignVersion() {
        Long __key = this.version2_id;
        if (foreignVersion__resolvedKey == null || !foreignVersion__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VersionDao targetDao = daoSession.getVersionDao();
            Version foreignVersionNew = targetDao.load(__key);
            synchronized (this) {
                foreignVersion = foreignVersionNew;
            	foreignVersion__resolvedKey = __key;
            }
        }
        return foreignVersion;
    }

    public void setForeignVersion(Version foreignVersion) {
        synchronized (this) {
            this.foreignVersion = foreignVersion;
            version2_id = foreignVersion == null ? null : foreignVersion.getId();
            foreignVersion__resolvedKey = version2_id;
        }
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
