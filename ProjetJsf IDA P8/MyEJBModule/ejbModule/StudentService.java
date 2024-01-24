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

    public List<StudentEntity> getStudentsByName(String name) {
        TypedQuery<StudentEntity> query = entityManager.createQuery("SELECT s FROM StudentEntity s WHERE s.name = :name", StudentEntity.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<StudentEntity> getStudentsByEmail(String email) {
        TypedQuery<StudentEntity> query = entityManager.createQuery("SELECT s FROM StudentEntity s WHERE s.email = :email", StudentEntity.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    public List<StudentEntity> getStudentsWithPagination(int startPosition, int maxResults) {
        TypedQuery<StudentEntity> query = entityManager.createQuery("SELECT s FROM StudentEntity s", StudentEntity.class);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    public long countStudents() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(s) FROM StudentEntity s", Long.class);
        return query.getSingleResult();
    }


}

