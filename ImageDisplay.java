import javax.swing.*; // Импортируем классы из библиотеки Swing для создания графического интерфейса.
import java.awt.*; // Импортируем класс для работы с различные графическими компонентами и атрибутами.
import java.awt.image.BufferedImage; // Импортируем класс BufferedImage для работы с изображениями в формате изображений.
import java.util.List; // Импортируем интерфейс List из коллекций для работы с динамическими массивами.

public class ImageDisplay extends JFrame { // Объявляем класс ImageDisplay, который наследуется от JFrame для создания окна приложения.
    private JPanel panel; // Объявляем переменную для панели, на которой будут располагаться изображения.
    public ImageDisplay() { // Конструктор класса ImageDisplay.
        setTitle("Инверсия изображений"); // Устанавливаем заголовок окна.
        setSize(800, 600); // Устанавливаем размер окна (ширина на высоту).
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Устанавливаем действие при закрытии окна (выход из приложения).
        panel = new JPanel(); // Инициализируем панель.
        add(panel); // Добавляем панель в окно.
    }
    public void displayImages(List<BufferedImage> original) { // Метод для отображения оригинальных изображений.
        panel.removeAll(); // Удаляем все компоненты из панели, чтобы подготовиться к добавлению новых изображений.
        panel.setLayout(new GridLayout(2, original.size())); // Устанавливаем сетчатую компоновку, где будет 2 строки и количество колонок соответствует количеству изображений.
        for (BufferedImage img : original) { // Перебираем все оригинальные изображения в списке.
            panel.add(new JLabel(new ImageIcon(img))); // Для каждого изображения создаем новый JLabel и добавляем его на панель.
        }
        panel.revalidate(); // Перерасчитываем компоненты панели для применения изменений.
        panel.repaint(); // Перерисовываем панель, чтобы отобразить обновленные элементы.
    }
    public void newImages(BufferedImage inverted, List<BufferedImage> original) { // Метод для отображения инвертированного изображения вместе с оригинальными.
        panel.setLayout(new GridLayout(2, original.size())); // Снова устанавливаем сетчатую компоновку для просмотра изображений.
        panel.add(new JLabel(new ImageIcon(inverted))); // Добавляем инвертированное изображение на панель.
        panel.revalidate(); // Перерасчет компонентов панели для применения изменений.
        panel.repaint(); // Перерисовка панели для обновления отображаемых изображений.
    }
}