package ru.geekbrains.android3_4.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.geekbrains.android3_4.R;
import ru.geekbrains.android3_4.model.entity.Repository;
import ru.geekbrains.android3_4.model.image.IImageLoader;
import ru.geekbrains.android3_4.model.image.android.GlideImageLoader;
import ru.geekbrains.android3_4.model.image.android.PicassoImageLoader;
import ru.geekbrains.android3_4.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView
{
    @BindView(R.id.iv_avatar)
    ImageView avatarImageView;

    @BindView(R.id.tv_username)
    TextView usernameTextView;

    @BindView(R.id.lv_repos)
    ListView reposListView;

    @InjectPresenter
    MainPresenter presenter;

    IImageLoader<ImageView> imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageLoader = new PicassoImageLoader();
    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter()
    {
        return new MainPresenter(AndroidSchedulers.mainThread());
    }

    @Override
    public void setUsernameText(String username)
    {
        usernameTextView.setText(username);
    }

    @Override
    public void loadImage(String url)
    {
       imageLoader.loadInto(url, avatarImageView);
    }

    @Override
    public void loadReposList(List<Repository> repos) {
        List<String> reposList = new ArrayList<>();
        for (Repository repo: repos) {
            reposList.add(repo.getName());
        }
        ArrayAdapter<String> adapterSimple = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, reposList);
        reposListView.setAdapter(adapterSimple);
    }


}
