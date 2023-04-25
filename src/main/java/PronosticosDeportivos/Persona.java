package PronosticosDeportivos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Persona {

	private String nombre;
	private    ArrayList<Pronosticos> listaPronosticos = new ArrayList<Pronosticos>();
	private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	
	
	public void agregarPronostico(Pronosticos pronostico) {
		listaPronosticos.add(pronostico);
		
	}
	
	
	
	public static Persona existePersona(String nombre) {
		
		for( Persona persona: listaPersonas) {
			if (persona.getNombre().equals(nombre))
				return persona;
			} 
		    Persona estaPersona= new Persona(nombre);
		    listaPersonas.add(estaPersona);
			return estaPersona;
			
		}
	
	
	
	public static ArrayList<Persona> ArmarListaDePersonas(String archivo2, ArrayList<Partido> listaDePartidos ) {

		
		try {

			CSVReader csvReader2 = new CSVReader(new FileReader(archivo2));
			String[] fila2 = null;
			String[] estaFila2 = null;
			Boolean primeraFila=true;
			
			while ((fila2 = csvReader2.readNext()) != null) {
				if (primeraFila) {
					primeraFila=false;
				} else {
				estaFila2 = fila2[0].split(";");
                
				Persona estaPersona=existePersona(estaFila2[0]);
			//	System.out.println(estaFila2[0]);
			
								
				String idPartido = estaFila2[1];
				Partido estePartido = null;
				for (Partido partido : listaDePartidos) {
					if (partido.getIdPartido().equals(idPartido)) {
						estePartido = partido;
					}
				}
               
				
				String resultadoEquipo1 = "";

				if (Arrays.asList(estaFila2).indexOf("x") == 4) {
					resultadoEquipo1 = "ganador";

				} else if (Arrays.asList(estaFila2).indexOf("x") == 5) {
					resultadoEquipo1 = "empate";
				} else if (Arrays.asList(estaFila2).indexOf("x") == 6) {
					resultadoEquipo1 = "perdedor";
				}

				Pronosticos nuevoPronostico = new Pronosticos(estePartido,  resultadoEquipo1);
				estaPersona.agregarPronostico(nuevoPronostico);
				

			}
			}
			
			
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}
    
	return Persona.listaPersonas;

	}
	
	public static ArrayList<String[]> tabladePuntos() {
		
		ArrayList<String[]> tablaPuntos = new ArrayList<String[]>();
		for(Persona persona: listaPersonas ) {
            String[] puntaje= {persona.getNombre(), Integer.toString(contarPuntos(persona))};
			tablaPuntos.add(puntaje);
		}
		Collections.sort(tablaPuntos, (x,y) -> y[1].compareTo(x[1]));
		return tablaPuntos;
	}
	
	public static int contarPuntos(Persona persona) {

		int totalPuntos = 0;
		for (Pronosticos pronostico : persona.listaPronosticos) {

			totalPuntos = totalPuntos + pronostico.Puntos();
			
		}
        
		return totalPuntos;
	}
}
