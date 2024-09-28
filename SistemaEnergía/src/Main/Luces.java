package Main;

public class Luces extends Dispositivo {
    public Luces() {
        super("Luces");
    }

    @Override
    public float calcularConsumoDiario(float horas) {
        // Ejemplo: suponer que las luces consumen 0.1 kWh por hora
        return horas * 0.1f;
    }
}
