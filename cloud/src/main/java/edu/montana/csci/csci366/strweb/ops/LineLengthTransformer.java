package edu.montana.csci.csci366.strweb.ops;

import java.util.concurrent.CountDownLatch;

/**
 * This class is should calculate the length of each line and replace the line in the
 * array with a string representation of its length
 */
public class LineLengthTransformer {
    String[] _lines;


    public LineLengthTransformer(String strings) {
        _lines = strings.split("\n");
    }

    public String toLengths() {
        //we create a countdown latch so that we can await all of the threads to finish and join them together at the end
        CountDownLatch latch = new CountDownLatch(_lines.length);
        //loop throug all the lines and create threads for each one
        for (int i = 0; i < _lines.length; i++) {
            //sending individual lines to line len calculator w latch and index
            LineLengthCalculator lineLengthCalcualtor = new LineLengthCalculator(i, latch);
            //creating a new thread for each line for efficiency and starting it
            new Thread(lineLengthCalcualtor).start();
        }
        //waiting for all of the threads to be finished before we join and return countdown latch must be 0
        try {
            latch.await();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        //TODO - this method should create a series of Runnables and use Threads to do all
        //       line lengths in parallel
        return String.join("\n", _lines);
    }
    class LineLengthCalculator implements Runnable{
        private final int index;
        private final CountDownLatch latch;
        //private final String Value
        //constructor for latch and index
        LineLengthCalculator(int index, CountDownLatch latch) {
            this.index = index;
            this.latch = latch;
        }


        @Override
        public void run(){
            //getting line at index
            String currentValue = _lines[index];
            //replacing this index with the length
            _lines[index] = String.valueOf(currentValue.length());
            //letting the latch know this thread is done
            latch.countDown();
        };

    }



}
