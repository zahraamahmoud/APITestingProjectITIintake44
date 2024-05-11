package utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static   String baseurl="https://gorest.co.in/public/v2/";
    public static   String userendpoint="users/";

    public static   String postendpoint="posts/";
    public static String commentsendpoint="comments/";
    public static String todosendpoint="todos/";


    public static   String username="aysha";
    public static   String usernewEmail=generateEmail();

    public static   String usergender="female";
    public static   String userstatus="active";
    public static Map<String,String> generateHeaders(){
        Map<String,String> headers=new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Authorization", "Bearer 696c4a039592e32298d31d6014b4f6f5601236a974851580d7133680b24041cf");
        return headers;

    }
    public  static String generateEmail(){
        return ("restassured"+100*Math.random()+"@yahoo.com");
    }
}
