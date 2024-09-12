import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectList = new ArrayList<>();
        ArrayList<Rectangle> shortRect = new ArrayList<>();
        BigRectangleFilter rectFilter = new BigRectangleFilter();
        Rectangle rect1 = new Rectangle(5, 10); // > 10
        Rectangle rect2 = new Rectangle(1,2);
        Rectangle rect3 = new Rectangle(10,20);// > 10
        Rectangle rect4 = new Rectangle(2, 3);
        Rectangle rect5 = new Rectangle(3, 4);// > 10
        Rectangle rect6 = new Rectangle(5, 6);// > 10
        Rectangle rect7 = new Rectangle(1, 4);
        Rectangle rect8 = new Rectangle(1, 3);
        Rectangle rect9 = new Rectangle(4, 5);// > 10
        Rectangle rect10 = new Rectangle(6, 7);// > 10

        rectList.add(rect1);
        rectList.add(rect2);
        rectList.add(rect3);
        rectList.add(rect4);
        rectList.add(rect5);
        rectList.add(rect6);
        rectList.add(rect7);
        rectList.add(rect8);
        rectList.add(rect9);
        rectList.add(rect10);


        for (Rectangle r : rectList){
            if (rectFilter.accept(r)){
                shortRect.add(r);
            }
        }
        System.out.println("This rectangles have a perimeter greater than 10:\n ");

        for (Rectangle r2 : shortRect){
            System.out.println("Rectangle with width: '" + r2.getWidth() + "' and height '" + r2.getHeight() + "' ." +  "\n");
        }



    }
}
