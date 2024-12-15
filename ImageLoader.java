import javax.imageio.ImageIO; // Импортируем класс ImageIO для работы с изображениями, позволяет читать (и записывать) изображения в различные форматы.
import java.awt.image.BufferedImage; // Импортируем класс BufferedImage, который представляет собой изображение, которое может быть изменено (обработано) программным способом.
import java.io.File; // Импортируем класс File для работы с файлами и директориями в файловой системе.
import java.util.ArrayList; // Импортируем класс ArrayList, который представляет собой изменяемый массив для хранения объектов.
import java.util.List; // Импортируем интерфейс List, который представляет собой коллекцию элементов.

public class ImageLoader { // Определяем публичный класс ImageLoader, который будет отвечать за загрузку изображений из директории.
    public List<BufferedImage> loadImages(String directoryPath) throws Exception { // Определяем метод loadImages, который принимает путь к директории и может выбрасывать исключения. Возвращаемый тип - список изображений.
        List<BufferedImage> images = new ArrayList<>(); // Создаем новый список, чтобы хранить загруженные изображения.
        File dir = new File(directoryPath); // Создаем объект File, представляющий директорию по заданному пути.
        File[] files = dir.listFiles((d, name) -> name.endsWith(".jpg") || name.endsWith(".png")); // Получаем массив файлов из директории, фильтруя их по расширению: только .jpg и .png.
        if (files != null) { // Проверяем, что массив файлов не равен null (что означает, что директория существует и доступна).
            for (File file : files) { // Итерируемся по каждому файлу в массиве files.
                BufferedImage image = ImageIO.read(file); // Читаем файл как BufferedImage с помощью метода read класса ImageIO.
                images.add(image); // Добавляем загруженное изображение в список images.
            }
        }
        return images; // Возвращаем список загруженных изображений.
    }
}