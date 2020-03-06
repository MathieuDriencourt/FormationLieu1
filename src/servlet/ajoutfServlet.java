package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Formationdao;
import dao.IFormation;
import dao.ILieu;
import dao.Lieudao;
import model.Formation;
import model.Lieu;



/**
 * Servlet implementation class ajoutfServlet
 */
@WebServlet("/ajoutfServlet")
public class ajoutfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lieu> listefl = new ArrayList<Lieu>();
		ILieu daol = new Lieudao();
		listefl = daol.afficheLieux();
		request.setAttribute("listefl", listefl);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ajouterf.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation form = new Formation();
		form.setTheme(request.getParameter("theme"));
		IFormation dao = new Formationdao();
		
		Lieu l = new Lieu();
		l.setIdLieu(Integer.parseInt(request.getParameter("lieu")));
		form.setLieu(l);
		dao.ajoutFormation(form);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/confirmationf.jsp").forward(request, response);
	}

}
