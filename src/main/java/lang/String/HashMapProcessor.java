package lang.String;

/**
 * Created by nguyen on 10/11/2016.
 */
public class HashMapProcessor implements Runnable {
    private String[] strArr = null;

    public HashMapProcessor(String[] m) {
        this.strArr = m;
    }

    public String[] getMap() {
        return strArr;
    }

    @Override
    public void run() {
        processArr(Thread.currentThread().getName());
    }

    private void processArr(String name) {
        for (int i = 0; i < strArr.length; i++) {
            //process data and append thread name
            processSomething(i);
            addThreadName(i, name);
        }
    }


    //non-synchronized
  /*  private void addThreadName(int i, String name) {
        strArr[i] = strArr[i] + ":" + name;
    }*/

    //
    private Object lock = new Object();
    private void addThreadName(int i, String name) {
        synchronized(lock){
            strArr[i] = strArr[i] +":"+name;
        }
    }


    private void processSomething(int index) {
        // processing some job
        try {
            Thread.sleep(index * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
