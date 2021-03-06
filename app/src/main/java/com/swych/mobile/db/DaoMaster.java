package com.swych.mobile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import com.swych.mobile.db.BookDao;
import com.swych.mobile.db.VersionDao;
import com.swych.mobile.db.LibraryDao;
import com.swych.mobile.db.BookmarkDao;
import com.swych.mobile.db.SentenceDao;
import com.swych.mobile.db.StructureDao;
import com.swych.mobile.db.PhraseReplacementDao;
import com.swych.mobile.db.MappingDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        BookDao.createTable(db, ifNotExists);
        VersionDao.createTable(db, ifNotExists);
        LibraryDao.createTable(db, ifNotExists);
        BookmarkDao.createTable(db, ifNotExists);
        SentenceDao.createTable(db, ifNotExists);
        StructureDao.createTable(db, ifNotExists);
        PhraseReplacementDao.createTable(db, ifNotExists);
        MappingDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        BookDao.dropTable(db, ifExists);
        VersionDao.dropTable(db, ifExists);
        LibraryDao.dropTable(db, ifExists);
        BookmarkDao.dropTable(db, ifExists);
        SentenceDao.dropTable(db, ifExists);
        StructureDao.dropTable(db, ifExists);
        PhraseReplacementDao.dropTable(db, ifExists);
        MappingDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(BookDao.class);
        registerDaoClass(VersionDao.class);
        registerDaoClass(LibraryDao.class);
        registerDaoClass(BookmarkDao.class);
        registerDaoClass(SentenceDao.class);
        registerDaoClass(StructureDao.class);
        registerDaoClass(PhraseReplacementDao.class);
        registerDaoClass(MappingDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
