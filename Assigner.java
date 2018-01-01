import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class Assigner {
	private ArrayList<String> people;
	private HashMap<String, String> assignments;
	private ArrayList<String> unassigned;
	private Random random;
	
	public Assigner() {
	    people = new ArrayList<String>();
	    assignments = new HashMap<String, String>();
	    unassigned = new ArrayList<String>();
	    random = new Random();
	}
	
	public String getMembers() {
		String displayText = "";
		for(String person : people) {
            displayText += ("\n" + person);
        }
		return displayText;
	}
	
	public void addPerson(String name)
    {
        people.add(name);
        unassigned.add(name);
    }
	
	public void assignSecretSantas() {
        for(String person : people) 
        {
            findMatch(person);
            unassigned.remove(assignments.get(person));
        }
    }
	
	public boolean containsAssignment(String name) {
		return (assignments.containsKey(name));
	}
	
	public boolean containsUnassigned(String name) {
		return (unassigned.contains(name));
	}
	
	public String getAssignment(String name) {
		return (assignments.get(name));
	}
	
	public int getUnassignedSize() {
		return unassigned.size();
	}

    private void findMatch(String person) {
    	boolean found = false;
    	while(!found) 
    	{
    		String possibleMatch = unassigned.get(random.nextInt(unassigned.size()));
    		if(!possibleMatch.equals(person)) 
    		{
    				assignments.put(person, possibleMatch);
    				found = true;
    		}
    	}
    }
}

