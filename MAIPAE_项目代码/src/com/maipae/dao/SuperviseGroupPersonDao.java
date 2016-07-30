package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.util.DBUtil;

public class SuperviseGroupPersonDao {
	
	/**
     * Description:[վ�쵼 - ���ӹ��̼ල����Ա���ල�鳤���ලԱ��]
     * 
     * @param addPSG
     * @return
     */

	public boolean addPSG(int projectSuperviseGroupID, String personID, String post) {
		// TODO Auto-generated method stub
		String sql = "insert into t_supervisegroupperson (ProjectSuperviseGroupID, PersonID, Post) values (?,?,?)";
		List<Object> param = new ArrayList<Object>();
		param.add(projectSuperviseGroupID);
		param.add(personID);
		param.add(post);
		        
		DBUtil db = new DBUtil();
		        
		return db.InsertUpdateDeleteExcute(sql, param);
	}

}
