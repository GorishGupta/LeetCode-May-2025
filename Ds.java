class DS {
    public static void main(String[] args) {
        int arr[] = { 2, 10, 5, 6, 8, 9 };
        // Sorting
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; i++) {
                if (arr[i] < arr[i + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
