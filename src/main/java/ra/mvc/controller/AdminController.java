package ra.mvc.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.mvc.model.FormRequest;
import ra.mvc.service.DemoService;
import ra.mvc.validator.FormRequestValidator;



@Controller
public class AdminController {
    @Autowired
    private DemoService demoService;
    @Autowired
    private FormRequestValidator validator;
    @GetMapping("/")
    public String home() {
        // You can use the demoService to get any required data
        System.out.println(demoService.getMessage());
        return "admin/home"; // Return the view name for the admin home page
    }

    @GetMapping("/form") // hiển thị form
    public String showForm(Model model) {
//        List<FormRequest> list = Arrays.asList(new FormRequest("John Doe", "john@gmail.com", 30),
//                                               new FormRequest("Jane Smith", "hane@gmail.com", 25));
//        model.addAttribute("list", list); // Add the list of FormRequest objects to the model
        model.addAttribute("formRequest", new FormRequest()); // Add an empty FormRequest object to the model
        return "form"; // Return the view name for the form page
    }

    @PostMapping("/form")
    public String handleForm(@Valid @ModelAttribute("formRequest") FormRequest formRequest, BindingResult result, Model model) {
//        validator.validate(formRequest,result);
        if (result.hasErrors()) {
            // If there are validation errors, return to the form view
            model.addAttribute("formRequest", formRequest);
            return "form";
        }
        // xử lý dữ liệu từ form
        return "index";
    }
}
