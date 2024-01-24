
public class StudentEntity {
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import java.io.Serializable;
	import java.util.Objects;

	@Entity
	@Table(name = "etudiants")
	public class StudentEntity implements Serializable {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String email;

	    // Constructeurs
	    public StudentEntity() {
	    }

	    public StudentEntity(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }


	    // Méthodes equals et hashCode pour la comparaison et l'utilisation dans des structures de données Java
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        StudentEntity that = (StudentEntity) o;
	        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, name, email);
	    }

	    // Autres méthodes utilitaires ou logiques métier
	    public String getDisplayName() {
	        return "etudiant: " + name + " (" + email + ")";
	    }

	 

}
