package kr.noname.noname.user.repository;

import kr.noname.noname.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserRepository {
    Optional<UserInfo> findByLoginId(String loginId);     // 아이디로 사용자 정보 가져옴
}
