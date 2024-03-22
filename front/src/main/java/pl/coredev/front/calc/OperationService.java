package pl.coredev.front.calc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coredev.front.types.OperationRequest;

@Slf4j
@Service
public class OperationService {
    public void saveOperation(OperationRequest request) {
        LOG.info(String.format("Saving operation [%s]", request.toString()));
    }
}
