package kr.noname.noname.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class CmUserInfo {

  private String userUid;
  private String userNm;
  private String userNknm;
  private String bhdt;
  private String gndrCd;
  private String userCno;
  private String userEmail;
  private String loginId;
  private String loginPw;
  private Timestamp pwUpdtDtm;
  private String loginLockYn;
  private Timestamp rcntLoginDtm;
  private String useYn;
  private Timestamp rcrdRegDtm;
  private String rcrdRegId;
  private Timestamp rcrdUpdtDtm;
  private String rcrdUpdtId;

}
