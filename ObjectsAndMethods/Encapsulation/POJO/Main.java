public class Main {

    public static void main(String[] args) {

        Vacancy vacancy = new Vacancy("специалист", 35000);
        vacancy.setWorkplace("Мурманск");
        vacancy.setFullTimeJob(true);

        String infoVacancy =
                "\n\tДолжность: " + vacancy.getPosition() + "\n\tМесто работы: " + vacancy.getWorkplace()
                        + "\n\tОклад: " + vacancy.getSalary() + "\n\tПолная занятость: " + vacancy.getFullTimeJob();
        System.out.println("Информация о вакансии: " + infoVacancy + "\n");

        Country country = new Country("Norway");
        country.setPopulation(5425270);
        country.setArea(385207);
        country.setCapitalName("Oslo");
        country.setLandlocked(false);

        String infoCountry =
                "\n\tCountry name: " + country.getCountryName() + "\n\tpopulation: " + country.getPopulation()
                        + "\n\tarea: " + country.getArea() + "\n\tCapital's name: " + country.getCapitalName()
                        + "\n\tlandlocked: " + country.getLandlocked();

        System.out.println("Информация о стране: " + infoCountry);
    }
}
