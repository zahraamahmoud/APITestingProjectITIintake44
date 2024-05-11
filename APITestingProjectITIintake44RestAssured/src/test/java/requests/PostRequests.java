package requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.post.UpdatePostBodyUsingPATCHRequestBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import models.user.GetUserWithInvalidIDResponseBodyModel;
import utils.Constants;

import static io.restassured.RestAssured.given;
import static utils.Constants.*;


public class PostRequests {

    public static CreatePostResponseBodyModel createPost(CreatePostRequestBodyModel createPostRequestBodyModel, int status){
        return   given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(createPostRequestBodyModel)
                .post(baseurl + postendpoint).then().statusCode(status).extract().as(CreatePostResponseBodyModel.class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel[] createPostwithinvaliddata(CreatePostRequestBodyModel createPostRequestBodyModel, int statuscode) throws JsonProcessingException {

        return  given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(createPostRequestBodyModel)
                .post(baseurl + postendpoint).then().log().all().statusCode(statuscode).extract().as(CreateUserWithInvalidFieldsResponseBodyModel[] .class);
    }
    public static CreatePostResponseBodyModel getsinglePost(String postid, int statuscode){

        return  given()
                .headers(generateHeaders()).log().ifValidationFails()
                .get(baseurl + postendpoint+postid).then().statusCode(statuscode).extract().as(CreatePostResponseBodyModel.class);
    }
    public static GetUserWithInvalidIDResponseBodyModel getPostWithInvalidPostID(String postID, int statuscode){

        return  given()
                .headers(generateHeaders()).log().ifValidationFails()
                .get(baseurl + postendpoint+postID).then().statusCode(statuscode).extract().as(GetUserWithInvalidIDResponseBodyModel.class);
    }

    public static CreatePostResponseBodyModel updatePostUsingPUT(CreatePostRequestBodyModel createPostRequestBodyModel,String postID, int statuscode){
        return   given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(createPostRequestBodyModel).
                put(baseurl + postendpoint+postID).then().statusCode(statuscode).extract().as(CreatePostResponseBodyModel.class);
    }
    public static CreatePostResponseBodyModel updatePostUsingPATCH(UpdatePostBodyUsingPATCHRequestBodyModel updatePostBodyUsingPATCHRequestBodyModel, String postID, int statuscode){
        return   given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(updatePostBodyUsingPATCHRequestBodyModel).
                patch(baseurl + postendpoint+postID).then().log().all().statusCode(statuscode).extract().as(CreatePostResponseBodyModel.class);
    }

    public static void deletePost(String postid,int statuscode){

         given().log().ifValidationFails()
                .headers(Constants.generateHeaders())
                .delete(Constants.baseurl+ postendpoint+postid).then().statusCode(statuscode);

    }
    public static GetUserWithInvalidIDResponseBodyModel deletePostWithInvalidID(String postid, int statuscode){

       return given().log().ifValidationFails()
                .headers(Constants.generateHeaders())
                .delete(Constants.baseurl+ postendpoint+postid).then().statusCode(statuscode).extract().as(GetUserWithInvalidIDResponseBodyModel.class);

    }
}
