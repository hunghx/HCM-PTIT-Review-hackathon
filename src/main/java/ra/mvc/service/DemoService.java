package ra.mvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Value("${project.name}")
    public String projectName;
    public String getMessage() {
        return "projectName = " + projectName;
    }
}
