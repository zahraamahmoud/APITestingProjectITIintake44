package testcases.user.validUserTests;

import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static org.testng.Assert.assertNotNull;
import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class UpdateUserWithValidFieldsUsingPutTests {

    String user_id="";
    private String useremail=generateEmail();

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreateUserRequestBodyModel  updateUserRequestBodyModel;
    CreateUserResponseBodyModel updateUserResponseBodyModel;

    @BeforeMethod
    public void setup() {
        createUserRequestBodyModel = new CreateUserRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(useremail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel = createuser(createUserRequestBodyModel, 201);
        user_id = createUserResponseBodyModel.getId();
    }
    @Test
    public void updatetheUserNameTest() {
        SoftAssert softAssert=new SoftAssert();
        updateUserRequestBodyModel=new CreateUserRequestBodyModel();
        updateUserRequestBodyModel.setName("nana");
        updateUserRequestBodyModel.setEmail(createUserRequestBodyModel.getEmail());
        updateUserRequestBodyModel.setGender(createUserRequestBodyModel.getGender());
        updateUserRequestBodyModel.setStatus(createUserRequestBodyModel.getStatus());
        updateUserResponseBodyModel= updateUserUsingPUT(updateUserRequestBodyModel,user_id,200);
        assertNotNull(updateUserResponseBodyModel.getId());
        softAssert.assertEquals(updateUserResponseBodyModel.getName(),updateUserRequestBodyModel.getName());
        softAssert.assertEquals(updateUserResponseBodyModel.getStatus(),updateUserRequestBodyModel.getStatus());
        softAssert.assertAll();

    }
    @Test
    public void updatetheUserEmailTest() {
        SoftAssert softAssert=new SoftAssert();
        updateUserRequestBodyModel=new CreateUserRequestBodyModel();
        updateUserRequestBodyModel.setName(createUserRequestBodyModel.getName());
        updateUserRequestBodyModel.setEmail(Constants.usernewEmail);
        updateUserRequestBodyModel.setGender(createUserRequestBodyModel.getGender());
        updateUserRequestBodyModel.setStatus(createUserRequestBodyModel.getStatus());
        updateUserResponseBodyModel= updateUserUsingPUT(updateUserRequestBodyModel,user_id,200);
        assertNotNull(updateUserResponseBodyModel.getId());
        softAssert.assertEquals(updateUserResponseBodyModel.getEmail(),updateUserRequestBodyModel.getEmail(),"the email is not as expected");
        softAssert.assertEquals(updateUserResponseBodyModel.getStatus(),updateUserRequestBodyModel.getStatus());
        softAssert.assertAll();

    }

    @AfterMethod
    public void teardown(){
        deleteUser(user_id);
    }


    }
