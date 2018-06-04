package ru.geekbrains.android3_4.model.entity;

import com.google.gson.annotations.Expose;

public class User
{
    @Expose String avatarUrl;
    @Expose String name;
    @Expose String login;
    @Expose String reposUrl;

    public String getAvatarUrl()
    {
        return avatarUrl;
    }

    public String getName(){
        return name;
    }

    public String getLogin()
    {
        return login;
    }

    public String getReposUrl() {
        return reposUrl;
    }
}
