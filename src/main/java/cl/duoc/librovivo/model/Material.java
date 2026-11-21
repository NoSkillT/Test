package cl.duoc.librovivo.model;

/**
 * Representa a cualquier material de lectura de la Biblioteca Municipal LibroVivo.
 * Define los datos comunes y delega en cada tipo de material el cálculo del
 * costo de préstamo.
 */
public abstract class Material {

    private String titulo;
    private int anioPublicacion;
    private int copiasDisponibles;

    /**
     * Constructor sin parámetros, requerido para reconstruir objetos.
     */
    protected Material() {
    }

    public Material(String titulo, int anioPublicacion, int copiasDisponibles) {
        setTitulo(titulo);
        setAnioPublicacion(anioPublicacion);
        setCopiasDisponibles(copiasDisponibles);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo ni vacío.");
        }
        this.titulo = titulo.trim();
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion < 1450 || anioPublicacion > 2026) {
            throw new IllegalArgumentException("El año de publicación debe estar entre 1450 y 2026.");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        if (copiasDisponibles <= 0) {
            throw new IllegalArgumentException("Las copias disponibles deben ser mayores que cero.");
        }
        this.copiasDisponibles = copiasDisponibles;
    }

    /**
     * Calcula el costo de préstamo según las reglas propias de cada tipo de material.
     *
     * @return costo del préstamo en pesos
     */
    public abstract double calcularCostoPrestamo();

    /**
     * Retorna el nombre del tipo de material (por ejemplo, "Libro" o "AudioLibro").
     *
     * @return tipo de material
     */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Título: " + titulo + " | Año: " + anioPublicacion;
    }
}
