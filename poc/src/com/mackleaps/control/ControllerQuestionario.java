package com.mackleaps.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mackleaps.model.JdbcTemplateQuestionario;
import com.mackleaps.model.dominio.Questionario;

@WebServlet("/ControllerQuestionario")
public class ControllerQuestionario extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    public static final String LIST_QUESTIONARIOS = "/listQuestionario.jsp";
    public static final String INSERT_OR_EDIT = "/questionario.jsp";
    public JdbcTemplateQuestionario jdbcTempQuest;
	
	public ControllerQuestionario(){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		jdbcTempQuest = (JdbcTemplateQuestionario) context.getBean("jdbcTemplateQuestionario");
				
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		//------------------------- DELETAR -------------------------
		if (action.equalsIgnoreCase("delete")){
			forward = LIST_QUESTIONARIOS;			
			int idQuestionario = Integer.parseInt(request.getParameter("idQuestionario"));
			jdbcTempQuest.deleteQuestionario(idQuestionario);
			request.setAttribute("questionarios", jdbcTempQuest.listQuestionario());
			
		}
		//------------------------- EDITAR -------------------------
		else if (action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			int idQuestionario = Integer.parseInt(request.getParameter("idQuestionario"));
			Questionario questionario = jdbcTempQuest.getQuestionario(idQuestionario);
			request.setAttribute("questionario", questionario);
			
		}
		//------------------------- INSERIR -------------------------
		else if (action.equalsIgnoreCase("insert")){
			forward = INSERT_OR_EDIT;
			
		} 
		//------------------------- UPDATE -------------------------
		else {
			forward = LIST_QUESTIONARIOS;
			request.setAttribute("questionarios", jdbcTempQuest.listQuestionario());

		}
		
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Questionario questionario = new Questionario();
		questionario.setTituloQuestionario(request.getParameter("tituloQuestionario"));
		questionario.setDescricaoQuestionario(request.getParameter("descricaoQuestionario"));
		String idQuestionario = request.getParameter("idQuestionario");
		
		if (idQuestionario == null || idQuestionario.isEmpty()){
			jdbcTempQuest.createQuestionario(questionario);
		} 
		
		else {
			questionario.setIdQuestionario(Integer.parseInt(idQuestionario));
			jdbcTempQuest.updateQuestionario(questionario);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_QUESTIONARIOS);
		request.setAttribute("questionarios", jdbcTempQuest.listQuestionario());
		view.forward(request, response);
		
	}
	
}
