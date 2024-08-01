package dao.custom.impl;

import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.MemberDao;
import entity.MemberEntity;
import java.sql.ResultSet;

public class MemberDaoImpl implements MemberDao {

    @Override
    public boolean create(MemberEntity t) throws Exception {
       return false;
    }

    @Override
    public boolean update(MemberEntity t) throws Exception {
       return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
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
        return null;
    }

}
