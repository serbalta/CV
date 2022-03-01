/*
 * Java Angabe2-Chatty
 * 
 * Salih ERBALTA
 * 1125266
 * 
 */

public class Pva implements IChattyServerObserver,IChattyGroupObserver{

	
	private ChattyServer server;
	
	public Pva(ChattyServer server){
		this.setServer(server);
		
	}
	
	
		
	@Override
	public void deliverMessage(ChattyMessage msg) {
			
		System.out.println("PVA liest mit:  " + msg.toString());
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishGroup(IChattyGroup group) {
		group.joinGroup(this);
		
	}

	@Override
	public void revokeGroup(IChattyGroup group) {
	
		group.leaveGroup(this);
		
		// TODO Auto-generated method stub
		
	}



	public ChattyServer getServer() {
		return server;
	}



	public void setServer(ChattyServer server) {
		this.server = server;
	}

}
