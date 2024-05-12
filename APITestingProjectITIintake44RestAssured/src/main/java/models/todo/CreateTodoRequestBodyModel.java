package models.todo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTodoRequestBodyModel {
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDue_on() {
        return due_on;
    }

    public void setDue_on(String due_on) {
        this.due_on = due_on;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("user_id")
    private  String user_id="";
    @JsonProperty("title")
    private  String title="";
    @JsonProperty("due_on")
    private  String due_on="";
    @JsonProperty("status")
    private  String status="";



}
