public class ShortWordFilter implements Filter{


    public ShortWordFilter (){

    }
    @Override
    public boolean accept(Object x) {
        boolean shortWord = false;
        if (x instanceof String) {
            String word = (String) x;
            if (word.length() < 5){
                shortWord = true;
            }
        }
        return shortWord;
    }

}
