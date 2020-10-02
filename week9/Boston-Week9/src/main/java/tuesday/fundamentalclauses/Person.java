package tuesday.fundamentalclauses;

public class Person {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) { 
            return true; 
        } 

        if (!(obj instanceof Person)) { 
            return false; 
        } 
          
        Person p = (Person) obj; 
          
        // Compare the data members and return accordingly  
        return name.equals(p.name);
    } 

	  @Override
	    public int hashCode() 
	    { 
	        return this.hashCode(); 
	    } 
	
}
