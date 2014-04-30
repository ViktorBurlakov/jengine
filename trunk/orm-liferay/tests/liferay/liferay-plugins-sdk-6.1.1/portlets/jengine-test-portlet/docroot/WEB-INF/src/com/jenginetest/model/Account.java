package com.jenginetest.model;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.liferay.LiferayModel;
import com.jengine.orm.db.adapter.liferay.LiferayModelClass;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.PrimaryKey;
import com.jengine.orm.model.field.StringField;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.BasePersistence;
import com.liferay.portal.service.persistence.UserUtil;

import java.util.Map;

import static com.jengine.utils.CollectionUtil.map;
import static com.jengine.utils.CollectionUtil.set;

public class Account extends LiferayModel<User> {
    public static Field userId  = new PrimaryKey();
    public static Field uuid = new StringField("columnName", "uuid_");
    public static Field password = new StringField("verbose", "Password", "columnName", "password_");
    public static AccountModelClass cls = new AccountModelClass(map("exclude", set("passwordUnencrypted", "userUuid", "passwordModified", "primaryKey")));


    public Account() throws DBException {
        super();
    }

    public String getVerbose() throws DBException {
        return getEmailAddress();
    }

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

        public AccountModelClass() {
            super(Account.class, "com.liferay.portal.model.impl.UserImpl");
        }

        public AccountModelClass(Map options) {
            super(Account.class, "com.liferay.portal.model.impl.UserImpl", options);
        }

        public BasePersistence getPersistence() {
            return UserUtil.getPersistence();
        }
    }
}
