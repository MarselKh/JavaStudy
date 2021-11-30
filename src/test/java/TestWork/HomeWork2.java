package TestWork;

public class HomeWork2 {
        public static void main(String[] args) {
                chapter1(5, 4);
                chapter2(-10);
                System.out.println(chapter3(5));
                chapter4(2);
                /*System.out.println(chapter5(5));*/  //Не выполнил 5 задание
        }

/*        public static boolean chapter5(int a) {
                int i;
                int h;
                int t;
                for (i = 0, t = 0, h = 0; i <= a, t <= a, h <= a; i += 4, t += 400, h += 100) {
                        if (a == i || a == t) {
                                return true;
                        } else if (a == h) {
                                return false;
                        } else {
                                return false;
                        }
                }
        }*/

        public static void chapter4(int a) {
                // Хотел использовать foreach, не получилось
                String s = "Hello";
                for (int i = 0; i < a; i++) {
                        System.out.println(s);
                }
        }

        public static boolean chapter3(int a) {
                int b = 0;
                if (a < b) {
                        return true;
                } else {
                        return false;
                }
        }

        public static void chapter2(int a) {
                int b = 0;
                if (a >= b) {
                        System.out.println("Число положительное");
                } else {
                        System.out.println("Число отрицательное");
                }
        }


        public static void chapter1(int a, int b) {
                int c = (a + b);
                if (c >= 10 && c <= 20) {
                        System.out.println(true);
                } else {
                        System.out.println(false);
                }

        }
}