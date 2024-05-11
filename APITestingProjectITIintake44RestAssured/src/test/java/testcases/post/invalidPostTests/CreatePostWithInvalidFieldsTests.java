package testcases.post.invalidPostTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.post.CreatePostRequestBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.PostRequests.createPostwithinvaliddata;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;

public class CreatePostWithInvalidFieldsTests {

    String user_id="";
    private String useremail=generateEmail();

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreatePostRequestBodyModel createPostRequestBodyModel=new CreatePostRequestBodyModel();
    CreateUserWithInvalidFieldsResponseBodyModel[]responselist;
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


    }
    @Test
    public void creatPostswithinvaliduseridTests() throws JsonProcessingException {
        SoftAssert softassert=new SoftAssert();
        createPostRequestBodyModel.setUser_id("43434");
        createPostRequestBodyModel.setTitle("restassred course");
        createPostRequestBodyModel.setBody("this course for api testing");
        responselist=createPostwithinvaliddata(createPostRequestBodyModel,422);
        softassert.assertEquals(responselist[0].getField(),"user","field is not correct");
        softassert.assertEquals(responselist[0].getMessage(),"must exist","message is not correct");
        softassert.assertAll();
    }
    @Test
    public void creatPostswithemptyuseridTests() throws JsonProcessingException {
        SoftAssert softassert=new SoftAssert();
        createPostRequestBodyModel.setUser_id("");
        createPostRequestBodyModel.setTitle("restassred course");
        createPostRequestBodyModel.setBody("this course for api testing");
        responselist=createPostwithinvaliddata(createPostRequestBodyModel,422);
        softassert.assertEquals(responselist[0].getField(),"user","field is not correct");
        softassert.assertEquals(responselist[0].getMessage(),"must exist","message is not correct");
        softassert.assertEquals(responselist[1].getField(),"user_id","field is not correct");
        softassert.assertEquals(responselist[1].getMessage(),"is not a number","message is not correct");
        softassert.assertAll();
    }
    @AfterClass
    public void teardown(){
        deleteUser(user_id);
    }
}
