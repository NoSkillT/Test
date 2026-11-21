package cl.duoc.librovivo.model;

/**
 * Libro disponible para préstamo. Participa en el sistema de reservas.
 * Costo de préstamo: base $3.500; si no está en buen estado de conservación, recargo del 20%.
 */
public class Libro extends Material implements Reservable {

    private static final double COSTO_BASE = 3500;
    private static final double RECARGO_DETERIORO = 0.20;

    private String autor;
    private boolean buenEstado;
    private boolean reservado;

    /**
     * Constructor sin parámetros, requerido para reconstruir objetos.
     */
    public Libro() {
    }

    public Libro(String titulo, int anioPublicacion, int copiasDisponibles, String autor, boolean buenEstado) {
        super(titulo, anioPublicacion, copiasDisponibles);
        setAutor(autor);
        setBuenEstado(buenEstado);
        this.reservado = false;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isBuenEstado() {
        return buenEstado;
    }

    public void setBuenEstado(boolean buenEstado) {
        this.buenEstado = buenEstado;
    }

    @Override
    public boolean estaReservado() {
        return reservado;
    }

    @Override
    public void reservar() {
        this.reservado = true;
    }

    @Override
    public double calcularCostoPrestamo() {
        if (buenEstado) {
            return COSTO_BASE;
        }
        return COSTO_BASE + COSTO_BASE * RECARGO_DETERIORO;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }
}
