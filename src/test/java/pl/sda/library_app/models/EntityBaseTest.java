package pl.sda.library_app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
abstract class EntityBaseTest {

    @Autowired
    protected EntityManager em;

    protected void persistAndClearCache(Object entity) {
        em.persist(entity);
        em.flush();
        em.clear();
    }
}