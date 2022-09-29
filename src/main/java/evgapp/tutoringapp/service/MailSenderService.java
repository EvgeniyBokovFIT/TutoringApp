package evgapp.tutoringapp.service;

import ch.qos.logback.core.util.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${owner.mail}")
    private String toEmail;

    public static final String DIRECTORY = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + "uploads" + File.separator;

    public void sendMailWithAttachment(String body, String subject, List<MultipartFile> files) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        if(files != null) {
            for (var file : files) {
                String filename = file.getOriginalFilename();
                Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
                Files.copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                FileSystemResource fileSystemResource = new FileSystemResource(new File(DIRECTORY + filename));
                mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);
            }
        }

        javaMailSender.send(mimeMessage);

        if(files != null) {
            for (var file : files) {
                String filename = file.getOriginalFilename();
                Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
                Files.deleteIfExists(fileStorage);
            }
        }
    }
}
