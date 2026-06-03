package ExceptionDemo;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        int[] arr = null;
        try {
            test(arr);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static int test(int[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }

        if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
