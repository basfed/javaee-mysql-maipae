package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.entity.EnterpriseEntity;
import com.maipae.util.DBUtil;

public class EnterpriseDao {
	/**
     * Description:[���������� - ע�ᵥλ]
     * 
     * @param addEnterprise
     * @return
     */
	public boolean addEnterprise(EnterpriseEntity enterpriseEntity) {
		String sql = "insert into t_enterpriseinfo (EnterpriseName,EnterpriseStartTime,EnterpriseCharacter,EnterpriseAddress,EnterpriseNumber,EnterpriseWebSite,EnterpriseOrganCode,EnterprisePerson,EnterpriseEmail,EnterprisePersonTel,EnterprisePassword,EnterpriseState,Remarks) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> param = new ArrayList<Object>();
        param.add(enterpriseEntity.getEnterpriseName());
        param.add(enterpriseEntity.getEnterpriseStartTime());
        param.add(enterpriseEntity.getEnterpriseCharacter());
        param.add(enterpriseEntity.getEnterpriseAddress());
        param.add(enterpriseEntity.getEnterpriseNumber());
        param.add(enterpriseEntity.getEnterpriseWebSite());
        param.add(enterpriseEntity.getEnterpriseOrganCode());
        param.add(enterpriseEntity.getEnterprisePerson());
        param.add(enterpriseEntity.getEnterpriseEmail());
        param.add(enterpriseEntity.getEnterprisePersonTel());
        param.add(enterpriseEntity.getEnterprisePassword());
        param.add(enterpriseEntity.getEnterpriseState());
        param.add(enterpriseEntity.getRemarks());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[ϵͳ����Ա - ����˵ĵ�λע���б����ݣ����ȡ����ע�ᵥλ����]
     * 
     * @param enterpriseToBeAuditedList
     * @return
     */
    public List<EnterpriseEntity> enterpriseToBeAuditedList(String parameterName, String parameterValue) {
    	String sql = "select * from t_enterpriseinfo where " + parameterName + " = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(parameterValue);
        
    	DBUtil db = new DBUtil();
    	
    	try {
			return db.queryInfoByParam(sql, param, EnterpriseEntity.class);
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
     * Description:[ϵͳ����Ա - ����ע�ᵥλ�����״̬]
     * 
     * @param updateEnterprise
     * @return
     */
	public boolean updateEnterprise(EnterpriseEntity enterpriseEntity) {
		String sql = "update t_enterpriseinfo set EnterpriseState= ? where EnterpriseID = ?";
		List<Object> param = new ArrayList<Object>();
        param.add(enterpriseEntity.getEnterpriseState());
        param.add(enterpriseEntity.getEnterpriseID());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[ϵͳ����Ա - ɾ����˲�ͨ����ע�ᵥλ����]
     * 
     * @param deleteEnterprise
     * @return
     */
	public boolean deleteEnterprise(int enterpriseID) {
		// TODO Auto-generated method stub
		String sql = "delete from t_enterpriseinfo where EnterpriseID = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(enterpriseID);
		
		DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
}
