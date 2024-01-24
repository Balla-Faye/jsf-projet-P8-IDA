
public class StudentServiceBean {
	import javax.ejb.Stateless;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.TypedQuery;
	import java.util.List;

	@Stateless
	public class StudentServiceBean {
	    @PersistenceContext
	    private EntityManager entityManager;

	    public void addStudent(StudentEntity student) {
	        entityManager.persist(student);
	    }

	    public List<StudentEntity> getAllStudents() {
	        TypedQuery<StudentEntity> query = entityManager.createQuery("SELECT s FROM StudentEntity s", StudentEntity.class);
	        return query.getResultList();
	    }

	    public StudentEntity getStudentById(Long id) {
	        return entityManager.find(StudentEntity.class, id);
	    }

	    public void updateStudent(StudentEntity student) {
	        entityManager.merge(student);
	    }

	    public void deleteStudent(Long id) {
	        StudentEntity student = entityManager.find(StudentEntity.class, id);
	        if (student != null) {
	            entityManager.remove(student);
	        }
	    }
	}

