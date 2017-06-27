package edu.learn.rest.RestfulWebservices.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.learn.rest.RestfulWebservices.model.Student;
import edu.learn.rest.RestfulWebservices.Dao.SessionUtil;

public class StudentDao {
	@SuppressWarnings("deprecation")
	public List<Student> getAllStudents() throws Exception {
		Session session = null;
		session = SessionUtil.createSessionFactory().openSession();
		Transaction tx = null;
		List<Student> Student = null;
		try{
			tx = session.beginTransaction();
			Student = session.createCriteria(Student.class).list();
			Student.forEach(students -> System.out.println(students));
			tx.commit();
			session.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}

		return Student;
	}

    public void addStudent(Student bean) throws Exception{
        Session session = SessionUtil.createSessionFactory().openSession();        
        Transaction tx = session.beginTransaction();
        addStudent(session,bean);        
        tx.commit();
        session.close();
        
    }
	private void addStudent(Session session, Student bean){
		Student student = new Student();

		student.setMarks(bean.getMarks());
		student.setSid(bean.getSid());
		student.setSname(bean.getSname());
		session.save(student);
	}

	public int updateStudent(int sid, Student st) throws Exception{
		if(sid <=0)  
            return 0;  
      Session session = SessionUtil.createSessionFactory().openSession();    
         Transaction tx = session.beginTransaction();
         String hql = "update Student set sname = :sname, marks=:marks where sid = :sid";
         Query query = session.createQuery(hql);
         query.setInteger("sid",sid);
         query.setString("sname",st.getSname());
         query.setInteger("marks",st.getMarks());
         int rowCount = query.executeUpdate();
         System.out.println("Rows affected: " + rowCount);
         tx.commit();
         session.close();
         return rowCount;
	}

	public int deleteStudent(int sid) throws Exception {
		Session session = SessionUtil.createSessionFactory().openSession();    
        Transaction tx = session.beginTransaction();
        String hql = "delete from Student where sid = :sid";
        Query query = session.createQuery(hql);
        query.setInteger("sid",sid);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
	}
}
