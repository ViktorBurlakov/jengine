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

import com.jengine.db.field.FunctionField;
import com.jenginetest.builder.service.base.TestLocalServiceBaseImpl;
import com.jenginetest.custom.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

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

        /* adding new objects */

        // Authors
        Author jule = new Author(context);
        jule.setAuthorId(1l);
        jule.setFirstName("Jules");
        jule.setLastName("Verne");
        jule.save();

        Author asimov = new Author(context);
        asimov.setAuthorId(2l);
        asimov.setFirstName("Isaac");
        asimov.setLastName("Asimov");
        asimov.save();

        Author king = new Author(context);
        king.setAuthorId(3l);
        king.setFirstName("Stephen");
        king.setLastName("King");
        king.save();

        // Libraries
        Library globeLibrary = new Library(context);
        globeLibrary.setLibraryId(1l);
        globeLibrary.setName("Globe");
        globeLibrary.setAddress("Springfield, 742 Evergreen Terrace");
        globeLibrary.save();

        Library localLibrary = new Library(context);
        localLibrary.setLibraryId(2l);
        localLibrary.setName("Local");
        localLibrary.setAddress("Local");
        localLibrary.save();

        // Books
        Book book1 = new Book(context);
        book1.setBookId(1l);
        book1.setTitle("The Dark Tower");
        book1.setLibrary(globeLibrary);
        book1.save();

        Book book2 = new Book(context);
        book2.setBookId(2l);
        book2.setTitle("The Shining ");
        book2.setLibrary(globeLibrary);
        book2.save();

        Book book3 = new Book(context);
        book3.setBookId(3l);
        book3.setTitle("Vingt mille lieues sous les mers");
        book3.setLibrary(globeLibrary);
        book3.save();

        // Members
        Member member1 = new Member(context);
        member1.setMemberId(1l);
        member1.setFirstName("Mark");
        member1.setLastName("Adamson");
        member1.setLibrary(globeLibrary);
        member1.save();

        Member member2 = new Member(context);
        member2.setMemberId(2l);
        member2.setFirstName("Peter");
        member2.setLastName("Douglas");
        member2.setLibrary(globeLibrary);
        member2.save();

        Member member3 = new Member(context);
        member3.setMemberId(3l);
        member3.setFirstName("Gary");
        member3.setLastName("Miller");
        member3.setLibrary(globeLibrary);
        member3.save();

        Member member4 = new Member(context);
        member4.setMemberId(4l);
        member4.setFirstName("Homer");
        member4.setLastName("Simpson");
        member4.setLibrary(globeLibrary);
        member4.save();

        Member member5 = new Member(context);
        member5.setMemberId(5l);
        member5.setFirstName("Burt");
        member5.setLastName("Simpson");
        member5.setLibrary(globeLibrary);
        member5.save();
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
        check(Member.cls.filterMap("lastName", "Simpson").list(context).size() == 2);
        check(Author.cls.filter(map("firstName", "Stephen")).<Author>one(context).getLastName().equals("King"));
        check(Book.cls.filter(map("library", Library.cls.get(1, context))).<Book>list(context).size() == 3);
        check(Book.cls.filter(map("library.name__like", "%Globe")).<Book>list(context).size() == 3);
        check(Book.cls.filter(map("library.libraryId", 101)).<Book>list(context).size() == 0);
    }

    /**
     * Sub query test
     */
    public void test4() throws SystemException, PortalException {
        System.out.println("** Test4: Sub Query test");
        Map context = getServiceContext();

        clearData();
        loadData();

        check(Book.cls.filterMap("library", Library.cls.select("libraryId").filterMap("name__like", "%Globe"))
                .<Book>list(context).size() == 3);
    }


    /**
     * Inserting and Updating test
     */
    public void test5() throws SystemException, PortalException {
        System.out.println("** Test 5: Inserting and Updating test");
        Map context = getServiceContext();

        clearData();
        Author author1 = new Author(context);
        author1.setAuthorId(1l);
        author1.setFirstName("Jules");
        author1.setLastName("Verne");
        author1.save();

        check(Author.cls.get(1, context).getLastName().equals("Verne"));

        author1.setValue("firstName", "Jules1");
        author1.save();

        check(Author.cls.get(1, context).getFirstName().equals("Jules1"));
    }

   /**
     * Aggregation testing
     */
    public void test6() throws SystemException, PortalException {
        System.out.println("** Test 6:  Aggregation testing");
        Map context = getServiceContext();

        clearData();
        loadData();

        check(Author.cls.<Long>max(Author.authorId, context) == 3l);
        check(Author.cls.<Long>sum(Author.authorId, context) == 6l);
        check(Author.cls.<Long>min(Author.authorId, context) == 1l);
        check(Book.cls.count(context) == 3l);
        check(Book.cls.select(new FunctionField("function1", Long.class, "%s + 1", Book.bookId))
                .filter(map("bookId", 1l))
                .<Long>one(context) == 2l);
        check(Book.cls.<Long>calc(context, "sum", Long.class, "max(%s) + 2", Book.bookId) == 5l);
    }

   /**
     * Model relation testing
     */
    public void test7() throws SystemException, PortalException {
        System.out.println("** Test 7: Model relation testing");
        Map context = getServiceContext();

        clearData();
        loadData();

        check(Book.cls.get(1, context).getLibrary().equals(Library.cls.get(1, context)));

        Library globe = Library.cls.filterMap("name", "Globe").one(context);
        check(globe.getMemberList().size() == 5);
        check(globe.getMembers().list().size() == 5);
        check(globe.getMembers().count() == 5);
        check(globe.getMembers().filterMap("lastName", "Simpson").count() == 2);
    }

    private void check(boolean value) throws PortalException {
        if (value) {
            return;
        } else {
            throw new PortalException("Checking failed!!!");
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