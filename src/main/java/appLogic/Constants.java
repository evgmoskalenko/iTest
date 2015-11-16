package appLogic;


import java.util.Properties;

public class Constants {

    public static class Settings {

        //    ------------------- Запуск в браузерах  ------------------------------//
        public static final String BROWSER;

        static {
            Properties prop = new Properties();
            try {

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (System.getProperty("BROWSER") != null) {
                BROWSER = System.getProperty("BROWSER");
            } else {
                BROWSER = "firefox";// = "chrome"; //firefox or proxy or myfirefox or chrome or ie or opera or htmlunit
            }

        }

        //    ------------------- Регионы  ------------------------------//
        public static class Region {
            public static final String Dnipropetrovska = "Дніпропетровська";
            public static final String Poltavska = "Полтавська";
        }
        //    ------------------- Города  ------------------------------//
        public static class City {
            public static final String Dnipropetrovsk = "Дніпропетровськ";
            public static final String Poltava= "Полтава";
        }

        //    ------------------- Услуги  -----------------//
        // Міліція та ДАІ
        public static class ServiceMVD {
            public static final String CriminalRecord = "Надання довідки про відсутність (наявність) судимості або обмежень, передбачених кримінально-процесуальним законодавством";
        }
        //Взаємодія з державними органами
        public static class InteractionWithPublicAuthorities {
        	public static final String Subsidy = "Отримання субсидії на оплату житлово-комунальних послуг";
        }


        //    ------------------- Данные для подачи заявок  -----------------//
        public static class Data {
            public static final String Phone = "380102030405";
            public static final String FIO_UA = "Дмитро Олександрович Дубілет";
            public static final String FIO_RUS = "Дубилет Дмитрий Александрович";
            public static final String E_MAIL = "vidokgulich@gmail.com";
            public static final String BirthDay = "01.01.1960";
            public static final String BirthLocal = "Україна,Дніпропетровська,Дніпропетровськ";
            public static final String Resident = "Українське";
        }

        //    ------------------- Данные для входа в Банк ИД ПриаптБанк  -----------------//
        public static class BankIDprivatBank {
            public static final String Login = "+380102030405";   // номер телефона
            public static final String Password = "value";   // пароль
            public static final String OTP1 = "12";   // Одноразовый пароль
            public static final String OTP2 = "34";   // Одноразовый пароль
            public static final String OTP3 = "56";   // Одноразовый пароль
        }
    }

    //    ------------------- Сервера для запуска тестов  ------------------------------//
    public static class Server {
        public static final String SERVER = "https://test-version.igov.org.ua";
        // https://test-version.igov.org.ua/   - для регреса
        // https://test.igov.org.ua/   - тестовый
    }

}
