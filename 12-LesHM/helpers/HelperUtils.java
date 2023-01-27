package krg.petr.otusjava.helpers;

import java.util.Random;

public class HelperUtils {
    private final String[] names = {"Дмитрий", "Максим", "Пётр", "Никита", "Артем", "Иван", "Кирилл", "Егор",
            "Илья", "Андрей"};
    private final String[] middleName = {"Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич",
            "Сергеевич", "Викторович", "Михайлович", "Артемович", "Петрович"};
    private final String[] surName = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов",
            "Лазарев", "Медведев", "Ершов"};

    public String generateRandomFIO() {

        return String.format("%s %s %s",
                generateRandomString(this.names),
                generateRandomString(this.middleName),
                generateRandomString(this.surName));
    }

    private String generateRandomString(String[] stringsArray) {

        final int MAX_INDEX = stringsArray.length;
        int randomIndex = new Random().nextInt(MAX_INDEX);
        return stringsArray[randomIndex];
    }

    public int generateBalance() {

        final int MAX_BALANCE = 100;
        return new Random().nextInt(MAX_BALANCE);
    }
    public  int generateClientAge(int minAge, int maxAge) {

        return new Random().nextInt(maxAge - minAge) + minAge;
    }

}

