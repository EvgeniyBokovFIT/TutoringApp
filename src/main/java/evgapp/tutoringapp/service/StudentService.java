package evgapp.tutoringapp.service;

import evgapp.tutoringapp.rest.StudentInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class StudentService {

    @Autowired
    MailSenderService mailSenderService;

    public static final String DIRECTORY = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "uploads" + File.separator;

    public void sendEmailWithOrder(MultipartFile file, StudentInfoDTO studentInfo) throws IOException, MessagingException {
        String attachmentPath = null;
        if(file != null) {
            String filename = file.getOriginalFilename();
            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            attachmentPath = DIRECTORY + filename;
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
