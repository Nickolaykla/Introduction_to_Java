package programming_with_classes.simple_classes_and_objects.task6;

/*
Составьте описание класса для представления времени. Предусмотрите возможности установки времени и изменения
его отдельных полей(час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых
значений полей поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов,
минут и секунд.
*/
public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        if (hours >= 0 && hours <= 23 &&
                minutes >= 0 && minutes <= 59 &&
                seconds >= 0 && seconds <= 59) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        } else {
            this.hours = 0;
            this.minutes = 0;
            this.seconds = 0;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours <= 23) {
            this.hours = hours;
        } else this.hours = 0;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes <= 59) {
            this.minutes = minutes;
        } else this.minutes = 0;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds <= 59) {
            this.seconds = seconds;
        } else this.seconds = 0;
    }

    public void changeHours(Time time, int hours) {
        if (time.getHours() + hours <= 23) {
            time.setHours((time.getHours() + hours));
        } else {
            time.setHours(time.getHours() + (hours % 24));
        }
    }

    public void changeMinutes(Time time, int minutes) {
        if (time.getMinutes() + minutes <= 59) {
            time.setMinutes(time.getMinutes() + minutes);
        } else {
            time.changeHours(time, (time.getMinutes() + minutes) / 60);
            time.setMinutes((time.getMinutes() + minutes) % 60);
        }
    }

    public void changeSeconds(Time time, int seconds) {
        if (time.getSeconds() + seconds <= 59) {
            time.setSeconds(getSeconds() + seconds);
        } else {
            time.changeHours(time, (time.getSeconds() + seconds) / 60 / 60);
            time.changeMinutes(time, ((time.getSeconds() + seconds) / 60) % 60);
            time.setSeconds((time.getSeconds() + seconds) % 60);
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}