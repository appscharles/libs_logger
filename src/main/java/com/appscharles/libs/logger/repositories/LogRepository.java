package com.appscharles.libs.logger.repositories;

import com.appscharles.libs.databaser.exceptions.DatabaserException;
import com.appscharles.libs.databaser.operators.DBOperator;
import com.appscharles.libs.logger.models.Log;
import com.appscharles.libs.logger.models.enums.LevelLog;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Log repository.
 */
public class LogRepository {

    /**
     * Remove all.
     *
     * @throws DatabaserException the databaser exception
     */
    public static void removeAll() throws DatabaserException {
        DBOperator.commit(session -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<Log> criteriaQuery = builder.createCriteriaDelete(Log.class);
            criteriaQuery.from(Log.class);
            session.createQuery(criteriaQuery).executeUpdate();
        });
    }

    /**
     * Gets with error level.
     *
     * @return the with error level
     * @throws DatabaserException the databaser exception
     */
    public static List<Log> getWithErrorLevel() throws DatabaserException {
        List<Log> results = new ArrayList<>();
        DBOperator.commit(session->{
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Log> criteriaQuery = builder.createQuery(Log.class);
            Root<Log> root = criteriaQuery.from(Log.class);
            criteriaQuery.select(root);
            criteriaQuery.where(builder.equal(root.get("level"), LevelLog.ERROR));
            Query<Log> q = session.createQuery(criteriaQuery);
            results.addAll(q.getResultList());
        });
        return results;
    }
}
