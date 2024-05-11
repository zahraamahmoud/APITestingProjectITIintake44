package testcases.user.validUserTests;

import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.UserRequests.*;
import static utils.Constants.generateEmail;


public class GetUserWithValidIDTests {


    String user_id ="";
    private String useremail=generateEmail();


    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreateUserResponseBodyModel getSingleUserResponseBodyModel;

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
    public void getUserTest(){
        SoftAssert softAssert=new SoftAssert();

        getSingleUserResponseBodyModel =getSingleUser(user_id,200);
        softAssert.assertEquals(getSingleUserResponseBodyModel.getId(),user_id,"id is not as expected");
        softAssert.assertEquals(getSingleUserResponseBodyModel.getName(),createUserRequestBodyModel.getName());
        softAssert.assertAll();
    }

    @AfterClass
    public void teardown(){
     deleteUser(user_id);

}


}
