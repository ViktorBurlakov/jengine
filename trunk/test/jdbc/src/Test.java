import com.jengine.orm.db.DB;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBFactory;
import com.jengine.orm.db.adapter.Adapter;
import com.jengine.orm.db.adapter.jdbc.JDBCAdapter;
import com.jengine.orm.db.provider.Provider;
import com.jengine.orm.db.provider.mysql.MySQLProvider;
import com.jengine.orm.field.FunctionField;
import models.*;

import static com.jengine.utils.CollectionUtil.map;

public class Test {

    public static void main(String [] args) throws Exception {
        Adapter adapter = new JDBCAdapter("com.mysql.jdbc.Driver", "MySQL", "jdbc:mysql://localhost:3306/bookdb?", "root", "");
        Provider provider = new MySQLProvider(adapter);
        DBFactory.register(new DB(provider));

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
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

    }

    /**
     * New objects Adding
     * @throws DBException
     */
    public static void loadData() throws DBException {
        /* Authors */
        Author jule = new Author();
        jule.setAuthorId(1l);
        jule.setFirstName("Jules");
        jule.setLastName("Verne");
        jule.save();

        Author asimov = new Author();
        asimov.setAuthorId(2l);
        asimov.setFirstName("Isaac");
        asimov.setLastName("Asimov");
        asimov.save();

        Author king = new Author();
        king.setAuthorId(3l);
        king.setFirstName("Stephen");
        king.setLastName("King");
        king.save();

        /* Libraries */
        Library globeLibrary = new Library();
        globeLibrary.setLibraryId(1l);
        globeLibrary.setName("Globe");
        globeLibrary.setAddress("Springfield, 742 Evergreen Terrace");
        globeLibrary.save();

        Library localLibrary = new Library();
        localLibrary.setLibraryId(2l);
        localLibrary.setName("Local");
        localLibrary.setAddress("Local");
        localLibrary.save();

        /* Books */
        Book book1 = new Book();
        book1.setBookId(1l);
        book1.setTitle("The Dark Tower");
        book1.setLibrary(globeLibrary);
        book1.save();

        Book book2 = new Book();
        book2.setBookId(2l);
        book2.setTitle("The Shining ");
        book2.setLibrary(globeLibrary);
        book2.save();

        Book book3 = new Book();
        book3.setBookId(3l);
        book3.setTitle("Vingt mille lieues sous les mers");
        book3.setLibrary(globeLibrary);
        book3.save();

        /* Members */
        Member member1 = new Member();
        member1.setMemberId(1l);
        member1.setFirstName("Mark");
        member1.setLastName("Adamson");
        member1.setLibrary(globeLibrary);
        member1.save();

        Member member2 = new Member();
        member2.setMemberId(2l);
        member2.setFirstName("Peter");
        member2.setLastName("Douglas");
        member2.setLibrary(globeLibrary);
        member2.save();

        Member member3 = new Member();
        member3.setMemberId(3l);
        member3.setFirstName("Gary");
        member3.setLastName("Miller");
        member3.setLibrary(globeLibrary);
        member3.save();

        Member member4 = new Member();
        member4.setMemberId(4l);
        member4.setFirstName("Homer");
        member4.setLastName("Simpson");
        member4.setLibrary(globeLibrary);
        member4.save();

        Member member5 = new Member();
        member5.setMemberId(5l);
        member5.setFirstName("Burt");
        member5.setLastName("Simpson");
        member5.setLibrary(globeLibrary);
        member5.save();
    }

    /**
     * Clearing data test
     */
    public static void test1() throws Exception {
        System.out.println("** Test1: Clearing data test");

        clearData();
        // checking
        assert Author.cls.count() == 0;
        assert Library.cls.count() == 0;
        assert Book.cls.count() == 0;
        assert Member.cls.count() == 0;
        assert Transaction.cls.count() == 0;
    }

    /**
     *  Object creation test
     */
    public static void test2() throws Exception {
        System.out.println("** Test2: Object creation test");

        clearData();
        loadData();

        assert Author.cls.count() == 3;
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
        assert Member.cls.filter("lastName = ?", "Simpson").list().size() == 2;
        assert Author.cls.filter(Author.firstName.eq("Stephen")).<Author>one().getLastName().equals("King");
        assert Book.cls.filter(Book.library.eq(Library.cls.get(1))).list().size() == 3;
        assert Book.cls.filter(map("library.name__like", "%Globe")).list().size() == 3;
        assert Book.cls.filter(map("library.libraryId", 101)).<Book>list().size() == 0;
    }

    /**
     * Sub query test
     */
    public static void test4() throws Exception {
        System.out.println("** Test4: Sub SQLQuery test");

        clearData();
        loadData();

        assert Book.cls.filter("library = ?", Library.cls.select("libraryId").filter("name like ?", "%Globe")).list().size() == 3;
    }


    /**
     * Inserting and Updating test
     */
    public static void test5() throws Exception {
        System.out.println("** Test 5: Inserting and Updating test");

        clearData();
        Author author1 = new Author();
        author1.setAuthorId(1l);
        author1.setFirstName("Jules");
        author1.setLastName("Verne");
        author1.save();

        assert Author.cls.get(1).getLastName().equals("Verne");

        author1.setValue("firstName", "Jules1");
        author1.save();

        assert Author.cls.get(1).getFirstName().equals("Jules1");
    }

    /**
     * Aggregation testing
     */
    public static void test6() throws Exception {
        System.out.println("** Test 6:  Aggregation testing");

        clearData();
        loadData();

        assert Author.cls.<Long>max(Author.authorId) == 3l;
        assert Author.cls.<Long>sum(Author.authorId) == 6l;
        assert Author.cls.<Long>min(Author.authorId) == 1l;
        assert Book.cls.count() == 3l;
        FunctionField function1 = new FunctionField("function1", Long.class, "%s + 1", Book.bookId);
        assert Book.cls.select(function1).filter("bookId = 1").<Long>one() == 2l;
        assert Book.cls.<Long>calc("sum", Long.class, "max(%s) + 2", Book.bookId) == 5l;
    }

    /**
     * Model relation testing
     */
    public static void test7() throws Exception {
        System.out.println("** Test 7: Model relation testing");

        clearData();
        loadData();

        assert Book.cls.get(1).getLibrary().equals(Library.cls.get(1));

        Library globe = Library.cls.filter("name = ?", "Globe").one();
///        check(globe.getMemberList().size() == 5);
//        check(globe.getMembers().list().size() == 5);
//        check(globe.getMembers().count() == 5);
//        check(globe.getMembers().filter("lastName = ?", "Simpson").count() == 2);
    }

}
