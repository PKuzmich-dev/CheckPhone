public class Main {

    public static void main(String[] args) {
        // write your code here
        String[] a = validatePhone("+7( 910 ) 1862761");
        System.out.println(a[0]);
        System.out.println(a[1]);
    }

    public static String[] validatePhone(String str) {
        String modificationList = "";

        if (str.startsWith("+7")) {
            str = str.replace("+7", "8");
            modificationList = "Замена +7 на 8";
        }

        if (str.indexOf(" ") > 0 || str.indexOf("(") > 0 || str.indexOf(")") > 0) {
            str = str.replace(" ", "");
            str = str.replace(")", "");
            str = str.replace("(", "");
            if (modificationList.isEmpty())
                modificationList = "В номере есть пробелы и/или скобки";
            else
                modificationList = modificationList + "; В номере есть пробелы и/или скобки";
        }

        if (str.length() != 11){
            if (str.length() > 11)
                modificationList = "Количество символов больше 11";
            else
                modificationList = "Количество символов меньше 11";
            str = "Введен некорректный номер";
        }

        if (modificationList.isEmpty()) {
            modificationList = "Не было изменений";
        }

        String[] arr = new String[2];
        arr[0] = str;
        arr[1] = modificationList;

        return arr;
    }
}
