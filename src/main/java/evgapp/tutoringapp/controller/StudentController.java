package evgapp.tutoringapp.controller;

import evgapp.tutoringapp.rest.StudentInfoDTO;
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

    @PostMapping()
    public ResponseEntity<?> handleOrder(@RequestPart StudentInfoDTO request, @RequestPart("file")MultipartFile file) {

        try {
            studentService.sendEmailWithOrder(file, request);
        } catch (IOException | MessagingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("Заявка успешно отправлена");
    }
}
