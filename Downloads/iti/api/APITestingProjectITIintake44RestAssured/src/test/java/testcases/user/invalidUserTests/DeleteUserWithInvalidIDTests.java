package testcases.user.invalidUserTests;

import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static requests.UserRequests.deleteUserWithInvalidID;

public class DeleteUserWithInvalidIDTests {


    GetUserWithInvalidIDResponseBodyModel getUserWithInvalidIDResponseBodyModel;


    @Test
    public void deleteUserWithValidIDTest(){
        getUserWithInvalidIDResponseBodyModel =deleteUserWithInvalidID("1234",404);
        assertEquals(getUserWithInvalidIDResponseBodyModel.getMessage(),"Resource not found","message is not as expected");
    }
}
