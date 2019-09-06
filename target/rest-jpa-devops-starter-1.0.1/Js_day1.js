/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Function Declaration
       //Observe: no return type, no type on parameters
function add(n1, n2){
   return n1 +n2;
}

//Function Expression
var sub = function(n1,n2){
  return n1 - n2
} 

//Callback example
var cb = function(n1,n2, callback){
  return "Result from the two numbers: "+n1+"+"+n2+"="+callback(n1,n2);
};

console.log( add(1,2) )     // What will this print?                                3
console.log( add )          // What will it print and what does add represent?      Function: add
console.log( add(1,2,3) ) ; // What will it print                                   3
console.log( add(1) );	  // What will it print                                     NaN Not a number
console.log( cb(3,3,add) ); // What will it print                                   Result from the two numbers: 3+3=6
//console.log( cb(4,3,sub) ); // What will it print                                   Result from the two numbers: 4+3=1
//console.log(cb(3,3,add())); // What will it print (and what was the problem)        Uncaught TypeError: callback is not a function
console.log(cb(3,"hh",add));// What will it print                                   Result from the two numbers: 3+hh=3hh
//try {
//  throw new Error('Whoops!');
//} catch (e) {
//  console.log(cb(3,"hh",add)
//  }
  
//let name = [emil,sara,tessi]
//name.forEach(console.log())


// The JavaScript Array

//a
var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];
console.log(boys.concat(girls));
//b
var all = boys.concat(girls);
console.log(all);
//c
var string = all.join();
console.log(string);
var string = all.join('-');
console.log(string);
//d
all.push("Lone","Gitte")
console.log(all);
//e
all.unshift("Hans","Kurt")
console.log(all);
//f
all.shift("Hans")
console.log(all);
//g
all.pop("Gitte")
console.log(all);
//h
all.splice(4,2);
console.log(all);
//i
all.reverse();
console.log(all);
//j
all.sort();
console.log(all);
//k no

//l
var uppers = all.map(function(UpperCase) { return UpperCase.toUpperCase(); });
console.log(uppers);
//m
var gatekeeper = all.filter(function(letter) {  
    return letter[0] === "L" || letter[0] === "I"; });
console.log(gatekeeper);



//Dynamic UI manipulation using data obtained via fetch
let url = "https://jsonplaceholder.typicode.com/users/" + ID-FROM-INPUT

fetch(url)
  .then(res => res.json()) //in flow1, just do it
  .then(data => {
   // Inside this callback, and only here, the response data is available
   console.log("data",data);
  /* data now contains the response, converted to JavaScript
     Observe the output from the log-output above
     Now, just build your DOM changes using the data*/       
})

//document.getElementById(fetch).value = "Johnny Bravo";
var x = document.getElementById("myText");
<button onclick="fetch()">Get User</button>
<button onclick="fetch()">Get All</button>
let data = fetch(function(UpperCase) { return UpperCase.toUpperCase(); });
console.log(data);

var uppers = all.map(function(UpperCase) { return UpperCase.toUpperCase(); });
console.log(uppers);


