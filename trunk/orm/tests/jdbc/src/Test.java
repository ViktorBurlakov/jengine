import com.jengine.orm.DB;
import com.jengine.orm.DBFactory;
import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBSavePoint;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.adapter.ConnectionManager;
import com.jengine.orm.db.adapter.jdbc.JDBCAdapter;
import com.jengine.orm.db.adapter.jdbc.connection.DBCPConnectionPool;
import com.jengine.orm.db.cache.ehcache.EhcacheManager;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.db.provider.mysql.MySQLProvider;
import com.jengine.orm.exception.ValidateException;
import com.jengine.orm.model.cluster.Cluster;
import com.jengine.orm.model.field.Calc;
import com.jengine.orm.model.field.aggregation.Max;
import com.jengine.utils.CollectionUtil;
import model.*;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.map;

public class Test {

    public static void main(String [] args) throws Exception {
        ConnectionManager connectionManager = new DBCPConnectionPool(newDBCPDataSource());
//        ConnectionManager connectionManager = new SingleConnectionManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/bookdb?", "root", "");
        Adapter adapter = new JDBCAdapter(connectionManager);
        EhcacheManager cacheManager = new EhcacheManager(newEhcacheManager());
        Provider provider = new MySQLProvider(adapter, cacheManager);
        DB db = DBFactory.register(new DB(provider));

        // testing
        DBConnection connection = db.getConnection();
        try {
//            test1();
//            test2();
//            test3();
//            test4();
//            test5();
//            test6();
//            test7();
//            test8();
//            test9();
//            test10();
            test11();
        } finally {
            db.closeConnection(connection);
            db.getCacheManager().shutdown();
        }
    }

    public static DataSource newDBCPDataSource() {
        // jdbc connection pool manager
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("");
        ds.setUrl("jdbc:mysql://localhost:3306/bookdb?");
        ds.setMaxActive(20);
        ds.setMaxIdle(2);

        return ds;
    }

    public static net.sf.ehcache.CacheManager newEhcacheManager() {
        //Create a singleton CacheManager using defaults
        CacheManager manager = CacheManager.create();
        //Create a Cache specifying its configuration.
        Cache testCache = new Cache(
                new CacheConfiguration("Author", 7)
                        .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
                        .eternal(false)
                        .timeToLiveSeconds(60)
                        .timeToIdleSeconds(30)
//                        .diskExpiryThreadIntervalSeconds(0)
                        .persistence(new PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP)));
        manager.addCache(testCache);

        return manager;
    }


    /**
     * All data Removing
     * @throws DBException
     */
    public static void clearData() throws DBException {
        Author.cls.remove();
        Library.cls.remove();
        Book.cls.remove();
        Member.cls.remove();
        Transaction.cls.remove();
        Address.cls.remove();
        Author.books.remove();

    }

    /**
     * New objects Adding
     * @throws DBException
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
        book2.setTitle("The Shining ");
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
        member1.save();

        Member member2 = new Member();
        member2.setId(2l);
        member2.setFirstName("Peter");
        member2.setLastName("Douglas");
        member2.setLibrary(globeLibrary);
        member2.save();

        Member member3 = new Member();
        member3.setId(3l);
        member3.setFirstName("Gary");
        member3.setLastName("Miller");
        // required is set to 'false' only for testing
        // member3.setLibrary(globeLibrary);
        member3.save();

        Member member4 = new Member();
        member4.setId(4l);
        member4.setFirstName("Homer");
        member4.setLastName("Simpson");
        member4.setLibrary(globeLibrary);
        member4.save();

        Member member5 = new Member();
        member5.setId(5l);
        member5.setFirstName("Burt");
        member5.setLastName("Simpson");
        member5.setLibrary(globeLibrary);
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
        Date modificationDate = Transaction.cls.get(1).getModificationDate();
        Thread.sleep(2000);
        Transaction.cls.get(1).save();

        check(Transaction.cls.get(1).getDate().equals(tdate));
        check(!Transaction.cls.get(1).getModificationDate().equals(modificationDate));
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
        List members = Member.cls.select(new Calc("f", Long.class, "%s + 1", Member.id)).order("library.name").order("f").list();
        check( CollectionUtil.equals(members, list(2l, 3l, 4l, 5l, 6l)) );
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
        check( Book.cls.select(new Calc(Book.cls, "counter", Long.class, "id + 1", Book.id)).filter("id = ?", 1l).<Long>one() == 2l );
        Book.cls.select("id", new Max(Book.cls, "id")).filter("id = ?", 1l).group("id").one();
        check( Book.cls.<Long>calc("sum", Long.class, "max(%s) + 2", Book.id) == 5l );
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
        check( Author.cls.getProvider().getCache(Author.cls.getManager().getTableName(), 1l) != null );
    }

    /**
     * Cluster testing
     */
    public static void test11() throws Exception {
        System.out.println("** Test 11: Cluster testing");

        clearData();
        loadData();

        Cluster cluster = new Cluster(Transaction.cls).ljoin(Book.cls, "Book", "Transaction.book", "Book.id");
        check( cluster.select("Transaction.id").one() != null );
    }


    private static void check(boolean value) throws Exception {
        if (!value) {
            throw new Exception("Checking failed!!!");
        }
    }
}
