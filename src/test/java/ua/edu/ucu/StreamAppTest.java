package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 *
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamOperations2() {
        System.out.println("filter");
        IntStream expResult = AsIntStream.of(2, 3);
        IntStream output = AsIntStream.of(-1, 0, 1, 2, 3);
        IntStream result = output.filter(x -> x > 1);
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    @Test
    public void testStreamOperations3() {
        System.out.println("mapping");
        IntStream expResult = AsIntStream.of(2, 4, 6);
        IntStream output = AsIntStream.of(1, 2, 3);
        IntStream result = output.map(x -> x * 2);
        assertArrayEquals(expResult.toArray(), result.toArray());
    }
    @Test
    public void testStreamOperations4() {
        System.out.println("flatMapping");
        IntStream expResult = AsIntStream.of(-1, 1, 3, 2, 4, 6, 7, 9, 11);
        IntStream output = AsIntStream.of(1, 4, 9);
        IntStream result = output.flatMap(x -> AsIntStream.of(x - 2, x, x + 2));
        assertArrayEquals(expResult.toArray(), result.toArray());
    }
    @Test
    public void testAverage() {
        System.out.println("average");
        double expResult = 1.0;
        double result = intStream.average();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testMin() {
        System.out.println("min");
        double expResult = -1;
        double result = intStream.min();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testMax() {
        System.out.println("max");
        double expResult = 3;
        double result = intStream.max();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testSum() {
        System.out.println("sum");
        double expResult = 5;
        double result = intStream.sum();
        assertEquals(expResult, (Object) result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxO() {
        IntStream intStrm = AsIntStream.of();
        System.out.println("MaxException");
        intStrm.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinO() {
        IntStream intStrm = AsIntStream.of();
        System.out.println("MinException");
        intStrm.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageO() {
        IntStream intStrm = AsIntStream.of();
        System.out.println("AverageException");
        intStrm.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumO() {
        IntStream intStrm = AsIntStream.of();
        System.out.println("SumException");
        intStrm.sum();
    }



}
