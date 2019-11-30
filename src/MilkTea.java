public class MilkTea {
    private String name;
    private Ingredient ingredient;

    MilkTea(String name,Ingredient ingredient){
        this.name=name;
        this.ingredient=ingredient;
    }

    @Override
    public String toString() {
        if (ingredient instanceof Bubble){
            return ("奶茶:"+name+"\n配料:"+"Bubble");
        }
        else{
            return ("奶茶:"+name+"\n配料:"+"Coconut");
        }
    }
}
