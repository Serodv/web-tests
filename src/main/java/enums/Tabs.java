package enums;

public enum Tabs {
    MAIN("Главная"),
    FORUM("Форум"),
    NEWS("Лента"),
    SALARIES("Зарплаты"),
    WORK("Работа"),
    CALENDAR("Календарь"),
    JOBS("Вакансии"),
    TRENDS("Тренды"),
    COMPANIES("Компании"),
    RATINGS("Рейтинг"),
    TOP_50("Топ-50"),
    REVIEWS("Отзывы")
    ;

    private final String name;

    Tabs(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
