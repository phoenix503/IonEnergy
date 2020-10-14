package com.suite.ionenergy.models;

import java.util.ArrayList;

public class MovieListClass {
    private String page;

    private ArrayList<MoviesListModel> results;

    private String status_message;

    private  String status_code;

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public ArrayList<MoviesListModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<MoviesListModel> results) {
        this.results = results;
    }
}
