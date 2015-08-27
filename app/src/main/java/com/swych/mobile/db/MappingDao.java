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

import com.swych.mobile.db.Mapping;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MAPPING.
*/
public class MappingDao extends AbstractDao<Mapping, Long> {

    public static final String TABLENAME = "MAPPING";

    /**
     * Properties of entity Mapping.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StrMapping = new Property(1, String.class, "strMapping", false, "STR_MAPPING");
        public final static Property Date = new Property(2, java.util.Date.class, "date", false, "DATE");
        public final static Property Version1_id = new Property(3, Long.class, "version1_id", false, "VERSION1_ID");
        public final static Property Version2_id = new Property(4, Long.class, "version2_id", false, "VERSION2_ID");
        public final static Property Library_item_mapping = new Property(5, Long.class, "library_item_mapping", false, "LIBRARY_ITEM_MAPPING");
    };

    private DaoSession daoSession;

    private Query<Mapping> library_SentenceMappingsQuery;

    public MappingDao(DaoConfig config) {
        super(config);
    }
    
    public MappingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MAPPING' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'STR_MAPPING' TEXT," + // 1: strMapping
                "'DATE' INTEGER NOT NULL ," + // 2: date
                "'VERSION1_ID' INTEGER," + // 3: version1_id
                "'VERSION2_ID' INTEGER," + // 4: version2_id
                "'LIBRARY_ITEM_MAPPING' INTEGER);"); // 5: library_item_mapping
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MAPPING'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Mapping entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String strMapping = entity.getStrMapping();
        if (strMapping != null) {
            stmt.bindString(2, strMapping);
        }
        stmt.bindLong(3, entity.getDate().getTime());
 
        Long version1_id = entity.getVersion1_id();
        if (version1_id != null) {
            stmt.bindLong(4, version1_id);
        }
 
        Long version2_id = entity.getVersion2_id();
        if (version2_id != null) {
            stmt.bindLong(5, version2_id);
        }
 
        Long library_item_mapping = entity.getLibrary_item_mapping();
        if (library_item_mapping != null) {
            stmt.bindLong(6, library_item_mapping);
        }
    }

    @Override
    protected void attachEntity(Mapping entity) {
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
    public Mapping readEntity(Cursor cursor, int offset) {
        Mapping entity = new Mapping( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // strMapping
            new java.util.Date(cursor.getLong(offset + 2)), // date
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // version1_id
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // version2_id
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // library_item_mapping
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Mapping entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStrMapping(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDate(new java.util.Date(cursor.getLong(offset + 2)));
        entity.setVersion1_id(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setVersion2_id(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setLibrary_item_mapping(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Mapping entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Mapping entity) {
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
    
    /** Internal query to resolve the "sentenceMappings" to-many relationship of Library. */
    public List<Mapping> _queryLibrary_SentenceMappings(Long library_item_mapping) {
        synchronized (this) {
            if (library_SentenceMappingsQuery == null) {
                QueryBuilder<Mapping> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Library_item_mapping.eq(null));
                library_SentenceMappingsQuery = queryBuilder.build();
            }
        }
        Query<Mapping> query = library_SentenceMappingsQuery.forCurrentThread();
        query.setParameter(0, library_item_mapping);
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
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getLibraryDao().getAllColumns());
            builder.append(" FROM MAPPING T");
            builder.append(" LEFT JOIN VERSION T0 ON T.'VERSION1_ID'=T0.'_id'");
            builder.append(" LEFT JOIN VERSION T1 ON T.'VERSION2_ID'=T1.'_id'");
            builder.append(" LEFT JOIN LIBRARY T2 ON T.'LIBRARY_ITEM_MAPPING'=T2.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Mapping loadCurrentDeep(Cursor cursor, boolean lock) {
        Mapping entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Version nativeVersion = loadCurrentOther(daoSession.getVersionDao(), cursor, offset);
        entity.setNativeVersion(nativeVersion);
        offset += daoSession.getVersionDao().getAllColumns().length;

        Version foreignVersion = loadCurrentOther(daoSession.getVersionDao(), cursor, offset);
        entity.setForeignVersion(foreignVersion);
        offset += daoSession.getVersionDao().getAllColumns().length;

        Library library = loadCurrentOther(daoSession.getLibraryDao(), cursor, offset);
        entity.setLibrary(library);

        return entity;    
    }

    public Mapping loadDeep(Long key) {
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
    public List<Mapping> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Mapping> list = new ArrayList<Mapping>(count);
        
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
    
    protected List<Mapping> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Mapping> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
