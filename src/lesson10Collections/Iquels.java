package lesson10Collections;

public class Iquels {
    public static void main(String[] args) {

        Point point = new Point(434343, 43434);

        System.out.println(point.compareTo(point));


    }
}

    class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.y) {
                return 0;
            } else if (this.x > o.y) {
                return 1;
            } else {
                return -1;
            }

        }
    }