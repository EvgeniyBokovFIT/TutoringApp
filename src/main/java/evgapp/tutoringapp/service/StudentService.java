package evgapp.tutoringapp.service;

import evgapp.tutoringapp.rest.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class StudentService {

    @Autowired
    MailSenderService mailSenderService;

    public void sendEmailWithOrder(StudentInfoDTO studentInfo) throws IOException, MessagingException {

        String body = String.format(
                "Здравствуйте! \n" +
                        "Появился новый заказ: \n" +
                        "Имя: %s %s \n" +
                        "Почта: %s \n" +
                        "Номер телефона: %s \n" +
                        "Дисциплина: %s \n" +
                        "Описание: %s",
                studentInfo.getFirstName(),
                studentInfo.getLastName(),
                studentInfo.getMail(),
                studentInfo.getPhoneNumber(),
                studentInfo.getDiscipline(),
                studentInfo.getDescription()
        );

        String subject = "Заказ от студента " + studentInfo.getFirstName() + " " + studentInfo.getLastName() + " " + studentInfo.getMail();

        mailSenderService.sendMailWithAttachment(body, subject, studentInfo.getFiles());
    }
}
