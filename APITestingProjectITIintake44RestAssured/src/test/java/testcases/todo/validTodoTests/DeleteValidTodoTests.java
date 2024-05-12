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

public class DeleteValidTodoTests {
    private String useremail=generateEmail();
    String userID="";

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreateTodoRequestBodyModel createTodoRequestBodyModel;
    CreateTodoResponseBodyModel createTodoResponseBodyModel;
    CreateUserWithInvalidFieldsResponseBodyModel getTodoWithInvalidResponseBodyModel;
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
    public void deleteTodoWithValidIDTest(){
        SoftAssert softAssert=new SoftAssert();
        deleteValidTodo(createTodoResponseBodyModel.getId(),204);
        getTodoWithInvalidResponseBodyModel = getTodoWithInvalidID(createTodoResponseBodyModel.getId(), 404);
        softAssert.assertEquals(getTodoWithInvalidResponseBodyModel.getMessage(),"Resource not found","the error message is not correct");
        softAssert.assertAll();
    }
    @AfterClass
    public void clear(){
        deleteUser(userID);
    }
}
