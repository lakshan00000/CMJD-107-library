package service.custom.impl;

import java.util.ArrayList;

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
    @Override
    public MemberDto get(String member_id) throws Exception {
         MemberDao entity = (MemberDao) memberDao.get(member_id);
        if(entity != null){
            return getMemberDto ((MemberEntity) entity);
        }
        return null;
    }
    @Override
    public String save(MemberDto memberDto) throws Exception {
        MemberEntity entity = getMemberEntity(memberDto);
        
      return memberDao.create(entity) ? "Success": "Fail"; 
    }
    @Override
    public String update(MemberDto memberDto) throws Exception {
        MemberEntity entity = getMemberEntity(memberDto);
        
        return memberDao.update(entity) ? "Success": "Fail";
    }
    @Override
    public String delete(MemberDto memberDto) throws Exception {
        return memberDao.delete(memberDto) ;
    }
    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntities = memberDao.getAll();
        if (memberEntities != null && !memberEntities.isEmpty() ) {
            ArrayList<MemberDto> memberDtos= new ArrayList<>();

            for( MemberEntity memberEntity: memberEntities) {
                memberDtos.add(getMemberDto(memberEntity));
            }
            return memberDtos;
            
        }
        return null;
    }


}
