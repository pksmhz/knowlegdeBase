package pl.coredev.front.types;

import lombok.Data;

import java.util.List;

@Data
public class AllowedResponse {
    private List<String> allowedOperations;
}
