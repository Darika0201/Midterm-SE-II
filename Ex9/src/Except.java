public class Except {
    public static void checkEmptyBlankNull(String field, String label) {
        if (field == null)
            throw new NullPointerException(label + " shoudn't be null");
        if (field.isEmpty() || field.isBlank())
            throw new IllegalArgumentException(label + " shoudn't be empty");

    }
}
