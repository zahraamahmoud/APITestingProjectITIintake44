package requests;

import io.restassured.RestAssured;
import models.todo.CreateTodoRequestBodyModel;
import models.todo.CreateTodoResponseBodyModel;
import models.user.CreateUserWithInvalidFieldsResponseBodyModel;

import static utils.Constants.*;

public class TodoRequests {
    public static CreateTodoResponseBodyModel createTodo(CreateTodoRequestBodyModel createTodoRequest, int status){
        return RestAssured.
                given().
                headers(generateHeaders()).
                body(createTodoRequest).
                post(baseurl + todosendpoint).then().log().all().statusCode(status).extract().as(CreateTodoResponseBodyModel.class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel[] createTodoWithInvalidFieldsResponseBodyModel(CreateTodoRequestBodyModel createTodoRequest, int status){
        return RestAssured.
                given().log().all().
                headers(generateHeaders()).body(createTodoRequest).
                post(baseurl + todosendpoint).then().log().all().statusCode(status).extract().as(CreateUserWithInvalidFieldsResponseBodyModel[].class);
    }
    public static CreateTodoResponseBodyModel getTodoWithValidID(String todoID, int status){
        return RestAssured.
                given().
                headers(generateHeaders()).log().ifValidationFails().get(baseurl+todosendpoint+todoID).then().statusCode(status).extract().as(CreateTodoResponseBodyModel .class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel getTodoWithInvalidID(String todoId, int status){
        return RestAssured.
                given().log().all().
                headers(generateHeaders()).
                get(baseurl + todosendpoint+todoId).then().log().all().statusCode(status).extract().as(CreateUserWithInvalidFieldsResponseBodyModel.class);
    }
    public static void deleteValidTodo(String todoId, int status){
        RestAssured.
                given().log().ifValidationFails().
                headers(generateHeaders()).delete(baseurl+todosendpoint+todoId).then().statusCode(status);

    }
    public static CreateUserWithInvalidFieldsResponseBodyModel deleteInvalidTodo(String todoId, int status){
        return RestAssured.
                given().log().ifValidationFails().
                headers(generateHeaders()).delete(baseurl+todosendpoint+todoId).then().statusCode(status).extract().as(CreateUserWithInvalidFieldsResponseBodyModel.class);
    }
    public static CreateTodoResponseBodyModel putTodoWithValidDataFields(String todoID, int status, CreateTodoRequestBodyModel createTodoRequestBodyModel){
        return RestAssured
                .given().log().ifValidationFails()
                .headers(generateHeaders())
                .body(createTodoRequestBodyModel)
                .put(baseurl+todosendpoint+todoID)
                .then().statusCode(status).extract().as(CreateTodoResponseBodyModel.class);
    }
    public static CreateUserWithInvalidFieldsResponseBodyModel[]putTodoWithInvalidDataFields(String todoID, int status, CreateTodoRequestBodyModel createTodoRequestBodyModel){
        return RestAssured
                .given().log().ifValidationFails()
                .headers(generateHeaders())
                .body(createTodoRequestBodyModel)
                .put(baseurl+todosendpoint+todoID)
                .then().statusCode(status).extract().as(CreateUserWithInvalidFieldsResponseBodyModel[].class);
    }

}
