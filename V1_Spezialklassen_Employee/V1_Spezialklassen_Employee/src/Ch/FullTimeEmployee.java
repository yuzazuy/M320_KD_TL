package Ch;

public class FullTimeEmployee {
    private Integer hourly_rate;
    private Integer hours_worked;

    public Integer calculate_rate() {
        Integer rate = hourly_rate * hours_worked;
        return rate;
    };

}
