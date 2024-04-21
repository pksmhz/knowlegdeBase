package pl.coredev.front.calc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OperationServiceTest

{
    @Autowired
    private OperationService operationService;

    @Test
    void testStr() {
        String msg = operationService.getMsg();

        Assert.assertEquals("ddd", msg);
    }

}