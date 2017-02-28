package creational;

import java.util.Hashtable;

/**
 * Created by oharas on 28.02.2017.
 */
public class Prototype {
    /**
     * https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
     *
     * We're going to create an abstract class Shape and concrete classes extending the Shape class.
     * A class ShapeCache is defined as a next step which stores shape objects in a Hashtable
     * and returns their clone when requested.
     * PrototypePatternDemo, our demo class will use ShapeCache class to get a Shape object.
     */

    /**
     * Step 1 : Create an abstract class implementing Cloneable interface.
     */
    public abstract class Shape extends java.lang.Object implements Cloneable {
        private String id;
        protected String type;

        abstract void draw();

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public Object clone() {
            Object clone = null;

            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    /**
     * Step 2: Create concrete classes extending the above class.
     */

    public class Rectangle extends Shape {

        public Rectangle() {
            type = "Rectangle";
        }

        @Override
        void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    public class Square extends Shape {

        public Square() {
            type = "Square";
        }

        @Override
        void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    public class Circle extends Shape {

        public Circle() {
            type = "Circle";
        }

        @Override
        void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }

    /**
     * Step 3: Create a class to get concrete classes from database and store them in a Hashtable.
     */

    public class ShapeCache {

        private Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

        public Shape getShape(String shapeId) {
            Shape cachedShape = shapeMap.get(shapeId);
            return (Shape) cachedShape.clone();
        }
        // for each shape run database query and create shape
        // shapeMap.put(shapeKey, shape);
        // for example, we are adding three shapes

        public void loadCache() {
            Circle circle = new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(), circle);

            Square square = new Square();
            square.setId("2");
            shapeMap.put(square.getId(), square);

            Rectangle rectangle = new Rectangle();
            rectangle.setId("3");
            shapeMap.put(rectangle.getId(), rectangle);
        }
    }

    /**
     * Step 4
     * PrototypePatternDemo uses ShapeCache class to get clones of shapes stored in a Hashtable.
     */
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        ShapeCache shapeCache = prototype.new ShapeCache();
        shapeCache.loadCache();

        Shape clonedShape;
        clonedShape = shapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2;
        clonedShape2 = shapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3;
        clonedShape3 = shapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
