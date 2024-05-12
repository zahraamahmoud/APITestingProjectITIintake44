package testcases.comment.invalidCommentTests;

import models.comment.CreateCommentRequestBodyModel;
import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;
import static requests.CommentRequests.createCommentWithInvalidFields;
import static requests.PostRequests.createPost;
import static requests.PostRequests.deletePost;
import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class CreateInvalidCommentsTests {
    private String userEmail=generateEmail();
    String userID="";

    String postID="";
    int random=(int)(Math.random()*500);
    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostRequestBodyModel createPostRequestBodyModel;
    CreatePostResponseBodyModel createPostResponseBodyModel;
    CreateCommentRequestBodyModel createCommentRequestBodyModel=new CreateCommentRequestBodyModel();

    CreateUserWithInvalidFieldsResponseBodyModel[] createWithInvalidFieldsResponseBodyModel;



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
    public void createInvalidCommentTest_emailKeyMissing(){
        createCommentRequestBodyModel=new CreateCommentRequestBodyModel();
        SoftAssert softAssert=new SoftAssert();
        createCommentRequestBodyModel.setPost_id(postID);
        createCommentRequestBodyModel.setEmail("");
        createCommentRequestBodyModel.setName("Elakshi Embranthiri DC");
        createCommentRequestBodyModel.setBody("Quia ipsa maxime. Sit at illo.");
        createWithInvalidFieldsResponseBodyModel =createCommentWithInvalidFields(createCommentRequestBodyModel,422);


        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[0].getField(),"email","field is not correct");
        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[0].getMessage(),"can't be blank, is invalid","message is not correct");
        softAssert.assertAll();
    }
    @Test
    public void createInvalidCommentTest_withInvalidPostID(){
        createCommentRequestBodyModel=new CreateCommentRequestBodyModel();
        SoftAssert softAssert=new SoftAssert();
        createCommentRequestBodyModel.setPost_id("789");
        createCommentRequestBodyModel.setEmail("gfdgf@hhjk.com");
        createCommentRequestBodyModel.setName("Elakshi Embranthiri DC");
        createCommentRequestBodyModel.setBody("Quia ipsa maxime. Sit at illo.");
        createWithInvalidFieldsResponseBodyModel =createCommentWithInvalidFields(createCommentRequestBodyModel,422);


        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[0].getField(),"post","field is not correct");
        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[0].getMessage(),"must exist","message is not correct");

        softAssert.assertAll();
    }
    @Test
    public void createInvalidCommentTest_withEmptyPostID(){
        createCommentRequestBodyModel=new CreateCommentRequestBodyModel();
        SoftAssert softAssert=new SoftAssert();
        createCommentRequestBodyModel.setPost_id("");
        createCommentRequestBodyModel.setEmail("gfdgf@hhjk.com");
        createCommentRequestBodyModel.setName("Elakshi Embranthiri DC");
        createCommentRequestBodyModel.setBody("Quia ipsa maxime. Sit at illo.");
        createWithInvalidFieldsResponseBodyModel =createCommentWithInvalidFields(createCommentRequestBodyModel,422);
        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[0].getField(),"post","field is not correct");
        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[0].getMessage(),"must exist","message is not correct");
        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[1].getField(),"post_id","field is not correct");
        softAssert.assertEquals(createWithInvalidFieldsResponseBodyModel[1].getMessage(),"is not a number","message is not correct");
        softAssert.assertAll();
    }
    @AfterClass
    public void clear(){
        deletePost(postID,204);
        deleteUser(userID);
    }
}
