package testcases.user.validUserTests;

import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static org.testng.Assert.*;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;

public class CreateUserWithValidFieldsTests {

   // public static   String useremail="restassured"+100*Math.random()+"@yahoo.com"
    private String useremail=generateEmail();
    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;

           @Test
           public void createuserTests() {
               SoftAssert softassert=new SoftAssert();

               createUserRequestBodyModel=new CreateUserRequestBodyModel();
               createUserRequestBodyModel.setName(Constants.username);
               createUserRequestBodyModel.setEmail(useremail);
               createUserRequestBodyModel.setGender(Constants.usergender);
               createUserRequestBodyModel.setStatus(Constants.userstatus);
               createUserResponseBodyModel  =createuser(createUserRequestBodyModel,201);
               assertNotNull(createUserResponseBodyModel.getId(),"id is Null");
               softassert.assertEquals(createUserResponseBodyModel.getName(),createUserRequestBodyModel.getName(),"name  is not as entered");
               softassert.assertEquals(createUserResponseBodyModel.getGender(),createUserRequestBodyModel.getGender(),"gender  is not as entered");
               softassert.assertAll();

           }

    @AfterClass
    public void tear(){
        deleteUser(createUserResponseBodyModel.getId()).prettyPrint();
    }
}
