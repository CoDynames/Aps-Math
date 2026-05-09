# 🌿 Smart Garden

Este projeto foi desenvolvido como **Atividade Prática Supervisionada (APS)** para a disciplina de **Lógica Matemática**. O sistema utiliza os fundamentos da Álgebra de Boole para controlar um jardim inteligente, integrando lógica de sensores com execução em **Java**.

## 🧠 Proposição Lógica de Controle

O motor de decisão do sistema é baseado na seguinte expressão lógica, que equilibra a necessidade de manutenção da planta com a segurança contra pragas:

$$((P \lor Q) \land \neg R) \lor R$$

### Definição das Variáveis (Sensores):
* **P (Solo Seco):** Sensor de umidade do solo.
* **Q (Sol Forte):** Sensor de luminosidade.
* **R (Presença de Pragas):** Sensor de presença/infravermelho.

---

## 📊 Tabela Verdade com Retorno do Sistema

A tabela abaixo segue a **ordem canônica** e inclui a interpretação das ações que o sistema Java executa para cada combinação de sensores.

| P | Q | R | ¬R | (P ∨ Q) | (P ∨ Q) ∧ ¬R | **((P ∨ Q) ∧ ¬R) ∨ R** | **Status / Mensagem do Sistema** |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **V** | **V** | **V** | F | V | F | **V** | ⚠️ **ALERTA:** Praga detectada! Ativando Repelente. |
| **V** | **V** | **F** | V | V | V | **V** | 💧 **AÇÃO:** Irrigação e Toldo ativados. |
| **V** | **F** | **V** | F | V | F | **V** | ⚠️ **ALERTA:** Praga detectada! Ativando Repelente. |
| **V** | **F** | **F** | V | V | V | **V** | 💧 **AÇÃO:** Solo seco. Iniciando irrigação. |
| **F** | **V** | **V** | F | V | F | **V** | ⚠️ **ALERTA:** Praga detectada! Ativando Repelente. |
| **F** | **V** | **F** | V | V | V | **V** | ☀️ **AÇÃO:** Sol forte. Estendendo toldo. |
| **F** | **F** | **V** | F | F | F | **V** | ⚠️ **ALERTA:** Praga detectada! Ativando Repelente. |
| **F** | **F** | **F** | V | F | F | **F** | ✅ **OK:** Condições ideais. Sistema em Standby. |

---

## 🚀 Implementação em Java

A expressão lógica foi implementada de forma direta no código. Note como o sistema diferencia se o resultado `true` veio da necessidade de cuidado ou da presença de uma praga:

```java
// Simulação da leitura dos sensores
boolean soloSeco = sensorUmidade.isSoloSeco();
boolean solForte = sensorLuz.isSolForte();
boolean temPraga = sensorPresenca.hasPragas();

// Aplicação fiel da Proposição Lógica: ((P v Q) ^ ~R) v R
boolean sistemaAtivo = ((soloSeco || solForte) && !temPraga) || temPraga;

if (sistemaAtivo) {
    if (temPraga) {
        // Se R é verdadeiro, a disjunção final força o sistema a Ativo
        System.out.println("RETORNO: [Sensor R] Praga detectada! Acionando Repelente.");
    } else {
        // Se R é falso, o sistema ativou porque (P v Q) é verdadeiro
        System.out.println("RETORNO: [Sensores P/Q] Ativando Irrigação/Toldo.");
    }
} else {
    System.out.println("RETORNO: Ambiente estável. Nenhuma ação necessária.");
}
