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
import com.mackleaps.model.JdbcTemplateQuestionario;
import com.mackleaps.model.dominio.Categoria;

@WebServlet("/ControllerCategoria")
public class ControllerCategoria extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public static final String LIST_CATEGORIAS = "/listCategoria.jsp";
    public static final String INSERT_OR_EDIT = "/categoria.jsp";
    public static final String LIST_QUESTOES_CATEGORIA = "/listQuestao.jsp";
	private JdbcTemplateCategoria jdbcTempCat;
	private JdbcTemplateQuestionario jdbcTempQuest;
	
	public ControllerCategoria(){
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		jdbcTempCat = (JdbcTemplateCategoria) context.getBean("jdbcTemplateCategoria");
		jdbcTempQuest = (JdbcTemplateQuestionario) context.getBean("jdbcTemplateQuestionario");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		
		//---------------------- LISTA CATEGORIAS -------------------
		if (action.equalsIgnoreCase("listQuestao")){
			forward = LIST_QUESTOES_CATEGORIA;
			int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));			
			request.setAttribute("questoes", jdbcTempCat.listQuestoesCategoria(idCategoria));
			
		}
		//------------------------- DELETAR -------------------------
		else if (action.equalsIgnoreCase("delete")){
			forward = LIST_CATEGORIAS;
			int idCategoria= Integer.parseInt(request.getParameter("idCategoria"));
			int idQuestionario = jdbcTempCat.getCategoria(idCategoria).getIdQuestionario();
			jdbcTempCat.deleteCategoria(idCategoria);
			request.setAttribute("categorias", jdbcTempQuest.listCategoriasQuestionario(idQuestionario));
			
		}
		//------------------------- EDITAR -------------------------
		else if (action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			
			int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
			Categoria categoria = jdbcTempCat.getCategoria(idCategoria);
			request.setAttribute("categoria", categoria);
			
		}
		//------------------------- INSERIR -------------------------
		else if (action.equalsIgnoreCase("insert")){
			forward = INSERT_OR_EDIT;
			
		} 
		//------------------------- UPDATE -------------------------
		else {
			forward = LIST_CATEGORIAS;
			int idQuestionario = Integer.parseInt(request.getParameter("idQuestionario"));
			request.setAttribute("categorias", jdbcTempQuest.listCategoriasQuestionario(idQuestionario));
		}
		
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setTituloCategoria(request.getParameter("tituloCategoria"));
		categoria.setDescricaoCategoria(request.getParameter("descricaoCategoria"));
		categoria.setIdQuestionario(Integer.parseInt(request.getParameter("idQuestionario")));
		String idCategoria = request.getParameter("idCategoria");
		
		if (idCategoria == null || idCategoria.isEmpty()){
			jdbcTempCat.createCategoria(categoria);
		} 
		
		else {
			categoria.setIdCategoria(Integer.parseInt(idCategoria));
			jdbcTempCat.updateCategoria(categoria);
		}
				
		RequestDispatcher view = request.getRequestDispatcher(LIST_CATEGORIAS);
		request.setAttribute("categorias", jdbcTempQuest.listCategoriasQuestionario(categoria.getIdQuestionario()));
		view.forward(request, response);
	}
	
}
