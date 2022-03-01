/*
 * Java Angabe2-Chatty
 * 
 * Salih ERBALTA
 * 1125266
 * 
 */



import java.util.Collection;
import java.util.Vector;



public class ChattyGroup implements IChattyGroup {

	
	
	
	private String group;
	private Collection<IChattyGroupObserver> observers;
	
	
	public ChattyGroup (String group) {
		this.setGroup(group);
		observers = new Vector<IChattyGroupObserver>();
		
	}
	
	@Override
	public void joinGroup(IChattyGroupObserver obs) {
		
		if(observers.contains(obs))
			return;
		
		observers.add(obs);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leaveGroup(IChattyGroupObserver obs) {
		
		if(observers.contains(obs)){
			observers.remove(obs);
			return;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getGroupID() {
		// TODO Auto-generated method stub
		return group;
	}

	@Override
	public void sendMessage(ChattyMessage msg) {
		for (IChattyGroupObserver o : observers){
			o.deliverMessage(msg);
		}
			
		
			
		// TODO Auto-generated method stub
		
	}

	
	public String toString(){
		return getGroupID();
		
	}
	



	public String getGroup() {
		return group;
	}




	public void setGroup(String group) {
		this.group = group;
	}





}

