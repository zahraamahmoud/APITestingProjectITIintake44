package testcases.post.invalidPostTests;

import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static requests.PostRequests.deletePostWithInvalidID;

public class DeletePostWithInvalidID {
    GetUserWithInvalidIDResponseBodyModel deletePostWithInvalidPostIDResponseModel;

    @Test
    public void deletePostWithInvalidPostIDTest(){
        deletePostWithInvalidPostIDResponseModel=deletePostWithInvalidID("1234",404);
       assertEquals(deletePostWithInvalidPostIDResponseModel.getMessage(),"Resource not found","message is not as expected");
    }


}
