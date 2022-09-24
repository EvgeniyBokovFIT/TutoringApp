package evgapp.tutoringapp.service;

import evgapp.tutoringapp.rest.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

@Service
public class StudentService {

    @Autowired
    MailSenderService mailSenderService;

    public void sendEmailWithOrder(MultipartFile file, StudentInfoDTO studentInfo) throws IOException, MessagingException {
        String filename = file.getOriginalFilename();
        file.transferTo(new File("C:\\upload\\" + filename));

        String body = String.format(
                "Здравствуйте! \n" +
                        "Появился новый заказ: \n" +
                        "Имя: %s %s \n" +
                        "Почта: %s \n" +
                        "Номер телефона: %s \n" +
                        "Описание: %s",
                studentInfo.getFirstName(),
                studentInfo.getLastName(),
                studentInfo.getMail(),
                studentInfo.getPhoneNumber(),
                studentInfo.getDescription()
        );

        String subject = "Заказ от студента " + studentInfo.getFirstName() + " " + studentInfo.getLastName();

        String attachmentPath = "C:\\upload\\" + filename;

        mailSenderService.sendMailWithAttachment(body, subject, attachmentPath);
    }
}
