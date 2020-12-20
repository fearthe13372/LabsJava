package lab6;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent{//класс JImageDisplay, производный от  javax.swing.JComponent//

    private BufferedImage img;//класс BufferedImage управляет  изображением, содержимое которого можно записать
    
    public JImageDisplay(int width, int height)
    {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//инициализирую объект класса BufferedImage с данными характеристиками
        //длинны и высоты, а также с типом изображения и типом изображения TYPE_INT_RGB. Тип определяет, как цвета каждого пикселя будут
        //представлены в изображении; значение TYPE_INT_RGB обозначает, что
        //красные, зеленые и синие компоненты имеют по 8 битов, представленные в
        //формате int в указанном порядке
        
        Dimension dim = new Dimension(width, height);// создаю объект класса Dimension с данными характеристиками,чтобы в дальнейшем передать
        // родительскому классу
        super.setPreferredSize(dim);
    }
    //Пользовательские компоненты Swing должны предоставлять свой
    // собственный код для отрисовки, переопределяя защищенный метод JComponent
    //paintComponent (Graphics g)
    protected void paintComponent(Graphics g)

    {
        super.paintComponent(g);//нужно всегда
        //вызывать метод суперкласса paintComponent (g) так, чтобы объекты
        //отображались правильно.

        g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);//Рисую изображение
    }
    

    public void clearImage() //метод устанавливает все пиксели  изображения в черный цвет
    {
        for(int j = 0 ; j < img.getHeight() ; ++j)
        {
            for(int i = 0 ; i < img.getWidth() ; ++i)
            {
                this.drawPixel(i, j, 0);
            }
        }
    }
    //метод устанавливает пиксель определенного цвета
    public void drawPixel(int x, int y, int color)
    {
        img.setRGB(x, y, color);
    }
    //метод для получения картинки
    public BufferedImage getImage()
    {
        return img;
    }
    
}
