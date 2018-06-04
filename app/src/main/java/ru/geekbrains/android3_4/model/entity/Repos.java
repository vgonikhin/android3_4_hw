package ru.geekbrains.android3_4.model.entity;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Repos {
    @Expose
    List<String> name;

    public List<String> getRepos(){
        return name;
    }

}
