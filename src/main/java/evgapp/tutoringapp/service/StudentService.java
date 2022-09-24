package evgapp.tutoringapp.service;

import evgapp.tutoringapp.rest.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    MailSenderService mailSenderService;

    public void sendEmailWithOrder(MultipartFile file, StudentInfoDTO studentInfo) throws IOException, MessagingException {
        String attachmentPath = null;
        if(file != null) {
            String fileSeparator = File.separator;
            String filename = file.getOriginalFilename();
            file.transferTo(new File(System.getProperty("user.home") + "Downloads" + fileSeparator + "uploads" + fileSeparator + filename));
            attachmentPath = System.getProperty("user.home") + "Downloads" + fileSeparator + "uploads" + fileSeparator + filename;
        }


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



        mailSenderService.sendMailWithAttachment(body, subject, attachmentPath);
    }
}
