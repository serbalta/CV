/* 1125266
 * Salih Erbalta
 * 2017_OOP_2.Angabe
 */
package domain.product;

import domain.copy.*;

public interface IProduct extends IDeepCopy {

	
	String getName();
	
	float getPrice();
	
}
