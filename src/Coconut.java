import java.util.Calendar;

public class Coconut extends Ingredient {

    Coconut( Calendar time) {
        super( time);
        this.day=5;
        if (getsdays(this.time,nowtime)>day){
            ifoverdue=true;
        }
        else {
            ifoverdue=false;
        }
    }
    Coconut(){
        super();
        this.day=5;
    }

    @Override
    public String toString() {
        return ("配料名字:Coconut\n"+"生产日期:"+time.get(Calendar.YEAR)+"."+(time.get(Calendar.MONTH)+1)+"."+time.get(Calendar.DAY_OF_MONTH)+"\n"+"保质期:5天\n"+"是否过期:"+ifoverdue);
    }
}
