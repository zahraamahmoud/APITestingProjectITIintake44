package testcases.comment.validCommentTests;

import models.comment.CreateCommentRequestBodyModel;
import models.comment.CreateCommentResponseBodyModel;
import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.CommentRequests.createComment;
import static requests.CommentRequests.deleteValidComment;
import static requests.PostRequests.createPost;
import static requests.PostRequests.deletePost;
import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class CreateValidCommentTests {
    private String userEmail=generateEmail();

    String userID="";

    String postID="";
    String commentID="";
    int random=(int)(Math.random()*500);
    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostRequestBodyModel createPostRequestBodyModel;
    CreatePostResponseBodyModel createPostResponseBodyModel;
    CreateCommentRequestBodyModel createCommentRequestBodyModel=new CreateCommentRequestBodyModel();
    CreateCommentResponseBodyModel createCommentResponseBodyModel;




    @BeforeClass
    public void setup() {
        createPostRequestBodyModel = new CreatePostRequestBodyModel();
        createUserRequestBodyModel = new CreateUserRequestBodyModel();
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
    }
    @Test
    public void createCommentTestWithValidValues(){
        SoftAssert softAssert=new SoftAssert();
        createCommentRequestBodyModel.setPost_id(postID);
        createCommentRequestBodyModel.setEmail("jhgj"+random+"@foo.com");
        createCommentRequestBodyModel.setName("hamada");
        createCommentRequestBodyModel.setBody("api is interested");
        createCommentResponseBodyModel=createComment(createCommentRequestBodyModel,201);
        commentID=createCommentResponseBodyModel.getId();
        softAssert.assertEquals(createCommentResponseBodyModel.getName(),createCommentRequestBodyModel.getName());
        softAssert.assertAll();

    }
    @AfterClass
    public void clear(){
        deleteValidComment(commentID,204);
        deletePost(postID,204);
        deleteUser(userID);
    }
}
