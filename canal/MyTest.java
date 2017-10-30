package canal;

import java.util.Arrays;
import java.util.List;


public class MyTest {


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
        Boat b5 = new Boat( "REEEEE", 30, fullCanalRoute );

        b1.start();
        Utilities.sleep( 2 );
        b2.start();
        Utilities.sleep( 6 );
        b3.start();
        Utilities.sleep( 8 );
        b4.start();
        Utilities.sleep( 11);
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
