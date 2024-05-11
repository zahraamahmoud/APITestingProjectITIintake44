package testcases.post.validPostTests;

import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static org.testng.Assert.assertNotNull;
import static requests.PostRequests.*;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;

public class UpdatePostWithValidFieldsUsingPutTests {

    String user_id="";
    private String useremail=generateEmail();

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostRequestBodyModel createPostRequestBodyModel;
    CreatePostRequestBodyModel updatePostRequestBodyModel;

    CreatePostResponseBodyModel createPostResponseBodyModel;
    CreatePostResponseBodyModel updatePostResponseBodyModel;


    @BeforeMethod
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
    public void updatetheBodyofPostTest() {
        SoftAssert softAssert=new SoftAssert();
        updatePostRequestBodyModel=new CreatePostRequestBodyModel();
        updatePostRequestBodyModel.setUser_id(user_id);
        updatePostRequestBodyModel.setTitle("restassred course");
        updatePostRequestBodyModel.setBody("this course for automation api testing");
        updatePostResponseBodyModel= updatePostUsingPUT(updatePostRequestBodyModel,createPostResponseBodyModel.getId(),200);
        assertNotNull(createPostResponseBodyModel.getId());
        softAssert.assertEquals(createPostResponseBodyModel.getUser_id(),createPostRequestBodyModel.getUser_id());
        softAssert.assertEquals(createPostResponseBodyModel.getBody(),createPostRequestBodyModel.getBody());

        softAssert.assertAll();

    }
    @Test
    public void updatetheTitleofPostTest() {
        SoftAssert softAssert=new SoftAssert();
        updatePostRequestBodyModel=new CreatePostRequestBodyModel();
        updatePostRequestBodyModel.setUser_id(user_id);
        updatePostRequestBodyModel.setTitle("My second API course");
        createPostRequestBodyModel.setBody("this course for api testing");
        updatePostResponseBodyModel= updatePostUsingPUT(updatePostRequestBodyModel,createPostResponseBodyModel.getId(),200);
        assertNotNull(createPostResponseBodyModel.getId());
        softAssert.assertEquals(createPostResponseBodyModel.getUser_id(),createPostRequestBodyModel.getUser_id());
        softAssert.assertEquals(createPostResponseBodyModel.getTitle(),createPostRequestBodyModel.getTitle());

        softAssert.assertAll();

    }
    @AfterMethod
    public void teardown(){
        deletePost(createPostResponseBodyModel.getId(),204);
        deleteUser(user_id);
    }

}
