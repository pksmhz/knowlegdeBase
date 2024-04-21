# Transaction management

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

  @Transient
  private Date loginTime;

  private transient Date loginTime;   <-- java keyword

In other words, the transient keyword has the same effect as the @Transient annotation when saving to a database. However, the @Transient annotation does not affect Java object serialization.



https://springframework.guru/spring-framework-annotations/

@Component
This annotation is used on classes to indicate a Spring component. The @Component annotation marks the Java class as a bean or say component so that the component-scanning mechanism of Spring can add into the application context.

@Controller
The @Controller annotation is used to indicate the class is a Spring controller. This annotation can be used to identify controllers for Spring MVC or Spring WebFlux.

@Service
This annotation is used on a class. The @Service marks a Java class that performs some service, such as execute business logic, perform calculations and call external APIs. This annotation is a specialized form of the @Component annotation intended to be used in the service layer.

@Repository
This annotation is used on Java classes which directly access the database. The @Repository annotation works as marker for any class that fulfills the role of repository or Data Access Object.

This annotation has an automatic translation feature. For example, when an exception occurs in the @Repository there is a handler for that exception and there is no need to add a try catch block.

# Bean lifecycle

To interact with the container’s management of the bean lifecycle, you can implement the Spring InitializingBean and DisposableBean interfaces. 
The container calls afterPropertiesSet() for the former and destroy() for the latter to let the bean perform certain actions upon initialization and destruction of your beans.

The Spring Framework supports six scopes, four of which are available only if you use a web-aware ApplicationContext. You can also create a custom scope.

The following table describes the supported scopes:



# Bean scopes

* singleton (Default) 
  * Scopes a single bean definition to a single object instance for each Spring IoC container.

* prototype
  * Scopes a single bean definition to any number of object instances.

* request
  * Scopes a single bean definition to the lifecycle of a single HTTP request. That is, each HTTP request has its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext.

* session
  * Scopes a single bean definition to the lifecycle of an HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext.

* application
  * Scopes a single bean definition to the lifecycle of a ServletContext. Only valid in the context of a web-aware Spring ApplicationContext.

* websocket
  * Scopes a single bean definition to the lifecycle of a WebSocket. Only valid in the context of a web-aware Spring ApplicationContext.