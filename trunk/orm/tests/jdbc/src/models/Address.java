package models;

import com.jengine.orm.ModelClass;
import com.jengine.orm.db.DBException;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.StringField;
import com.jengine.orm.field.reference.SingleReferenceField;

import static com.jengine.utils.CollectionUtil.map;

public class Address extends TestModel {
    public static Field street = new StringField("verbose", "Street");
    public static Field number = new StringField("verbose", "Building Number");
    public static Field member = new SingleReferenceField(Member.class, map("verbose", "Member"));
    public static ModelClass<Address> cls = new ModelClass<Address>(Address.class);

    public Address() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return String.format("%s %s", getNumber(), getStreet());
    }

    public String getStreet() throws DBException {
        return (String) getValue(street);
    }

    public void setStreet(String value) throws DBException {
        setValue(street,value);
    }

    public String getNumber() throws DBException {
        return (String) getValue(number);
    }

    public void setNumber(String value) throws DBException {
        setValue(number, value);
    }

    public Member getMember() throws DBException {
        return (Member) getValue(member);
    }

    public void setMember(Member obj) throws DBException {
        setValue(member, obj);
    }
}
