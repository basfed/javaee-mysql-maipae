package com.maipae.service;

import java.util.List;

import com.maipae.entity.ProjectSuperviseGroupEntity;

public interface ProjectSuperviseGroupService {
	/**
     * Description:[վ�쵼 - ��ȡ���̼ල���б�����]
     * 
     * @param psgList
     * @return
     */
	List<ProjectSuperviseGroupEntity> psgList();
	
	/**
     * Description:[վ�쵼 - �������ල�� - ���ӵ����̼ල��]
     */
	public boolean addPSG(int projectID);
	
	/**
     * Description:[վ�쵼 - �������ල�� - ��ȡProjectID�б�����]
     * 
     * @param PSGList
     * @return
     */
	List<ProjectSuperviseGroupEntity> PSGList(int projectID);

}
