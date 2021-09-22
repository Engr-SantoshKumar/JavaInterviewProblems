/**
 * What's the difference between inner join and outer join?
 */
package PrepSetOne;

public class _Goo_55_JavaLanguage_Joins{
/**
     Inner Join
     An inner join focuses on the commonality between two tables.
     When using an inner join,
     there must be at least some matching data between two (or more) tables that are being compared.
     An inner join searches tables for matching or overlapping data.
     Upon finding it, the inner join combines and returns the information into one new table.

     Example of Inner Join
     Let's consider a common scenario of two tables: product prices and quantities.
     The common information in the two tables is product name, so that is the logical column to join the tables on.
     There are some products that are common in the two tables;
     others are unique to one of the tables and don't have a match in the other table.
*/

/*
    Outer Join
    An outer join returns a set of records (or rows) that include what an inner join would return but
    also includes other rows for which no corresponding match is found in the other table.

    There are three types of outer joins:

    Left Outer Join (or Left Join)
    Right Outer Join (or Right Join)
    Full Outer Join (or Full Join)

    Each of these outer joins refers to the part of the data that is being compared, combined, and returned.
    Sometimes nulls will be produced in this process as some data is shared while other data is not.
*/
}
