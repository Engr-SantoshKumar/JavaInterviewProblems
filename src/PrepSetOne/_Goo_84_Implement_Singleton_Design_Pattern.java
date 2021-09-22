/**
 * [ Goo 84 ] [ Implement Singleton Design Pattern ]
 * ____________________________________________________________________________________________________________________
 Singleton pattern is a design pattern which restricts a class to instantiate its multiple objects.
 It is nothing but a way of defining a class. Class is defined in such a way that only one instance of
 the class is created in the complete execution of a program or project. It is used where only a single
 instance of a class is required to control the action throughout the execution. A singleton class shouldn’t have
 multiple instances in any case and at any cost. Singleton classes are used for logging, driver objects,
 caching and thread pool, database connections.

 An implementation of singleton class should have following properties:

 ----> It should have only one instance : This is done by providing an instance of the class from within the class.
    Outer classes or subclasses should be prevented to create the instance. This is done by making the constructor
    private in java so that no class can access the constructor and hence cannot instantiate it.

 ----> Instance should be globally accessible : Instance of singleton class should be globally accessible so
    that each class can use it. In Java, it is done by making the access-specifier of instance public.


         Structure:
         public class SingletonClass {
                private static SingletonClass obj = null;

                // private constructor to force use of getInstance() to create Singleton object
                private SingletonClass() {
                        obj = new SingletonClass();
                }

                public static SingletonClass getInstance() {
                        if (obj == null)
                        obj = new SingletonClass();
                        return obj;
                }
         }


 */
package PrepSetOne;

/*A singleton class should have public visibility
        so that complete application can use */
public class _Goo_84_Implement_Singleton_Design_Pattern {

        /*static instance of class globally accessible */
        public static _Goo_84_Implement_Singleton_Design_Pattern instance =
                new _Goo_84_Implement_Singleton_Design_Pattern();

        private _Goo_84_Implement_Singleton_Design_Pattern() {
            /*private constructor so that class
                cannot be instantiated from outside
                this class

             */
        }
}

/**
        Initialization Types of Singleton

        Singleton class can be instantiated by two methods:
        ---> Early initialization : In this method, class is initialized whether it is to be used or not.
        The main advantage of this method is its simplicity. You initiate the class at the time of class loading.
        Its drawback is that class is always initialized whether it is being used or not.

        ---> Lazy initialization : In this method, class in initialized only when it is required.
        It can save you from instantiating the class when you don’t need it.
        Generally, lazy initialization is used when we create a singleton class.

        Pros:
                Very simple to implement.
        Cons:

                May lead to resource wastage. Because instance of class is created always, whether it is required or not.
                CPU time is also wasted in creation of instance if it is not required.
                Exception handling is not possible.


 more to read: https://www.geeksforgeeks.org/singleton-design-pattern-introduction/

 */