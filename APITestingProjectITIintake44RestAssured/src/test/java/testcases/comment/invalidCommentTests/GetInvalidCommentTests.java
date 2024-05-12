package testcases.comment.invalidCommentTests;

import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static requests.CommentRequests.getCommentWithInvalidID;

public class GetInvalidCommentTests {



    GetUserWithInvalidIDResponseBodyModel getWithInvalidFieldsResponseBodyModel;

    @Test
    public void getCommentWithValidDate(){
        SoftAssert softAssert=new SoftAssert();

        getWithInvalidFieldsResponseBodyModel = getCommentWithInvalidID("785",404);
        softAssert.assertEquals(getWithInvalidFieldsResponseBodyModel.getMessage(),"Resource not found","not as expected");

        softAssert.assertAll();
    }


}
