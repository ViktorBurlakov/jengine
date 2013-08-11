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

import java.util.ArrayList;
import java.util.List;
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
    private List<Author> authors = new ArrayList<Author>();
    private List<Library> libraries = new ArrayList<Library>();
    private List<Book> books = new ArrayList<Book>();
    private List<Member> members = new ArrayList<Member>();
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public void clearData() throws SystemException {
        // remove all db
        Map context = getServiceContext();

        Author.manager.remove(context);
        Library.manager.remove(context);
        Book.manager.remove(context);
        Member.manager.remove(context);
        Transaction.manager.remove(context);

        authors.clear();
        libraries.clear();
        books.clear();
        members.clear();
        transactions.clear();
    }

    public void loadData() throws SystemException, PortalException {
        Map context = getServiceContext();

        // adding new objects
        Author author1 = new Author(context, map("authorId", 1, "firstName", "Jules", "lastName", "Verne"));
        Author author2 = new Author(context, map("authorId", 2, "firstName", "Isaac", "lastName", "Asimov"));
        Author author3 = new Author(context, map("authorId", 3, "firstName", "Stephen", "lastName", "King"));
        authors.add((Author) author1.save());
        authors.add((Author) author2.save());
        authors.add((Author) author3.save());

        Library library = new Library(context, map("libraryId", 1, "name", "Globe", "address", "Springfield, 742 Evergreen Terrace"));
        Library library2 = new Library(context, map("libraryId", 2, "name", "Local", "address", "Local"));
        libraries.add((Library) library.save());
        libraries.add((Library) library2.save());

        Book book1 = new Book(context, map("bookId", 1, "title", "The Dark Tower", "library", library));
        Book book2 = new Book(context, map("bookId", 2, "title", "The Shining ", "library", library));
        Book book3 = new Book(context, map("bookId", 3, "title", "Vingt mille lieues sous les mers", "library", library));
        books.add((Book) book1.save());
        books.add((Book) book2.save());
        books.add((Book) book3.save());

        Member member1 = new Member(context, map("memberId", 1, "firstName", "Mark", "lastName", "Adamson", "library", library));
        Member member2 = new Member(context, map("memberId", 2, "firstName", "Peter", "lastName", "Douglas", "library", library));
        Member member3 = new Member(context, map("memberId", 3, "firstName", "Gary", "lastName", "Miller", "library", library));
        Member member4 = new Member(context, map("memberId", 4, "firstName", "Homer", "lastName", "Simpson", "library", library));
        Member member5 = new Member(context, map("memberId", 5, "firstName", "Burt", "lastName", "Simpson", "library", library));
        members.add((Member) member1.save());
        members.add((Member) member2.save());
        members.add((Member) member3.save());
        members.add((Member) member4.save());
        members.add((Member) member5.save());
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
        Author author1 = new Author(context, map("authorId", 1, "firstName", "Jules", "lastName", "Verne"));
        author1.save();

        check(Author.cls.get(1, context).getLastName().equals("Verne"));

        author1.setValue("firstName", "Jules1");
        author1.save();

        check(Author.cls.get(1, context).getFirstName().equals("Jules1"));
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