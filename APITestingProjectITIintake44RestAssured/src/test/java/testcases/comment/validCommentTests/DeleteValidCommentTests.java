package testcases.comment.validCommentTests;

import models.comment.CreateCommentRequestBodyModel;
import models.comment.CreateCommentResponseBodyModel;
import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.CommentRequests.*;
import static requests.PostRequests.createPost;
import static requests.PostRequests.deletePost;
import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class DeleteValidCommentTests {
    private String userEmail=generateEmail();

    String userID="";
    String postID="";
    String commentID="";
    int random=(int)(Math.random()*500);
    CreatePostRequestBodyModel createPostRequestBodyModel;

    CreateCommentRequestBodyModel createCommentRequestBodyModel;
    CreateCommentResponseBodyModel createCommentResponseBodyModel;
    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostResponseBodyModel createPostResponseBodyModel;

    GetUserWithInvalidIDResponseBodyModel getUserWithInvalidIDResponseBodyModel;


    @BeforeClass
    public void setup() {
        createPostRequestBodyModel = new CreatePostRequestBodyModel();
        createUserRequestBodyModel = new CreateUserRequestBodyModel();
        createCommentRequestBodyModel=new CreateCommentRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(userEmail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel = createuser(createUserRequestBodyModel, 201);
        userID= createUserResponseBodyModel.getId();
        createPostRequestBodyModel.setUser_id(userID);
        createPostRequestBodyModel.setTitle("restassred course");
        createPostRequestBodyModel.setBody("this course for api testing");
        createPostResponseBodyModel = createPost(createPostRequestBodyModel, 201);
        postID= createPostResponseBodyModel.getId();
        createCommentRequestBodyModel.setPost_id(postID);
        createCommentRequestBodyModel.setEmail(random+"sollo@yahoo.com");
        createCommentRequestBodyModel.setName("sollo");
        createCommentRequestBodyModel.setBody("we are about to finish");
        createCommentResponseBodyModel=createComment(createCommentRequestBodyModel,201);
        commentID=createCommentResponseBodyModel.getId();
    }


    @Test
    public void deleteCommentWithValidIDTest(){
        SoftAssert softAssert=new SoftAssert();
        deleteValidComment(commentID,204);
        getUserWithInvalidIDResponseBodyModel= getCommentWithInvalidID(commentID,404);
        softAssert.assertEquals(getUserWithInvalidIDResponseBodyModel.getMessage(),"Resource not found","not as expected");
        softAssert.assertAll();
    }

    @AfterClass
    public void clear(){
        deletePost(postID,204);
        deleteUser(userID);
    }
}
