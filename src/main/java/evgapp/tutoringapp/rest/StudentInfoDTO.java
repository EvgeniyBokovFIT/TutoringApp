package evgapp.tutoringapp.rest;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class StudentInfoDTO {
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private String task;
    private String discipline;
    private List<MultipartFile> files;

    public StudentInfoDTO() {
    }

    public StudentInfoDTO(String name, String surname, String mail, String phone, String task, String discipline, List<MultipartFile> files) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.task = task;
        this.discipline = discipline;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
