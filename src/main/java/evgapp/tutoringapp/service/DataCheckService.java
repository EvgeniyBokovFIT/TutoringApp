package evgapp.tutoringapp.service;

import evgapp.tutoringapp.exception.MailException;
import evgapp.tutoringapp.exception.PhoneNumberException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class DataCheckService {

    private final String REGEX_MAIL_PATTERN = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private final String REGEX_PHONE_NUMBER_PATTERN = "^(8|\\+7)\\d{10}";

    public boolean checkData(String phoneNumber, String mail) throws MailException, PhoneNumberException {
        if(!Pattern.compile(REGEX_MAIL_PATTERN).matcher(mail).matches()) {
            throw new MailException("Некорректный формат почты");
        }
        if(!Pattern.compile(REGEX_PHONE_NUMBER_PATTERN).matcher(phoneNumber).matches()) {
            throw new PhoneNumberException("Некорректный формат номера телефона");
        }
        return true;
    }
}
