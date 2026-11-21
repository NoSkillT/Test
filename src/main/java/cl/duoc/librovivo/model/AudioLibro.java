package cl.duoc.librovivo.model;

/**
 * Audiolibro disponible para préstamo.
 * Costo de préstamo: base $2.800; si la duración supera los 300 minutos, recargo del 15%.
 */
public class AudioLibro extends Material {

    private static final double COSTO_BASE = 2800;
    private static final double RECARGO_DURACION = 0.15;
    private static final int LIMITE_MINUTOS = 300;

    private int duracionMinutos;

    /**
     * Constructor sin parámetros, requerido para reconstruir objetos.
     */
    public AudioLibro() {
    }

    public AudioLibro(String titulo, int anioPublicacion, int copiasDisponibles, int duracionMinutos) {
        super(titulo, anioPublicacion, copiasDisponibles);
        setDuracionMinutos(duracionMinutos);
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public double calcularCostoPrestamo() {
        if (duracionMinutos > LIMITE_MINUTOS) {
            return COSTO_BASE + COSTO_BASE * RECARGO_DURACION;
        }
        return COSTO_BASE;
    }

    @Override
    public String getTipo() {
        return "AudioLibro";
    }
}
