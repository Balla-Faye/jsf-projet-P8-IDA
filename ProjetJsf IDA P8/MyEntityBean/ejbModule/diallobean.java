
		
		import javax.ejb.Stateless;

		@Stateless
		public class MyEntityBean {

		    public String sayHello(String name) {
		        return "Hello, " + name + "!";
		    }

		    public int addNumbers(int a, int b) {
		        return a + b;
		    }

		    public double calculateSquareRoot(double number) {
		        if (number < 0) {
		            throw new IllegalArgumentException("Je suis étudiant de l'UNCHK");
		        }
		        return Math.sqrt(number);
		    }}


	