package com.maipae.service;

import java.util.List;

import com.maipae.entity.EnterpriseEntity;

public interface EnterpriseService {
	/**
     * Description:[���������� - ע�ᵥλ]<br>
     * 
     * @param addEnterprise
     * @return
     */
	public boolean addEnterprise(EnterpriseEntity enterpriseEntity);
	
	/**
     * Description:[ϵͳ����Ա - ����˵ĵ�λע���б����ݣ����ȡ����ע�ᵥλ����]<br>
     * 
     * @param enterpriseToBeAuditedList
     * @return
     */
    public List<EnterpriseEntity> enterpriseToBeAuditedList(String parameterName, String parameterValue);
    
    /**
     * Description:[ϵͳ����Ա - ����ע�ᵥλ�����״̬]
     * 
     * @param updateEnterprise
     * @return
     */
    public boolean updateEnterprise(EnterpriseEntity enterpriseEntity);
    
    /**
     * Description:[ϵͳ����Ա - ɾ����˲�ͨ����ע�ᵥλ����]
     * 
     * @param deleteEnterprise
     * @return
     */
	public boolean deleteEnterprise(int enterpriseID);
}
