package ru.geekbrains.android3_4.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.geekbrains.android3_4.model.entity.Repository;

public interface MainView extends MvpView
{
    void setUsernameText(String username);
    void loadImage(String url);
    void loadReposList(List<Repository> repos);
}
