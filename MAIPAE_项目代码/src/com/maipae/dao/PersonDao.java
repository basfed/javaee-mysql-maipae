package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.entity.PersonEntity;
import com.maipae.util.DBUtil;

public class PersonDao {
	/**
     * Description:[��Ա - ��֤��¼]
     * 
     * @param verifyPerson
     * @return
     */
    public List<PersonEntity> verifyPerson(String personname, String password) {
        String sql = "select PersonID,PersonName,Password,PersonIdentity,EnterpriseID from t_personinfo where PersonName = ? and Password = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(personname);
        param.add(password);
        
        DBUtil db = new DBUtil();
        
        try {
			return db.queryInfoByParam(sql, param, PersonEntity.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * Description:[ϵͳ����Ա - ���ͨ����ע�ᵥλ���ӵ�λ��ϵ�˵���Ա��Ϣ��]
     * 
     * @param addPreson
     * @return
     */
	public boolean addPreson(PersonEntity personEntity) {
		String sql = "insert into t_personinfo (PersonName,TelNumber,Email,Password,PersonIdentity,EnterpriseID) values (?,?,?,?,?,?)";
        List<Object> param = new ArrayList<Object>();
        param.add(personEntity.getPersonName());
        param.add(personEntity.getTelNumber());
        param.add(personEntity.getEmail());
        param.add(personEntity.getPassword());
        param.add(personEntity.getPersonIdentity());
        param.add(personEntity.getEnterpriseID());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[���������� - ��ȡ����λ��Ա�б�����]
     * 
     * @param enterprisePersonList
     * @return
     */
	public List<PersonEntity> enterprisePersonList(String parameterName, int parameterValue) {
		String sql = "select PersonName,TelNumber,Email,PersonIdentity from t_personinfo where " + parameterName + " = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(parameterValue);
        
    	DBUtil db = new DBUtil();
    	
    	try {
			return db.queryInfoByParam(sql, param, PersonEntity.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * Description:[���������� - ��ȡ����λ��Ա�б�����]
     * 
     * @param personInfo
     * @return
     */
	public List<PersonEntity> personInfo(int personID) {
		String sql = "select * from t_personinfo where PersonID = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(personID);
        
    	DBUtil db = new DBUtil();
    	
    	List<PersonEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, PersonEntity.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
     * Description:[��Ա - ��ȡ�ල�鳤�б����ݣ���ȡ�ලԱ�б�����]
     * 
     * @param jdpList
     * @return
     */
	public List<PersonEntity> jdpList(String identity) {
		String sql = "select PersonID,PersonName,PersonIdentity from t_personinfo where PersonIdentity = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(identity);
        
    	DBUtil db = new DBUtil();
    	
    	try {
			return db.queryInfoByParam(sql, param, PersonEntity.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
}
