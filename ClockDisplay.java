import java.time.LocalTime;

public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    public ClockDisplay(int hour, int minute) {
        hours = new NumberDisplay(24); 
        minutes = new NumberDisplay(60); 
        setTime(hour, minute);
    }

    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    public void updateTime() {
        LocalTime now = LocalTime.now(); 
        setTime(now.getHour(), now.getMinute());
    }

    private void updateDisplay() {
        displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue();
    }

    public String getTime() {
        return displayString;
    }
}
