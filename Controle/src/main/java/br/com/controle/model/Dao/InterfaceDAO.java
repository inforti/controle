
package br.com.controle.model.Dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;


public interface InterfaceDAO<T> {
    void save (T entity);
    void updatae(T entity);
    void remuve (T entity);
    void merge (T entity);
    T getEntity (Serializable id);
    T getEnityByDetachedCriteria(DetachedCriteria criteria);
    List<T> getEntyties();
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
    
}
