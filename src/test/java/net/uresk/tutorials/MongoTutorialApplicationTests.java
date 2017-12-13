package net.uresk.tutorials;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tests4geeks.tutorials.MongoTutorialApplication;
import com.tests4geeks.tutorials.model.User;
import com.tests4geeks.tutorials.repository.UserMongoRepository;
import com.tests4geeks.tutorials.service.UserServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MongoTutorialApplication.class)
//@WebAppConfiguration
public class MongoTutorialApplicationTests {

	User userTest = new User();
	List<User> listUsers = new ArrayList();

	@Mock
	private UserMongoRepository daoMock;

	@InjectMocks
	private UserServiceImpl service;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);

		userTest.setName("nejah");
		userTest.setSalary(1111);
		listUsers.add(userTest);

	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersist() {

		when(daoMock.save(userTest)).thenReturn(userTest);

		assertEquals(service.persist(userTest), userTest);

	}

	@Test
	public void testGetAllUser() {

		when(daoMock.findAll()).thenReturn(listUsers);

		assertEquals(service.getAllUser(), listUsers);

	}

	@Test
	public void testGetUserByName() {

		when(daoMock.findByName(userTest.getName())).thenReturn(userTest);

		assertEquals(service.getUserByName("nejah"), userTest);

	}

	@Test
	public void testDeleteUser() {

		when(daoMock.findById(1)).thenReturn(userTest);
		daoMock.delete(userTest);

		assertTrue(service.deleteUser(1));

	}
}
