package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PassagemDAO;
import modelos.Passagens;

@WebServlet(urlPatterns = { "/passagem", "/passagem-create", "/passagem-update", "/passagem-delete" })
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PassagemDAO ldao = new PassagemDAO();
	Passagem livro = new Passagem();
	
    public PassagemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/passagem":
			read(request, response);
			break;
		case "/passagem-create":
			create(request, response);
			break;
		case "/passagem-update":
			update(request, response);
			break;
		case "/passagem-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passagens> lista = ldao.read();

		request.setAttribute("listaPassagens", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/index.jsp");
		rd.forward(request, response);

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		passagem.setDestino(request.getParameter("destino"));
		passagem.setPreco(Double.parseDouble(request.getParameter("preco")));

		ldao.create(passagem);
		response.sendRedirect("passagem");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		passagem.setId(Integer.parseInt(request.getParameter("id")));
		passagem.setNome(request.getParameter("destino"));
		passagem.setPreco(Double.parseDouble(request.getParameter("preco")));

		ldao.update(passagem);
		response.sendRedirect("passagem");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ldao.delete(id);
		response.sendRedirect("passagem");
	}

}
