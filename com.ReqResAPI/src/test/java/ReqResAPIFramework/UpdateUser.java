package ReqResAPIFramework;

import org.testng.annotations.Test;

import POJOclasses.UpdateUserReqPOJO;
import POJOclasses.UpdateUserRespPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUser 
{
	@Test
	public static void UpdateUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		UpdateUserReqPOJO ur=new UpdateUserReqPOJO();
		ur.setName("morpheus");
		ur.setJob("zion resident");
		Response res=RestAssured
				 .given()
				 .body(ur)
				 .contentType(ContentType.JSON)
				 .when()
				 .put();
		res.then().statusCode(200);
		UpdateUserRespPOJO up=res.as(UpdateUserRespPOJO.class);
		String name=up.getName();
		String job=up.getJob();
		String updatedAt=up.getUpdatedAt();
		System.out.println("\n The user details after update is :");
		System.out.println("Name : "+name+"\n Job : "+job);
		System.out.println("Updated At : "+updatedAt);
	}
}
