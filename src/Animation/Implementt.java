package Animation;

public class Implementt extends Jello implements Bana, Boom {
    public Implementt(){
        super(3);
        System.out.println("hello");
    }

    public Implementt(int b){
        this();
        System.out.println("Hello I am from");

    }

    public static void main(String[] args) {
        Implementt a = new Implementt(3);
    }
    @Override
    public void hello() {
        System.out.println("I am of boon");
    }
}
