abstract class Cake{
    public void makeCake(){
        preheatOven();
        mixIngredients();
        bake();
        cool();
        frost();
    }
        protected void preheatOven() { System.out.println("Preheating the oven");}
        protected abstract void mixIngredients(); //Hooks
        protected abstract void bake(); //Hooks
        protected void cool(){System.out.println("Cooling down the cake");}
        protected abstract void frost();
}

class ChocolateCake extends Cake{
    @Override
    protected void mixIngredients(){System.out.println("Mixing Chocolate ingredients");}
    @Override
    protected void bake(){System.out.println("Baking cake for 30 minutes");}
    @Override
    protected void frost() {System.out.println("Frosting with chocolate whipped cream");}
}
class VanillaCake extends Cake{
    @Override
    protected void mixIngredients(){System.out.println("Mixing vanilla ingredients");}
    @Override
    protected void bake(){System.out.println("Baking for 35 minutes");}
    @Override
    protected void frost(){System.out.println("Frosting with vanilla whipped cream");}
}

public class TemplatePattern {
    public static void main(String[] args) {
        Cake chocolateCake = new ChocolateCake();
        chocolateCake.makeCake();
    
        Cake vanillaCake = new VanillaCake();
        vanillaCake.makeCake();
    
    }

}
