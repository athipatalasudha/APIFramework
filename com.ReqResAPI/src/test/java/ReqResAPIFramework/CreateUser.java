package ReqResAPIFramework;

import org.testng.annotations.Test;

import POJOclasses.CreateUserReqPOJO;
import POJOclasses.CreateUserRespPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser 
{
	@Test
	
	public void CreateUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		CreateUserReqPOJO cp=new CreateUserReqPOJO();
		cp.setName("morpheus");
		cp.setJob("leader");
		Response res=RestAssured
				 .given()
				 .body(cp)
				 .contentType(ContentType.JSON)
				 .when()
				 .post();
		CreateUserRespPOJO cr=res.as(CreateUserRespPOJO.class);
		res.then().statusCode(201);
		String name=cr.getName();
		String job=cr.getJob();
		String id=cr.getId();
		String createdat=cr.getCreatedAt();
		System.out.println("\n The created user details :");
		System.out.println("Name : "+name+"\n Job : "+job+"\n ID : "+id);
		System.out.println("Created At : "+createdat);
	}
}
