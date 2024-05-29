package kr.noname.noname.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JasyptConfigTest {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private JasyptConfig jasyptConfig = new JasyptConfig();
    private StringEncryptor encryptor = jasyptConfig.stringEncryptor();

    @Test
    void DB암호_확인() {
        // given
        String decryptedUrl = url;
        String decryptedUsername = username;
        String decryptedPassword = password;

        // when

        // then
        System.out.println("url_encrypted: " + decryptedUrl);
        System.out.println("username_encrypted: " + decryptedUsername);
        System.out.println("password_encrypted: " + decryptedPassword);
    }

    @Test
    void DB암호화_테스트() {
        // given
        String url = "";
        String username = "";
        String password = "";
        String tossSecretKey = "";

        // when
        String encryptedUrl = encryptor.encrypt(url);
        String encryptedUsername = encryptor.encrypt(username);
        String encryptedPassword = encryptor.encrypt(password);
        String encryptedTossSecretKey = encryptor.encrypt(tossSecretKey);

        // then
        System.out.println("url: " + url);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("tossSecretKey: " + tossSecretKey);

        System.out.println("encryptedUrl: " + encryptedUrl);
        System.out.println("encryptedUsername: " + encryptedUsername);
        System.out.println("encryptedPassword: " + encryptedPassword);
        System.out.println("encryptedTossSecretKey: " + encryptedTossSecretKey);

        assertThat(encryptor.decrypt(encryptedUrl)).isEqualTo(url);
        assertThat(encryptor.decrypt(encryptedUsername)).isEqualTo(username);
        assertThat(encryptor.decrypt(encryptedPassword)).isEqualTo(password);
        assertThat(encryptor.decrypt(encryptedTossSecretKey)).isEqualTo(tossSecretKey);
    }


}