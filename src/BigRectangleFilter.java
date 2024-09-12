import java.awt.*;

public class BigRectangleFilter implements Filter  {


    public BigRectangleFilter() {
    }

    @Override
    public boolean accept(Object x) {
        boolean bigRect = false;
        if (x instanceof Rectangle){
            Rectangle rect = (Rectangle) x;
            double perimeter = 2.0 *(rect.height) + 2.0 *(rect.width);
            if (perimeter > 10.0){
                bigRect = true;
            }

        }
        return bigRect;
    }
}
