package ua.edu.ucu.stream;

/**
 *
 */
import ua.edu.ucu.function.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsIntStream implements IntStream {
    private ArrayList<Integer> arr;

    private AsIntStream(ArrayList<Integer> array) {
        arr = array;
    }

    public static IntStream of(int... values) {
        ArrayList<Integer> NewArr = new ArrayList<>();
        for (int i: values) {
            NewArr.add(i);
        }
        return new AsIntStream(NewArr);
    }


    @Override
    public Double average() {
        if (count() == 0){
            throw new IllegalArgumentException();
        }
        return (double)sum()/count();
    }

    @Override
    public Integer max() {
        if (count() == 0){
            throw new IllegalArgumentException();
        }
        Integer m = Integer.MIN_VALUE;
        for(int i: arr){
            if (i > m){
                m = i;
            }
        }
        return m;
    }

    @Override
    public Integer min() {
        if (count() == 0){
            throw new IllegalArgumentException();
        }
        Integer m = Integer.MAX_VALUE;
        for(int i: arr){
            if (i < m){
                m = i;
            }
        }
        return m;
    }

    @Override
    public long count() {
        return arr.size();
    }

    @Override
    public Integer sum() {
        if (count() == 0){
            throw new IllegalArgumentException();
        }
        Integer s = 0;
        for (int i: arr){
            s+=i;
        }
        return s;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        int a = 0;
        for (int i: arr){
            if (predicate.test(i)){
                a+=1;
            }
        }

        ArrayList<Integer> NewArr = new ArrayList<Integer>();
        for (int i: arr){
            if (predicate.test(i)){
                NewArr.add(i);
            }
        }

        return new AsIntStream(NewArr);
    }


    @Override
    public void forEach(IntConsumer action) {
        for (int i: arr){
            action.accept(i);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {

        ArrayList<Integer> NewArr = new ArrayList<Integer>();
        for (int i : arr){
            NewArr.add(mapper.apply(i));
        }

        return new AsIntStream(NewArr);

    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<IntStream> NewArr = new ArrayList<>();
        for (int i: arr){
            NewArr.add(func.applyAsIntStream(i));
        }
        ArrayList<Integer> Result = new ArrayList<>();
        for (IntStream el: NewArr){
            for (int i : el.toArray()){
                Result.add(i);
            }
        }

        return new AsIntStream(Result);
    }



    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int s = 0;
        for (int i : arr) {
            s += op.apply(identity, i);
        }
        return s;
    }

    @Override
    public int[] toArray() {
        int[] a = new int[arr.size()];
        int k = 0;
        for (int i: arr){
            a[k] = i;
            k+=1;

        }
        return a;

    }

}

