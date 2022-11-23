package triki;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	// Variables para guardar datos del usuario y del simbolo elegido
	static String[] simbolos =  new String [3];
	static String Jugador1= "";
	static String Jugador2= "";
	static String simbolo1= "";
	static String simbolo2= "";
	
	//Creación del tablero
	static String[][] tablero = new String [3][3];
	static int jugadorTurno = 1;
	
	
	//Variable para jugar de nuevo
	static int jugarNuevo;
	
	public static void main(String[] args) {
		
		
		 datosjugadores();
		 simbolos[0]="";
		 simbolos[1]=simbolo1;
		 simbolos[2]=simbolo2;
		 iniciarTablero();
		 mostrarTablero();
		 jugar();
	
	}
	
	public static void datosjugadores() {
		Scanner scanner = new Scanner(System.in);
		//Solicitar datos de los usuarios
		System.out.println("Ingresar nombre de Jugador 1 :");
		Jugador1 = scanner.nextLine();
		
		System.out.println("Seleccione simbolo X o O :");
		simbolo1= scanner.nextLine();
		
		System.out.println("Nombre de Jugador 1 "+Jugador1 + " Simbolo es: "+ simbolo1);
		
		if(simbolo1.equals("x") ||simbolo1.equals("X")) {
			simbolo1="X";
			simbolo2="O";
			//System.out.println("if ingreso" + simbolo1 + " " + simbolo2);	
		}
		else {
			simbolo2="X";
			//System.out.println("else ingreso" + simbolo1 + " " + simbolo2);
		};
		
		System.out.println("Ingresar nombre de Jugador 2 :");
		Jugador2 = scanner.nextLine();
		System.out.println("Nombre de Jugador 2 "+Jugador2 + " Simbolo es: "+ simbolo2);
		
	}

	public static void iniciarTablero() {
		
		int posicion = 1;
		
		for (int i = 0;i < 3;i++){//iniciar filas
			for(int j = 0;j < 3; j++) {// iniciar columnas
				tablero[i][j]= String.valueOf(posicion);
				posicion++;
			}
		}
	}
	
	public static void mostrarTablero() {
		
		System.out.println(tablero[0][0]+ " | " + tablero[0][1]+ " | " + tablero[0][2]);
		System.out.println("--------");
		System.out.println(tablero[1][0]+ " | " + tablero[1][1]+ " | " + tablero[1][2]);
		System.out.println("--------");
		System.out.println(tablero[2][0]+ " | " + tablero[2][1]+ " | " + tablero[2][2]);
		System.out.println("--------");
	}
	
	public static void jugar() {
		
		//Mostrar el nombre del jugador
		String nombreJugador ="";
		if(jugadorTurno == 1) {
			nombreJugador= Jugador1;
		}else {
			nombreJugador=Jugador2;
		}
			
		Scanner scanner = new Scanner(System.in);
		System.out.print("Usuario que Juega es "+ nombreJugador+" "+ " juega con "+ simbolos[jugadorTurno] + " Indicar Posicion de juego : " );
		int posicion_usuario = scanner.nextInt();
		
		// capturar la coordenadas para ingresar datos o simbolo 
		int i,j;
		switch (posicion_usuario){
			case 1:
				i=0;
				j=0;
				break;
			case 2:
				i=0;
				j=1;
				break;
			case 3:
				i=0;
				j=2;
				break;
			case 4:
				i=1;
				j=0;
				break;
			case 5:
				i=1;
				j=1;
				break;
			case 6:
				i=1;
				j=2;
				break;
			case 7:
				i=2;
				j=0;
				break;
			case 8:
				i=2;
				j=1;
				break;
			case 9:
				i=2;
				j=2;
				break;
			default:
				System.out.println("Posición incorrecta, intentar nuevamente");
				jugar();
				return;
		}
		//validar si en la posicion hay marcación en esa posicion
		if(tablero [i][j] == "X" || tablero [i][j]== "O") {
			System.out.println("Ya hay marca, ingresar otra posición");
			jugar();
			return;
		}
		tablero[i][j] =simbolos[jugadorTurno];
		if(!Ganador()) {
			if(jugadorTurno ==1) {
				jugadorTurno++;
			}else {
				jugadorTurno--;
			}
			mostrarTablero();
			jugar();
		}else{
			
			if( nombreJugador== Jugador1) {
				System.out.println();
				System.out.println("Ya hay ganador y es: "+ Jugador1 + " y el perdedor es : "+Jugador2);
				System.out.println("Quiere volver a Jugar Si :1 / No :2");
				jugarNuevo= scanner.nextInt();
				if(jugarNuevo ==1){
					iniciarTablero();
					mostrarTablero();
					jugar();
					return;
				}else {
					System.out.println("Jugos Finalizados");
				}
			}else {
				System.out.println();
				System.out.println("Ya hay ganador y es: "+ Jugador2 + " y el perdedor es : "+Jugador1);
				System.out.println("Quiere volver a Jugar Si :1 / No :2");
				jugarNuevo= scanner.nextInt();
				if(jugarNuevo ==1){
					iniciarTablero();
					mostrarTablero();
					jugar();
					return;
				}else {
					System.out.println("Jugos Finalizados");
				}
				
			}
			
			
		}
	}
	
	public static boolean Ganador() {
		//validar la primera fila
		if(tablero [0][0] == tablero [0][1] && tablero [0][1] == tablero [0][2]  ){
			return true;
		}
		//Validar la segunda fila
		else if(tablero [1][0] == tablero [1][1] && tablero [1][1] == tablero [1][2]  ){
			return true;
		}
		//Validar la tercera fila
		else if(tablero [2][0] == tablero [2][1] && tablero [2][1] == tablero [2][2]  ){
			return true;
		}
		//Validar la primera columna
		else if(tablero [0][0] == tablero [1][0] && tablero [1][0] == tablero [2][0]  ){
			return true;
		}
		//Validar la segunda columna
		else if(tablero [0][1] == tablero [1][1] && tablero [1][1] == tablero [2][1]  ){
			return true;
		}
		//Validar la tercero columna
		else if(tablero [0][2] == tablero [1][2] && tablero [1][2] == tablero [2][2]  ){
			return true;
		}
		//Validar la primera diagonal izq a der, arriba a abajo
		else if(tablero [0][0] == tablero [1][1] && tablero [1][1] == tablero [2][2]  ){
			return true;
		}
		//Validar la segunda diagonal der a izq, arriba a abajo
		else if(tablero [0][2] == tablero [1][1] && tablero [1][1] == tablero [2][0]  ){
			return true;
		}
		else{
			return false;
		}
	}
}
