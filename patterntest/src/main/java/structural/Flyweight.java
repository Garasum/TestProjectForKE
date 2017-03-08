package structural;

import java.util.HashMap;

/**
 * Created by Orest on 3/5/2017.
 * <p>
 * Flyweight pattern is primarily used to reduce the number of objects created and to decrease memory footprint and increase performance.
 * This type of design pattern comes under structural pattern as this pattern provides ways
 * to decrease object count thus improving the object structure of application.
 * <p>
 * Flyweight pattern tries to reuse already existing similar kind objects by storing them and creates new object when no matching object is found.
 * We will demonstrate this pattern by drawing 20 circles of different locations but we will create only 5 objects.
 * Only 5 colors are available so color property is used to check already existing Circle objects.
 */
public class Flyweight {

    public interface Shape {
        void draw();
    }

    public class Circle implements Shape {
        private String color;
        private int x;
        private int y;
        private int radius;

        public Circle(String color) {
            this.color = color;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }


        @Override
        public void draw() {
            System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
        }
    }

    //static
    public class ShapeFactory {
        private final HashMap<String, Shape> circleMap = new HashMap<>();

        public Shape getCircle(String color) {
            Circle circle = (Circle) circleMap.get(color);

            if (circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
                System.out.println("Creating circle of color : " + color);
            }
            return circle;
        }
    }


    /**
     * Step 4
     * Use the factory to get object of concrete class by passing an information such as color.
     */
    private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        Flyweight flyweight = new Flyweight();
        for (int i = 0; i < 20; ++i) {
            Circle circle = (Circle) flyweight.new ShapeFactory().getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }

}

