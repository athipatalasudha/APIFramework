package ReqResAPIFramework;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dockerjava.transport.DockerHttpClient.Response;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import POJOclasses.CreateUserRespPOJO;
import POJOclasses.GetUserPOJO;
import POJOclasses.ListUsersPOJO;
import POJOclasses.SingleUserPOJO;
import api.test.base.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.parser.JSONParser;

public class GetUserDetails extends BaseAPI
{
	@Test 
	public static void GetSingleUserDetails() throws JsonProcessingException
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		response=RestAssured
				 .given()
				 .when()
				 .get();
		response.prettyPrint();
		SingleUserPOJO user = response.body().as(SingleUserPOJO.class);
		System.out.println("\n The user details are : ");
		System.out.println(user.getData().getId());
		System.out.println(user.getData().getEmail());
		System.out.println(user.getData().getFirst_name());
		System.out.println(user.getData().getLast_name());
		System.out.println(user.getData().getAvatar());

		//ObjectMapper mapper = new ObjectMapper();
		//String uss = mapper.writeValueAsString(list.getData());
		//System.out.println("first name: -- " +uss);

		validate_statuscode(200);
	}
	@Test 
	public static void GetAllUsersDetails()
	{
		RestAssured.baseURI="https://reqres.in/api/users";
		response=RestAssured
				 .given()
				 .when()
				 .get();
		response.prettyPrint();
		var list = response.body().as(ListUsersPOJO.class);
		//Gson g = new Gson();  
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
		validate_statuscode(200);
	}
}
