package testcases.post.validPostTests;

import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static org.testng.Assert.assertNotNull;
import static requests.PostRequests.createPost;
import static requests.PostRequests.deletePost;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;


public class CreatePostWithValidFieldsTests {

    String user_id ="";
    private String useremail=generateEmail();

    CreatePostRequestBodyModel  createPostRequestBodyModel;
    CreatePostResponseBodyModel createPostResponseBodyModel;

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;

    @BeforeClass
    public void setup() {
        createUserRequestBodyModel=new CreateUserRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(useremail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel  =createuser(createUserRequestBodyModel,201);
        user_id =createUserResponseBodyModel.getId();
    }
    @Test
    public void creatPostTest() {
        SoftAssert softAssert=new SoftAssert();
        createPostRequestBodyModel=new CreatePostRequestBodyModel();
        createPostRequestBodyModel.setUser_id(user_id);
        createPostRequestBodyModel.setTitle("restassred course");
        createPostRequestBodyModel.setBody("this course for api testing");
        createPostResponseBodyModel=createPost(createPostRequestBodyModel,201);
        assertNotNull(createPostResponseBodyModel.getId());
        softAssert.assertEquals(createPostResponseBodyModel.getUser_id(),createPostRequestBodyModel.getUser_id());
        softAssert.assertAll();
    }
    @AfterClass
    public void teardown(){
        deletePost(createPostResponseBodyModel.getId(),204);
        deleteUser(user_id);
    }

    }
