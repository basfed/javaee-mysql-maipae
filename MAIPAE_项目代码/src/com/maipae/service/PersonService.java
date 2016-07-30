package com.maipae.service;

import java.util.List;

import com.maipae.entity.PersonEntity;

public interface PersonService {
	/**
     * Description:[��Ա - ��֤��¼]<br>
     * 
     * @param verifyPerson
     * @return
     */
    public List<PersonEntity> verifyPerson(String personname, String password);
    
    /**
     * Description:[ϵͳ����Ա - ���ͨ����ע�ᵥλ���ӵ�λ��ϵ�˵���Ա��Ϣ��]
     * 
     * @param addPreson
     * @return
     */
	public boolean addPreson(PersonEntity personEntity);
	
	/**
     * Description:[���������� - ��ȡ����λ��Ա�б�����]
     * 
     * @param enterprisePersonList
     * @return
     */
	public List<PersonEntity> enterprisePersonList(String parameterName, int parameterValue);
	
	/**
     * Description:[��Ա - ������Ϣ]
     * 
     * @param personInfo
     * @return
     */
	public List<PersonEntity> personInfo(int personID);
	
	/**
     * Description:[��Ա - ��ȡ�ල�鳤�б����ݣ���ȡ�ලԱ�б�����]
     * 
     * @param jdpList
     * @return
     */
	public List<PersonEntity> jdpList(String identity);
    
}