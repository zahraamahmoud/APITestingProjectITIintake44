package testcases.todo.invalidTodoTests;

import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static requests.TodoRequests.getTodoWithInvalidID;


public class GetInvalidTodoTests {


    CreateUserWithInvalidFieldsResponseBodyModel getTodoWithInvalidResponseBodyModel;


    @Test
    public void getTodoWithInvalidIDTest(){
        SoftAssert softAssert=new SoftAssert();

        getTodoWithInvalidResponseBodyModel=getTodoWithInvalidID("789",404);
        softAssert.assertEquals(getTodoWithInvalidResponseBodyModel.getMessage(),"Resource not found","the error message not as expected");
        softAssert.assertAll();
    }

}
