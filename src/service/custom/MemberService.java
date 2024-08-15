package service.custom;

import java.util.ArrayList;

import dto.BooksDto;
import dto.MemberDto;
import service.SuperService;

public interface MemberService extends SuperService{

    MemberDto get(String member_id)throws Exception;
    String save(MemberDto memberDto) throws Exception;
    String update(MemberDto memberDto) throws Exception;
    String delete(MemberDto memberDto) throws Exception;
   
    static ArrayList<BooksDto> getAll () throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
