package kr.noname.noname.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {

//    private static final String ALGORITHM = "PBEWithMD5AndDES";
    public static final String ALGORITHM = "PBEWITHHMACSHA512ANDAES_256";
    public static final String ENCRYPT_KEY = System.getenv("JASYPT_SECRET_KEY");

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword(ENCRYPT_KEY);     // 암호화할 때 사용하는 키
        config.setAlgorithm(ALGORITHM);     // 암호화 알고리즘
        config.setKeyObtentionIterations("1000");   // 반복할 해싱 함수
        config.setPoolSize("1");    // 인스턴스 pool
        config.setProviderName("SunJCE");   // 프로바이더
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");    // salt 생성 클래스 지정
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");   // 인코딩

        encryptor.setConfig(config);

        return encryptor;
    }
}
