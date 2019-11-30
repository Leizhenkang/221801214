public interface Shop {
    public Ingredient StockPurch(Ingredient ingredient);

    public Boolean Sell(String name, String inname, Ingredient ingredient);
}
