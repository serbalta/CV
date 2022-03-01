package cashregister;

import java.util.Collection;

import container.Container;
import domain.product.IShoppingCartElement;



public class ShoppingCart implements IShoppingCart{
	
	private long id; 
	private Collection<IShoppingCartElement> shoppingCardsElements;
	
	
	public ShoppingCart(long id){
		this.id = id;	
		this.shoppingCardsElements = new Container<IShoppingCartElement>();
		
	}

	@Override
	public void addElement(IShoppingCartElement shoppingCartElement) {
		// TODO Auto-generated method stub
		
		shoppingCardsElements.add(shoppingCartElement);
		
		
	}

	@Override
	public Collection<IShoppingCartElement> currentElements() {
		// TODO Auto-generated method stub
		return shoppingCardsElements;
	}

	@Override
	public int getNumberOfElements() {
		// TODO Auto-generated method stub
		return shoppingCardsElements.size();
	}

	@Override
	public Long getShoppingCartID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public float getTotalPriceOfElements() {
		// TODO Auto-generated method stub
		float totalprice = 0;
		
		for(IShoppingCartElement elems : shoppingCardsElements){
			totalprice += elems.getPrice();
		}
		return totalprice;
	}

	@Override
	public boolean removeElement(IShoppingCartElement element) {
		// TODO Auto-generated method stub
		boolean i = false;
		
	
			if(shoppingCardsElements.contains(element)){
				shoppingCardsElements.remove(element);
				removeElement(element);
				i = true;
			}
		
		
		return i;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + "]";
	}

	
	
	
}
