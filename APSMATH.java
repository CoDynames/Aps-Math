import java.util.Scanner;

public class APSMATH {
    // Cores ANSI para o terminal
public static final String RESET = "\u001B[0m";
public static final String VERDE = "\u001B[32m";
public static final String AMARELO = "\u001B[33m";
public static final String CIANO = "\u001B[36m";
public static final String VERMELHO = "\u001B[31m";
public static final String AZUL = "\u001B[34m";
public static final String MARROM = "\u001B[33m";

// Métodos de Desenho
public static void desenharSol() {
    System.out.println(AMARELO + "      \\ _ /      ");
    System.out.println("    -= (_) =-    ");
    System.out.println("      /   \\      " + RESET);
}

public static void desenharGota() {
    System.out.println(CIANO + "       _       ");
    System.out.println("      / \\      ");
    System.out.println("     /   \\     ");
    System.out.println("     \\___/     " + RESET);
}

public static void desenharBesouro() {
    System.out.println(VERMELHO + "     / ^ \\     ");
    System.out.println("   (  o o  )   ");
    System.out.println("    |  V  |    ");
    System.out.println("   /|  _  |\\   " + RESET);
}

public static void desenharVasoDetalhado() {
    System.out.println(VERDE + "       _(_)_       ");
    System.out.println("      (_)@(_)      ");
    System.out.println("        (_)\\       ");
    System.out.println("         |/        " + RESET);
    System.out.println(MARROM + "      _|_|_|_      ");
    System.out.println("      \\     /      ");
    System.out.println("       \\___/       " + RESET);
}
public static void main(String[] args) {
    
     

Scanner Lap = new Scanner(System.in);
boolean p = false, q = false, r = false, continuarSessao = true; 
String entrada;

do {
System.out.println("Responda com 'Sim' ou 'Não' os Sensores");

// -- SENSOR P ------------------------------------------------------------------------------------------------------------------------------------------------
while(true){ // O While nos sensores serve como trava pra manter o looping ate o usuario responder corretamente...
System.out.println(AZUL + "Sensor P - A terra esta seca? " + RESET);
desenharGota();
entrada = Lap.nextLine().trim();
if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {
    p = true;
    break;
} else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N") || entrada.equalsIgnoreCase("Nao")) {
    p = false;
    break;
} else {System.out.println("Resposta invalida Responda apenas com 'Sim' ou 'Não'");} 
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    
// -- SENSOR Q -------------------------------------------------------------------------------------------------------------------------------------------------
while(true){ 
System.out.println(AMARELO + "Sensor Q - O Sol esta Forte? " + RESET);
desenharSol();
entrada = Lap.nextLine().trim();
if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {
    q = true;
    break;
} else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N") || entrada.equalsIgnoreCase("Nao")) {
    q = false;
    break;
} else {System.out.println("Resposta invalida Responda apenas com 'Sim' ou 'Não'");}
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------

// -- SENSOR R -------------------------------------------------------------------------------------------------------------------------------------------------
while(true){ 
System.out.println(VERMELHO + "Sensor R - Detectou Alguma Praga?" + RESET);
desenharBesouro();
entrada = Lap.nextLine().trim();
if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {
    r = true;
    break;
} else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N") || entrada.equalsIgnoreCase("Nao")) {
    r = false;
    break;
} else {System.out.println("Resposta invalida Responda apenas com 'Sim' ou 'Não'");}
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

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

// -- Detector de pragas --
if (r) {
    while (r) {
    System.out.println(VERMELHO + "\nAs pragas foram eliminadas?" + RESET);
    entrada = Lap.nextLine().trim();
    if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {
        r = false; // pragas eliminadas
        // Formulas com r sendo falso
        acionarRegador = p && !r;
        acionarToldo   = q && !r;
        System.out.println(VERDE + "\n[PRAGAS ELIMINADAS] Atualizando Sistema..." + RESET);
        System.out.println(VERDE + "\n[AMBIENTE SEGURO INICIANDO PROTOCOLOS DE CUIDADO]" + RESET);
        desenharVasoDetalhado();
        System.out.println("irrigador" + (acionarRegador ? "[LIGADO]" : "[DESLIGADO]"));
        System.out.println("Toldo"   + (acionarToldo ? " [ESTENDIDO]" : "[RECOLHIDO]"));
        break;

    } else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N")) {
        break;
    } else System.out.println(VERMELHO + "\\n[PRAGAS DETECTADAS] Reiniciando Protocolos de Repelimento..." + RESET); // Reinicia caso o usuario declare que ainda tem pragas
//--Reiniciador de sistema------------------------------------------------------------------------------------------------------------------------------------------    
} 
}
System.out.println("\n===========================================");
System.out.println("Deseja realizar uma nova analise?");
entrada = Lap.nextLine().trim();

if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N") || entrada.equalsIgnoreCase("Nao")) {
   continuarSessao = false;
   System.out.println("Encerrando o Sistema... Ate logo!");
   break;
   
} else if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {
   continuarSessao = true;
   System.out.println("Reiniciando Sistema......");
}
} while (continuarSessao);
 Lap.close();
}
}