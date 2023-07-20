package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker();

    public static AuthInfo getAuthInfoTest (){
        return new AuthInfo("vasya", "qwerty123");
    }

    private static String generateRandomLogin (){
        return faker.leagueOfLegends().champion();
    }
    private static String generateRandomPassword(){
        return faker.internet().password();
    }

    public static AuthInfo getRandomUser () {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    @Value
    public static class AuthInfo {
        String userLogin;
        String userPassword;
    }
    @Value
    public static class VerificationCode {
      String verifyCode;
    }

}
