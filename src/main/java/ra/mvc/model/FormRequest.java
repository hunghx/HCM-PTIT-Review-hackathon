package ra.mvc.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import ra.mvc.validator.EmailUnique;

public class FormRequest {
//    @NotBlank @NotNull @NotEmpty
//    @Email
//    @Pattern()
//    @Min()@Max()
//    @Size()
//    @PastOrPresent@Past
//    @Future@FutureOrPresent
//    @Positive@PositiveOrZero
//    @Negative@NegativeOrZero
    @NotBlank(message = "{name.emtpy}")
    private String name;
    @NotBlank(message = "Not blank!!!!!!")
    @EmailUnique
    private String email;
    @Min(value = 18, message = "{age.min}")
    private int age;
//    private List<String> hobbies;

    public String getName() {
        return name;
    }

    public FormRequest(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public FormRequest() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public List<String> getHobbies() {
//        return hobbies;
//    }
//
//    public void setHobbies(List<String> hobbies) {
//        this.hobbies = hobbies;
//    }
}
