package PronosticosDeportivos;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		String archivo = "Partidos.csv";
		String archivo2 = "Pronosticos.csv";
		ArrayList<Partido> listaDePartidos;
		ArrayList<Persona> listaDePersonas;
		
		
		
		listaDePartidos = Partido.ArmarListaPartidos(archivo);
		
		for(Partido partidos: listaDePartidos) {
			System.out.println(partidos.getIdPartido());
		}
		
		listaDePersonas = Persona.ArmarListaDePersonas(archivo2,listaDePartidos);
		
		for(Persona personas: listaDePersonas) {
			System.out.println(personas.getNombre());
			
		}
		
	   	        	
	   
	    ArrayList<String[]> tablaPuntajes=Persona.tabladePuntos();
	    for(String[] puntaje: tablaPuntajes) {
	    	System.out.println("Apostador: " + puntaje[0] + " Puntos: " + puntaje[1]);
	    	
	    }
	    
	    
	    }
	}


