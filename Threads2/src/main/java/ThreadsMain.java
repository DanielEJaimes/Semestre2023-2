
import java.io.File;

import java.io.IOException;

public class ThreadsMain {

    public static void main(String[] args) throws IOException {
        File inputDirectory = new File("input");
        File outputDirectory = new File("output");

        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        File[] files = inputDirectory.listFiles();
        int numThreads = 5;
        int pathsPerThread = (int) Math.ceil((double) files.length / numThreads);
        Thread[] threads = new Thread[numThreads];
        if (files != null) {
            for (int i = 0; i < numThreads; i++) {
                for (File file : files){
                if (file.isFile()) {
                    threads[i] = new Thread(new ConversionTask(file, outputDirectory));
                    threads[i].start();
                }
                }
            }

            // Creación de jilos
            // Espera a que todos los jilos terminen
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
