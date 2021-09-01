package pl.sda.library_app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
abstract class BaseServiceTest {

    @Autowired
    protected EntityManager em;

    protected void persistAndClearCache(Object entity) {
        em.persist(entity);
        em.flush();
        em.clear();
    }
}