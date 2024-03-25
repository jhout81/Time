public class Time {
    // private variables only accessible in this class
    private int hours;
    private int minutes;
    private int seconds;

    //default constructor
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;

    }

    //constructor
    public Time(int hours, int minutes, int seconds) {
        //passing through variables using "this" keyword
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //Attempts to put the string into the a time object
    // I wss able to parse successfully but I was never able to successfully
    // pass the integers for calculation for t3 not quite sure here
    public static Time fromString(String time) {
        String[] newTime = time.split(":");
        int hours = Integer.parseInt(newTime[0]);
        int minutes = Integer.parseInt(newTime[1]);
        int seconds = Integer.parseInt(newTime[2]);
        Time timeParsed = new Time(hours, minutes, seconds);
        return new Time();
        //return new Time(hours, minutes, seconds) didn't work why not?

    }

    public void increment(int seconds) {
        //conditions to calculate proper time
        if (this.seconds + seconds < 60) {
            this.seconds += seconds;

        } else if (this.seconds + seconds < 3600) {
            this.minutes += ((this.seconds + seconds) / 60);
            this.seconds += ((this.seconds + seconds) % 60);

        } else if (this.seconds + seconds >= 3600) {
            this.hours += ((this.seconds + seconds) / 60 / 60);
            this.minutes += ((this.seconds + seconds) / 60 % 60);
            this.seconds += ((this.seconds + seconds) % 60);
            if (this.seconds >= 60) {
                this.minutes += (this.seconds / 60);
                this.seconds -= 60;
            }
            if (this.minutes >= 60) {
                this.hours += (this.minutes / 60);
                this.minutes -= 60;
            }
            if (this.hours >= 24) {
                this.hours -= 24;
            }
        }

    }

    public void print(Boolean military) {
        //when true formats 24 hour time when hours less than 10
        if (military) {
            if (this.minutes < 10 && this.seconds < 10) {
                System.out.println(hours + ":" + "0" + minutes + ":" + "0" + seconds);
            } else if (this.minutes < 10) {
                System.out.println(hours + ":" + "0" + minutes + ":" + seconds);
            } else if (this.seconds < 10) {
                System.out.println(hours + ":" + minutes + ":" + "0" + seconds);
            }

        } else {
            // when false formats 24 hour time to 12 hour time
            if (this.hours <= 11) {
                if (this.minutes < 10 && this.seconds < 10) {
                    System.out.println(hours + ":" + "0" + minutes + ":" + "0" + seconds + " AM");
                } else if (this.minutes < 10) {
                    System.out.println(hours + ":" + "0" + minutes + ":" + seconds + " AM");
                } else if (this.seconds < 10) {
                    System.out.println(hours + ":" + minutes + ":" + "0" + seconds + " AM");
                }
            } else if (this.hours == 12) {
                if (this.minutes < 10 && this.seconds < 10) {
                    System.out.println(hours + ":" + "0" + minutes + ":" + "0" + seconds + " PM");
                } else if (this.minutes < 10) {
                    System.out.println(hours + ":" + "0" + minutes + ":" + seconds + " PM");
                } else if (this.seconds < 10) {
                    System.out.println(hours + ":" + minutes + ":" + "0" + seconds + " PM");
                }
            } else if (this.hours > 12) {
                if (this.minutes < 10 && this.seconds < 10) {
                    System.out.println((hours - 2 - 10) + ":" + "0" + minutes + ":" + "0" + seconds + " PM");
                } else if (this.minutes < 10) {
                    System.out.println((hours - 2 - 10) + ":" + "0" + minutes + ":" + seconds + " PM");
                } else if (this.seconds < 10) {
                    System.out.println((hours - 2 - 10) + ":" + minutes + ":" + "0" + seconds + " PM");
                }
            }

        }

    }


}
