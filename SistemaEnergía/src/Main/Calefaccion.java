package Main;

public class Calefaccion extends Dispositivo {
    public Calefaccion() {
        super("Calefacción");
    }

    @Override
    public float calcularConsumoDiario(float horas) {
        // Ejemplo: suponer que la calefacción consume 1.5 kWh por hora
        return horas * 1.5f;
    }
}
