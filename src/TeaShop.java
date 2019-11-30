import java.util.Calendar;
import java.util.Scanner;

public class TeaShop implements Shop {
    @Override
    public Ingredient StockPurch(Ingredient ingredient) {
        if (ingredient instanceof Bubble){
            ingredient.setDay(7);
            System.out.print("请输入你要生产的年份:");
            Scanner in=new Scanner(System.in);
            int year=in.nextInt();
            System.out.print("请输入你要生产的月份:");
            int month=in.nextInt();
            System.out.print("请输入你要生产的号数:");
            int day=in.nextInt();
            Calendar time=Calendar.getInstance();
            time.set(year,(month-1),day);
            ingredient.setTime(time);
        }
        else{
            ingredient.setDay(5);
            System.out.print("请输入你要生产的年份:");
            Scanner in=new Scanner(System.in);
            int year=in.nextInt();
            System.out.print("请输入你要生产的月份:");
            int month=in.nextInt();
            System.out.print("请输入你要生产的号数:");
            int day=in.nextInt();
            Calendar time=Calendar.getInstance();
            time.set(year,(month-1),day);
        }
        return ingredient;
    }

    @Override
    public Boolean Sell(String name, String inname, Ingredient ingredient) {
        if (inname.equals("Bubble")){
            if (ingredient.getIfoverdue()){
                System.out.println("该配料已过期,移除,重新加入配料");
                return false;
            }
        }
        else {
            if (ingredient.getIfoverdue()){
                System.out.println("该配料已过期,移除,重新加入配料");
                return false;
            }
        }
        return true;
    }
}
