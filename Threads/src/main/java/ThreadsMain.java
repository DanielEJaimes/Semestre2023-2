
import java.util.Arrays;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

/*
https://www.upb.edu.co/es/home https://www.youtube.com/ https://www.netflix.com/co/ https://web.whatsapp.com/
 */
public class ThreadsMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los URLs separados por espacio:");
        String input = scanner.nextLine();
        String[] urls = input.split(" ");

        int numThreads = 3;
        int urlsPerThread = (int) Math.ceil((double) urls.length / numThreads);

        // Configurar ChromeDriver
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        // Configurar opciones de Chrome
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-gpu");

        // Crear hilos
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * urlsPerThread;
            int endIndex = Math.min(startIndex + urlsPerThread, urls.length);
            String[] urlsForThread = Arrays.copyOfRange(urls, startIndex, endIndex);

            threads[i] = new Thread(new PdfConversion(options, urlsForThread));
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Conversión completada.");
    }
}
