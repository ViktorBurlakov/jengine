import com.jengine.db.DB;
import com.jengine.db.DBFactory;
import com.jengine.db.adapter.Adapter;
import com.jengine.db.adapter.jdbc.JDBCAdapter;
import com.jengine.db.exception.DBException;
import com.jengine.db.provider.Provider;
import com.jengine.db.provider.mysql.MySQLProvider;
import models.*;

public class Test {

    public static void main(String [] args) throws DBException {
        Adapter adapter = new JDBCAdapter("sun.jdbc.odbc.JdbcOdbcDriver", "MySQL", "jdbc:mysql://localhost:3306/bookdb?", "root", "");
        Provider provider = new MySQLProvider(adapter);
        DBFactory.register(new DB(provider));

        clearData();
    }

    public static void test1(){

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

}
