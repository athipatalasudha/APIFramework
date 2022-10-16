package ReqResAPIFramework;

import org.testng.annotations.Test;

import POJOclasses.LoginReqPOJO;
import POJOclasses.LoginRespPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginUnsuccessful 
{
	@Test
	
	public static void LoginUnSuccessful()
	{
		RestAssured.baseURI="https://reqres.in/api/login";
		LoginReqPOJO logindata=new LoginReqPOJO();
		logindata.setEmail("eve.holt@reqres.in");
		
		Response res=RestAssured
					 .given()
					 .body(logindata)
					 .contentType(ContentType.JSON)
					 .when()
					 .post();
		
		res.then().statusCode(400);
		res.prettyPrint();
		String errormsg=res.jsonPath().get("error");
		System.out.println("error : "+errormsg);
					 
	}
}
