import java.util.Scanner;

public class APSMATH {
public static void main(String[] args) {

Scanner Lap = new Scanner(System.in);
boolean p = false, q = false, r = false;

System.out.println("Responda com 'Sim' ou 'Não' os Sensores");


// -- SENSOR P --
String entrada;
while (true) {
     System.out.println("Sensor P - A terra esta seca? ");
     entrada = Lap.nextLine().trim();
     if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S") ) {p = true; break;}
     else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N") ) {p = false; break;}
     else System.out.println("Resposta invalida. Por favor, Responda apenas com 'Sim' ou 'Não' "); 
}

// -- SENSOR Q --
while (true) {
    System.out.println("Sensor Q - O Sol esta Forte? ");
    entrada = Lap.nextLine().trim();
    if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S") ) {q = true; break;}
    else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N") ) {q = false; break;}
    else System.out.println("Resposta invalida. Por favor, Responda apenas com 'Sim' ou 'Não' ");
}

// -- SENSOR R --
while (true) {
    System.out.println("Sensor R - Detectou Alguma Praga?");
    entrada = Lap.nextLine().trim();
    if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {r = true; break;}
    else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N")) {r = false; break;}
    else System.out.println("Resposta invalida. Por favor, Responda apenas com 'Sim' ou 'Não' ");
}

// -- PROCESSAMENTO LOGICO --
// -- S= ( ( P Ou Q ) E ~R) OU R --
// -- O Sistema so acionara o toldo ou a irrigação se Não houver pragas --
boolean acionarRegador = p && !r;
boolean acionarToldo = q && !r;
boolean acionarRepelente = r;

// -- Saida Final Do Sistema --
System.out.println("\n[RELATORIO DO SISTEMA] ");
System.out.println("----------------------------------------------------------------");
System.out.println("Irrigador:   " + (acionarRegador ? "[LIGADO]" : (p && r ? "[DESLIGADO - PRAGA DETECTADA]" : "[DESLIGADO]") ) );
System.out.println("Toldo:      " + (acionarToldo ? "[ESTENDIDO]" : (q && r ? "[RECOLHIDO - PRAGA DETECTADA]" : "[RECOLHIDO]") ) );
System.out.println("Repelente: " + (acionarRepelente ? "[DISPARANDO]" : "[AGUARDANDO]") );
System.out.println("-----------------------------------------------------------------");





}  
}

