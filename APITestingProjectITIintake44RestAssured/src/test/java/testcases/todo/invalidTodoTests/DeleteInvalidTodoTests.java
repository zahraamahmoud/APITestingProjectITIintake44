package testcases.todo.invalidTodoTests;

import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static requests.TodoRequests.deleteInvalidTodo;


public class DeleteInvalidTodoTests {


    CreateUserWithInvalidFieldsResponseBodyModel getTodoWithInvalidResponseBodyModel;

    @Test
    public void deleteTodoWithInvalidIDTest(){
        SoftAssert softAssert=new SoftAssert();

        getTodoWithInvalidResponseBodyModel=deleteInvalidTodo("789",404);
        softAssert.assertEquals(getTodoWithInvalidResponseBodyModel.getMessage(),"Resource not found","the error message not as expected");
        softAssert.assertAll();
    }


}
