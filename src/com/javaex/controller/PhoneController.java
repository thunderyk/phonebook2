package com.javaex.controller;

import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
//나중에 필요 잠시 남겨둠

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;;

@WebServlet("/PhoneController")
public class PhoneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "list";
		}
		//
		if(action.equals("list")) {
			//리스트 출력 관련
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getPhoneList();
			
			//데이터 전달
			request.setAttribute("personList", personList);
			
			//jsp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("./list.jsp"); 
			rd.forward(request, response);
		}else if(action.equals("writeForm")) {
			//jsp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("./writeForm.jsp"); 
			rd.forward(request, response);
		}else if(action.equals("delete")) {
			int personId = Integer.parseInt(request.getParameter("id"));
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.PhoneDelete(personId);
			
			RequestDispatcher rd = request.getRequestDispatcher("./PhoneController?action=list");
			rd.forward(request, response);
		}else if(action.equals("updateForm")) {
			//궁금증 list.jsp에서 보낸 id의 값을 여기서 받지 않아도 updateForm에서 받을 수 있다.
			//아마 cookie로 남아 있어서 남을 수 있는 거 같은데 이렇게 해도 괜찮은 것일까?
			//아니면 attribute로 넘겨야 할까?
			// -> 결론 파라미터 영역에 계속 남아 있는 것임
			RequestDispatcher rd = request.getRequestDispatcher("./updateForm.jsp"); 
			rd.forward(request, response);
		}
		
		
		/*
		doPost(request,response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//RequestDispatcher rd = request.getRequestDispatcher("./list.jsp");
		response.sendRedirect("./list.jsp");*/ //중간에 공부
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert, update를 post로 보내봄 공부를 위해 test해봄
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "list";
		}
		
		if(action.equals("list")) {
			//리스트 출력 관련
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getPhoneList();
			
			//데이터 전달
			request.setAttribute("personList", personList);
			
			//jsp에 포워드 시킨다.
			RequestDispatcher rd = request.getRequestDispatcher("./list.jsp"); 
			rd.forward(request, response);
		}else if(action.equals("insert")) {
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVo personVo = new PersonVo(name,hp,company);
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.PhoneInsert(personVo);
			
			RequestDispatcher rd = request.getRequestDispatcher("./PhoneController?action=list");
			rd.forward(request, response);
			
		}else if(action.equals("update")) {
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			int personId = Integer.parseInt(request.getParameter("id"));
			
			PersonVo personVo = new PersonVo(personId,name,hp,company);
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.PhoneUpdate(personVo);
			
			RequestDispatcher rd = request.getRequestDispatcher("./PhoneController?action=list");
			rd.forward(request, response);
		}
		
		/*
		//doGet(request,response);
		System.out.println("doPost");
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("./list.jsp");
		rd.forward(request, response);*/ //중간에 공부
	}

}
