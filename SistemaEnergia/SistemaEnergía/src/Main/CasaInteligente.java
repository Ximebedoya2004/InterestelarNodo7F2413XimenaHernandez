package Main;

import java.util.Scanner;

public class CasaInteligente {
    private static final float LIMITE_CONSUMO_MENSUAL = 500.0f; // kWh
    private static final int DIAS_POR_MES = 30; // Número de días en el mes

    private Luces luces;
    private Calefaccion calefaccion;
    private Electrodomesticos electrodomesticos;

    public CasaInteligente() {
        luces = new Luces();
        calefaccion = new Calefaccion();
        electrodomesticos = new Electrodomesticos();
    }

    // Switch para encender/apagar dispositivos y registrar horas de uso
    public void gestionarDispositivo(Scanner sc, Dispositivo dispositivo) {
        System.out.print("¿Deseas gestionar " + dispositivo.getNombre() + "? (1: Encender, 2: Apagar): ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1: // Encender
                dispositivo.encender();
                System.out.print("¿Cuántas horas al día funcionan " + dispositivo.getNombre() + "? ");
                float horas = sc.nextFloat();
                dispositivo.setHorasPorDia(horas);
                float consumoDiario = dispositivo.calcularConsumoDiario(horas);
                System.out.println("Consumo diario de " + dispositivo.getNombre() + ": " + consumoDiario + " kWh.\n");
                break;

            case 2: // Apagar
                dispositivo.apagar();
                System.out.println(dispositivo.getNombre() + " está apagado y no consume energía.\n");
                break;

            default: // Opción no válida
                System.out.println("Opción no válida. Por favor, elige 1 para encender o 2 para apagar.\n");
                break;
        }
    }

    public void calcularConsumoMensual() {
        Scanner sc = new Scanner(System.in);

        // Preguntamos al usuario sobre el estado y uso de cada dispositivo
        gestionarDispositivo(sc, luces);
        gestionarDispositivo(sc, calefaccion);
        gestionarDispositivo(sc, electrodomesticos);

        float consumoTotalMensual = 0.0f;

        // Simulamos el ciclo diario por 30 días y acumulamos el consumo mensual
        float consumoTotalLuces = luces.estaEncendido() ? luces.calcularConsumoDiario(luces.getHorasPorDia()) * DIAS_POR_MES : 0;
        float consumoTotalCalefaccion = calefaccion.estaEncendido() ? calefaccion.calcularConsumoDiario(calefaccion.getHorasPorDia()) * DIAS_POR_MES : 0;
        float consumoTotalElectrodomesticos = electrodomesticos.estaEncendido() ? electrodomesticos.calcularConsumoDiario(electrodomesticos.getHorasPorDia()) * DIAS_POR_MES : 0;

        consumoTotalMensual = consumoTotalLuces + consumoTotalCalefaccion + consumoTotalElectrodomesticos;

        // Mostramos el consumo mensual acumulado
        System.out.println("Consumo total del mes: " + consumoTotalMensual + " kWh.");

        // Verificamos si se supera el límite mensual
        if (consumoTotalMensual > LIMITE_CONSUMO_MENSUAL) {
            System.out.println("¡Alerta! El consumo mensual ha excedido el límite de " + LIMITE_CONSUMO_MENSUAL + " kWh.");
        } else {
            System.out.println("Consumo dentro del límite permitido.");
        }

        sc.close();
    }

    public static void main(String[] args) {
        CasaInteligente casa = new CasaInteligente();
        casa.calcularConsumoMensual();
    }
}
