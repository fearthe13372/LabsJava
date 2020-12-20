package lab6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import lab6.fractal.*;

public class FractalExplorer {
    
    /**
       размер  экрана
     */
    private int dispSize;
    private int rowsRemaining;
    /**
       Ссылка для обновления отображения в разных методах в процессе вычисления фрактала
     */
    private JImageDisplay img;

    /**
     *  Кнопка для сохранения
     */
    private JButton saveButton;

    /**
     *   Кнопка для ресета
     */
    private JButton resetButton;
    private JComboBox<String> fractalChos;


    private JFrame frame;
    
    /**
        Ссылка на базовый класс для отображения других видов фракталов в будущем
     */
    private FractalGenerator generetion;
    
    /**
      Объект Rectangle2D.Double, указывающий диапазона комплексной
      плоскости, которая выводится на экран.
     */
    Rectangle2D.Double rng;

    private class FractalHandler implements ActionListener 
    { 
        public void actionPerformed(ActionEvent e) 
        { 
            String cmd = e.getActionCommand(); 

            if (e.getSource() == fractalChos)
            { 
                String selectedItem = fractalChos.getSelectedItem().toString();

                if(selectedItem.equals(Mandelbrot.nameString()))
                {
                    generetion = new Mandelbrot();
                }
                else if(selectedItem.equals(Tricorn.nameString()))
                {
                    generetion = new Tricorn();
                }
                else if(selectedItem.equals(BurningShip.nameString()))
                {
                    generetion = new BurningShip();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error: fractalChooser unknown choice");
                    return;
                }
                
                rng = new Rectangle2D.Double();
                generetion.getInitialRange(rng);
                
                drawFractal();
            } 
            else if (cmd.equals("reset")) 
            { 
                rng = new Rectangle2D.Double();
                generetion.getInitialRange(rng);
                
                drawFractal();
            } 
            else if (cmd.equals("save")) 
            { 
                JFileChooser chooser = new JFileChooser();
                
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                
                if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    try 
                    {
                        File fd = chooser.getSelectedFile();
                        String filePath = fd.getPath();
                        if(!filePath.toLowerCase().endsWith(".png"))
                        {
                            fd = new File(filePath + ".png");
                        }
                        
                        ImageIO.write(img.getImage(), "png", fd);
                    } 
                    catch (IOException exc) 
                    {
                        JOptionPane.showMessageDialog(null, "Error: couldn't save file ( " + exc.getMessage() + " )");
                        
                        exc.printStackTrace();
                    }
                }
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "Error: FractalHandler unknown action");
            }
        } 
    }
    // для обрабатывания работы мыши - увеличение
    private class MouseHandler extends MouseAdapter 
    { 
        public void mouseClicked(MouseEvent e)
        {
            double xCoord = getFractlXcord(e.getX());
            double yCoord = getFractlYcord(e.getY());
            
            generetion.recenterAndZoomRange(rng,xCoord, yCoord, 0.5);
            
            drawFractal();
        } 
    }
    /**
     конструктор, который принимает значение
     размера отображения в качестве аргумента, затем сохраняет это значение в
     соответствующем поле, а также инициализирует объекты диапазона и
     фрактального генератора.
     */

    private class FractalWorker extends SwingWorker<Object, Object> {


        private int _y;


        private int[] rgbVals;

        public FractalWorker(int y)
        {
            _y = y;
        }

        /**
         *  Хранение каждое значение RGB в соответствующем элементе целочисленного массива
         */
        protected Object doInBackground()
        {
            rgbVals = new int[dispSize];

            int numIters;
            int rgbColor;

            double yCoord = getFractlYcord(_y);
            double xCoord;
            float hue;

            for(int x = 0 ; x < dispSize ; ++x)
            {
                xCoord = getFractlXcord(x);

                numIters = generetion.numIterations(xCoord, yCoord);
                if(numIters < 0)
                {
                    rgbColor = 0;
                }
                else
                {
                    hue = 0.7f + numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }

                rgbVals[x] = rgbColor;
            }

            return null;
        }

        protected void done()
        {
            for(int x = 0 ; x < dispSize ; ++x)
            {
                img.drawPixel(x, _y, rgbVals[x]);
            }

            img.repaint(0, 0, _y, dispSize, 1);

            if((--rowsRemaining) < 1)
            {
                enableUI(true);
            }
        }

    }

    //Игнорирование событий во время перерисовки
    private void enableUI(boolean val)
    {
        fractalChos.setEnabled(val);

        saveButton.setEnabled(val);
        resetButton.setEnabled(val);
    }


    public FractalExplorer(int displaySize)
    {
        dispSize = displaySize;
        
        generetion = new Mandelbrot();
        
        rng = new Rectangle2D.Double();
        generetion.getInitialRange(rng);
    }
    /**
     Метод createAndShowGUI () инициализирует
     графический интерфейс Swing: JFrame, содержащий объект JimageDisplay, и
     кнопку для сброса отображения.
     */
    public void createAndShowGUI()
    {
        frame = new JFrame("Fractal Explorer");//дать окну подходящий заголовок и

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//обеспечить операцию закрытия окна по умолчанию
        Container contentpn = frame.getContentPane();//Создаю панель содержимого

        contentpn.setLayout(new BorderLayout()); // устанавливаю расположение границ
        
        FractalHandler handler = new FractalHandler();// создаю объект класса fractalhandler
        
        /**
         * Выбираю фрактальную панель
         */
        JPanel fractalPanel = new JPanel();// создаю фрактальную панель
        
        JLabel panelLabel = new JLabel("Fractal: ");// создаю название фрактальной панели
        fractalPanel.add(panelLabel);// добавляю название к фрактальной панеле
        //Беру названия
        fractalChos = new JComboBox<String>();
        fractalChos.addItem(Mandelbrot.nameString());
        fractalChos.addItem(BurningShip.nameString());
        fractalChos.addItem(Tricorn.nameString());
        fractalChos.addActionListener(handler);
        
        fractalPanel.add(fractalChos);// добавляю названия в фрактальную панель
        
        contentpn.add(fractalPanel, BorderLayout.NORTH);//Добавляю к панеле содержимого фрактальную панель с расположением BorderLayout.NORTH

        // создаю изображение и добавляю на позицию BorderLayout.CENTER
        img = new JImageDisplay(dispSize, dispSize);
        contentpn.add(img, BorderLayout.CENTER);
        
        //Создаю кнопку  для панели
        JPanel buttonsPanel = new JPanel();
        
        //Создаю кнопку для сохранения изображения
        saveButton= new JButton("Save Image");
        saveButton.setActionCommand("save"); 
        saveButton.addActionListener(handler);
        buttonsPanel.add(saveButton);
        
        //Создаю кнопку для сброса дисплея
        resetButton = new JButton("Reset Display");
        resetButton.setActionCommand("reset"); 
        resetButton.addActionListener(handler);
        buttonsPanel.add(resetButton);
        
        contentpn.add(buttonsPanel, BorderLayout.SOUTH);//Добавляю к панели содержимого панель кнопок на позицию BorderLayout.SOUTH
        
        contentpn.addMouseListener(new MouseHandler());//добавляю MouseHandler для того, чтобы работала компьютерная мыш и
        // происходило отслеживание действий


        //Данные операции правильно разметят содержимое окна, сделают его
        //видимым  и затем запретят изменение размеров окна.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    //вывода на экран фрактала. данный метод циклически проходит через каждый пиксель в отображении
    public void drawFractal()
    {
        this.enableUI(false);
        rowsRemaining = dispSize;

        for(int y = 0 ; y < dispSize ; ++y)
        {
            FractalWorker worker = new FractalWorker(y);
            worker.execute();
        }

        img.repaint();
    }
    
    /**
     Метод который возвращает координату в пространстве фрактала для х
     */
    private double getFractlXcord(int x)
    {
        return FractalGenerator.getCoord(rng.x, rng.x + rng.width, dispSize, x);
    }

    /**
     Метод который возвращает координату в пространстве фрактала для у
     */
    private double getFractlYcord(int y)
    {
        return FractalGenerator.getCoord(rng.y, rng.y + rng.height, dispSize, y);
    }
    
    /**
     * Entry-point for the application.  No command-line arguments are
     * recognized at this time.
     **/
    public static void main(String[] args) 
    {
        FractalExplorer explorer = new FractalExplorer (400);//Инициализировую новый экземпляр класса FractalExplorer с
        //размером отображения 800
        explorer.createAndShowGUI();//отображаю интерфейс
        explorer.drawFractal();// рисую фрактал
    } 
}
