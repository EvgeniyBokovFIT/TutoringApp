package evgapp.tutoringapp.service;

import evgapp.tutoringapp.rest.TutorInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class TutorService {

    @Autowired
    MailSenderService mailSenderService;

    public void sendEmailWithRequest(TutorInfoDTO tutorInfo) throws MessagingException, IOException {
        String body = String.format(
                "Здравствуйте! \n" +
                        "Появилась новая заявка: \n" +
                        "Имя: %s %s \n" +
                        "Почта: %s \n" +
                        "Номер телефона: %s \n" +
                        "Дисциплина: %s \n" +
                        "Описание: %s",
                tutorInfo.getName(),
                tutorInfo.getSurname(),
                tutorInfo.getMail(),
                tutorInfo.getPhone(),
                tutorInfo.getDiscipline(),
                tutorInfo.getDescription()
        );

        String subject = "Заявка от преподавателя " + tutorInfo.getName() + " " + tutorInfo.getSurname();

        mailSenderService.sendMailWithAttachment(body, subject, tutorInfo.getFiles());
    }
}
