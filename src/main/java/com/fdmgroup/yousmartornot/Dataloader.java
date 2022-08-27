package com.fdmgroup.yousmartornot;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.ApplicationArguments; 
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fdmgroup.yousmartornot.Model.Question;
import com.fdmgroup.yousmartornot.Model.Topic;
import com.fdmgroup.yousmartornot.Model.User;
import com.fdmgroup.yousmartornot.Service.QuestionService;
import com.fdmgroup.yousmartornot.Service.TopicService;
import com.fdmgroup.yousmartornot.Service.UserService; 

/**
 * This is Dataloader class to load all the default data into MySQL
 * @author SmartPeople
 *
 */
@Component
public class Dataloader implements ApplicationRunner { 
    private QuestionService questionService; 
    private TopicService topicService;
    private UserService userService;
    @Autowired
    public Dataloader(QuestionService questionService, TopicService topicService, UserService userService) { 
     super(); 
     this.questionService = questionService; 
     this.topicService=topicService;
     this.userService = userService;
    } 
    @Override
    public void run(ApplicationArguments args) throws Exception { 
        Topic topic1 = new Topic("Unix"); 
        Topic topic2 = new Topic("SQL");
        Topic topic3 = new Topic("JAVA");
        topicService.save(topic1);
        topicService.save(topic2);
        topicService.save(topic3);
        User user1 = new User("John", "john@weicheng.com", 4, topic1);
        User user2 = new User("Jamie", "jamie@weichenggroup.com", 4, topic1);
        User user3 = new User("Jason", "jason@weichenggroup.com", 3, topic1);
        User user4 = new User("Jackson", "jackson@weichenggroup.com", 2, topic1);
        User user5 = new User("James", "james@weichengllc.com", 2, topic1);
        User user6 = new User("Janet", "janet@weichengllc.com", 1, topic1);
        User user7 = new User("Jacob", "jacob@weichenggroup.com", 1, topic1);
        User user8 = new User("Jack", "jack@weichenggroup.com", 0, topic1);
        User user9 = new User("Joshua", "joshua@weichenghome.com", 1, topic1);
        User user10 = new User("Jake", "jake@weichengman.com", 3, topic1);
        User user11 = new User("Five", "five@as.queue.el.com", 5, topic2);
        User user12 = new User("AlsoFive", "alsofive@as.queue.el.com", 5, topic2);
        User user13 = new User("Four", "four@as.queue.el.com", 4, topic2);
        User user14 = new User("Alsofour", "alsofour@as.queue.el.com", 4, topic2);
        User user15 = new User("Three", "three@as.queue.el.com", 3, topic2);
        User user16 = new User("AlsoThree", "alsothree@as.queue.el.com", 3, topic2);
        User user17 = new User("Two", "two@as.queue.el.com", 2, topic2);
        User user18 = new User("One", "one@as.queue.el.com", 1, topic2);
        User user19 = new User("AlsoOne", "alsoone@as.queue.el.com", 1, topic2);
        User user20 = new User("OneAgain", "oneagain@as.queue.el.com", 1, topic2);
        User user21 = new User("Weicheng", "weicheng@boss.com", 10, topic3);
        User user22 = new User("Weicheng", "weicheng@anothercompanyboss.com", 10, topic3);
        User user23 = new User("ThisIsNotWeicheng", "is.not.weicheng@noob.com", 2, topic3);
        User user24 = new User("INotWeicheng", "i.not.weicheng@trash.com", 3, topic3);
        User user25 = new User("SomeoneButNotWeicheng", "someone@passerby.com", 1, topic3);
        User user26 = new User("FakeWeicheng", "fake.weicheng@callpolice.com", 0, topic3);
        User user27 = new User("Servant", "servant1@weicheng.com", 2, topic3);
        User user28 = new User("DefinitelyNotWeicheng", "def.not.weicheng@rubbish.com", 1, topic3);
        User user29 = new User("NotWeicheng", "not.weicheng@semakau.com", 1, topic3);
        User user30 = new User("NotWeichengAlso", "not.weicheng.also@dumpster.com", 0, topic3);
        Question question1 = new Question("How to create a directory?", "touch", "cd", "mkdir", "makedir", 3, topic1); 
        Question question2 = new Question("What is chmod 751?", "User can read/write/execute, Group can read/execute, Others can execute", "User can read/write/execute, Group can read/execute, Others can read", "User can read/write/execute, Group can write/execute, Others can read", "User can read/write/execute, Group can read/write, Others can execute", 1, topic1); 
        Question question3 = new Question("How to create a regular file?", "mkfile", "cd", "makefile", "touch", 4, topic1); 
        Question question4 = new Question("What is shell command", "A shell command is one that is processed internally by the shell", "A Unix command to create multiple directories", "Shell command does not exist in Unix", "A command used to run other programming language in Unix", 1, topic1); 
        Question question5 = new Question("How do you redirect a file", ">>", "/redirect", ">", "<", 3, topic1); 
        Question question6 = new Question("How do you append to a destination?", ">>", "/append", ">", "<", 1, topic1); 
        Question question7 = new Question("How to display the first 4 characters of each line in the accounts file?", "display -c1-4 accounts", "cut -c4 accounts", "cut '-c1-4' accounts", "cut -c1-4 accounts", 4, topic1); 
        Question question8 = new Question("What is the command to display the full pathname of your current directory?", "touch", "cd ~", "echo", "pwd", 4, topic1); 
        Question question9 = new Question("How to display all the list of files in your current directory?", "touch", "cd", "ls", "tree", 3, topic1); 
        Question question10 = new Question("List all the processes running on the Unix server?", "-ps all", "ps -a", "ps -all", "-ps -all", 2, topic1);
        Question question11 = new Question("What is a Primary Key", "A column that uniquely identifies each record in a table", "A column that appears as an attribute in another table and acts to provide a logical relationship between two tables ", "Every SQL table must have a primary key", "You can have multiple primary keys in a table", 1, topic2);
        Question question12 = new Question("What is a Foreign Key", "A column that uniquely identifies each record in a table", "A column that appears as an attribute in another table and acts to provide a logical relationship between two tables ", "Every SQL table must have a foreign key", "You cannot have multiple foreign keys in a table", 2, topic2);
        Question question13 = new Question("How do you write an SQL query to get all username from User table", "SELECT username FROM User table", "SELECT username FROM User ", "SELECT username column FROM User", "SELECT username ", 2, topic2);
        Question question14 = new Question("How do you write an SQL query to get all details from User table", "SELECT all FROM User table", "SELECT all FROM User ", "SELECT * FROM User table", "SELECT * FROM User", 4, topic2);
        Question question15 = new Question("How do you write an SQL query to get details of user whose username starts with a", "SELECT a FROM User", "SELECT * FROM User WHERE username like '%a'", "SELECT * FROM User WHERE username like 'a%'", "SELECT * from User WHERE username like 'a'", 3, topic2);
        Question question16 = new Question("How do you write an SQL query to get details of user who created their account in July 2022", "SELECT * FROM User WHERE year and month = 2022 and July", "SELECT * FROM User WHERE month and year = July and 2022", "SELECT * FROM User WHERE year = 2022 and month = July", "SELECT * from User WHERE year = 2022 and month = 7", 4, topic2);
        Question question17 = new Question("How do you write an SQL query to get count of user staying in Orchard", "SELECT COUNT(*) FROM User WHERE House = 'Orchard'", "SELECT COUNT(*) FROM User WHERE House = Orchard", "SELECT COUNT(Orchard) FROM User", "SELECT COUNT(House) from User WHERE 'Orchard'", 1, topic2);
        Question question18 = new Question("What is the difference of left join and right join", "Left join shows the details of left table and right join shows the details in the right table in the joined region", "There are no difference", "Left join shows the details from left table and joined region, and right join shows the details from right table and the joined region", "None of the above", 3, topic2);
        Question question19 = new Question("How do you write an SQL query to get the highest salary from the worker table", "SELECT highest(Salary) FROM Worker", "SELECT max(salary) FROM Worker", "SELECT salary from Worker WHERE max(salary)","SELECT max(*) FROM Worker", 2, topic2);
        Question question20 = new Question("How do you write an SQL query to get name of User whose username starts with a, created their account in July 2022, and staying at Orchard", "SELECT House, month, year, username FROM User WHERE House = 'Orchard' and year = 2022 and month = 7 and username like 'a%' ", "SELECT House, month, year, username FROM User WHERE House = 'Orchard', year = 2022 and month = 7, username like 'a%'", "SELECT * FROM User WHERE House = 'Orchard' and year = 2022 and month = 7 and username like 'a%'", "None of the above", 4, topic2);
        Question question21 = new Question("What is an object in Object Oriented Development?", "Objects are instances of a class created with specifically defined data", "Objects are anything that is visible or tangible and its relatively stable in form", "the thing/person that the action is done to", "Object is a collection of properties",1,topic3);
        Question question22 = new Question("How are variables being passed in JAVA", "Pass-by-references", "Pass-by-values", "Pass-away", "Both pass-by-values and references",2,topic3);
        Question question23 = new Question("Which method is for executing a java program", "main()", "execute()", "run()", "start()",1,topic3);
        Question question24 = new Question("What is a constructor", "A block of code which only runs when it is called", "A void method that has no return value", "A special method to initialise objects", "None of the above",3,topic3);
        Question question25 = new Question("What is the 4 pillars of OOD", "Class, Objects, Package, Interface", "Abstraction, Encapsulation, Inheritence, Polymorphism", "Main, Resources, Test, Maven", "None of the above",2,topic3);
        Question question26 = new Question("Which of the following is incorrect?", "You can extend multiple interfaces in Java", "The Final keyword cannot be overridden", "You can have multiple inheritance in java", "All of the above",3,topic3);
        Question question27 = new Question("What are the 4 types of access modifiers in Java", "Private, Normal, Protected, Public", "Private, Default, Protected, Public", "Private, Default, Preserved, Public", "Personal, Default, Protected, Public",2,topic3);
        Question question28 = new Question("How does a class inherit the constructor of its parent class", "By super() method", "By creating a class object", "It is not possible to inherit the constructor of the parent class", "None of the above",1,topic3);
        Question question29 = new Question("What is the purpose of logging?", "A function to enter into a registered user account", "A tool to store the backlog of a Java project", "A function to improve time complexity of methods to O(log n)", "An important feature to record and trace out errors",4,topic3);
        Question question30 = new Question("What is the difference between method overriding and overloading?", "Overriding is a run-time polymorphism but overloading is a compile-time polymorphism", "You can override static method but not overload", "Overloading a method can be done by changing the return type but overriding can only remain as the parent class method", "All of the above",1,topic3);
        questionService.save(question1); 
        questionService.save(question2); 
        questionService.save(question3); 
        questionService.save(question4); 
        questionService.save(question5); 
        questionService.save(question6); 
        questionService.save(question7); 
        questionService.save(question8); 
        questionService.save(question9); 
        questionService.save(question10); 
        questionService.save(question11); 
        questionService.save(question12); 
        questionService.save(question13); 
        questionService.save(question14); 
        questionService.save(question15); 
        questionService.save(question16); 
        questionService.save(question17); 
        questionService.save(question18); 
        questionService.save(question19); 
        questionService.save(question20); 
        questionService.save(question21); 
        questionService.save(question22); 
        questionService.save(question23); 
        questionService.save(question24); 
        questionService.save(question25); 
        questionService.save(question26); 
        questionService.save(question27); 
        questionService.save(question28); 
        questionService.save(question29); 
        questionService.save(question30); 
        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        userService.createUser(user5);
        userService.createUser(user6);
        userService.createUser(user7);
        userService.createUser(user8);
        userService.createUser(user9);
        userService.createUser(user10);
        userService.createUser(user11);
        userService.createUser(user12);
        userService.createUser(user13);
        userService.createUser(user14);
        userService.createUser(user15);
        userService.createUser(user16);
        userService.createUser(user17);
        userService.createUser(user18);
        userService.createUser(user19);
        userService.createUser(user20);
        userService.createUser(user21);
        userService.createUser(user22);
        userService.createUser(user23);
        userService.createUser(user24);
        userService.createUser(user25);
        userService.createUser(user26);
        userService.createUser(user27);
        userService.createUser(user28);
        userService.createUser(user29);
        userService.createUser(user30);
    }
}