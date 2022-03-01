package cashregister;

public class CashRegisterFactory {

	
	 private static long CASH_REGISTER_ID ;
	 
	public CashRegisterFactory(){
		
	
		
	}
	
	
	public static ICashRegister createCashRegister(){
		CashRegisterFactory.CASH_REGISTER_ID++;
		CashRegister cashReg = new CashRegister(CASH_REGISTER_ID);
		return cashReg;
	}
	
}
