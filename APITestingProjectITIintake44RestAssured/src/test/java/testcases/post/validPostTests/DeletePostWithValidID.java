package testcases.post.validPostTests;

import models.post.CreatePostRequestBodyModel;
import models.post.CreatePostResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Constants;

import static org.testng.Assert.assertEquals;
import static requests.PostRequests.*;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;

public class DeletePostWithValidID {
    String user_id = "";
    private String useremail=generateEmail();

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostRequestBodyModel createPostRequestBodyModel;
    CreatePostResponseBodyModel createPostResponseBodyModel;
    GetUserWithInvalidIDResponseBodyModel getUserWithInvalidIDResponseBodyModel;


    @BeforeClass
    public void setup() {
        createUserRequestBodyModel=new CreateUserRequestBodyModel();
        createPostRequestBodyModel = new CreatePostRequestBodyModel();
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
    public void deletePostWithValidPostIDTest(){
        deletePost(createPostResponseBodyModel.getId(),204);
        getUserWithInvalidIDResponseBodyModel =getPostWithInvalidPostID(createPostResponseBodyModel.getId(),404);
        assertEquals(getUserWithInvalidIDResponseBodyModel.getMessage(),"Resource not found","message is not as expected");
    }
    @AfterClass
    public void teardown(){
        deleteUser(user_id);
    }
}
