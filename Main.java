import com.google.gson.*;

import com.google.gson.reflect.TypeToken;
import shapes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;


public class Main {
    public static void main(String[] args) throws Exception {
        RuntimeTypeAdapterFactory<Shape> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Shape.class, "type")
                .registerSubtype(Triangle.class, "triangle")
                .registerSubtype(Circle.class, "circle")
                .registerSubtype(Rectangle.class, "rectangle")
                .registerSubtype(Square.class, "square");
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

        String jsonShapes;
        List<Shape> shapes;
        String filename = "shapes.json";
        File file = new File(filename);

        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                jsonShapes = scanner.next();
                scanner.close();
            } catch (Exception e) {
                System.out.println("An error occurred while reading serialized data");
                e.printStackTrace();
                return;
            }

            Type listType = new TypeToken<List<Shape>>(){}.getType();
            shapes = gson.fromJson(jsonShapes, listType);
            System.out.println("Deserialized shapes from shapes.json: ");
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
        } else {
            int max = 10;
            shapes = List.of(
                    new Triangle(6.0, 7.0, 4.0),
                    new Circle(Math.random() * max),
                    new Rectangle(Math.random() * max, Math.random() * max),
                    new Square(Math.random() * max)
            );
            System.out.println("Shape objects for serializing: ");
            for (Shape shape : shapes) {
                System.out.println(shape);
            }
            jsonShapes = gson.toJson(shapes);

            try {
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(jsonShapes);
                myWriter.close();
                System.out.println("Successfully wrote serialized data to the shapes.json");
            } catch (IOException e) {
                System.out.println("An error occurred while saving serialized data");
                e.printStackTrace();
            }
        }
    }
}
