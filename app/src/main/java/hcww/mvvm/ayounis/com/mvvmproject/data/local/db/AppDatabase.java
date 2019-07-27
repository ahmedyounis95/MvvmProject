package hcww.mvvm.ayounis.com.mvvmproject.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import hcww.mvvm.ayounis.com.mvvmproject.data.local.db.dao.NewsDao;
import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import hcww.mvvm.ayounis.com.mvvmproject.di.DatabaseInfo;

/**
 * Created by Ahmed Younis on 7/10/2019.
 */
@Database(entities = Articles.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao NewsDao();
}
