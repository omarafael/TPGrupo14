package PronosticosDeportivos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Partido {
	
	private String IdPartido;
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private int ronda;
	
	
	
	public Partido(String IdPartido, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2, int ronda) {
	
		this.IdPartido=IdPartido;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
		this.ronda= ronda;
		
	}


	public int getRonda() {
		return ronda;
	}


	public String getIdPartido() {
		return IdPartido;
	}


	public void setIdPartido(String idPartido) {
		IdPartido = idPartido;
	}


	public Equipo getEquipo1() {
		return equipo1;
	}


	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}


	public Equipo getEquipo2() {
		return equipo2;
	}


	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}


	public int getGolesEquipo1() {
		return golesEquipo1;
	}


	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}


	public int getGolesEquipo2() {
		return golesEquipo2;
	}


	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

    public String Resultadoequipo1() {
    	if (this.golesEquipo1>this.golesEquipo2){
    		return "ganador";
    		
    	}else if(this.golesEquipo1<this.getGolesEquipo2()) {
    		return "perdedor";
    	     }else return "empate";
    }
	
	//--------------------------------------------------------------------------------
    
    
    public static ArrayList<Partido> ArmarListaPartidos(String archivo) {

		ArrayList<Partido> listaDePartidos = new ArrayList<Partido>();
		try {

			CSVReader csvReader = new CSVReader(new FileReader(archivo));
			String[] fila = null;
			String[] estaFila = null;
			Boolean primeraFila=true;
			
			while ((fila = csvReader.readNext()) != null) {
				if (primeraFila) {
					primeraFila=false;
				} else {
					
			
				estaFila = fila[0].split(";");

				String idPartido = estaFila[0];
				
				Equipo equipo1 = Equipo.existeEquipo(estaFila[2],estaFila[3]);
				Equipo equipo2 = Equipo.existeEquipo(estaFila[7],estaFila[8]);
				int golesEquipo1 = Integer.parseInt(estaFila[4]);
				int golesEquipo2 = Integer.parseInt(estaFila[5]);
				int ronda = Integer.parseInt(estaFila[9]);

				Partido nuevoPartido = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2, ronda);
				listaDePartidos.add(nuevoPartido);
				}
			}

		} catch (IOException e) {
			System.out.println("Error:" + e);
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaDePartidos;

	}

	
	
	

}
