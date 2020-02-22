public class TestPassword {
    private TestPassword() {
    }

    public static void main(final String[] args) {
        RandomStringGenerator gen = new RandomStringGenerator(6, new String("abcdefghijklmnopq"));
        System.out.println("Random String: " + gen.next());

        PasswordMaker pass = new PasswordMaker("Laurentiu", "Stamate", 22);
        System.out.println("Password: " + pass.getPassword());
    }
}
