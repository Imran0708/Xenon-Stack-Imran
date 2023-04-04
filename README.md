# Xenon-Stack-Imran
We have implemented the roll base login for Restaurant, customer where all get login option on same page. 
For every role we have different fields but there was some common fields also. So to reduce data redundancy and achieve normalization we have created on table with all common fields with table name “user”. 
Further we mapped other three (Restaurant, Customer) tables with user table with one to one mapping. 
Two actors present in the project Customer, Restaurant. After login to particular role that specific user will able to see functionalities according to role.

// role base registration 
@Override  public void saveuser(UserDto userdto)   { 
 
  User user = new User(userdto.getFirstName(), 
  userdto.getLastName(), userdto.getEmail(), 
  userdto.getMobileNo(), userdto.getGender(), 
  userdto.getAddress(), userdto.getCity(),    
  userdto.getState(), userdto.getPinCode(),
  userdto.getPassword(),userdto.getDate(),   
  userdto.getRole());      
  if(user.getRole().equalsIgnoreCase("Restaurant")) { 
  Restaurant restaurant = new Restaurant(userdto.getRestaurantName(),
  userdto.getLicenseNo(),userdto.getCateogry(),
  us erdto.getRestaurantType(),userdto.getRestaurantImage());
  user.setRestaurant(restaurant);    
  restaurant.setUser(user);    
  } 

}      userepo.save(user); 
 
 
   
 
 } 
 
Customer will see various restaurants and cloud kitchen from locality and will be able to orders food from specific restaurants. 
Customer can also add food items to cart. Customer can add multiple items to cart also.
Further customer can proceed to checkout. After successful order placement user will receive confirmation on mail.
And order details will added to order table.    
 Restaurants will be able to login and can add, delete or update food menu available in their restaurants. 
 And will able to see once any order get placed for specific restaurant on that restaurant’s profile. 
 When customer places order the order will assigned to delivery boy. And delivery boy will see order details on his dashboard. 
 
 We have used MVC design pattern to develop application. We have used various entity class to store data into database.
 For that we have use certain annotations like @Entity @Id,@ @GeneratedValue(strategy = GenerationType.IDENTITY) 
all this annotation helped us to save data into database.
We inserted data into MySQL database with help of JPA (Java Persistence API) Repository. 
which internally perform hibernate(ORM tool) to save into database. For mappinf of table we have used @OneToOne 
 controller package contains controller classes which have control flow of project. We have use @controller annotations to specify specific controller.
 
 //* MYSQL TABLES
 ->
  6 tables  -- >  user, restaurant, order_details, bill_details, user_pay_ngo, food_menu 
  
 //*  Why you choose spring boot technology in backend? 
->
Without Spring-Boot: 
Need to maintain a separate application-context.xml file (Well you should know basic XML for this). 
You need to make sure you are having all the bean dependencies being declared properly in the context file. 
Post creation of the project, we need to deploy the application on a server manualy to test (considered as the time consuming task by developers) 
 
With SpringBoot: 
No expertise required on XML, since spring boot gets rid of application-context.xml. 
Spring Boot “Bootstraps” all the dependencies on the start-up of the application which are available on the class path. 
No need of declaring an beans in any file. Instead you can simply annotate the with @bean annotation. 
Simple configuration using the application.properties file. 
And yes, since spring boot comes along with embedded tomcat, no need of additional deployment. 
 
// *  Annotations used in our project? 
 -> 
@Service - indicates that an annotated class is a service class. 
@Repository - indicates that an annotated class is a repository, which is an abstraction of data access and storage. 
@Configuration - indicates that a class is a configuration class that may contain bean definitions. 
@Controller - marks the class as web controller, capable of handling the requests. 
@RequestMapping - maps HTTP request with a path to a controller method. 
@Autowired - marks a constructor, field, or setter method to be autowired by Spring dependency injection. 
@SpringBootApplication - enables Spring Boot autoconfiguration and component scanning. 
@Column - annotation is used to specify the details of the column to which a field or property will be mapped.  
@Table - annotation allows you to specify the details of the table that will be used to persist the entity in the database. 
@Entity annotation marks this class as an entity. 
@Id - annotation marks the identifier for this entity. 
@OnetoOne - Defines a single-valued association to another entity that has one-to-one multiplicity. 
@ManytoMany - Defines a many-valued association with many-to-many multiplicity 
 
