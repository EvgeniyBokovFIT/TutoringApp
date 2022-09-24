package evgapp.tutoringapp.service;

import evgapp.tutoringapp.rest.TutorInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class TutorService {

    @Autowired
    MailSenderService mailSenderService;

    public void sendEmailWithRequest(TutorInfoDTO tutorInfo) throws MessagingException {
        String body = String.format(
                "Здравствуйте! \n" +
                        "Появилась новая заявка: \n" +
                        "Имя: %s %s \n" +
                        "Почта: %s \n" +
                        "Номер телефона: %s \n" +
                        "Дисциплина: %s \n" +
                        "Описание: %s",
                tutorInfo.getFirstName(),
                tutorInfo.getLastName(),
                tutorInfo.getMail(),
                tutorInfo.getPhoneNumber(),
                tutorInfo.getDiscipline(),
                tutorInfo.getDescription()
        );

        String subject = "Заявка от преподавателя " + tutorInfo.getFirstName() + " " + tutorInfo.getLastName();

        mailSenderService.sendMailWithAttachment(body, subject, null);
    }
}
