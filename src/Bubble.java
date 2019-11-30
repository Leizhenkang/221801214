import java.util.Calendar;

public class Bubble extends Ingredient{
    Bubble(Calendar time) {
        super(time);
        this.day=7;      //珍珠配料保质期为七天
        if (getsdays(this.time,nowtime)>day){
            ifoverdue=true;
        }
        else {
            ifoverdue=false;
        }
    }

    Bubble(){
        super();
        this.day=7;
    }

    @Override
    public String toString() {
        return ("配料名字:Bubble\n"+"生产日期:"+time.get(Calendar.YEAR)+"."+(time.get(Calendar.MONTH)+1)+"."+time.get(Calendar.DAY_OF_MONTH)+"\n"+"保质期:7天\n"+"是否过期:"+ifoverdue);
    }
}
