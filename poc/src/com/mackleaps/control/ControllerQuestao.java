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

import com.mackleaps.model.JdbcTemplateCategoria;
import com.mackleaps.model.JdbcTemplateQuestao;
import com.mackleaps.model.dominio.Questao;

@WebServlet("/ControllerQuestao")
public class ControllerQuestao extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public static final String LIST_QUESTOES = "/listQuestao.jsp";
    public static final String INSERT_OR_EDIT = "/questao.jsp";
	private JdbcTemplateQuestao jdbcTempQuest;
	private JdbcTemplateCategoria jdbcTempCat;
	
	public ControllerQuestao(){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		jdbcTempQuest = (JdbcTemplateQuestao) context.getBean("jdbcTemplateQuestao");
		jdbcTempCat = (JdbcTemplateCategoria) context.getBean("jdbcTemplateCategoria");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		//------------------------- DELETAR -------------------------
		if (action.equalsIgnoreCase("delete")){
			forward = LIST_QUESTOES;
			int idQuestao= Integer.parseInt(request.getParameter("idQuestao"));
			int idCategoria = jdbcTempQuest.getQuestao(idQuestao).getIdCategoria();
			jdbcTempQuest.deleteQuestao(idQuestao);
			request.setAttribute("questoes", jdbcTempCat.listQuestoesCategoria(idCategoria));
			
		}
		//------------------------- EDITAR -------------------------
		else if (action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			int idQuestao = Integer.parseInt(request.getParameter("idQuestao"));
			Questao questao = jdbcTempQuest.getQuestao(idQuestao);
			request.setAttribute("questao", questao);
			
		}
		//------------------------- INSERIR -------------------------
		else if (action.equalsIgnoreCase("insert")){
			forward = INSERT_OR_EDIT;
			
		} 
		//------------------------- UPDATE -------------------------
		else {
			forward = LIST_QUESTOES;
			int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
			request.setAttribute("questoes", jdbcTempCat.listQuestoesCategoria(idCategoria));
		}
		
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Questao questao = new Questao();
		questao.setPergunta(request.getParameter("pergunta"));
		questao.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		String idQuestao = request.getParameter("idQuestao");
		
		if (idQuestao == null || idQuestao.isEmpty()){
			jdbcTempQuest.createQuestao(questao);
		}
		
		else {
			questao.setIdQuestao(Integer.parseInt(idQuestao));
			jdbcTempQuest.updateQuestao(questao);
		}
				
		RequestDispatcher view = request.getRequestDispatcher(LIST_QUESTOES);
		request.setAttribute("questoes", jdbcTempCat.listQuestoesCategoria(questao.getIdCategoria()));
		view.forward(request, response);
		
	}
	
}
