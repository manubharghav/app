package com.swych.mobile.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.swych.mobile.db.Library;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table LIBRARY.
*/
public class LibraryDao extends AbstractDao<Library, Long> {

    public static final String TABLENAME = "LIBRARY";

    /**
     * Properties of entity Library.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Imageurl = new Property(1, String.class, "imageurl", false, "IMAGEURL");
        public final static Property Mode1 = new Property(2, Boolean.class, "mode1", false, "MODE1");
        public final static Property Mode2 = new Property(3, Boolean.class, "mode2", false, "MODE2");
        public final static Property Book_title = new Property(4, String.class, "book_title", false, "BOOK_TITLE");
        public final static Property Title = new Property(5, String.class, "title", false, "TITLE");
        public final static Property Author = new Property(6, String.class, "author", false, "AUTHOR");
        public final static Property SrcLanguage = new Property(7, String.class, "srcLanguage", false, "SRC_LANGUAGE");
        public final static Property SwychLanguage = new Property(8, String.class, "swychLanguage", false, "SWYCH_LANGUAGE");
        public final static Property SrcVersionId = new Property(9, Long.class, "srcVersionId", false, "SRC_VERSION_ID");
        public final static Property SwychVersionId = new Property(10, Long.class, "swychVersionId", false, "SWYCH_VERSION_ID");
        public final static Property Last_modified_date = new Property(11, java.util.Date.class, "last_modified_date", false, "LAST_MODIFIED_DATE");
    };

    private DaoSession daoSession;

    private Query<Library> version_SrcMappingsQuery;
    private Query<Library> version_SwychMappingsQuery;

    public LibraryDao(DaoConfig config) {
        super(config);
    }
    
    public LibraryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'LIBRARY' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'IMAGEURL' TEXT," + // 1: imageurl
                "'MODE1' INTEGER," + // 2: mode1
                "'MODE2' INTEGER," + // 3: mode2
                "'BOOK_TITLE' TEXT," + // 4: book_title
                "'TITLE' TEXT," + // 5: title
                "'AUTHOR' TEXT," + // 6: author
                "'SRC_LANGUAGE' TEXT," + // 7: srcLanguage
                "'SWYCH_LANGUAGE' TEXT," + // 8: swychLanguage
                "'SRC_VERSION_ID' INTEGER," + // 9: srcVersionId
                "'SWYCH_VERSION_ID' INTEGER," + // 10: swychVersionId
                "'LAST_MODIFIED_DATE' INTEGER);"); // 11: last_modified_date
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_LIBRARY_TITLE_SRC_LANGUAGE_SWYCH_LANGUAGE ON LIBRARY" +
                " (TITLE,SRC_LANGUAGE,SWYCH_LANGUAGE);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'LIBRARY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Library entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String imageurl = entity.getImageurl();
        if (imageurl != null) {
            stmt.bindString(2, imageurl);
        }
 
        Boolean mode1 = entity.getMode1();
        if (mode1 != null) {
            stmt.bindLong(3, mode1 ? 1l: 0l);
        }
 
        Boolean mode2 = entity.getMode2();
        if (mode2 != null) {
            stmt.bindLong(4, mode2 ? 1l: 0l);
        }
 
        String book_title = entity.getBook_title();
        if (book_title != null) {
            stmt.bindString(5, book_title);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(6, title);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(7, author);
        }
 
        String srcLanguage = entity.getSrcLanguage();
        if (srcLanguage != null) {
            stmt.bindString(8, srcLanguage);
        }
 
        String swychLanguage = entity.getSwychLanguage();
        if (swychLanguage != null) {
            stmt.bindString(9, swychLanguage);
        }
 
        Long srcVersionId = entity.getSrcVersionId();
        if (srcVersionId != null) {
            stmt.bindLong(10, srcVersionId);
        }
 
        Long swychVersionId = entity.getSwychVersionId();
        if (swychVersionId != null) {
            stmt.bindLong(11, swychVersionId);
        }
 
        java.util.Date last_modified_date = entity.getLast_modified_date();
        if (last_modified_date != null) {
            stmt.bindLong(12, last_modified_date.getTime());
        }
    }

    @Override
    protected void attachEntity(Library entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Library readEntity(Cursor cursor, int offset) {
        Library entity = new Library( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // imageurl
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // mode1
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // mode2
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // book_title
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // title
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // author
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // srcLanguage
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // swychLanguage
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9), // srcVersionId
            cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10), // swychVersionId
            cursor.isNull(offset + 11) ? null : new java.util.Date(cursor.getLong(offset + 11)) // last_modified_date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Library entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setImageurl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMode1(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setMode2(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setBook_title(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTitle(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAuthor(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSrcLanguage(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setSwychLanguage(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSrcVersionId(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
        entity.setSwychVersionId(cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10));
        entity.setLast_modified_date(cursor.isNull(offset + 11) ? null : new java.util.Date(cursor.getLong(offset + 11)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Library entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Library entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "srcMappings" to-many relationship of Version. */
    public List<Library> _queryVersion_SrcMappings(Long srcVersionId) {
        synchronized (this) {
            if (version_SrcMappingsQuery == null) {
                QueryBuilder<Library> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SrcVersionId.eq(null));
                version_SrcMappingsQuery = queryBuilder.build();
            }
        }
        Query<Library> query = version_SrcMappingsQuery.forCurrentThread();
        query.setParameter(0, srcVersionId);
        return query.list();
    }

    /** Internal query to resolve the "swychMappings" to-many relationship of Version. */
    public List<Library> _queryVersion_SwychMappings(Long swychVersionId) {
        synchronized (this) {
            if (version_SwychMappingsQuery == null) {
                QueryBuilder<Library> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SwychVersionId.eq(null));
                version_SwychMappingsQuery = queryBuilder.build();
            }
        }
        Query<Library> query = version_SwychMappingsQuery.forCurrentThread();
        query.setParameter(0, swychVersionId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getVersionDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getVersionDao().getAllColumns());
            builder.append(" FROM LIBRARY T");
            builder.append(" LEFT JOIN VERSION T0 ON T.'SRC_VERSION_ID'=T0.'_id'");
            builder.append(" LEFT JOIN VERSION T1 ON T.'SWYCH_VERSION_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Library loadCurrentDeep(Cursor cursor, boolean lock) {
        Library entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Version srcVersion = loadCurrentOther(daoSession.getVersionDao(), cursor, offset);
        entity.setSrcVersion(srcVersion);
        offset += daoSession.getVersionDao().getAllColumns().length;

        Version swychVersion = loadCurrentOther(daoSession.getVersionDao(), cursor, offset);
        entity.setSwychVersion(swychVersion);

        return entity;    
    }

    public Library loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Library> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Library> list = new ArrayList<Library>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Library> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Library> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
