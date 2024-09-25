// 322871831 Yahav Atias
package gameObjects;

/**
 * A Counter class that is a wrapper for an int.
 */
public class Counter {
    private int counter;

    /**
     * The constructor for the Counter class.
     */
    public Counter() {
        this.counter = 0;
    }


    /**
     * Increase the counter by a count.
     *
     * @param number The count to Increase the counter by.
     */
    void increase(int number) {
        counter = counter + number;
    }


    /**
     * Decrease the counter by a count.
     *
     * @param number The count to decrease the counter by.
     */
    void decrease(int number) {
        counter = counter - number;
    }


    /**
     * Getter for the value of the counter.
     *
     * @return The value of the counter.
     */
    int getValue() {
        return counter;
    }
}