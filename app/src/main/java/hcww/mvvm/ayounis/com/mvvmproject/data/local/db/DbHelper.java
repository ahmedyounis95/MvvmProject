package hcww.mvvm.ayounis.com.mvvmproject.data.local.db;

import java.util.List;

import hcww.mvvm.ayounis.com.mvvmproject.data.model.Articles;
import io.reactivex.Observable;

/**
 * Created by Ahmed Younis on 7/10/2019.
 */
public interface DbHelper {
    Observable<List<Articles>> getAllArticles();



}
