package dao.custom.impl;

import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.MemberDao;
import entity.MemberEntity;
import java.sql.ResultSet;

public class MemberDaoImpl implements MemberDao {

    @Override
    public boolean create(MemberEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO Member VALUES(?,?,?,?,?)", t.getMember_id(), t.getName(), t.getAddress(), t.getAge(), t.getContact());
    }

    @Override
    public boolean update(MemberEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE Member SET Name = ?, Address = ?, Age = ?, Contact = ? WHERE Member_id = ?", 
       t.getName(), t.getAddress(), t.getAge(), t.getContact(), t.getMember_id());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Member WHERE Member_id = ?", id);
    }

    @Override
    public MemberEntity get(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM member WHERE member_id = ?",id);
         if (rst.next()) {
        MemberEntity entity = new MemberEntity(rst. getString("Member_id"),
                       rst.getString("Name"),rst.getString("Address"),
                       rst.getInt("Age"),rst.getString("Contact"));
          return entity;
        
       }
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
         ArrayList<MemberEntity> memberEntities = new ArrayList<>();
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Member");
       while ( rst.next()) {
        MemberEntity entity = new MemberEntity(rst. getString("Member_id"),
                       rst.getString("Name"),rst.getString("Address"),
                       rst.getInt("Age"),rst.getString("Contact"));
                    memberEntities.add(entity);

       }
       return memberEntities;
    }

}
