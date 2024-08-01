package service.custom;

import dto.MemberDto;
import service.SuperService;

public interface MemberService extends SuperService{

    public MemberDto getMember(String member_id)throws Exception;

}
