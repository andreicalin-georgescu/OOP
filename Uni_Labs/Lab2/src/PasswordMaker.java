class PasswordMaker {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static final int MAGIC_NUMBER = 13;
    private static final String MAGIC_STRING = new RandomStringGenerator(25, alphabet).next();

    private String firstName;
    private String lastName;
    private int age;

    PasswordMaker(final String f, final String l, final int a) {
        this.firstName = f;
        this.lastName = l;
        this.age = a;
    }

    String getPassword() {
        String alpha = new RandomStringGenerator(10, MAGIC_STRING).next();
        RandomStringGenerator gen = new RandomStringGenerator(MAGIC_NUMBER, alpha);

        String password = firstName.substring(firstName.length() - (age % 3));
        password = password.concat(gen.next());

        return password.concat(String.valueOf(age + lastName.length()));
    }
}
