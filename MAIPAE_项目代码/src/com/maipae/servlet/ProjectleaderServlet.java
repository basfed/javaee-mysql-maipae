package com.maipae.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maipae.entity.ProjectEntity;
import com.maipae.service.ProjectService;
import com.maipae.service.impl.ProjectServiceImpl;

/**
 * Servlet implementation class ProjectleaderServlet
 */
@WebServlet("/ProjectleaderServlet")
public class ProjectleaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectleaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		if ("search-results".equals(type)) {//��ѯ������Ŀ����
            this.searchProjectList(request, response);
        }
		else if ("addProject".equals(type)) {//����������Ŀ����
            this.addProject(request, response);
        }
		else if ("projectDetail".equals(type)) {//������Ŀ��������
            this.projectDetail(request, response);
        }
		else if ("modifyProject".equals(type)) {//�޸Ľ�����Ŀ����
            this.modifyProject(request, response);
        }
		else if ("changeMState".equals(type)) {//�ύ������Ŀ����
            this.changeMState(request, response);
        }
		else if ("deleteProject".equals(type)) {//ɾ��������Ŀ����
            this.deleteProject(request, response);
        }
		
	}

	/**
     * Description:[������Ŀ������ - ��ѯ������Ŀ����]
     */
	public void searchProjectList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String s = request.getParameter("s");
		
		System.out.println(s);
		
		ProjectService projectService = new ProjectServiceImpl();
        
        List<ProjectEntity> searchProjectList = projectService.searchProjectList(s);
        
        request.setAttribute("searchProjectList", searchProjectList);
        request.setAttribute("s", s);
        
        try {
    		request.getRequestDispatcher("projectleader-search-results.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[������Ŀ������ - ����������Ŀ����]
     */
	private void addProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String projectName = request.getParameter("projectName");
		String projectFiles = request.getParameter("projectFiles");
		int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
		String projectStartTimeString = request.getParameter("projectStartTime");
        String projectEndTimeString = request.getParameter("projectEndTime");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date projectStartTime = null;
        Date projectEndTime = null;
		try {
			projectStartTime = sdf.parse(projectStartTimeString);//�ַ���ת����
			projectEndTime = sdf.parse(projectEndTimeString);//�ַ���ת����
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int personID = Integer.valueOf(request.getParameter("personID"));
        String belongStations = request.getParameter("belongStations");
        String stationName = request.getParameter("stationName");
        String remarks = request.getParameter("remarks");
        
        ProjectService projectService = new ProjectServiceImpl();
        
        ProjectEntity pe = new ProjectEntity();
        pe.setProjectName(projectName);
        pe.setProjectFiles(projectFiles);
        pe.setEnterpriseID(enterpriseID);
        pe.setState("δ���");
        pe.setProjectStartTime(projectStartTime);
        pe.setProjectEndTime(projectEndTime);
        pe.setPersonID(personID);
        pe.setBelongStations(belongStations);
        pe.setStationName(stationName);
        pe.setRemarks(remarks);
        pe.setMonitorState("δ����");
        
        projectService.addProject(pe);
        
        try {
			response.sendRedirect("projectleader-index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[������Ŀ������ - ������Ŀ��������]
     */
	private void projectDetail(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		
		ProjectService projectService = new ProjectServiceImpl();
        
        List<ProjectEntity> projectDetail = projectService.projectDetail(projectID);
        
        request.setAttribute("projectDetail", projectDetail);
        request.setAttribute("projectID", projectID);
        
    	try {
    		
    		request.getRequestDispatcher("projectleader-modify-project.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[������Ŀ������ - �޸Ľ�����Ŀ����]
     */
	public void modifyProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		String projectName = request.getParameter("projectName");
		String projectFiles = request.getParameter("projectFiles");
		int enterpriseID = Integer.valueOf(request.getParameter("enterpriseID"));
		String projectStartTimeString = request.getParameter("projectStartTime");
        String projectEndTimeString = request.getParameter("projectEndTime");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date projectStartTime = null;
        Date projectEndTime = null;
		try {
			projectStartTime = sdf.parse(projectStartTimeString);//�ַ���ת����
			projectEndTime = sdf.parse(projectEndTimeString);//�ַ���ת����
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int personID = Integer.valueOf(request.getParameter("personID"));
        String stationName = request.getParameter("stationName");
        String remarks = request.getParameter("remarks");
        String monitorState = request.getParameter("monitorState");
        
        ProjectService projectService = new ProjectServiceImpl();
        
        ProjectEntity pe = new ProjectEntity();
        pe.setProjectID(projectID);
        pe.setProjectName(projectName);
        pe.setProjectFiles(projectFiles);
        pe.setEnterpriseID(enterpriseID);
        pe.setProjectStartTime(projectStartTime);
        pe.setProjectEndTime(projectEndTime);
        pe.setPersonID(personID);
        pe.setBelongStations("�Ĵ�ʡ�ɶ���");
        pe.setStationName(stationName);
        pe.setRemarks(remarks);
        pe.setMonitorState(monitorState);
        
        projectService.modifyProject(pe);
        
        try {
			response.sendRedirect("projectleader-index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[������Ŀ������ - �ύ������Ŀ����]
     */
	private void changeMState(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		
		ProjectService projectService = new ProjectServiceImpl();
		
		projectService.changeMState(projectID);
        
        try {
			response.sendRedirect("projectleader-index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * Description:[������Ŀ������ - ɾ��������Ŀ����]
     */
	public void deleteProject(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int projectID = Integer.valueOf(request.getParameter("projectID"));
		String s = request.getParameter("s");
		
		ProjectService projectService = new ProjectServiceImpl();
		
		projectService.deleteProject(projectID);
        
        try {
			response.sendRedirect("ProjectleaderServlet?type=search-results&s=" + s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}