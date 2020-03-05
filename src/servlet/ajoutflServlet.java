package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class ajoutflServlet
 */
@WebServlet("/ajoutflServlet")
public class ajoutflServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajoutflServlet() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ajouterfl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Formation> listef1 = new ArrayList<Formation>();
		Lieu l = new Lieu();
		l.setIdLieu(Integer.parseInt(request.getParameter("idlieu")));
		IFormation daof2 = new Formationdao();
		listef1 = daof2.getFormations(l);
		request.setAttribute("listef1", listef1);
	}
}
