package com.skilldistillery.datenight.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlogCommentTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private BlogComment blogComment;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPADateNightApp");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		blogComment = em.find(BlogComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		blogComment = null;
	}
	@Test
	void test_BlogComment_entity_mappings() {
		assertNotNull(blogComment.getId());
		assertEquals("try Massage Oasis near hwy 29. One of my favorite places. ", blogComment.getMessage());
	}
	
	@Test
	void test_BlogComment_User_MTO_mapping() {
		assertNotNull(blogComment.getUser());
		assertEquals("Liam", blogComment.getUser().getFirstName());
	}
	
	@Test
	void test_BlogComment_Blog_MTO_mapping() {
		assertNotNull(blogComment.getBlog());
		assertEquals("Good massage place", blogComment.getBlog().getTitle());
	}

	@Test
	void test_BlogComment_BlogCommentList_OTM_mapping() {
		assertNotNull(blogComment.getBlogComments());
		assertTrue(blogComment.getBlogComments().size() > 0);
		
	}
}





























