package service.custom.impl;

import dao.DaoFactory;
import dao.custom.MemberDao;
import dto.MemberDto;
import entity.MemberEntity;
import service.custom.MemberService;

public class MemberServiceImpl implements MemberService {
     
    
    private MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.Member); 

    
    public MemberDto getMember(String member_id) throws Exception {
       MemberEntity entity =  memberDao.get(member_id);
        if(entity != null){
            return getMemberDto((MemberEntity) entity);
        }
        return null;

    }
     private MemberEntity getMemberEntity(MemberDto memberDto){
       return new MemberEntity(
            memberDto.getMember_id(),
            memberDto.getName(),
            memberDto.getAddress(),
            memberDto.getAge(),
            memberDto.getContact());

    }

    private MemberDto getMemberDto(MemberEntity memberEntity){
        return new MemberDto(
             memberEntity.getMember_id(),
             memberEntity.getName(),
             memberEntity.getAddress(),
             memberEntity.getAge(),
             memberEntity.getContact());
     }


}
