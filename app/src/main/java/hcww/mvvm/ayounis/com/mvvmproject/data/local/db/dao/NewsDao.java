package hcww.mvvm.ayounis.com.mvvmproject.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;

/**
 * Created by Ahmed Younis on 7/10/2019.
 */
@Dao
public interface NewsDao {
@Query("SELECT * FROM `news.db`")
    List<Articles> getAllNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Articles> articlesList);
}
