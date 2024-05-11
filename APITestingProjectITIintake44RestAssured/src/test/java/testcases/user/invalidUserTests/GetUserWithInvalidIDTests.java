package testcases.user.invalidUserTests;

import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static requests.UserRequests.getUserWithInvalidID;

public class GetUserWithInvalidIDTests {

    GetUserWithInvalidIDResponseBodyModel getUserWithInvalidIDResponseBodyModel;


    @Test
    public void getInvalidUserTest(){
        getUserWithInvalidIDResponseBodyModel =getUserWithInvalidID("1234",404);
        assertEquals(getUserWithInvalidIDResponseBodyModel.getMessage(),"Resource not found","message is not as expected");

    }




}
