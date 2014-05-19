/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jenginetest;

import com.jengine.orm.DB;
import com.jengine.orm.DBFactory;
import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBSavePoint;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.adapter.ConnectionManager;
import com.jengine.orm.db.adapter.liferay.LiferayAdapter;
import com.jengine.orm.db.adapter.liferay.LiferayConnectionManager;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.db.provider.mysql.MySQLProvider;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.model.cluster.Cluster;
import com.jengine.orm.model.multi.field.Calc;
import com.jengine.orm.model.multi.field.aggregation.Max;
import com.jengine.orm.model.query.ModelQuery;
import com.jengine.utils.CollectionUtil;
import com.jenginetest.model.*;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jengine.utils.ClassUtils.forceInit;
import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;

public class Test {

    static {
        try {
            ConnectionManager connectionManager = new LiferayConnectionManager();
            Adapter adapter = new LiferayAdapter(connectionManager);
            Provider provider = new MySQLProvider(adapter);
            DB db = DBFactory.register(new DB(provider));
        } catch (DBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void run() throws Exception {
        // testing
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
//            test8();
//            test9();
        test10();
        test11();
        test12();
    }

    /**
     * All data Removing
     * @throws com.jengine.orm.db.DBException
     */
    public static void clearData() throws DBException {
        Author.cls.remove();
        Library.cls.remove();
        Book.cls.remove();
        forceInit(Account.class);
        Member.cls.remove();
        Transaction.cls.remove();
        Address.cls.remove();
        Author.books.remove();

    }

    /**
     * New objects Adding
     * @throws com.jengine.orm.db.DBException
     */
    public static void loadData() throws Exception {
        /* Authors */
        Author jule = new Author();
        jule.setId(1l);
        jule.setFirstName("Jules");
        jule.setLastName("Verne");
        jule.save();

        Author asimov = new Author();
        asimov.setId(2l);
        asimov.setFirstName("Isaac");
        asimov.setLastName("Asimov");
        asimov.save();

        Author king = new Author();
        king.setId(3l);
        king.setFirstName("Stephen");
        king.setLastName("King");
        king.save();

        /* Libraries */
        Library globeLibrary = new Library();
        globeLibrary.setId(1l);
        globeLibrary.setName("Globe");
        globeLibrary.setAddress("Springfield, 742 Evergreen Terrace");
        globeLibrary.save();

        Library localLibrary = new Library();
        localLibrary.setId(2l);
        localLibrary.setName("Local");
        localLibrary.setAddress("Local");
        localLibrary.save();

        /* Books */
        Book book1 = new Book();
        book1.setId(1l);
        book1.setTitle("The Dark Tower");
        book1.setLibrary(globeLibrary);
        book1.save();

        king.setBooks(list(book1));
        king.save();

        Book book2 = new Book();
        book2.setId(2l);
        book2.setTitle("The Shining");
        book2.setLibrary(globeLibrary);
        book2.save();

        Book book3 = new Book();
        book3.setId(3l);
        book3.setTitle("Vingt mille lieues sous les mers");
        book3.setLibrary(globeLibrary);
        book3.save();

        /* Members */
        Member member1 = new Member();
        member1.setId(1l);
        member1.setFirstName("Mark");
        member1.setLastName("Adamson");
        member1.setLibrary(globeLibrary);
        member1.setAccount(Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one());
        member1.save();

        Member member2 = new Member();
        member2.setId(2l);
        member2.setFirstName("Peter");
        member2.setLastName("Douglas");
        member2.setLibrary(globeLibrary);
        member2.setAccount(Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one());
        member2.save();

        Member member3 = new Member();
        member3.setId(3l);
        member3.setFirstName("Gary");
        member3.setLastName("Miller");
        // required is set to 'false' only for testing
        // member3.setLibrary(globeLibrary);
        member3.setAccount(Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one());
        member3.save();

        Member member4 = new Member();
        member4.setId(4l);
        member4.setFirstName("Homer");
        member4.setLastName("Simpson");
        member4.setLibrary(globeLibrary);
        member4.setAccount(Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one());
        member4.save();

        Member member5 = new Member();
        member5.setId(5l);
        member5.setFirstName("Burt");
        member5.setLastName("Simpson");
        member5.setLibrary(globeLibrary);
        member5.setAccount(Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one());
        member5.save();

        Address address1 = new Address();
        address1.setId(1l);
        address1.setStreet("Evergreen Terrace");
        address1.setNumber("742");
        address1.setMember(member5);
        address1.save();

        Transaction transaction1 = new Transaction();
        transaction1.setId(1l);
        transaction1.setBook(book1);
        transaction1.setMember(member1);
        transaction1.save();
        Transaction transaction2 = new Transaction();
        transaction2.setId(2l);
        transaction2.setBook(book2);
        transaction2.setMember(member2);
        transaction2.save();
        Transaction transaction3 = new Transaction();
        transaction3.setId(3l);
        transaction3.setBook(book2);
        transaction3.setMember(member1);
        transaction3.save();
    }

    /**
     * Clearing data test
     */
    public static void test1() throws Exception {
        System.out.println("** Test1: Clearing data test");

        clearData();
        // checking
        check( Author.cls.count() == 0 );
        check( Library.cls.count() == 0 );
        check( Book.cls.count() == 0 );
        check( Member.cls.count() == 0 );
        check( Transaction.cls.count() == 0 );
    }

    /**
     *  Object creation test
     */
    public static void test2() throws Exception {
        System.out.println("** Test2: Object creation test");

        clearData();
        loadData();

        Date tdate = Transaction.cls.get(1).getDate();
//        check( Transaction.cls.get(1).getCounter() == (Transaction.cls.get(1).getBook().<Long>getId() + 1) );
        long t1 = System.currentTimeMillis();
        check( Transaction.cls.get(1).getCounter() == (Transaction.cls.get(1).<Long>getId() + 1) );
        Date modificationDate = Transaction.cls.get(1).getModificationDate();
        Thread.sleep(2000);
        Transaction.cls.clearCache();
        Transaction.cls.get(1).save();

        System.out.println("delta = " + (System.currentTimeMillis() -t1));
        check(Transaction.cls.get(1).getDate().getTime() == tdate.getTime());
        check(Transaction.cls.get(1).getModificationDate().getTime() != modificationDate.getTime());
        check(Author.cls.count() == 3);
        check(Member.cls.get(3).getLibrary() == null);
        check(Member.cls.select(Member.library).filter("id = ?", 3).one() == null);

        try {
            Transaction transaction4 = new Transaction();
            transaction4.setId(4l);
            transaction4.setBook(Book.cls.get(2));
            transaction4.save();
            check(false);
        } catch (ValidateException e) {
            System.out.println("Test was ok : " + e.getMessage());
        }
    }

    /**
     * Selection test
     */
    public static void test3() throws Exception {
        System.out.println("** Test3: Object selection test");

        clearData();
        loadData();

        // get testing
        Author.cls.get(1).getLastName().equals("Verne");
        Book.cls.get(1).getTitle().equals("The Dark Tower");

        // filter
        check( Member.cls.filter("lastName = ?", "Simpson").list().size() == 2 );
        check( Author.cls.filter(Author.firstName.eq("Stephen")).<Author>one().getLastName().equals("King") );
        check( Book.cls.filter(Book.library.eq(Library.cls.get(1))).list().size() == 3 );
        check( Book.cls.filter(map("library.name__like", "%Globe")).list().size() == 3 );
        check( Book.cls.filter(map("library.id", 101)).<Book>list().size() == 0 );

        //with fields
        check( Transaction.cls.select("member.library").<Library>list().get(0).getId() != null );
        check( Transaction.cls.select("member.library.id").<Long>list().get(0) != null );
        // distinct test
        check( Transaction.cls.select("member.library").distinct().<Library>list().size() == 1 );

        //order testing
        check( CollectionUtil.equals(Author.cls.select("id").order("lastName").list(), list(2l, 3l, 1l)) );
        List members = Member.cls.select(new Calc("f", Long.class, "%s + 1", "id")).order("library.name").order("f").list();
        check( CollectionUtil.equals(members, list(2l, 3l, 4l, 5l, 6l)) );
        check( Transaction.cls.select("member").distinct().page(0, 1).<Member>list().size() == 1 );

        check( Transaction.cls.select().<Transaction>list().size() == 3 );
    }

    /**
     * Sub query test
     */
    public static void test4() throws Exception {
        System.out.println("** Test4: Sub SQLQuery test");

        clearData();
        loadData();

        check( Book.cls.filter("library = ?", Library.cls.select("id").filter("name like ?", "%Globe")).list().size() == 3 );
    }


    /**
     * Inserting and Updating test
     */
    public static void test5() throws Exception {
        System.out.println("** Test 5: Inserting and Updating test");

        clearData();
        Author author1 = new Author();
        author1.setId(1l);
        author1.setFirstName("Jules");
        author1.setLastName("Verne");
        author1.save();

        check( Author.cls.get(1).getLastName().equals("Verne") );

        author1.setValue("firstName", "Jules1");
        author1.save();

        check( Author.cls.get(1).getFirstName().equals("Jules1") );
    }

    /**
     * Aggregation testing
     */
    public static void test6() throws Exception {
        System.out.println("** Test 6:  Aggregation testing");

        clearData();
        loadData();

        check( Author.cls.<Long>max(Author.id) == 3l );
        check( Author.cls.<Long>sum(Author.id) == 6l );
        check( Author.cls.<Long>min(Author.id) == 1l );
        check( Book.cls.count() == 3l );
        check( Book.cls.select(new Calc("counter", Long.class, "id + 1", "id")).filter("id = ?", 1l).<Long>one() == 2l );
        Book.cls.select("id", new Max("id")).filter("id = ?", 1l).group("id").one();
        check( Book.cls.<Long>calc("sum", Long.class, "max(%s) + 2", Book.id) == 5l );
        Transaction.cls.select("id", new Max("book.id")).filter("book.id = ?", 1l).group("id").one();
    }

    /**
     * Model multi testing
     */
    public static void test7() throws Exception {
        System.out.println("** Test 7: Model relation testing");

        clearData();
        loadData();

        check( Book.cls.get(1).getLibrary().equals(Library.cls.get(1)) );

        Library globe = Library.cls.filter("name = ?", "Globe").one();
        check( globe.getMemberList().size() == 4 );
        check( globe.getMembers().list().size() == 4 );
        check( globe.getMembers().count() == 4 );
        check( globe.getMembers().filter("lastName = ?", "Simpson").count() == 2 );
        check( Author.cls.get(3).getBooks().list().size() == 1);
        check( Member.cls.filter("firstName = ?", "Burt").<Member>one().getAddress().getNumber().equals("742"));
        check( Address.cls.filter("member.firstName = ?", "Burt").<Address>one().getNumber().equals("742"));
    }


    /**
     * ThreadLocal Connection testing
     */
    public static void test8() throws Exception {
        System.out.println("** Test 8: ThreadLocal Connection testing");

        clearData();
        loadData();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i=0; i < 10; i++) {
            threads.add(new Thread() {
                public void run() {
                    try {
                        DBConnection connection = DBFactory.get().getConnection();
                        try {
                            check(Book.cls.get(1).getLibrary().equals(Library.cls.get(1)));
                            Library globe = Library.cls.filter("name = ?", "Globe").one();
                            check( globe.getMemberList().size() == 4 );
                            check( globe.getMembers().list().size() == 4 );
                            check( globe.getMembers().count() == 4 );
                            check( globe.getMembers().filter("lastName = ?", "Simpson").count() == 2 );
                            check( Author.cls.get(3).getBooks().list().size() == 1);
                            check( Member.cls.filter("firstName = ?", "Burt").<Member>one().getAddress().getNumber().equals("742"));
                            check( Address.cls.filter("member.firstName = ?", "Burt").<Address>one().getNumber().equals("742"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            DBFactory.get().closeConnection(connection);
                        }
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    /**
     * Transaction testing
     */
    public static void test9() throws Exception {
        System.out.println("** Test 9: Transaction testing");

        DBConnection connection = DBFactory.get().getConnection();
        clearData();
        try {
            connection.startTransaction();
            loadData();
            throw new Exception("test!!!");
        } catch (Exception e) {
            connection.rollback();
            // checking
            check( Author.cls.count() == 0 );
            check( Library.cls.count() == 0 );
            check( Book.cls.count() == 0 );
            check( Member.cls.count() == 0 );
            check( Transaction.cls.count() == 0 );
        } finally {
            connection.finishTransaction();
        }

        clearData();
        connection.startTransaction();
        loadData();
        connection.commit();
        check( Author.cls.count() > 0 );
        check( Library.cls.count() > 0 );
        check( Book.cls.count() > 0 );
        check( Member.cls.count() > 0 );
        check( Transaction.cls.count() > 0 );
        connection.finishTransaction();


        clearData();
        connection.startTransaction();
        loadData();
            // save point
            DBSavePoint point = connection.savePoint();
            Author.cls.get(1).setLastName("test1");
            connection.rollback(point);
            connection.releasePoint(point);
        connection.commit();
        check( Author.cls.count() > 0 );
        check( Library.cls.count() > 0 );
        check( Book.cls.count() > 0 );
        check( Member.cls.count() > 0 );
        check( Transaction.cls.count() > 0 );
        connection.finishTransaction();
    }

    /**
     * Cache testing
     */
    public static void test10() throws Exception {
        System.out.println("** Test 10: Cache testing");

        clearData();
        loadData();

        check( Transaction.cls.get(1) != null );
        if (Author.cls.getProvider().isCacheEnabled()) {
            check( Author.cls.getProvider().getCache(Author.cls.getManager().getTableName(), 1l) != null );
        }
    }

    /**
     * Cluster testing
     */
    public static void test11() throws Exception {
        System.out.println("** Test 11: Cluster testing");

        clearData();
        loadData();

        check( new Cluster(Transaction.cls).ljoin(Book.cls).field("Transaction.id").select().one() != null );
        check( new Cluster("Transaction << Book", list("Transaction.id")).select().one() != null );
        check( new Cluster("Transaction << Book", list("Transaction.id", "Book.id", "Book.title")).select("Book.title").one() != null );
        Cluster cluster = new Cluster("Transaction << Book", list("Transaction.id", "Book.id", "Book.title")).filterCluster(" Book.title = ? ", "The Shining");
        check( cluster.select("Book.title").one() != null );
        check( new Cluster("Transaction << Book").fields("Transaction.id").select().<Long>one() == 1l );
        check( new Cluster("Transaction >> Book").fields("Transaction.id").select().list().size() == 4 );
        check( new Cluster("Transaction >> Book").fields("Transaction.id").select().list().get(3) == null );
        check( new Cluster("Transaction >> Book").fields("Transaction.id").select().<Long>one() == 1l );
        check( new Cluster("Transaction && Book").fields("Transaction.id").select().list().equals(list(1l, 2l, 3l)) );
        check( new Cluster("(Transaction && Book) << Book").fields("Transaction.id").select().list().equals(list(1l, 2l, 3l)) );
        check( new Cluster("(Transaction << Book << Library) >> Author_books << Author").fields("Author_books.id").select().one() != null );
        check( new Cluster("(Transaction << Book) >> Author_books, Author").fields("Author_books.id").select().one() != null );
        check( new Cluster("(Transaction << Book) >> Author_books, Author").alias("Author_books", "books").fields("books.id").select().one() != null );
        check( new Cluster("(Transaction << Book) >> Author_books, Author").alias(0, "t").fields("t.id").select().list().equals(list(1l, 1l, 1l)) );
        check( new Cluster("(Transaction << Book) >> Author_books, Author").restriction(0, "Transaction.book", "Book.id").fields("Transaction.id").select().list().equals(list(1l, 1l, 1l)) );
        Cluster cluster1 = new Cluster("Transaction << Book", list("Book.title"));
        check( cluster1.select().distinct("Book.title").order("Book.title").list().equals(list("The Dark Tower", "The Shining")) );
        check( cluster1.select().distinct("Book.title").order("Book.title", "DESC").page(0, 2).list().equals(list("The Shining", "The Dark Tower")));
        check( cluster1.select().distinct("Book.title").order("Book.title", "DESC").page(0, 1).list().equals(list("The Shining")));
        check( cluster1.<Long>max("Book.id") == 2l);
        check( cluster1.<Long>min("Transaction.id") == 1l);
        check( cluster1.<Double>avg("Transaction.id") == 2.0);
        check( cluster1.<Long>sum("Transaction.id") == 6);
        check( cluster1.count() == 3);
        check( cluster1.count("Book.id") == 3);
//        check( cluster1.<Long>calc("%s + 10", "Transaction.id") > 0);
//        check( new Cluster("Transaction >> Book").fields("Transaction.id", new Calc("calc_field", Long.class, "%s + 10", "Transaction.id")).select().list() != null );
        check( new Cluster("Transaction >> Book").fields("Transaction.id", new Calc("calc_field", Long.class, "%s + 10", "Transaction.id")).select().list()
                .equals(list(list(1l, 11l), list(2l, 12l), list(3l, 13l), list(null, null))) );
        check( new Cluster("Transaction >> Book").fields("Transaction.id",  "Book.id", "Book.title", new Max("Transaction.id")).select().group("Book.title").list()
                .equals(list(list(1l, 1l, "The Dark Tower", 1l), list(2l, 2l, "The Shining", 3l), list(null, 3l, "Vingt mille lieues sous les mers", null))) );
        check( new Cluster("Transaction >> Book").fields("Transaction.id",  "Book.id", "Book.title", new Max("Transaction.id")).groupCluster("Book.title").select().list()
                .equals(list(list(1l, 1l, "The Dark Tower", 1l), list(2l, 2l, "The Shining", 3l), list(null, 3l, "Vingt mille lieues sous les mers", null))) );
        check( new Cluster("Transaction << Book").select().filter("Book.id > 1").list().size() == 2);
    }

    /**
     * Liferay binding testing
     */
    public static void test12() throws Exception {
        System.out.println("** Test 12: Liferay binding testing");

        clearData();
        loadData();

        check( Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one().getScreenName().equals("test") );
        check( Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one().<ModelQuery>getValue("member_set").count() == 5 );
        check( Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one().<ModelQuery>getValue("member_set").filter("firstName = ?", "Homer").count() == 1 );
        Account account = Account.cls.filter("emailAddress = ?", "test@liferay.com").one();
        UserUtil.clearCache();
        User user = UserLocalServiceUtil.fetchUser((Long) account.getId());
//        User user = findUser("test@liferay.com");
        check( Account.cls.equalsEntity(account, user) );

        Account adminAccount = Account.cls.filter("emailAddress = ?", "test@liferay.com").<Account>one();
        String screenName = adminAccount.getScreenName();
        String newScreenName = screenName + "1";
        adminAccount.setScreenName(newScreenName);
        adminAccount.update();
        check( adminAccount.getScreenName().equals(newScreenName));
        check( UserLocalServiceUtil.getUser(user.getUserId()).getScreenName().equals(newScreenName));
        check( findUser("test@liferay.com").getScreenName().equals(newScreenName));
        adminAccount.setScreenName(screenName);
        adminAccount.update();

        user = UserLocalServiceUtil.getUser(user.getUserId());
        user.setScreenName(newScreenName);
        UserLocalServiceUtil.updateUser(user, false);
        check( Account.cls.get(user.getUserId()).getScreenName().equals(newScreenName));
        user.setScreenName(screenName);
        UserLocalServiceUtil.updateUser(user, false);
    }


    private static void check(boolean value) throws Exception {
        if (!value) {
            throw new Exception("Checking failed!!!");
        }
    }

    public static User findUser(String email) throws SystemException {
        DynamicQuery dqUser = DynamicQueryFactoryUtil.forClass(User.class)
                .add(PropertyFactoryUtil.forName("emailAddress").like("%" + email + "%"));
        return (User) UserLocalServiceUtil.dynamicQuery(dqUser).get(0);
    }

}
