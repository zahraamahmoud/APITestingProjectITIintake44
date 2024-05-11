package testcases.user.validUserTests;

import io.restassured.response.Response;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class DeleteUserWithValidIDTests {


    String user_id = "";
    private String useremail=generateEmail();

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    GetUserWithInvalidIDResponseBodyModel getUserWithInvalidIDResponseBodyModel;


    @BeforeClass
    public void setup() {
        createUserRequestBodyModel=new CreateUserRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(useremail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel  =createuser(createUserRequestBodyModel,201);
        user_id=createUserResponseBodyModel.getId();
    }
    @Test
    public void deleteUserWithValidIDTest(){
        SoftAssert softAssert=new SoftAssert();
        Response response=deleteUser(user_id);
        softAssert.assertEquals( response.statusCode(),204,"status code is  not as expected");
        getUserWithInvalidIDResponseBodyModel =getUserWithInvalidID(user_id,404);
        softAssert.assertEquals(getUserWithInvalidIDResponseBodyModel.getMessage(),"Resource not found","message is not as expected");
        softAssert.assertAll();
    }

}
