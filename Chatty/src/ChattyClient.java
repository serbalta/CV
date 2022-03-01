/*
 * Java Angabe2-Chatty
 * 
 * Salih ERBALTA
 * 1125266
 * 
 */


import java.util.Collection;
import java.util.Vector;



public class ChattyClient implements IGuiClient,IChattyGroupObserver,IChattyServerObserver {
	private IChattyServerSubject server;
	private String name;
	private IGui MyGui;
	private Collection<IChattyGroup> notRegisteredGroup;
	private Collection<IChattyGroup> registeredGroup;

	public ChattyClient(IChattyServerSubject server, String name) {
		this.setName(name);
		this.setServ(server);
		try {
			this.MyGui = new ChattyGui(this, name);
		} catch (Exception e) {

			e.printStackTrace();
		}
		notRegisteredGroup = new Vector<IChattyGroup>();
		registeredGroup = new Vector<IChattyGroup>();
	}



	private void setName(String name) {
		this.name = name;

	}

	@Override
	public void createGroup(String group) {
		try {
			server.createGroup(group);
		} catch (GroupAlreadyExists e) {
			System.out.println("Exeption GroupAlreadyExist abgefangen");
		}

	}

	@Override
	public void deleteGroup(IChattyGroup group) {
		try {

			server.deleteGroup(group);

		} catch (GroupDoesNotExist e) {
			System.out.println("Exception GroupDoesNotExist abgefangen.");
		}
	}

	@Override
	public Collection<IChattyGroup> getNotRegisteredGroups() {
		// TODO Auto-generated method stub
		return this.notRegisteredGroup;
	}

	@Override
	public Collection<IChattyGroup> getRegisteredGroups() {
		// TODO Auto-generated method stub
		return this.registeredGroup;
	}

	@Override
	public void joinGroup(IChattyGroup group) {

		group.joinGroup(this);
		notRegisteredGroup.remove(group);
		registeredGroup.add(group);
		MyGui.updateGUI();

		// TODO Auto-generated method stub

	}

	@Override
	public void leaveGroup(IChattyGroup group) {
		group.leaveGroup(this);

		if (registeredGroup.remove(group) == true)
			notRegisteredGroup.add(group);

		MyGui.updateGUI();

	}

	@Override
	public void sendMessage(ChattyMessage msg) {

		msg.getGroup().sendMessage(msg);

	}

	@Override
	public void unregister() {
		for (IChattyGroup g : registeredGroup) 
			{
		leaveGroup(g);
		server.unregisterClient(this);
		MyGui.updateGUI();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void publishGroup(IChattyGroup group) {

		notRegisteredGroup.add(group);

		this.MyGui.updateGUI();

		// TODO Auto-generated method stub

	}

	@Override
	public void revokeGroup(IChattyGroup group) {

		leaveGroup(group);

		notRegisteredGroup.remove(group);
		MyGui.updateGUI();
	}

	@Override
	public void deliverMessage(ChattyMessage msg) {

		MyGui.deliverMessage(msg);
		MyGui.updateGUI();
	}

	public IChattyServerSubject getServer() {
		return server;
	}

	public void setServ(IChattyServerSubject server) {
		this.server = server;
	}

}