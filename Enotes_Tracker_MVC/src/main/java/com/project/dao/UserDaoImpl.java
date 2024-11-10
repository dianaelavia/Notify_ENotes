package com.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.project.entity.Notes;
import com.project.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDAO 
{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int saveUser(User user) {
		int i = (Integer)hibernateTemplate.save(user);
		return i;
	}

	public User login(String email, String password) {
		
		String sql = "from User where email= :em and password = :pwd";
		
		User user  = (User) hibernateTemplate.execute(s-> {
		Query q =s.createQuery(sql);
		q.setString("em", email);
		q.setString("pwd", password);
		return q.uniqueResult();
		});
		
		return user;
	}

	@Override
	public int saveNotes(Notes notes) {
		hibernateTemplate.save(notes);
		return 0;
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
		String sql = "from Notes where user= :us";
		List<Notes> list = hibernateTemplate.execute(s->{
			Query q = s.createQuery(sql);
			q.setEntity("us",user);
			return q.getResultList();
		});
		return list;
	}

	@Override
	public Notes getNotesById(int id) {
		Notes n = hibernateTemplate.get(Notes.class, id);
		return n;
	}

	@Override
	public void deleteNotes(int id) {
		Notes n = hibernateTemplate.get(Notes.class, id);
		hibernateTemplate.delete(n);
		
	}

	@Override
	public void updateNotes(Notes n) {
		hibernateTemplate.update(n);
		
	}

}
