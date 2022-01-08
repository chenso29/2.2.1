package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


//---------------------------------------------------------------------------------------------------------

      Car car1 = new Car("BMW", 123);
      Car car2 = new Car("Mercedez", 456);
      Car car3 = new Car("Audi", 789);

      User user1 = new User("Ivan", "Ivanov" , "ivanivanov@gmail.com");
      User user2 = new User("Aleksandr", "Petrov" , "aleksandrpetrov@gmail.com");
      User user3 = new User("Semyon", "Semyonov" , "semyon@gmail.com");
      user1.setUsercar(car1);
      user2.setUsercar(car2);
      user3.setUsercar(car3);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getUsercar());
         System.out.println("--------------------------------");
      }
      System.out.println(userService.getUserByCar(car2));


      context.close();
   }
}
