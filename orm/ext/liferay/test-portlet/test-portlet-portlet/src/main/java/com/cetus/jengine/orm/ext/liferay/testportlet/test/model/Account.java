package com.cetus.jengine.orm.ext.liferay.testportlet.test.model;


import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.ext.liferay.LiferayModelClass;
import com.cetus.jengine.orm.core.exception.ValidateException;
import com.cetus.jengine.orm.core.model.Meta;
import com.cetus.jengine.orm.core.model.Model;
import com.cetus.jengine.orm.core.model.field.Field;
import com.cetus.jengine.orm.core.model.field.PrimaryKey;
import com.cetus.jengine.orm.core.model.field.StringField;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.UserUtil;

import java.io.Serializable;
import java.util.Set;

import static com.cetus.jengine.utils.commons.CollectionUtil.map;
import static com.cetus.jengine.utils.commons.CollectionUtil.set;

@Meta(table = "User_", cacheEnabled = true)
public class Account extends Model {
    public static Field userId  = new PrimaryKey();
    public static Field uuid = new StringField("columnName", "uuid_");
    public static Field password = new StringField("verbose", "Password", "columnName", "password_");
    public static AccountModelClass cls = new AccountModelClass();


    public Account() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return getEmailAddress();
    }

    /* getters and setters */

    public String getEmailAddress() throws DBException {
        return (String) getValue("emailAddress");
    }

    public void setScreenName(String screenName) throws DBException {
        setValue("screenName", screenName);
    }

    public String getScreenName() throws DBException {
        return (String) getValue("screenName");
    }


    /* Model Class for Account */

    public static class AccountModelClass extends LiferayModelClass<Account> {
        public static Set exclude = set("passwordUnencrypted", "passwordModified", "primaryKey", "userUuid",
                "cachedModel", "new");

        public AccountModelClass() {
            super(Account.class, User.class, map("autoScan", true, "exclude", exclude));
        }

        public BaseModel createEntity(Serializable id) throws ValidateException, DBException {
            return getPersistence().create((Long) id);
        }

        public UserPersistence getPersistence() {
            return UserUtil.getPersistence();
        }
    }
}
