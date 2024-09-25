package interfac;

/**
 * A HitNotifier is used to notify HitListeners for when a hit has occured.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl THe HitListener to add.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl The HitListener to remove.
     */
    void removeHitListener(HitListener hl);
}