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

import static requests.PostRequests.*;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;


public class GetPostWithValidIDTests {

    String user_id = "";
    private String useremail=generateEmail();

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostRequestBodyModel createPostRequestBodyModel = new CreatePostRequestBodyModel();
    CreatePostResponseBodyModel createPostResponseBodyModel;
    CreatePostResponseBodyModel getPostResponseBodyModel;





    @BeforeClass
    public void setup() {
        createPostRequestBodyModel = new CreatePostRequestBodyModel();
        createUserRequestBodyModel=new CreateUserRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(useremail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel  =createuser(createUserRequestBodyModel,201);
        user_id=createUserResponseBodyModel.getId();
        createPostRequestBodyModel.setUser_id(user_id);
        createPostRequestBodyModel.setTitle("restassred course");
        createPostRequestBodyModel.setBody("this course for api testing");
        createPostResponseBodyModel = createPost(createPostRequestBodyModel, 201);

    }
    @Test
    public void getPostWithPostIDTest(){
        SoftAssert softAssert=new SoftAssert();
        getPostResponseBodyModel=getsinglePost(createPostResponseBodyModel.getId(),200);
        softAssert.assertEquals(getPostResponseBodyModel.getId(),createPostResponseBodyModel.getId(),"id is not as expected");
        softAssert.assertEquals(getPostResponseBodyModel.getUser_id(),createPostResponseBodyModel.getUser_id());
        softAssert.assertAll();
    }
    @AfterClass
    public void teardown(){
        deletePost(createPostResponseBodyModel.getId(),204);
        deleteUser(user_id);
    }

}