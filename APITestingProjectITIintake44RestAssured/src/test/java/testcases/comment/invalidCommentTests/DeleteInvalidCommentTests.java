package testcases.comment.invalidCommentTests;


import models.user.GetUserWithInvalidIDResponseBodyModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static requests.CommentRequests.deleteInvalidComment;

public class DeleteInvalidCommentTests {

    GetUserWithInvalidIDResponseBodyModel deleteCommentResponseBodyModel;



    @Test
    public void deleteCommentWithInValidIDTest(){
        SoftAssert softAssert=new SoftAssert();
        deleteCommentResponseBodyModel= deleteInvalidComment("656565",404);
        softAssert.assertEquals(deleteCommentResponseBodyModel.getMessage(),"Resource not found","not as expected");
        softAssert.assertAll();
    }

}
