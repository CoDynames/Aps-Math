import java.util.Scanner;

public class APSMATH {
public static void main(String[] args) {

Scanner Lap = new Scanner(System.in);
boolean p = false, q = false, r = false;
String entrada;
long tempoinicio;

System.out.println("Responda com 'Sim' ou 'Não' os Sensores");


// -- SENSOR P ------------------------------------------------------------------------------------------------------------------------------------------------
while (true) {
    System.out.println("Sensor P - A terra esta seca? ");
    // -- Sensor de falta de resposta--
tempoinicio = System.currentTimeMillis(); // Reset do tempo

try {
    while (System.in.available() == 0) {
       if (System.currentTimeMillis() - tempoinicio > 30000) {
           System.out.println("\n[NENHUMA RESPOSTA DETECTADA] Reiniciando sistema");
           main(args);
           return;
       }
       Thread.sleep(100);
    }
} catch (Exception e) {}
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
while (true) {
    System.out.println("Sensor Q - O Sol esta Forte? ");
// -- Sensor de falta de resposta--
tempoinicio = System.currentTimeMillis(); // Reset do tempo

try {
    while (System.in.available() == 0) {
       if (System.currentTimeMillis() - tempoinicio > 30000) {
           System.out.println("\n[NENHUMA RESPOSTA DETECTADA] Reiniciando sistema");
           main(args);
           return;
       }
       Thread.sleep(100);
    }
} catch (Exception e) {}
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
while (true) {
    System.out.println("Sensor R - Detectou Alguma Praga?");
// -- Sensor de falta de resposta--
tempoinicio = System.currentTimeMillis(); // Reset do tempo

try {
    while (System.in.available() == 0) {
       if (System.currentTimeMillis() - tempoinicio > 30000) {
           System.out.println("\n[NENHUMA RESPOSTA DETECTADA] Reiniciando sistema");
           main(args);
           return;
       }
       Thread.sleep(100);
    }
} catch (Exception e) {}
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
    System.out.println("\nAs pragas foram eliminadas?");
    entrada = Lap.nextLine().trim();
    if (entrada.equalsIgnoreCase("Sim") || entrada.equalsIgnoreCase("S")) {
        r = false; // pragas eliminadas
        // Formulas com r sendo falso
        acionarRegador = p && !r;
        acionarToldo   = q && !r;

        System.out.println("\n[PRAGAS ELIMINADAS] Atualizando Sistema...");
        System.out.println("\n[AMBIENTE SEGURO INICIANDO PROTOCOLOS DE CUIDADO]");
        System.out.println("irrigador" + (acionarRegador ? "[LIGADO]" : "[DESLIGADO]"));
        System.out.println("Toldo"   + (acionarToldo ? " [ESTENDIDO]" : "[RECOLHIDO]"));
        break;

    } else if (entrada.equalsIgnoreCase("Não") || entrada.equalsIgnoreCase("N")) {
        System.out.println("\n[PRAGAS DETECTADAS] Iniciando Protocolos de Repelimento...");
    }
} 
}
}
}

