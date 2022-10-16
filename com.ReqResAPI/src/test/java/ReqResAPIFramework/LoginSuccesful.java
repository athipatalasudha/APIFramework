package ReqResAPIFramework;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import POJOclasses.LoginReqPOJO;
import POJOclasses.LoginRespPOJO;
import api.test.base.BaseAPI;
import api.test.utilities.CommonUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.*;
import io.restassured.response.Response;
public class LoginSuccesful extends BaseAPI
{
	static CommonUtilities CU = new CommonUtilities();
	static Properties applicationPropertiesFile = CU.loadFile("data");
	static String usrname = CU.getApplicationProperty("validusername", applicationPropertiesFile);
	static String pswd = CU.getApplicationProperty("validpswd", applicationPropertiesFile);
	
	@Test
	public static void LoginSuccessful()
	{
		RestAssured.baseURI="https://reqres.in/api/login";
		LoginReqPOJO logindata=new LoginReqPOJO();
		logindata.setEmail(usrname);
		logindata.setPassword(pswd);
		Response res=RestAssured
					 .given()
					 .body(logindata)
					 .contentType(ContentType.JSON)
					 .when()
					 .post();
					 
		LoginRespPOJO r=res.as(LoginRespPOJO.class);
		String token=r.getToken();
		res.then().statusCode(200);
		System.out.println("token="+token);
		res.prettyPrint();			 
	}
}
