package pl.coredev.front.types;

import lombok.Data;

@Data
public class OperationRequest {
    private int inputValue;
    private OperationType operationType;
}
