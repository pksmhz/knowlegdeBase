package pl.coredev.front.types;

import lombok.Data;

@Data
public class OperationRequest {
    private int inputValue;
    private OperationType operationType;

    @Override
    public String toString() {
        return "[OperationRequest] [ " +
                "inputValue= " + inputValue +
                ", operationType= " + operationType.toString() +
                " ]";
    }
}
