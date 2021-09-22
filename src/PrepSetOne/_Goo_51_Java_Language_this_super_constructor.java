/*
"Java
Can you call both this() and super() from a constructor?
Is this a valid hashcode method?
public int hashCode() {
  return (int) System.currentTimeMillis();
}
"

 */
package PrepSetOne;

public class _Goo_51_Java_Language_this_super_constructor extends myClass{


    /**Can you call both this() and super() from a constructor? **/

    /**
     * NO.
     * Constructor must always be the first statement
     * super() calls the base class constructor & this() calls the current class constructor.
     * we can not have two statements as first statement, so we either need to call super() or this() but not the both.
     */

    // There is a difference between super() and this() .
    /*Constructor must always be the first statement. SO we can not have two statements as first statement,
      hence either we can call super() or we can call this() from the constructor, but not both*/

      /**
              this(...)
         -- > will call another constructor in the same class whereas super() will call a super constructor.
              If there is no super() in a constructor the compiler will add one implicitly.

         --->  thus if both were allowed you could end up calling the super constructor twice.

         --->  Both this() and super() are constructor calls, and constructor call must be the first (and only first)
               call in a constructor. Otherwise, the Object constructor will be called more than once
               when instantiating a single object.

       **/

      /*  Q. Is this a valid hashcode method?
          public int hashCode() {
            return (int) System.currentTimeMillis();*/

    /**
     A.  Java hashCode()
        Java Object hashCode() is a native method and returns the integer hash code value of the object.
        The general contract of hashCode() method is:
        ----> Multiple invocations of hashCode() should return the same integer value,
                unless the object property is modified that is being used in the equals() method.
        ----> An object hash code value can change in multiple executions of the same application.
        ----> If two objects are equal according to equals() method, then their hash code must be same.
        ----> If two objects are unequal according to equals() method, their hash code are not required to be different.
                Their hash code value may or may-not be equal.

     Is this a valid hashcode method?
        Ans: No this is not a valid method, if we not convert (int) System.currentTimeMillis() to integer value
            also, if we keep assigning currentTime(KEY) to each value it will create N size of hashmap which will
            decrease the performance

     */


   public _Goo_51_Java_Language_this_super_constructor() {
       //this();  //Call to 'this()' must be the first statement in constructor body
       // super(); // Call to 'super()' must be the first statement in constructor body
       System.out.println("I am inside constructor");

       //super(); --> error
       //this();  --> error
    }

    public _Goo_51_Java_Language_this_super_constructor(int value) {
        this();  // calling line 67: _Goo_51_Java_Language_this_super_constructor
        // super(); // Call to 'super()' must be the first statement in constructor body
        System.out.println("I am inside constructor");
        //super(); --> error
        //this();  --> error
    }

    public void thisKeyWordTest(){
       //this();
    }


    public static void main(String[] args) {
        _Goo_51_Java_Language_this_super_constructor my = new _Goo_51_Java_Language_this_super_constructor();
        //this();
    }
}

class myClass{
    public myClass(){
        System.out.println("I am inside myClass");
    }
}


