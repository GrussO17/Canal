package canal;

/**
 * A stretch of canal that is actually a lock, guarded by a lockmaster
 * In this simulation, locks are one-way, and always follow this process
 * (important for timing).
 * <ol>
 *     <li>It is assumed that the water level in the lock is ready.</li>
 *     <li>Lock gates on entry side open. (Assume 0 time.)</li>
 *     <li>Boat enters. (Contributes to computed time.)</li>
 *     <li>Lock gates on entry side close. (Assume 0 time.)</li>
 *     <li>Lock chamber drains or fills. (Contributes to computed time.)</li>
 *     <li>Lock gates on exit side open. (Assume 0 time.)</li>
 *     <li>Boat leaves. (Contributes to computed time.)</li>
 *     <li>Lock gates on exit side close. (Assume 0 time.)</li>
 * </ol>
 *
 * @author Owen Gruss
 */
public class Lock implements CanalSegment {

    private LockMaster guard;
    private int num;
    private int length;
    private int depth;
    private boolean isOpen;
    /**
     * Create lock and set parameters for identification and time calculations.
     * @param num integer num of lock (assumed unique)
     * @param length length of lock chamber in feet
     * @param depth difference, in feet, of water level between filled
     *              and drained states
     */
    public Lock( int num, int length, int depth ) {
        this.guard = new LockMaster( this );
        this.num = num;
        this.length = length;
        this.depth = depth;
        this.isOpen = true;
    }


    /**
     * Give a description of this lock for meaningful log messages
     * @return a string of the format
     *   <code>Lock <i>num</i> [len=<i>length</i>',ht=<i>height</i>']</code>
     */
    @Override
    public String toString() {
        return "Lock " + num + " [len=" + length + "',ht=" + depth + "']";
    }

    /**
     * Get the LockMaster for this lock. It should return the same one every
     * time.
     * @return this lock's LockMaster
     */
    @Override
    public CanalSegmentGuard getGuard() {
        return this.guard;
    }

    /**
     * Compute time in minutes for a boat to get through this lock.
     * Contributions to the time are given in this class's documentation.
     * Speeds are set in constants in the {@link Utilities} class.
     * All units are minutes.
     * @param boatLength length of boat in feet
     * @return the total time it takes to get the boat through this lock,
     * from when the bow enters the entry gate to when the stern leaves
     * the exit gate.
     */
    @Override
    public float computeTime( int boatLength ) {
        float time = 0;
        time += (length + boatLength)/Utilities.BOAT_LOCK_SPEED;
        time += depth/Utilities.UP_DOWN_SPEED;
        return time;
    }

    /**
     * Is this lock unoccupied? (Used by LockMaster)
     * @return true iff there is no boat in the lock.
     */
    public boolean isAvailable() {
        return isOpen;
    }

    /**
     * Set the available state to true.
     */
    public void leave() {
        isOpen = true;
    }

    /**
     * Set the available state to false.
     */
    public void enter() {
        isOpen = false;
    }
}
