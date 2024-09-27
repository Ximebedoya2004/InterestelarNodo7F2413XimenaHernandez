package Main;

public class Electrodomesticos extends Dispositivo {
    public Electrodomesticos() {
        super("Electrodomésticos");
    }

    @Override
    public float calcularConsumoDiario(float horas) {
        // Ejemplo: suponer que los electrodomésticos consumen 2.0 kWh por hora
        return horas * 2.0f;
    }
}
