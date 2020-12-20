package lab4;

import java.awt.geom.Rectangle2D;


//Этот класс предоставляет общий интерфейс и операции для фрактальных
//генераторов, которые можно просмотреть в FractalExplorer
public abstract class FractalGenerator {

    /**
      Эта статическая вспомогательная функция принимает целочисленную координату и преобразует ее
      в значение double, соответствующее определенному диапазону. Он
      используется для преобразования координат пикселей в значения двойной точности для
      вычисление фракталов и т. д.
      range Min - минимальное значение диапазона с плавающей запятой
      rangeMax - максимальное значение диапазона с плавающей запятой
      size - размер измерения, из которого исходит координата пикселя.
      Например, это может быть ширина изображения или высота изображения.
      coord - координата для вычисления значения двойной точности.
      Координата должна находиться в диапазоне [0, размер].
     */
    public static double getCoord(double rngMin, double rngMax,
        int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rngMax - rngMin;
        return rngMin + (range * (double) coord / (double) size);
    }


    /**Метод позволяет генератору фракталов определить наиболее «интересную» область комплексной плоскости
     для конкретного фрактала. Задает заданный прямоугольник, содержащий начальный диапазон, подходящий для генерируемого фрактала.
     */
    public abstract void getInitialRange(Rectangle2D.Double range);


    /**
      Обновляет текущий диапазон для центрирования по заданным координатам
      и увеличения или уменьшения масштаба с заданным коэффициентом масштабирования.
     */
    public void recenterAndZoomRange(Rectangle2D.Double range,
        double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }


    /**
      Учитывая координату <em>x</em> + <em>iy</em> в комплексной плоскости,
      вычисляет и возвращает число итераций перед фракталом
      функция экранирует ограничивающую область для этой точки. Указывается точка, которая
      не убегает до достижения предела итерации
      с результатом -1.
     */
    public abstract int numIterations(double x, double y);
}

