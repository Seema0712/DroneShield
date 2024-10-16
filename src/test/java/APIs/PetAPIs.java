package APIs;

import POJOs.PetRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PetAPIs {

   String BaseURI = "https://petstore.swagger.io/v2/pet/";
   long petId = 0;
   String newPet = "Doggu";

   @Test
   public void createPet() throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       PetRequest petRequest = mapper.readValue(new File("src/main/resources/PetRequest.JSON"),PetRequest.class);
       Response response  = given().header("content-type","application/json").body(petRequest).when().post(BaseURI);
       Assert.assertEquals(response.statusCode(),200);
       JsonPath jsonPath = response.jsonPath();
       petId = jsonPath.getLong("id");
       System.out.println(response.asString());
       System.out.println("PetId is "+petId);
   }

    @Test
    public void getPetDetails(){
       Assert.assertEquals(given().header("content-type","application/json").when().get(BaseURI+petId).statusCode(),200);
    }

    @Test
    public void updatePet() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PetRequest petRequest = mapper.readValue(new File("src/main/resources/PetRequest.JSON"),PetRequest.class);
        petRequest.setName(newPet);
        Response response  = given().header("content-type","application/json").body(petRequest).when().post(BaseURI);
        Assert.assertEquals(response.statusCode(),200);
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("name"),newPet);
        System.out.println(response.asString());
    }

    @Test
    public void  delete() throws IOException {
        Assert.assertEquals(given().header("content-type","application/json").when().get(BaseURI+petId).statusCode(),200);
    }

}
