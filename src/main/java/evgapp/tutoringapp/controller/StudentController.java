package evgapp.tutoringapp.controller;

import evgapp.tutoringapp.exception.MailException;
import evgapp.tutoringapp.exception.PhoneNumberException;
import evgapp.tutoringapp.rest.StudentInfoDTO;
import evgapp.tutoringapp.service.DataCheckService;
import evgapp.tutoringapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DataCheckService dataCheckService;

    @PostMapping()
    public ResponseEntity<?> handleOrder(@RequestPart StudentInfoDTO studentInfo, @RequestPart("file")MultipartFile file) {

        try {
            dataCheckService.checkData(studentInfo.getPhoneNumber(), studentInfo.getMail());
            studentService.sendEmailWithOrder(file, studentInfo);
        } catch (IOException | MessagingException | PhoneNumberException | MailException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("Заявка успешно отправлена");
    }
}
