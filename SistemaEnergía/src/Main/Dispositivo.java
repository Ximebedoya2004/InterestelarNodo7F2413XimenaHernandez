package Main;

public abstract class Dispositivo {
    private String nombre;
    private boolean encendido;
    private float horasPorDia;

    public Dispositivo(String nombre) {
        this.nombre = nombre;
        this.encendido = false;
        this.horasPorDia = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
        this.horasPorDia = 0; // Cuando se apaga, el consumo se resetea
    }

    public boolean estaEncendido() {
        return encendido;
    }

    public void setHorasPorDia(float horas) {
        this.horasPorDia = horas;
    }

    public float getHorasPorDia() {
        return horasPorDia;
    }

    // Método abstracto para calcular el consumo diario en kWh (kilovatios-hora)
    public abstract float calcularConsumoDiario(float horas);
}
