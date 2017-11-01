package canal;

import java.util.Arrays;
import java.util.List;

/**
 * A test program for the canal system simulation.
 * Note that in order to keep simulation times reasonable the distances
 * between locks are made atypically short.
 *
 *     Here is a sample run. Times, of course, will vary slightly each time.
 *
 0:00: Beater arriving at Lock 1[len=65',ht=30']
 0:00: Beater[len=45'] is entering Lock 1[len=65',ht=30'] for 10 minutes.
 0:02: Ean arriving at Lock 3[len=80',ht=45']
 0:02: Ean[len=8'] is entering Lock 3[len=80',ht=45'] for 13 minutes.
 0:08: Carolyn arriving at Lock 1[len=65',ht=30']
 0:10: Beater[len=45'] has left Lock 1[len=65',ht=30']
 0:10: Carolyn[len=35'] is entering Lock 1[len=65',ht=30'] for 10 minutes.
 0:10: Beater arriving at Level 1-to-2
 0:10: Beater[len=45'] is entering Level 1-to-2 for 27 minutes.
 0:15: Ean[len=8'] has left Lock 3[len=80',ht=45']
 0:15: Ean has ended its trip.
 0:16: Petite arriving at Lock 2[len=45',ht=20']
 0:16: Petite[len=25'] is entering Lock 2[len=45',ht=20'] for 7 minutes.
 0:20: Carolyn[len=35'] has left Lock 1[len=65',ht=30']
 0:20: Carolyn arriving at Level 1-to-2
 0:20: Carolyn[len=35'] is entering Level 1-to-2 for 27 minutes.
 0:21: Nuggets arriving at Lock 1[len=65',ht=30']
 0:21: Nuggets[len=30'] is entering Lock 1[len=65',ht=30'] for 10 minutes.
 0:23: Petite[len=25'] has left Lock 2[len=45',ht=20']
 0:23: Petite arriving at Level 2-to-3
 0:23: Petite[len=25'] is entering Level 2-to-3 for 11 minutes.
 0:31: Nuggets[len=30'] has left Lock 1[len=65',ht=30']
 0:31: Nuggets arriving at Level 1-to-2
 0:31: Nuggets[len=30'] is entering Level 1-to-2 for 27 minutes.
 0:34: Petite[len=25'] has left Level 2-to-3
 0:34: Petite arriving at Lock 3[len=80',ht=45']
 0:34: Petite[len=25'] is entering Lock 3[len=80',ht=45'] for 14 minutes.
 0:37: Beater[len=45'] has left Level 1-to-2
 0:37: Beater arriving at Lock 2[len=45',ht=20']
 0:37: Beater[len=45'] is entering Lock 2[len=45',ht=20'] for 7 minutes.
 0:44: Beater[len=45'] has left Lock 2[len=45',ht=20']
 0:44: Beater arriving at Level 2-to-3
 0:44: Beater[len=45'] is entering Level 2-to-3 for 11 minutes.
 0:47: Carolyn[len=35'] has left Level 1-to-2
 0:47: Carolyn arriving at Lock 2[len=45',ht=20']
 0:47: Carolyn[len=35'] is entering Lock 2[len=45',ht=20'] for 7 minutes.
 0:48: Petite[len=25'] has left Lock 3[len=80',ht=45']
 0:48: Petite has ended its trip.
 0:54: Carolyn[len=35'] has left Lock 2[len=45',ht=20']
 0:54: Carolyn arriving at Level 2-to-3
 0:54: Carolyn[len=35'] is entering Level 2-to-3 for 11 minutes.
 0:55: Beater[len=45'] has left Level 2-to-3
 0:55: Beater arriving at Lock 3[len=80',ht=45']
 0:55: Beater[len=45'] is entering Lock 3[len=80',ht=45'] for 14 minutes.
 0:58: Nuggets[len=30'] has left Level 1-to-2
 0:58: Nuggets arriving at Lock 2[len=45',ht=20']
 0:58: Nuggets[len=30'] is entering Lock 2[len=45',ht=20'] for 7 minutes.
 1:05: Nuggets[len=30'] has left Lock 2[len=45',ht=20']
 1:05: Nuggets arriving at Level 2-to-3
 1:05: Nuggets[len=30'] is entering Level 2-to-3 for 11 minutes.
 1:05: Carolyn[len=35'] has left Level 2-to-3
 1:05: Carolyn arriving at Lock 3[len=80',ht=45']
 1:09: Beater[len=45'] has left Lock 3[len=80',ht=45']
 1:09: Beater has ended its trip.
 1:09: Carolyn[len=35'] is entering Lock 3[len=80',ht=45'] for 14 minutes.
 1:16: Nuggets[len=30'] has left Level 2-to-3
 1:16: Nuggets arriving at Lock 3[len=80',ht=45']
 1:23: Carolyn[len=35'] has left Lock 3[len=80',ht=45']
 1:23: Carolyn has ended its trip.
 1:23: Nuggets[len=30'] is entering Lock 3[len=80',ht=45'] for 14 minutes.
 1:37: Nuggets[len=30'] has left Lock 3[len=80',ht=45']
 1:37: Nuggets has ended its trip.

 */

public class MyTest {

    /**
     * Create a canal system consisting of three locks with a level
     * in between each. Two boats run the entire length of the canal, and
     * three undergo partial journeys.
     * @param args not used
     */
    public static void main(String args[]){
        myTest();
    }
    public static void myTest(){
        CanalSegment lock1 = new Lock( 1, 65, 30 );
        CanalSegment level1_2 = new Level( "1-to-2", 12000 );
        CanalSegment lock2 = new Lock( 2, 45, 20 );
        CanalSegment level2_3 = new Level("2-to-3", 5000);
        CanalSegment lock3 = new Lock(3, 80, 45);

        List< CanalSegment > fullCanalRoute =
                Arrays.asList( lock1, level1_2, lock2 , level2_3, lock3);

        List< CanalSegment > partialCanalRoute1 =
                Arrays.asList( level1_2, lock2, level2_3, lock3);

        List< CanalSegment > partialCanalRoute2 =
                Arrays.asList( lock2, level2_3, lock3 );


        List< CanalSegment > partialCanalRoute3 =
                Arrays.asList(lock3);

        Boat b1 = new Boat( "Beater", 45, fullCanalRoute );
        Boat b2 = new Boat( "Ean", 8, partialCanalRoute3);
        Boat b3 = new Boat("Carolyn", 35, fullCanalRoute);
        Boat b4 = new Boat( "Petite", 25, partialCanalRoute2);
        Boat b5 = new Boat( "Nuggets", 30, partialCanalRoute1 );

        b1.start();
        Utilities.sleep( 2 );
        b2.start();
        Utilities.sleep( 6 );
        b3.start();
        Utilities.sleep( 8 );
        b4.start();
        Utilities.sleep( 5);
        b5.start();

        try {
            b1.join();
            b2.join();
            b3.join();
            b4.join();
            b5.join();
        }
        catch( InterruptedException ie ) {
            assert false: "Thread interrupted.";
        }
    }
}
