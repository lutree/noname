package kr.noname.noname.user.service;

import kr.noname.noname.user.entity.UserInfo;
import kr.noname.noname.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserInfo findByLoginId(String loginId) throws Exception {
        UserInfo userInfo = userRepository.findByLoginId(loginId).orElseThrow(Exception::new);
        log.debug(String.valueOf(userInfo));
        return userInfo;
    }
}
