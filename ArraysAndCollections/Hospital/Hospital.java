public class Hospital {

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] temperatures = new float[patientsCount];
        float minTemperature = 32f;
        float maxTemperature = 40f;

        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = (float) roundAvoid(Math.random()
                    * (maxTemperature - minTemperature) + minTemperature, 1);
        }
        return temperatures;
    }

    public static String getReport(float[] temperatureData) {

        StringBuilder temperaturePatients = new StringBuilder();
        float average;
        float sum = 0;

        for (float temperature : temperatureData) {
            temperaturePatients.append(temperature).append(' ');
            sum += temperature;
        }

        average = (float) roundAvoid(sum / temperatureData.length, 2);
        
        return "Температуры пациентов: " + temperaturePatients.toString().trim() +
                "\nСредняя температура: " + average +
                "\nКоличество здоровых: " + getHealthyPatients(temperatureData);
    }

    public static int getHealthyPatients(float[] temperatureData) {
        int normalTemperature = 0;
        for (float temperatureDatum : temperatureData) {

            if (temperatureDatum >= 36.2f && temperatureDatum <= 36.9f) {
                normalTemperature++;
            }
        }
        return normalTemperature;
    }
}
