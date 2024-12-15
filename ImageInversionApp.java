import javax.swing.*; // Импортируем классы из библиотеки Swing для создания графического интерфейса.
import java.awt.image.BufferedImage; // Импортируем класс BufferedImage для работы с изображениями.
import java.util.List; // Импортируем класс List для работы с коллекциями.
import java.util.concurrent.ExecutorService; // Импортируем интерфейс ExecutorService для управления потоками.
import java.util.concurrent.Executors; // Импортируем класс Executors для создания пула потоков.

public class ImageInversionApp { // Определяем главный класс приложения.
    public static void main(String[] args) { // Главный метод приложения, точка входа.
        // Запускаем графический интерфейс в потоке событий Swing.
        SwingUtilities.invokeLater(() -> {
            ImageDisplay display = new ImageDisplay(); // Создаем экземпляр класса ImageDisplay для отображения изображений.
            display.setVisible(true); // Делаем окно с изображениями видимым.
            processImages(display); // Вызываем метод для обработки изображений.
        });
    }

    private static void processImages(ImageDisplay display) { // Метод для загрузки и обработки изображений.
        ImageLoader loader = new ImageLoader(); // Создаем экземпляр класса ImageLoader для загрузки изображений.
        // Создаем пул потоков, количество которых равно количеству доступных процессоров.
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            List<BufferedImage> images = loader.loadImages("фотки"); // Загружаем изображения из каталога "фотки".
            display.displayImages(images); // Отображаем загруженные изображения с помощью метода displayImages.
            // Итерируемся по каждому изображению в списке.
            for (BufferedImage img : images) {
                // Отправляем задание на обработку в пул потоков.
                executor.submit(() -> {
                    ImageProcessor processor = new ImageProcessor(); // Создаем экземпляр класса ImageProcessor для обработки изображений.
                    BufferedImage inverted = processor.invertColors(img); // Инвертируем цвета изображения.
                    display.newImages(inverted, images); // Вызываем метод newImages для добавления инвертированного изображения в интерфейс.
                });
            }
            executor.shutdown(); // После завершения всех задач, останавливаем пул потоков.
        } catch (Exception e) { // Обрабатываем возможные исключения.
            e.printStackTrace(); // Печатаем стек вызовов исключения для отладки.
        }
    }
}