package api.test.base;

import java.util.Properties;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOclasses.CreateUserReqPOJO;
import POJOclasses.CreateUserRespPOJO;
import POJOclasses.GetUserPOJO;
import POJOclasses.InvalidLoginResPOJO;
import POJOclasses.ListUsersPOJO;
import POJOclasses.LoginReqPOJO;
import POJOclasses.LoginRespPOJO;
import POJOclasses.SingleUserPOJO;
import POJOclasses.UpdateUserReqPOJO;
import POJOclasses.UpdateUserRespPOJO;
import api.test.utilities.CommonUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI 
{
	static CommonUtilities CU = new CommonUtilities();
	static Properties applicationPropertiesFile = CU.loadFile("data");
	static String usrname = CU.getApplicationProperty("validusername", applicationPropertiesFile);
	static String pswd = CU.getApplicationProperty("validpswd", applicationPropertiesFile);
	protected static RequestSpecification request;
	protected static Response response;
	public void set_URI(String str)
	{
		RestAssured.baseURI=str;
	}
	
	public static void LogintoAPI()
	{
		LoginReqPOJO logindata=new LoginReqPOJO();
		logindata.setEmail(usrname);
		logindata.setPassword(pswd);
		request = RestAssured.given();
		request.contentType(ContentType.JSON);
		response = request.body(logindata)
				.post();
	}
	public static void InvalidLogintoAPI()
	{
		LoginReqPOJO logindata=new LoginReqPOJO();
		logindata.setEmail(usrname);
		//logindata.setPassword(pswd);
		request = RestAssured.given();
		request.contentType(ContentType.JSON);
		response = request.body(logindata)
				.post();
	}
	public static void validate_statuscode(int str)
	{		
		Assert.assertEquals(response.getStatusCode(), str);
	}
	public void validate_token()
	{
		LoginRespPOJO r=response.as(LoginRespPOJO.class);
		String token=r.getToken();
		System.out.println("token="+token);
	}
	public String error_msg_login()
	{
		InvalidLoginResPOJO ip=response.as(InvalidLoginResPOJO.class);
		String msg=ip.getError();
		System.out.println("error msg :"+msg);
		return msg;
	}
	public static void getSingleUser()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		response=RestAssured
				 .given()
				 .when()
				 .get();
		response.prettyPrint();
	}
	public static void displaySingleUser()
	{
		SingleUserPOJO user = response.body().as(SingleUserPOJO.class);
		System.out.println("\n The user details are : ");
		System.out.println(user.getData().getId());
		System.out.println(user.getData().getEmail());
		System.out.println(user.getData().getFirst_name());
		System.out.println(user.getData().getLast_name());
		System.out.println(user.getData().getAvatar());

	}
	public static void getAllUsers()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		response=RestAssured
				 .given()
				 .when()
				 .get();
		response.prettyPrint();
	}
	public static void displayAllUsers()
	{
		var list = response.body().as(ListUsersPOJO.class);
		for( GetUserPOJO i: list.getData())
		{
			System.out.println("\n User["+i+"]");
			System.out.println("id: -- " +i.getId());
			System.out.println("email: -- " +i.getEmail());
			System.out.println("first name: -- " +i.getFirst_name());
			System.out.println("last name: -- " +i.getLast_name());
			System.out.println("avatar: -- " +i.getAvatar());
			System.out.println("\n");
		}
	}
	public static void createNewUser()
	{
		CreateUserReqPOJO cp=new CreateUserReqPOJO();
		cp.setName("morpheus");
		cp.setJob("leader");
		response =RestAssured
				 .given()
				 .body(cp)
				 .contentType(ContentType.JSON)
				 .when()
				 .post();
	}
	public static void createNewUserResp()
	{
		CreateUserRespPOJO cr=response.as(CreateUserRespPOJO.class);
		String name=cr.getName();
		String job=cr.getJob();
		String id=cr.getId();
		String createdat=cr.getCreatedAt();
		System.out.println("\n The created user details :");
		System.out.println("Name : "+name+"\n Job : "+job+"\n ID : "+id);
		System.out.println("Created At : "+createdat);
	}
	
	public static void updateUserReq()
	{
		UpdateUserReqPOJO ur=new UpdateUserReqPOJO();
		ur.setName("morpheus");
		ur.setJob("zion resident");
		response =RestAssured
				 .given()
				 .body(ur)
				 .contentType(ContentType.JSON)
				 .when()
				 .put();
	}
	public static void updateUserResp()
	{
		UpdateUserRespPOJO up=new UpdateUserRespPOJO();
		String name=up.getName();
		String job=up.getJob();
		String updatedAt=up.getUpdatedAt();
		System.out.println("\n The user details after update is :");
		System.out.println("Name : "+name+"\n Job : "+job);
		System.out.println("Updated At : "+updatedAt);
	}
}
