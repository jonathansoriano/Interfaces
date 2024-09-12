import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectList = new ArrayList<>();
        ArrayList<Rectangle> shortRect = new ArrayList<>();
        BigRectangleFilter rectFilter = new BigRectangleFilter();
        Rectangle rect1 = new Rectangle(5, 10);
        Rectangle rect2 = new Rectangle(1,2);
        Rectangle rect3 = new Rectangle(10,20);
        Rectangle rect4 = new Rectangle(2, 3);

        rectList.add(rect1);
        rectList.add(rect2);
        rectList.add(rect3);
        rectList.add(rect4);


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
