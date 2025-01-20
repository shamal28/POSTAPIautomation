package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
public class PostReq {

	public int StatusCode;
    public RequestSpecification httpReq;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JSONObject requestParam;
	@Given("user hits the url of POST API endpoint")
	public void user_hits_the_url_of_post_api_endpoint() {
	    
		RestAssured.baseURI = "https://fakestoreapi.com/";
        httpReq = RestAssured.given();
        requestParam = new JSONObject();
		
		
		
	}

	@When("user passes the details of products in the request")
	public void user_passes_the_details_of_products_in_the_request() {
		 
		 httpReq = RestAssured.given();
	        response = httpReq.get("/products");
	       
		
		
		
	}

	@And("user passes the request body for title of the product Watch")
	public void user_passes_the_request_body_for_title_of_the_product_watch() {
		requestParam.put( "title","Watch");
		requestParam.put( "price","2500");
        requestParam.put( "description","Watch add");
        requestParam.put( "category","Watches");
        httpReq.body(requestParam.toJSONString());
	}

	@Then("user should get the response code as {int} and new id for the added product")
	public void user_should_get_the_response_code_as_and_new_id_for_the_added_product(Integer int1) {
		ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode, 200);
        body = response.getBody();
        String responseBody = body.asString();
        Response response = httpReq.post("products");
        ResponseBody body = response.getBody();
        JsonPath jsnpath = response.jsonPath();
        String productid = jsnpath.getString("id").toString();
        assertEquals("21", productid);
       
        
        
     

      
        System.out.println(body.asString());
        
    
	}

	
	
	
	
	
}
