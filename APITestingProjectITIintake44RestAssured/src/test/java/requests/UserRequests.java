package requests;

import io.restassured.response.Response;
import models.user.CreateUserRequestBodyModel;
import models.user.CreateUserResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;
import models.user.GetUserWithInvalidIDResponseBodyModel;
import utils.Constants;

import static io.restassured.RestAssured.given;
import static utils.Constants.*;

public class UserRequests {

    public static CreateUserResponseBodyModel createuser(CreateUserRequestBodyModel createUserRequestBodyModel, int statuscode){
        return   given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(createUserRequestBodyModel).
                post(baseurl + userendpoint).then().log().all().statusCode(statuscode).extract().as(CreateUserResponseBodyModel.class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel[] createUserWithInvalidFields(CreateUserRequestBodyModel createUserRequestBodyModel, int statuscode){
        return   given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(createUserRequestBodyModel).
                post(baseurl + userendpoint).then().statusCode(statuscode).extract().as(CreateUserWithInvalidFieldsResponseBodyModel[].class);
    }
    public static CreateUserResponseBodyModel getSingleUser(String user_id, int statuscode){
      return  given()
                .headers(generateHeaders()).log().ifValidationFails()
               .get(baseurl + userendpoint+user_id).then().statusCode(statuscode).extract().as(CreateUserResponseBodyModel.class);
    }
    public static GetUserWithInvalidIDResponseBodyModel getUserWithInvalidID(String user_id, int statuscode){
        return  given()
                .headers(generateHeaders()).log().ifValidationFails()
                .get(baseurl + userendpoint+user_id).then().statusCode(statuscode).extract().as(GetUserWithInvalidIDResponseBodyModel.class);    }
    public static Response deleteUser(String id){

        return given()
                .headers(Constants.generateHeaders())
                .delete(Constants.baseurl+Constants.userendpoint+id);


    }
    public static CreateUserResponseBodyModel updateUserUsingPUT(CreateUserRequestBodyModel createUserRequestBodyModel, String userID, int statuscode){
        return   given()
                .headers(generateHeaders()).log().ifValidationFails()
                .body(createUserRequestBodyModel).
                put(baseurl + userendpoint+userID).then().statusCode(statuscode).extract().as(CreateUserResponseBodyModel.class);
    }
    public static GetUserWithInvalidIDResponseBodyModel deleteUserWithInvalidID(String id, int statuscode){

        return given()
                .headers(Constants.generateHeaders())
                .delete(Constants.baseurl+Constants.userendpoint+id).then().statusCode(statuscode).extract().as(GetUserWithInvalidIDResponseBodyModel.class);


    }


}
