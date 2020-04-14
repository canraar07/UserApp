package com.andi.userapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Problem {
    @SerializedName("result")
    List<ObjectProblem> problemList;
    @SerializedName("status")
    String status;

    public List<ObjectProblem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<ObjectProblem> problemList) {
        this.problemList = problemList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
