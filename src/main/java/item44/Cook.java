package item44;

abstract class Cook {

    // 공통 메서드
    public void cooking() {
        System.out.println("start cooking");
        variant();
        System.out.println("end cooking");
    }

    // 변화하는 부분
    abstract void variant();
}

class Pasta extends Cook {

    @Override
    void variant() {
        System.out.println("make pasta");
    }
}

class Pizza extends Cook {

    @Override
    void variant() {
        System.out.println("make pizza");
    }
}

class App {
    public static void main(String[] args) {
        Pasta pasta = new Pasta();
        Pizza pizza = new Pizza();

        pasta.cooking();
        pizza.cooking();
    }
}
