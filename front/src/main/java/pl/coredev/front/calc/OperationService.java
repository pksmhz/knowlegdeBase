package pl.coredev.front.calc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coredev.front.types.OperationRequest;

import static java.lang.StringTemplate.RAW;

@Slf4j
@Service
public class OperationService {
    public void saveOperation(OperationRequest request) {
        LOG.info(String.format("Saving operation [%s]", request.toString()));
    }

    public String getMsg() {


        String name = "Maciek";

        StringTemplate str = RAW."Your name is \{getName()} .";


        return STR.process(str);
    }

    private String getName() {
        return "Mister!!";
    }
}
