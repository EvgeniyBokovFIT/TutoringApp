package evgapp.tutoringapp.controller;

import evgapp.tutoringapp.exception.MailException;
import evgapp.tutoringapp.exception.PhoneNumberException;
import evgapp.tutoringapp.rest.TutorInfoDTO;
import evgapp.tutoringapp.service.DataCheckService;
import evgapp.tutoringapp.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import java.io.IOException;


@CrossOrigin(origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    TutorService tutorService;

    @Autowired
    DataCheckService dataCheckService;

    @PostMapping()
    public ResponseEntity<?> handleTutorRequest(@ModelAttribute TutorInfoDTO tutorInfo) {
        try {
            dataCheckService.checkData(tutorInfo.getPhone(), tutorInfo.getMail());
            tutorService.sendEmailWithRequest(tutorInfo);
        } catch (MailException | PhoneNumberException | MessagingException | IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Заявка успешно отправлена");
    }
}
