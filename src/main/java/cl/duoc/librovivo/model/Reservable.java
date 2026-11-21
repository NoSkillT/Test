package cl.duoc.librovivo.model;

/**
 * Contrato que cumplen los materiales que participan en el sistema de
 * reservas de la biblioteca.
 */
public interface Reservable {

    /**
     * Indica si el material se encuentra reservado.
     *
     * @return true si está reservado
     */
    boolean estaReservado();

    /**
     * Registra que el material queda reservado.
     */
    void reservar();
}
