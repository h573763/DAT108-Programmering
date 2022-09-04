package no.hvl.dat108.task2.adt;

/**
 *
 * @Autor
 * Torbjørn Vatnelid
 *
 * @param <T>
 *
 * For aa brukes i oppgave 2 av oblig 1
 */

public interface QueueADT<T> {
    /**
     *
     * @param element
     * Legges til i køen
     */
    void enQueue(T element);
    /**
     *
     * @return elementet som fjernes fra køen
     *
     */
    T deQueue();
    /**
     *
     * @return Om køen er tom eller ikke
     */
    boolean isEmpty();
    /**
     * @return Størrelsen på køen
     */
    int size();
    /**
     * @return begrensingen i køen
     */
    int getLim();
    /**
     *
     * @return Det første elementet i køen
     */
    T first();
    /**
     *
     * @return Om siste elementet i køen er null eller ikke
     */
    boolean isNull();
}//interface