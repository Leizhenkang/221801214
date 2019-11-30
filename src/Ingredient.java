import java.util.Calendar;

public abstract class Ingredient {
    protected Calendar time=Calendar.getInstance();
    protected int day;
    protected Boolean ifoverdue;
    protected Calendar nowtime=Calendar.getInstance();

    Ingredient(){
        this.time=nowtime;
        this.ifoverdue=false;
    }
    Ingredient(Calendar time){
        this.time=time;
    }

    public Boolean getIfoverdue() {
        return ifoverdue;
    }

    public int getDay() {
        return day;
    }


    public void setTime(Calendar time) {
        this.time = time;
        if (getsdays(time,nowtime)>day){
            ifoverdue=true;
        }
        else {
            ifoverdue=false;
        }
    }


    public Calendar getTime() {
        return time;
    }

    public void setDay(int day) {
        this.day = day;
    }


    public static int getsdays(Calendar a,Calendar b) {
        if(b.after(a)) {
            Calendar temp;
            temp=a;
            a=b;
            b=temp;
        }
        int days=a.get(Calendar.DAY_OF_YEAR)-b.get(Calendar.DAY_OF_YEAR);
        if(a.get(Calendar.YEAR)!=b.get(Calendar.YEAR)) {
            do {
                days+=a.getActualMaximum(Calendar.DAY_OF_YEAR);
                a.add(Calendar.YEAR, 1);
            }
            while(a.get(Calendar.YEAR)!=b.get(Calendar.YEAR));
        }
        return days;
    }
}
