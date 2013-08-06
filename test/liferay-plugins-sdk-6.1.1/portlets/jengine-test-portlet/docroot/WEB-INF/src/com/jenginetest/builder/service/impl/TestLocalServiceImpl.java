/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.service.impl;

import com.jenginetest.builder.service.base.TestLocalServiceBaseImpl;
import com.jenginetest.custom.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.concat;
import static com.jengine.utils.CollectionUtil.map;

/**
 * The implementation of the test local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jenginetest.builder.service.TestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jenginetest.builder.service.base.TestLocalServiceBaseImpl
 * @see com.jenginetest.builder.service.TestLocalServiceUtil
 */
public class TestLocalServiceImpl extends TestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.jenginetest.builder.service.TestLocalServiceUtil} to access the test local service.
	 */
    public void clearData() throws SystemException {
        // remove all db
        Map context = getServiceContext();

        Author.manager.remove(context);
        Library.manager.remove(context);
        Book.manager.remove(context);
        Member.manager.remove(context);
        Transaction.manager.remove(context);
    }

    public void loadData() throws SystemException, PortalException {
        Map context = getServiceContext();

        // adding new objects
        Author author1 = new Author(1, context);
        Author author2 = new Author(2, context);
        Author author3 = new Author(3, context);
        author1.setValues(map("firstName", "Jules", "lastName", "Verne"));
        author2.setValues(map("firstName", "Isaac", "lastName", "Asimov"));
        author3.setValues(map("firstName", "Stephen", "lastName", "King"));
        author1.save();
        author2.save();
        author3.save();

        Library library = new Library(1, context);
        library.setValues(map("name", "Globe", "address", "Springfield, 742 Evergreen Terrace"));
        library.save();

        Book book1 = new Book(1, context);
        Book book2 = new Book(2, context);
        Book book3 = new Book(3, context);
        book1.setValues(map("title", "The Dark Tower", "library", library));
        book2.setValues(map("title", "The Shining ", "library", library));
        book3.setValues(map("title", "The Dark Tower", "library", library));
        book1.save();
        book2.save();
        book3.save();

        Member member1 = new Member(1, context);
        Member member2 = new Member(2, context);
        Member member3 = new Member(3, context);
        Member member4 = new Member(4, context);
        member1.setValues(map("firstName", "Mark", "lastName", "Adamson", "library", library));
        member2.setValues(map("firstName", "Peter", "lastName", "Douglas", "library", library));
        member3.setValues(map("firstName", "Gary", "lastName", "Miller", "library", library));
        member4.setValues(map("firstName", "Homer", "lastName", "Simpson", "library", library));
        member1.save();
        member2.save();
        member3.save();
        member4.save();
    }

    /**
     * Clearing data test
     */
    public void test1() throws SystemException, PortalException {
        System.out.println("** Test1: Clearing data test");

        Map context = getServiceContext();

        clearData();
        // checking
        check(Author.cls.count(context) == 0);
        check(Library.cls.count(context) == 0);
        check(Book.cls.count(context) == 0);
        check(Member.cls.count(context) == 0);
        check(Transaction.cls.count(context) == 0);
    }

    /**
     *  Object creation test
     */
    public void test2() throws SystemException, PortalException {
        System.out.println("** Test2: Object creation test");
        Map context = getServiceContext();

        clearData();
        loadData();

        check(Author.cls.count(context) == 3);
    }

    /**
     * Selection test
     */
    public void test3() throws SystemException, PortalException {
        System.out.println("** Test3: Object selection test");
        Map context = getServiceContext();

        clearData();
        loadData();

        // get testing
        Author.cls.get(1, context).getLastName().equals("Verne");
        Book.cls.get(1, context).getTitle().equals("The Dark Tower");

        // filter
        check(CProject.cls.select(map("status", 1)).list(context).size() == 2);
        check(CProject.cls.select(map("status", 2)).<CProject>one(context).getTitle().equals("Project 2"));
        check(CTask.cls.select(map("project", CProject.cls.get(1, context))).<CTask>list(context).size() == 2);
        check(CTask.cls.select(map("project.title__like", "Pro%2")).<CTask>list(context).size() == 1);
        check(CTask.cls.select(map("project.projectId", 3)).<CTask>list(context).size() == 0);
    }

    /**
     * Sub query test
     */
    public void test4() throws SystemException, PortalException {
        System.out.println("** Test4: Sub Query test");
        Map context = getServiceContext();

        clearData();
        loadData();

        check(CTask.cls.select(map("project", CProject.cls.select().field("projectId")
                .filter(map("title__like", "%1")))).<CTask>list(context).size() == 2);
    }


    private void check(boolean value) throws PortalException {
        if (value) {
            return;
        } else {
            throw new PortalException("Value is false!!!");
        }
    }

    private Map getServiceContext() {
        return map(
                "SAuthor", map("persistence", sAuthorPersistence, "service", sAuthorLocalService, "finder", null),
                "SLibrary", map("persistence", sLibraryPersistence, "service", sLibraryLocalService, "finder", null),
                "SBook", map("persistence", sBookPersistence, "service", sBookLocalService, "finder", null),
                "SMember", map("persistence", sMemberPersistence, "service", sMemberLocalService, "finder", null),
                "STransaction", map("persistence", sTransactionPersistence, "service", sTransactionLocalService, "finder", null)
        );
    }
}