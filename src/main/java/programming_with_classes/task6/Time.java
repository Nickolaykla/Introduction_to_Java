package programming_with_classes.task6;

/*
Составьте описание класса для представления времени. Предусмотрите возможности установки времени и изменения
его отдельных полей(час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых
значений полей поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов,
минут и секунд.
* */
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

    public static void main(String[] args) {
        Time time = new Time(10, 50, 40);
        System.out.println("Изначальное время:");
        System.out.println(time);

        time.changeSeconds(time, 4000);
        System.out.println("Время после изменения на заданное количество секунд:");
        System.out.println(time);

        time.changeMinutes(time, 200);
        System.out.println("Время после изменения на заданное количество минут:");
        System.out.println(time);

        time.changeHours(time, 30);
        System.out.println("Время после изменения на заданное количество часов:");
        System.out.println(time);
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
        if (getHours() + hours <= 23) {
            time.setHours((getHours() + hours));
        } else {
                time.setHours(getHours() + (hours % 24));
        }
    }

    public void changeMinutes(Time time, int minutes) {
        if (getMinutes() + minutes <= 59) {
            time.setMinutes(getMinutes() + minutes);
        } else {
            time.setMinutes((getMinutes() + minutes) % 60);
            time.changeHours(time, (getMinutes() + minutes) / 60);
        }
    }

    public void changeSeconds(Time time, int seconds) {
        if (getSeconds() + seconds <= 59) {
            time.setSeconds(getSeconds() + seconds);
        } else {
            time.setSeconds((getSeconds() + seconds) % 60);
            time.changeMinutes(time, ((getSeconds() + seconds) / 60) % 60);
            time.changeHours(time, (getSeconds() + seconds) / 60 / 60);
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
