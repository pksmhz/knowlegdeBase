package pl.coredev.front.calc;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DoOperationTest {

    @Spy
    private OperationService operationService;

    @InjectMocks
    private DoOperation doOperation;


    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(doOperation, operationService);
    }

    @Test
    void testAllowedOKReturnCode() {
        given().when().post("/allowed").then().statusCode(200);
    }

    @Test
    void testAllowedOKProperResponse() {
        given().when().post("/allowed").then().body("allowedOperations", hasItems("ADD", "SUB"));
    }

    @Test
    void testSaveOperation() {


        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("inputValue", 3);
        jsonAsMap.put("operationType", "ADD");


        given()
                .body(jsonAsMap)
                .contentType(ContentType.JSON)
                .when().post("/operation")
                .then().statusCode(200);

        verify(operationService, times(1)).saveOperation(any());
    }
}