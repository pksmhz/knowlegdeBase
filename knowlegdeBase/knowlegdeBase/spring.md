# Transaction menagement

* Configuration

Config:

    @Configuration
    @EnableTransactionManagement
    public class PersistenceJPAConfig{
    
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
            //...
        }
    
        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }
    }


Transactional annotation:

    @Service
    @Transactional
    public class FooService {
        //...
    }

Default: rollback only for  runtime, unchecked exceptions only. 

Private methods are ignored.

    @Transactional(isolation = Isolation.SERIALIZABLE)

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

    @Transactional(rollbackFor = { SQLException.class })

    @Transactional(noRollbackFor = { SQLException.class })

    public void createCourseDefaultRatingProgramatic(Course course) {
        try {
            courseDao.create(course);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

Propagation types:

    @Transactional(propagation = Propagation.REQUIRED)


* REQUIRED is the default propagation. 
Spring checks if there is an active transaction, and if nothing exists, it creates a new one. 
Otherwise, the business logic appends to the currently active transaction


    @Transactional(propagation = Propagation.SUPPORTS)

For SUPPORTS, Spring first checks if an active transaction exists. 
If a transaction exists, then the existing transaction will be used. 
If there isn't a transaction, it is executed non-transactional

    @Transactional(propagation = Propagation.MANDATORY)

When the propagation is MANDATORY, if there is an active transaction, then it will be used. 
If there isn't an active transaction, then Spring throws an exception

    @Transactional(propagation = Propagation.NEVER)

For transactional logic with NEVER propagation, Spring throws an exception if there's an active transaction:

    @Transactional(propagation = Propagation.NOT_SUPPORTED)

If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction:

    @Transactional(propagation = Propagation.REQUIRES_NEW)

When the propagation is REQUIRES_NEW, Spring suspends the current transaction if it exists, and then creates a new one

    @Transactional(propagation = Propagation.NESTED)

For NESTED propagation, Spring checks if a transaction exists, and if so, it marks a save point. 
This means that if our business logic execution throws an exception, then the transaction rollbacks to this save point. 
If there's no active transaction, it works like REQUIRED.

* Isolation:
  Isolation describes how changes applied by concurrent transactions are visible to each other.

We can set the isolation level of a transaction by @Transactional::isolation. It has these five enumerations in Spring: 
* DEFAULT, 
* READ_UNCOMMITTED, 
* READ_COMMITTED, 
* REPEATABLE_READ, 
* SERIALIZABLE.


# Serialization is the process of converting an object into a byte stream, and deserialization is the opposite of it.

When we mark any variable as transient, then that variable is not serialized. Since transient fields aren't present in the serialized form of an object, the deserialization process would use the default values for such fields when creating an object out of the serialized form.

* @Transient

In other words, the transient keyword has the same effect as the @Transient annotation when saving to a database. However, the @Transient annotation does not affect Java object serialization.

supplier
accumulator
combiner
finisher



String - immutable
StringBuffer - mutable, StringBuffer is synchronous
StringBuilder -  mutable, no thread safety

