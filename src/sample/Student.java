package sample;

/**...*/
public class Student {

    private int id;
    private String name;
    private String lastName;
    private String phone;
    private String email;

    public Student(int id, String name, String lastName, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }
//imutable tik getteriai nes objektai nebekeiciami
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
