package pl.coredev.front.calc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coredev.front.rabbit.RabbitSender;
import pl.coredev.front.types.AllowedResponse;
import pl.coredev.front.types.OperationRequest;
import pl.coredev.front.types.OperationType;

import java.util.Arrays;

@Slf4j
@RestController
public class DoOperation {

    @Autowired
    RabbitSender sender;

    @CrossOrigin
    @PostMapping(value = "/operation")
    public void doOperation(@RequestBody OperationRequest request) {
        LOG.info("Request received. Values: 1:[{}], 2:[{}]", request.getInputValue(), request.getOperationType());

//        sender.send();
    }

    @CrossOrigin
    @PostMapping(value = "/allowed")
    public @ResponseBody AllowedResponse getAllowed() {
        AllowedResponse response = new AllowedResponse();
        response.setAllowedOperations(Arrays.stream(OperationType.values())
                        .map(Enum::name)
                .toList());
        return response;
    }
}
