package classes;

public class GeraTabuada {

	private Integer MAXIMO = 10;
	
	public String tabuada(Integer numero) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("-------------------------------");
		sb.append(" Tabuada do número " + numero + " ");
		sb.append("-------------------------------");
		sb.append("\n");
		sb.append("\n");
		
		for(int i = 1; i <= this.MAXIMO; i++) {
			int resultado = numero * i;
			sb.append(numero + " x " + i + " = " + resultado + " ");
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
