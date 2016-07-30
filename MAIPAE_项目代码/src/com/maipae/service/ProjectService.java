package com.maipae.service;

import java.util.List;

import com.maipae.entity.ProjectEntity;

public interface ProjectService {
	/**
     * Description:[������Ŀ������ - ��ѯ������Ŀ����]
     * 
     * @param verifyPerson
     * @return
     */
    public List<ProjectEntity> searchProjectList(String s);
    
    /**
     * Description:[������Ŀ������ - ����������Ŀ����]
     * 
     * @param addProject
     * @return
     */
    public boolean addProject(ProjectEntity projectEntity);
    
    /**
     * Description:[������Ŀ������ - ������Ŀ��������]
     * 
     * @param projectDetail
     * @return
     */
	public List<ProjectEntity> projectDetail(int projectID);
	
	/**
     * Description:[������Ŀ������ - �޸Ľ�����Ŀ����]
     * 
     * @param modifyProject
     * @return
     */
	public boolean modifyProject(ProjectEntity pe);
	
    /**
     * Description:[������Ŀ������ - �ύ������Ŀ����]
     * 
     * @param changeMState
     * @return
     */
    public boolean changeMState(int projectID);
    
    /**
     * Description:[������Ŀ������ - ɾ��������Ŀ����]
     * 
     * @param deleteProject
     * @return
     */
	public boolean deleteProject(int projectID);
	
	/**
     * Description:[�������Ա - ��ȡ������Ŀ�����б�����]
     * 
     * @param projectList
     * @return
     */
	public List<ProjectEntity> projectList();
	
	/**
     * Description:[�������Ա - �������]
     * 
     * @param projectList
     * @return
     */
	public boolean reviewProject(int projectID, String state);
	
	/**
     * Description:[վ�쵼 - ��ȡ���ͨ���Ľ�����Ŀ�����б�����]
     * 
     * @param statedProjectList
     * @return
     */
	public List<ProjectEntity> statedProjectList(String stated);
	
}
