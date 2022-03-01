package cashregister;

public class ShoppingCartFactory {

	private static long SHOPPING_CARD_ID ;
	
	
	public ShoppingCartFactory(){
		
	}
	
	public static IShoppingCart createShoppingCart(){
		ShoppingCartFactory.SHOPPING_CARD_ID++;
		ShoppingCart newCart = new ShoppingCart(SHOPPING_CARD_ID);
		
		return newCart;
		
	}
}
