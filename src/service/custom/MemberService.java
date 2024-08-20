package service.custom;

import java.util.ArrayList;

import dto.MemberDto;
import service.SuperService;

public interface MemberService extends SuperService{

    MemberDto get(String member_id)throws Exception;
    String save(MemberDto memberDto) throws Exception;
    String update(MemberDto memberDto) throws Exception;
    String delete(String member_id) throws Exception;
    ArrayList<MemberDto> getAll () throws Exception;
   
}
