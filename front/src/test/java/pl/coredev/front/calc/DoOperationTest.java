package pl.coredev.front.calc;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasItems;

@SpringBootTest
class DoOperationTest {

    @InjectMocks
    private DoOperation doOperation;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(doOperation);
    }

    @Test
    void testAllowedOKReturnCode() {
        given().when().post("/allowed").then().statusCode(200);
    }

    @Test
    void testAllowedOKProperResponse() {
        given().when().post("/allowed").then().body("allowedOperations", hasItems("ADD", "SUB"));
    }
}