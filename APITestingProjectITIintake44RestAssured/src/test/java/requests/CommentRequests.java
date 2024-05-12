package requests;

import io.restassured.RestAssured;

import models.comment.CreateCommentRequestBodyModel;
import models.comment.CreateCommentResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import models.user.GetUserWithInvalidIDResponseBodyModel;

import static utils.Constants.*;

public class CommentRequests {

    public static CreateCommentResponseBodyModel createComment(CreateCommentRequestBodyModel createCommentRequest, int status){
        return RestAssured.
                given().
                    headers(generateHeaders()).
                    body(createCommentRequest).
                 post(baseurl + commentsendpoint).then().log().all().statusCode(status).extract().as(CreateCommentResponseBodyModel.class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel[] createCommentWithInvalidFields(CreateCommentRequestBodyModel createCommentRequest, int status){
        return RestAssured.
                given().log().all().
                headers(generateHeaders()).body(createCommentRequest).
        post(baseurl + commentsendpoint).then().log().all().statusCode(status).extract().as(CreateUserWithInvalidFieldsResponseBodyModel[].class);
    }
    public static CreateCommentResponseBodyModel getCommentWithValidID(String commentId, int status){
        return RestAssured.
                given().
                    headers(generateHeaders()).log().ifValidationFails().get(baseurl+commentsendpoint+commentId).then().statusCode(status).extract().as(CreateCommentResponseBodyModel .class);
    }
    public static GetUserWithInvalidIDResponseBodyModel getCommentWithInvalidID(String commentId, int status){
        return RestAssured.
                given().log().all().
                headers(generateHeaders()).
                get(baseurl + commentsendpoint+commentId).then().log().all().statusCode(status).extract().as(GetUserWithInvalidIDResponseBodyModel.class);
    }
    public static void deleteValidComment(String commentId,int status){
      RestAssured.
             given().log().ifValidationFails().
             headers(generateHeaders()).delete(baseurl+commentsendpoint+commentId).then().statusCode(status);
    }
    public static GetUserWithInvalidIDResponseBodyModel deleteInvalidComment(String commentId, int status){
        return RestAssured.
                given().log().ifValidationFails().
                headers(generateHeaders()).delete(baseurl+commentsendpoint+commentId).then().statusCode(status).extract().as(GetUserWithInvalidIDResponseBodyModel.class);
    }
    public static CreateCommentResponseBodyModel putCommentWithValidID(String commentID,int status,CreateCommentRequestBodyModel createCommentRequestBodyModel){
        return RestAssured
                .given().log().ifValidationFails()
                .headers(generateHeaders())
                .body(createCommentRequestBodyModel)
                .put(baseurl+commentsendpoint+commentID)
                .then().statusCode(status).extract().as(CreateCommentResponseBodyModel.class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel[]putCommentWithInvalidFieldsResponseBodyModel(String commentID, int status, CreateCommentRequestBodyModel createCommentRequestBodyModel){
        return RestAssured
                .given().log().ifValidationFails()
                .headers(generateHeaders())
                .body(createCommentRequestBodyModel)
                .put(baseurl+commentsendpoint+commentID)
                .then().statusCode(status).extract().as(CreateUserWithInvalidFieldsResponseBodyModel[].class);
    }

}


