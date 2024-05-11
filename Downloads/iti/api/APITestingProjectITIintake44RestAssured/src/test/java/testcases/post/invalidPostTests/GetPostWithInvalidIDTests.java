package testcases.post.invalidPostTests;

import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static requests.PostRequests.getPostWithInvalidPostID;
public class GetPostWithInvalidIDTests {


   GetUserWithInvalidIDResponseBodyModel getUserWithInvalidIDResponseBodyModel;


    @Test
    public void getPostWithInvalidPostIDTest(){
        getUserWithInvalidIDResponseBodyModel =getPostWithInvalidPostID("1234",404);
        assertEquals(getUserWithInvalidIDResponseBodyModel.getMessage(),"Resource not found","message is not as expected");
    }

}
