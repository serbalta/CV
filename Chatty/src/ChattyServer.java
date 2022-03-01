/*
 * Java Angabe2-Chatty
 * 
 * Salih ERBALTA
 * 1125266
 * 
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Vector;
import javax.swing.JOptionPane;



public class ChattyServer implements IChattyServerSubject {

	private Collection <IChattyServerObserver> chattyServerObserver;
	private Collection <IChattyGroup> availableGroups;
	
	
public ChattyServer (){

		chattyServerObserver = new Vector<IChattyServerObserver>();
		availableGroups = new Vector<IChattyGroup>();
	}
	
	



	
	@Override
	public boolean createGroup(String groupid) throws GroupAlreadyExists {
		for(IChattyGroup gr : availableGroups){
			if(gr.getGroupID().equals(groupid)){
				JOptionPane.showMessageDialog(null, "Gruppe Already Exsist");
				throw new GroupAlreadyExists (groupid);
			}
		}
		
			ChattyGroup a = new ChattyGroup(groupid);
			availableGroups.add(a);
		for(IChattyServerObserver e : chattyServerObserver){
			e.publishGroup(a);
		}
		
				return true;	
	
}
		
	

		

	@Override
	public void deleteGroup(IChattyGroup group) throws GroupDoesNotExist {
		
		for(IChattyGroup gr : availableGroups){			
			if(gr.equals(group) ){
				Object[] options = {"Ja",
                "Nein"};
				int n = JOptionPane.showOptionDialog(null,
						" Wollen Sie sich wirklich vor der " + group + " abmelden? ",
						"Abmeldung",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,    
						options, 
						options[0]); 
			    
				if(n==JOptionPane.YES_NO_OPTION){
			
			for(IChattyServerObserver e : chattyServerObserver)
			{
				e.revokeGroup(group);
			}
			
		
				availableGroups.remove(gr);
			
			for(IChattyServerObserver e : chattyServerObserver){
				e.revokeGroup(gr);
			}
			return;
			}	
		
			
			if(!gr.equals(group)){
				JOptionPane.showMessageDialog(null,"Gruppe existiert nicht " + group );
				System.out.println("Gruppe existiert nicht" + group);
			throw new GroupDoesNotExist(group);}
			
		
	
	}}}

	@Override
	public void registerClient(IChattyServerObserver obs) {
		chattyServerObserver.add(obs);
	
		for(IChattyGroup gr : availableGroups)
		{
			obs.publishGroup(gr);
		}
	}

	@Override
	public void unregisterClient(IChattyServerObserver obs) {
		chattyServerObserver.remove(obs);
	
	}

private static String readLine()
{
	BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
	String helpString;
	try
	{
		helpString = keyb.readLine();
	    return helpString;
	} catch (Exception e)
	{
		
		System.out.println("Input Error");
	    return null;
	}
}
public static void  main(String[] arg) {
	
	ChattyServer server = new ChattyServer();
	Pva pva = new Pva(server);
	ChattyClient a = new ChattyClient(server, "Salih");
	server.registerClient(a);
	ChattyClient b = new ChattyClient(server, "second person");
	server.registerClient(b);
	
	
	
	
	int selection;
	boolean isRunning = true;
	while (isRunning)
	{
		System.out.println("1.  Client anlegen");
		System.out.println("2.  Beenden");
		String eingabe = readLine();
		try
		{
			selection = Integer.parseInt(eingabe);
		}
		catch(Exception e)
		{
			System.out.println("Keine Zahl eingegeben.");
			selection = 0;
		}
		
	switch (selection)
	{
      case 1:
    	    System.out.println("Name: ");
    	    String clientname = readLine();
    	  	ChattyClient newclient = new ChattyClient(server, clientname);
    	  	server.registerClient(newclient); 
    	  	break;
      case 2:
    	    System.out.println("Server wird geschlossen");
    	    System.out.println("Alle Clients zum Disconnecten auffordern");				
    	    for(IChattyGroup g : server.availableGroups)
    	    {
    	    	System.out.println("Gruppe: " + g);
				for(IChattyServerObserver i : server.chattyServerObserver) 
				{
					System.out.println("Fordere Client zum Verlassen auf: " + i.toString());
					i.revokeGroup(g); 
				}
    	    }
    	    server.availableGroups.clear();
    	    server.chattyServerObserver.clear();
    	    isRunning = false; // End
    	    System.exit(0);
    	    break;
      default:
    	   System.out.println("Option existiert nicht.");
	}
	}
}
}
