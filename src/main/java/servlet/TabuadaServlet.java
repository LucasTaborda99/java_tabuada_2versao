package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.GeraTabuada;

@WebServlet(
		name = "TabuadaServlet",
		urlPatterns = {"/tabuada"}
)

public class TabuadaServlet extends HttpServlet {

	private static final long serialVersionUID = 2595351072673549924L;
	private static final GeraTabuada gera = new GeraTabuada();
	private Integer MAXIMO = 10;
	private static final String PARAMETRO = "numero";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		parametros(req, resp);
	}
	
	private void parametros(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		if(req.getParameter(PARAMETRO) == null) {
			for(int i = 1; i <= MAXIMO; i++) {
				out.print(gera.tabuada(i));
			}
		} else {
			
			if(req.getParameter(PARAMETRO).contains(";")) {
				String[] lista = req.getParameter(PARAMETRO).split(";");
				for(String numero : lista) {
					out.print(gera.tabuada(Integer.parseInt(numero)));
				}
			} else {
				Integer num = Integer.parseInt(req.getParameter(PARAMETRO));
				out.print(gera.tabuada(num));
			}
			
		}
	}
}
