import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SoldOutException {
        int num=10;
        Scanner in=new Scanner(System.in);
        Calendar time=Calendar.getInstance();
        List<Bubble> bubbleList=new ArrayList<>();
        List<Coconut> coconutList=new ArrayList<>();
//        SetBubble(bubbleList);
        SetCoconut(coconutList);
        TeaShop teaShop=new TeaShop();
        int p=0;
        while(true){
            p=0;
            System.out.println("选择你的身份\n1:店长 2:顾客 3.退出");
            int choice=in.nextInt();
            if (choice==1){
                System.out.println("选择你要做的事\n1:进货 2:查看所有配料信息");
                int choice_=in.nextInt();
                if (choice_==1){
                    String s;
                    System.out.println("输入你要进货的配料种类(Bubble或者Coconut)");
                    s=in.next();
                    if (s.equals("Bubble")){
                        bubbleList.add((Bubble) teaShop.StockPurch(new Bubble()));
                        System.out.println(bubbleList.get(bubbleList.size()-1).toString());
                    }
                    else{
                        coconutList.add((Coconut) teaShop.StockPurch(new Coconut()));
                    }
                }
                else {
                    for (int i=0;i<bubbleList.size();i++){
                        System.out.println(bubbleList.get(i));
                    }
                    System.out.println("共有"+bubbleList.size()+"份Bubble配料");
                    for (int i=0;i<coconutList.size();i++){
                        System.out.println(coconutList.get(i));
                    }
                    System.out.println("共有"+coconutList.size()+"份配料");
                }
            }
            else if(choice==2){
                System.out.println("请输入你要的奶茶名字");
                String s,s1;
                s=in.nextLine();
                s=in.nextLine();
                System.out.println("请输入你要的配料名字(Bubble或Coconut)");
                s1=in.nextLine();
                System.out.println(s1);
                if (s1.equals("Bubble")){
                    try{
                        isgone1(bubbleList);
                    }catch (SoldOutException e){
                        p++;
                        System.out.println(e);
                    }
                    if (p==0){
                        if(teaShop.Sell(s,s1,bubbleList.get(bubbleList.size()-1))){
                            MilkTea milkTea=new MilkTea(s,new Bubble());
                            System.out.println("售出成功\n");
                            bubbleList.remove(bubbleList.size()-1);
                            System.out.println("该顾客获得的奶茶信息\n"+milkTea.toString());
                        }
                        else{
                            bubbleList.remove(bubbleList.size()-1);
                        }
                    }
                }
                else{
                    try{
                        isgone2(coconutList);
                    }catch (SoldOutException e){
                        p++;
                        System.out.println(e);
                    }
                    if (p==0){
                        if ( teaShop.Sell(s,s1,coconutList.get(coconutList.size()-1))){
                            MilkTea milkTea=new MilkTea(s,new Coconut());
                            System.out.println("售出成功\n");
                            System.out.println("该顾客获得的奶茶信息\n"+milkTea.toString());
                        }
                        else {
                            coconutList.remove(coconutList.size()-1);
                        }
                    }
                }
            }
            else {
                break;
            }
        }
    }
    public static void SetBubble(List<Bubble> bubbleList){
        for (int i=0;i<10;i++){
            bubbleList.add(new Bubble());
        }
    }
    public static void SetCoconut(List<Coconut> coconutList){
        for (int i=0;i<10;i++){
            coconutList.add(new Coconut());
        }
    }
    public static void isgone1(List<Bubble> bubbleList) throws SoldOutException{
        if (bubbleList.isEmpty()){
            throw new SoldOutException("该配料已经售空,请重新选择身份");
        }
    }
    public static void isgone2(List<Coconut> coconutList) throws SoldOutException{
        if (coconutList.isEmpty()){
            throw new SoldOutException("该配料已经售空,请重新选择身份");
        }
    }
}

