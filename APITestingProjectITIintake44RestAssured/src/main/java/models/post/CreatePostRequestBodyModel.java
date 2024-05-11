package models.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "user_id",
        "title",
        "body",

})
@Generated("jsonschema2pojo")

public class CreatePostRequestBodyModel {
    @JsonProperty("user_id")
    private String user_id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;

    @JsonProperty("user_id")

    public String getUser_id() {
        return user_id;
    }
    @JsonProperty("user_id")

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    @JsonProperty("title")

    public String getTitle() {
        return title;
    }
    @JsonProperty("title")

    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("body")

    public String getBody() {
        return body;
    }
    @JsonProperty("body")

    public void setBody(String body) {
        this.body = body;
    }



}
