package comm.example.inter;

public class Dog implements LivingThings {
	private String name;
	private String breed;
	
	
	
	public Dog(String name, String breed) {
		super();
		this.name = name;
		this.breed = breed;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void createLivingThings() {
		System.out.println("aa");
		LivingThings lt= new LivingThings() {
			
			//
			@Override
			public void walk() {
				System.out.println("Dog name: "+getName()+"Dog Breed: "+getBreed()+"can also walk");
			}
		};
		lt.walk();
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("walk outside");
		
	}

}
