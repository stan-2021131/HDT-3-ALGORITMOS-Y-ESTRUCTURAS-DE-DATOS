public class Main {
    public static void main(String[] args) {
        String file = "List.txt";
        FileControl fc = new FileControl();
        String result = fc.writeList(file, fc.generateNumbers(10, 0, 10));
        System.out.println(result);
    }
}
