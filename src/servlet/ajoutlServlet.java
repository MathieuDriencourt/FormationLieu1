package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ILieu;
import dao.Lieudao;
import model.Lieu;

/**
 * Servlet implementation class ajoutlServlet
 */
@WebServlet("/ajoutlServlet")
public class ajoutlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ajouterl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Lieu li = new Lieu();
		li.setVille(request.getParameter("ville"));
		li.setAdresse(request.getParameter("adresse"));
		ILieu dao = new Lieudao();
		dao.createLieu(li);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/confirmationl.jsp").forward(request, response);
	}

}
