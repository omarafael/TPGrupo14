package PronosticosDeportivos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Pronosticos {

	private Partido partido;
	private String resultadoEquipo1;
	
	
	public Pronosticos(Partido partido, String resultadoEquipo1) {
		
		this.partido = partido;
		this.resultadoEquipo1= resultadoEquipo1;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}



	public String getResultadoEquipo1() {
		return resultadoEquipo1;
	}


	public void setResultadoEquipo1(String resultadoEquipo1) {
		this.resultadoEquipo1 = resultadoEquipo1;
	}
	
	public int Puntos() {
		int Puntos=0;
		if (this.resultadoEquipo1.equals(partido.Resultadoequipo1())) {
			Puntos=1;
		}
			return Puntos;
		}
	
	//--------------------------------------------------------------------------
	
	
	

	// ---------------------------------------------------------------------

	public static int contarPuntos(ArrayList<Pronosticos> listaDePronosticos) {

		int totalPuntos = 0;
		for (Pronosticos pronostico : listaDePronosticos) {

			totalPuntos = totalPuntos + pronostico.Puntos();
		}

		return totalPuntos;
	}


	
	}
	
	

