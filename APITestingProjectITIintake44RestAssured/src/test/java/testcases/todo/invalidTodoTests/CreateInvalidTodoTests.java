package testcases.todo.invalidTodoTests;

import models.todo.CreateTodoRequestBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.TodoRequests.createTodoWithInvalidFieldsResponseBodyModel;
import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class CreateInvalidTodoTests {
    private String useremail=generateEmail();

    String userID="";

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreateTodoRequestBodyModel createTodoRequestBodyModel=new CreateTodoRequestBodyModel();

    CreateUserWithInvalidFieldsResponseBodyModel[]createTodoWithInvalidFieldsResponseBodyModel;
    @BeforeClass
    public void setup() {
        createUserRequestBodyModel=new CreateUserRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(useremail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel  =createuser(createUserRequestBodyModel,201);
        userID =createUserResponseBodyModel.getId();
    }
    @Test
    public void createTodoWithInvalidFieldsTest() {
        SoftAssert softAssert=new SoftAssert();
        createTodoRequestBodyModel.setUser_id(userID);
        createTodoRequestBodyModel.setTitle("API testing");
        createTodoRequestBodyModel.setStatus("");
        createTodoRequestBodyModel.setDue_on("2024-05-08T00:00:00.000+05:30");

        createTodoWithInvalidFieldsResponseBodyModel=createTodoWithInvalidFieldsResponseBodyModel(createTodoRequestBodyModel,422);
        softAssert.assertEquals(createTodoWithInvalidFieldsResponseBodyModel[0].getField(),"status","field is not correct");
        softAssert.assertEquals(createTodoWithInvalidFieldsResponseBodyModel[0].getMessage(),"can't be blank, can be pending or completed");
        softAssert.assertAll();
    }
    @AfterClass
   public void clear(){

        deleteUser(userID);

    }


}
