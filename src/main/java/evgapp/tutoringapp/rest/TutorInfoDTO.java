package evgapp.tutoringapp.rest;

public class TutorInfoDTO {
    private String firstName;
    private String lastName;
    private String mail;
    private String phoneNumber;
    private String discipline;
    private String description;

    public TutorInfoDTO() {
    }

    public TutorInfoDTO(String firstName, String lastName, String mail, String phoneNumber, String discipline, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.discipline = discipline;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getDescription() {
        return description;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
