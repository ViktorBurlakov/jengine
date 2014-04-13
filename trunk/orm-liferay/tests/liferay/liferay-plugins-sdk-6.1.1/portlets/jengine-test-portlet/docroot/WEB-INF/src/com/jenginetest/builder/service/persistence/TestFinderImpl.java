package com.jenginetest.builder.service.persistence;


import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.List;

public class TestFinderImpl extends BasePersistenceImpl implements TestFinder {

    public List search() throws SystemException {
        List result = new ArrayList<Long>();
        Session session = null;

        try {
            session = openSession();
            String qString = "SELECT Transaction.id, Book.id, Book.title, max(Transaction.id) AS max_Transaction__id FROM Transaction  RIGHT JOIN Book  ON Book.id = Transaction.bookId  GROUP BY Book.title";
//            String qString = "SELECT Transaction.id, Book.id, Book.title FROM Transaction  RIGHT JOIN Book  ON Book.id = Transaction.bookId";
            SQLQuery query = session.createSQLQuery(qString, true);
            query.addScalar("Book.id", Type.LONG);
            query.addScalar("Transaction.id", Type.LONG);
            query.addScalar("Book.title", Type.STRING);
            query.addScalar("max_Transaction__id", Type.LONG);
            System.out.println(qString);
            result = (List<Long>) QueryUtil.list(query, getDialect(), -1, -1);
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }

        return result;
    }
}
