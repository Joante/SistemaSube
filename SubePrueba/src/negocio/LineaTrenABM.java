package negocio;


import dao.LineaTrenDao;
import datos.LineaTren;

public class LineaTrenABM {
	private LineaTrenDao dao = new LineaTrenDao();

	public int agregarLineaTren(String nombre) {
		LineaTren c = new LineaTren (nombre);
		return dao.agregar(c);
	}

	public void modificarLineaTren(LineaTren lineaTren){
		dao.actualizar(lineaTren);
	}

	public void eliminarLineaTren(long idLineaTren){
		LineaTren c = dao.traerLineaTren(idLineaTren);
		dao.eliminar(c);
	}

	public LineaTren traerLineaTren(long idLineaTren){
		return dao.traerLineaTren(idLineaTren);
	}
	
}
