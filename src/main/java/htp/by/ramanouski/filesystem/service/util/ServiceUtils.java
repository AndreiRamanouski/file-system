package htp.by.ramanouski.filesystem.service.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class ServiceUtils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String generateFileId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(stringBuilder);
    }

}
