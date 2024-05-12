package testcases.todo.validTodoTests;

import models.todo.CreateTodoRequestBodyModel;
import models.todo.CreateTodoResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.TodoRequests.*;
import static requests.UserRequests.*;
import static utils.Constants.generateEmail;

public class GetValidTodoTests {
    private String useremail=generateEmail();
    String userID="";

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreateTodoRequestBodyModel createTodoRequestBodyModel;
    CreateTodoResponseBodyModel createTodoResponseBodyModel;
    CreateTodoResponseBodyModel getTodoResponseBodyModel;
    @BeforeClass
    public void setup() {
        createUserRequestBodyModel=new CreateUserRequestBodyModel();
        createTodoRequestBodyModel=new CreateTodoRequestBodyModel();
        createUserRequestBodyModel.setName(Constants.username);
        createUserRequestBodyModel.setEmail(useremail);
        createUserRequestBodyModel.setGender(Constants.usergender);
        createUserRequestBodyModel.setStatus(Constants.userstatus);
        createUserResponseBodyModel  =createuser(createUserRequestBodyModel,201);
        userID =createUserResponseBodyModel.getId();
        createTodoRequestBodyModel.setUser_id(userID);
        createTodoRequestBodyModel.setTitle("API testing");
        createTodoRequestBodyModel.setStatus("completed");
        createTodoRequestBodyModel.setDue_on("2024-05-08T00:00:00.000+05:30");
        createTodoResponseBodyModel=createTodo(createTodoRequestBodyModel,201);
    }
    @Test
    public void getTodoWithValidDate(){
        SoftAssert softAssert=new SoftAssert();
        getTodoResponseBodyModel = getTodoWithValidID(createTodoResponseBodyModel.getId(), 200);
        softAssert.assertEquals(getTodoResponseBodyModel.getTitle(),createTodoResponseBodyModel.getTitle(),"title is incorrect ");

        softAssert.assertEquals(getTodoResponseBodyModel.getStatus(),createTodoResponseBodyModel.getStatus(),"status is incorrect");
        softAssert.assertAll();
    }
    @AfterClass
    public void clear(){
        deleteValidTodo(getTodoResponseBodyModel.getId(),204);
        deleteUser(userID);
    }
}
