package evgapp.tutoringapp.rest;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class TutorInfoDTO {
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String discipline;
    private String description;

    private List<MultipartFile> files;

    public TutorInfoDTO() {
    }

    public TutorInfoDTO(String name, String surname, String mail, String phone, String discipline, String description, List<MultipartFile> files) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.discipline = discipline;
        this.description = description;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
