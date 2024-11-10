package com.project.dao;

import java.util.List;

import com.project.entity.Notes;
import com.project.entity.User;

public interface UserDAO 
{
	public int saveUser(User user);
	
	public User login(String email,String password);
	
	public int saveNotes(Notes noetes);
	
	public List<Notes> getNotesByUser(User user);

	public Notes getNotesById(int id);
	
	public void deleteNotes(int id);
	
	public void updateNotes(Notes n);
}
