package testcases.user.invalidUserTests;

import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.UserRequests.createUserWithInvalidFields;
import static utils.Constants.generateEmail;

public class CreateUserWithInvalidFieldsTests {

    private String useremail=generateEmail();
    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserWithInvalidFieldsResponseBodyModel[] createUserWithInvalidFieldsResponseBodyModels;

           @Test
           public void validateNameIsNull(){
               SoftAssert softassert=new SoftAssert();
               createUserRequestBodyModel=new CreateUserRequestBodyModel();
               createUserRequestBodyModel.setName("");
               createUserRequestBodyModel.setEmail(useremail);
               createUserRequestBodyModel.setGender(Constants.usergender);
               createUserRequestBodyModel.setStatus(Constants.userstatus);
               createUserWithInvalidFieldsResponseBodyModels  =createUserWithInvalidFields(createUserRequestBodyModel,422);
               softassert.assertEquals(createUserWithInvalidFieldsResponseBodyModels[0].getField(),"name","field is not correct");
               softassert.assertEquals(createUserWithInvalidFieldsResponseBodyModels[0].getMessage(),"can't be blank","error message is not correct");
               softassert.assertAll();

           }
        @Test
        public void validateAllFieldsIsNull(){
            SoftAssert softassert=new SoftAssert();
            String[]fields={ "email","name","gender","status"};
            createUserRequestBodyModel=new CreateUserRequestBodyModel();
            createUserRequestBodyModel.setName("");
            createUserRequestBodyModel.setEmail("");
            createUserRequestBodyModel.setGender("");
            createUserRequestBodyModel.setStatus("");
            createUserWithInvalidFieldsResponseBodyModels=createUserWithInvalidFields(createUserRequestBodyModel,422);


            for(int i=0;i< createUserWithInvalidFieldsResponseBodyModels.length;i++)
           {  softassert.assertEquals(createUserWithInvalidFieldsResponseBodyModels[i].getField(),fields[i],"field is not correct");
           softassert.assertTrue(createUserWithInvalidFieldsResponseBodyModels[i].getMessage().contains("can't be blank"),"error message is not correct");
           }

            softassert.assertAll();

        }

}
