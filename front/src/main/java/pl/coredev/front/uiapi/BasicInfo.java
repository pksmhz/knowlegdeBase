package pl.coredev.front.uiapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicInfo {

    @GetMapping("/info")
    public String getInfo() {
        return "Appka działa? <br/>No jasne, <strong>że działa!!</strong>";
    }
}
