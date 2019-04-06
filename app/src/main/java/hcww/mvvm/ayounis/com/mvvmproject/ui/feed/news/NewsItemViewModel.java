package hcww.mvvm.ayounis.com.mvvmproject.ui.feed.news;

import androidx.databinding.ObservableField;

/**
 * Created by Ahmed Younis on 28/03/19.
 */

public class NewsItemViewModel {

    public final ObservableField<String> content = new ObservableField<>();

    public final ObservableField<String> imageUrl = new ObservableField<>();

    public final ObservableField<String> projectUrl = new ObservableField<>();

    public final ObservableField<String> title = new ObservableField<>();

    public NewsItemViewModel(String imageUrl, String title, String content, String projectUrl) {
        this.imageUrl.set(imageUrl);
        this.title.set(title);
        this.content.set(content);
        this.projectUrl.set(projectUrl);
    }
}
