import java.awt.image.BufferedImage; // Импортируем класс BufferedImage для работы с изображениями в формате изображений.
public class ImageProcessor { // Объявляем публичный класс ImageProcessor, который будет содержать методы для обработки изображений.
    public BufferedImage invertColors(BufferedImage image) { // Метод invertColors принимает объект BufferedImage и возвращает новый BufferedImage с инвертированными цветами.
        int width = image.getWidth(); // Получаем ширину исходного изображения.
        int height = image.getHeight(); // Получаем высоту исходного изображения.
        BufferedImage invertedImage = new BufferedImage(width, height, image.getType()); // Создаем новое изображение с теми же размерами и типом пикселей, что и у исходного.
        for (int y = 0; y < height; y++) { // Внешний цикл проходит по всем вертикальным координатам (по высоте) изображения.
            for (int x = 0; x < width; x++) { // Внутренний цикл проходит по всем горизонтальным координатам (по ширине) изображения.
                int rgba = image.getRGB(x, y); // Получаем ARGB значение цвета пикселя в текущих координатах (x, y).
                int alpha = (rgba >> 24) & 0xff; // Извлекаем компонент альфа (прозрачность) путем сдвига вправо на 24 бита и маскирования с помощью 0xff.
                int red = 255 - ((rgba >> 16) & 0xff); // Извлекаем красный компонент, сдвигая вправо на 16 бит и затем инвертируем его (255 - значение).
                int green = 255 - ((rgba >> 8) & 0xff); // Извлекаем зеленый компонент, сдвигая вправо на 8 бит и затем инвертируем его.
                int blue = 255 - (rgba & 0xff); // Извлекаем синий компонент, получая его значение и инвертируя.
                invertedImage.setRGB(x, y, (alpha << 24) | (red << 16) | (green << 8) | blue); // Объединяем инвертированные компоненты обратно в одно значение ARGB и устанавливаем цвет пикселя в новом изображении.
            }
        }
        return invertedImage; // Возвращаем новое изображение с инвертированными цветами.
    }
}