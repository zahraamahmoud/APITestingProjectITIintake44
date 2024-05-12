package testcases.todo.validTodoTests;

import models.todo.CreateTodoRequestBodyModel;
import models.todo.CreateTodoResponseBodyModel;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import static requests.TodoRequests.createTodo;
import static requests.TodoRequests.deleteValidTodo;
import static requests.UserRequests.createuser;
import static requests.UserRequests.deleteUser;
import static utils.Constants.generateEmail;

public class CreateValidTodoTests {

    private String useremail=generateEmail();
    String userID="";

    CreateUserRequestBodyModel createUserRequestBodyModel;
    CreateUserResponseBodyModel createUserResponseBodyModel;
    CreateTodoRequestBodyModel createTodoRequestBodyModel=new CreateTodoRequestBodyModel();
    CreateTodoResponseBodyModel createTodoResponseBodyModel;
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
    public void createTodoWithValidFieldsTest() {
        SoftAssert softAssert=new SoftAssert();
        createTodoRequestBodyModel.setUser_id(userID);
        createTodoRequestBodyModel.setTitle("API testing");
        createTodoRequestBodyModel.setStatus("completed");
        createTodoRequestBodyModel.setDue_on("2024-05-08T00:00:00.000+05:30");
        createTodoResponseBodyModel=createTodo(createTodoRequestBodyModel,201);
        softAssert.assertEquals(createTodoResponseBodyModel.getStatus(),createTodoRequestBodyModel.getStatus());
        softAssert.assertAll();
    }
    @AfterClass
    public void clear(){
        deleteValidTodo(createTodoResponseBodyModel.getId(),204);
        deleteUser(userID);

    }

}