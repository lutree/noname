package kr.noname.noname.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@TestConfiguration
class JasyptConfigTest {

    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

    @BeforeEach
    void setup() {
        encryptor.setAlgorithm(JasyptConfig.ALGORITHM);
        encryptor.setPassword(JasyptConfig.ENCRYPT_KEY);
        encryptor.setIvGenerator(new RandomIvGenerator());
    }

    @Test
    void stringEncryptor() {
    }

    @Test
    void 환경변수_설정여부_확인 () {
        // then
        assertThat(JasyptConfig.ENCRYPT_KEY).isNotNull();
        assertThat(JasyptConfig.ENCRYPT_KEY).isNotEmpty();
    }

    @Test
    void 암호화_테스트 () {
        // given
        String url = "";
        String username = "username";
        String password = "";

        // when
        String url_encrypted = encryptor.encrypt(url);
        String username_encrypted = encryptor.encrypt(username);
        String password_encrypted = encryptor.encrypt(password);

        System.out.println(url_encrypted);
        System.out.println(username_encrypted);
        System.out.println(password_encrypted);

        // then
        assertThat(encryptor.decrypt(url_encrypted)).isEqualTo(url);
        assertThat(encryptor.decrypt(username_encrypted)).isEqualTo(username);
        assertThat(encryptor.decrypt(password_encrypted)).isEqualTo(password);
    }

}