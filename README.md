# FundApps Courier Kata

By Dario Nunez

# Disclaimer
* I went about 10 minutes over the timer (the last bit was too interesting) :)
* I assume the time it took me to write this README is not included in the 2 
hour restriction.
* I didn't get time to implement the discounts feature fully. I have something
that passes the test cases I came up with but it could be incorrect.

# Explanation
* Classes `InputOrder` and `InputParcel` are the way the application takes 
input. I used them in order to save time on parsing something like a JSON 
string.
* Abstract class `Item` represents any entity that can be placed in the items 
list of an `Order`. This can be a `Parcel` or a `Miscellaneous`.
* `Parcel` models an item of type Parcel that contains dimensions, cost, type
and weight. It has methods to determine type and cost given dimensions and 
weight. The logic used is defined in the spec.
* `Miscellaneous` is a simple class that allows other types of items to exist.
* `Order` models a collection of items with some extra properties: cost, 
discount and total cost. They are all deduced from a list of parcels and a type
of delivery.
* `OrderManager` is a simple interface that takes in some input, performs some
computations, and returns an output. Ideally, it would have been tasked with
parsing the input before instantiating Parcels and Orders but in this case it
doesn't have to.
* `ItemType` is an enum that defines all possible types that item objects can 
take.
* `Item` enforces a type and a cost for all items and this allows me to override
the compareTo() method and specify that all items should be sorted only by their
cost.
* `Order` overrides its toString() method to return a string JSON version of 
itself. This makes the output of the application a lot more flexible as JSON is
a standard format. I also used it to check the output in tests. This method not 
only tests the actual output of the program but it also makes it a lot easier 
to test that a list of items is contained in an order. It uses Jackson for all
the JSON goodness.

# My take on the discounts feature
1.  Sort the Parcels in the parcel list in decreasing order.
2.  Move along form the beginning of the list counting how many items of each 
type are seen.
3. Whenever a discount threshold is reached, discount that last element and 
reset all seen counters.
4. Repeat from 2 until reaching the end of the list.

My reasoning is: Because the items go from most to least expensive, saving the
most money will result from discounting as many low index items as possible.

# Improvements and further changes

* A server of some kind so the application can function like an actual API. A 
simple Typescript Express Server would do the trick.
* Add more unit and integration tests to cover more functionality and edge 
cases.
* Add more method and class comments to better describe the code.
* Add property files so all the constants that the application uses can be
dynamically loaded at runtime (costs, weight limits and overweight rates). 
This will make it very easy to edit properties and make the application much
more versatile.
* Improve the way the application takes in information. This solution uses input
classes but ideally, it would be able to parse input as JSON objects in string
format, just like the request an API would receive.
* Spend more time analysing the code specially the discounts feature, to make 
sure it behaves as intended.
