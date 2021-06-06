/**
 * This is a class to test the speed of the DLinkedList's 2 get method modes,
 * One mode only looks forward until the index needed, the other can
 * go from the back of the list, halfing the max time to get an item.
 */
public class SpeedTest
{
    DLinkedList<Integer> testList;

    public static void main(String[] args) {
        SpeedTest tester = new SpeedTest();

        System.out.println("Time to get 100k items.");
        System.out.println("All times in ms.");
        System.out.println();
        System.out.println("Normal get: " + tester.normalGetTime());
        System.out.println("Fast get: " + tester.fastGetTime());
        
    }

    public SpeedTest()
    {
        testList = new DLinkedList<>();
        for (int i = 0; i < 100000; i++) {
            testList.addLast(i);
        }
    }

    @SuppressWarnings("deprecation")
    public long normalGetTime()
    {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            testList.get(i);
        }

        return System.currentTimeMillis() - startTime;
    }

    public long fastGetTime()
    {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            testList.getFast(i);
        }

        return System.currentTimeMillis() - startTime;
    }
}
