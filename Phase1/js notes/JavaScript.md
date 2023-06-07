# Javascript

Javascript is client side programming language which run inside the browser and specially build for supporting dynamic functionality of the web-sites. like processing data, validating data, performing action based on user input.

technical definition of tell us that Javascript  is  

- client-side

- interpreted

- just-in-time compiled language

- Asynchronous

programming language with **First-class function** and JS is also **prototype based, single threaded, dynamic language**.

## Need of javascript

first and for most it make website more dynamic and for reducing the load on the back-end server.  

To support **Cross -platform application** and adding the new functionality in websites, like -   

- validating data.

- Creating data object.

- dynamic actions.

- adding animation.

- updating content.

- control multimedia.

- creating web based games.

- and many more.

All of these is not possible with only  HTML and CSS.

## Adding JavaScript into html pages

The JavaScript code can be inserted in HTML file by using the HTML `<script>` tag. When an HTML document is loaded with the `<script>` tag in the web browser, the browser processes the content enclosed inside the script tag as JavaScript code.

```html
<!DOCTYPE>
<html>
<head></head>
<body>
    <!-- using internal javascript -->
    <script>
       console.log("hello there!");
    </script>

    <!-- adding file location -->
    <script src="./yourFileName.js"></script>
</body>
</html>
```

### Script tag attributes

There are five attributes of **script** tag

| Attributes | Values                                                                                            | Description                                                                                                             |
| ---------- | ------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| async      | true or false                                                                                     | It specifies whether the script should be executed asynchronously or not.                                               |
| type       | text/ECMAScript, text/javascript, application/ECMAScript , application/javascript,  text/VBScript | It specifies the Multipurpose Internet Mail Extensions (MIME) type of script. Generally, text/javascript value is used. |
| charset    | charset                                                                                           | It specifies the type of character encoding used in the script                                                          |
| defer      | true or false                                                                                     | It specifies whether the browser continues parsing the web page or not.                                                 |
| src        | URL                                                                                               | It specifies the uniform source locator(URL) of a file that contains the script.                                        |

## How to get outputs

As javascript is used inside the webpages so there is few ways to get output. to get output we need to run javascript code inside the browser.

We have few ways to get output like - 

- using `innerHTML` - it will update inner html element text.

- using `document.write()` - it will update Complete webpage, it overwrite everything.

- using `window.alert()` - it will throw alert box on browser screen.

- using `console.log()` - to get output in browser console.

```html
<!DOCTYPE>
<html>
<head></head>
<body>
    <p id="para"></p>
    <!-- using internal javascript -->
    <script>
        document.getElementById("para").innerHTML = "this is example of"
        console.log("hello there!");
        window.alert("this is alert message");
        document.write("this message is from document write");
    </script>

    <!-- adding file location -->
    <script src="./yourFileName.js"></script>
</body>
</html>
```

## Javascript Variables

As we know that JavaScript is used to make webpage dynamic like showing new images, changing its properties. so all of this action can performed on data. this data can be any- type like images, text , number and any user input so to store this type of data we need some type of spaces. and we create space to store our data is called variables. 

We have 4 different way to create variables.

- using let - It have Block scope.

- using var - It have global scope.

- using const - similar to let variable but not assign new value again.

```html
....
    <script>
        var newValue1 = "abc";
        let newValue2 = "xyz";
        console.log(newValue2);
        {
            newValue2 = "oneOone";
            console.log(newValue2);
            console.log(newValue1);
        }
        // valid 
        const newValue3 = "123";
        const newValue4;
        newValue4 = "variable 4";
    </script>
....
```

> **NOTE - Const must used with new Function, Array, Object, RegEx**

### JavaScript Rules for Variable name

The following are some rules need to follow while declaring variables.

- Variable names cannot contain spaces.

- The first letter of the variable can be [a-z, A-Z], dollar sign (`$`) or underscore(`_`), after the first letter of name any digit [0-9] can be used.

- Variable names are case sensitive. For example: `var a` and `var A` both are different.

- We can use either `var` or `let` keyword to define variables.

- We can not use reserved words as the name of the variables in JavaScript.

## JavaScript DataTypes

JavaScript Data types are used to identify the type of data that is stored inside a variable during the script execution. As we have already specified about the Dynamic Typed JavaScript feature so we do not have to specify the data type of the variable while declaring it.

JavaScript broadly supports three types of Data types, they are:

- **Primitive Type** - 
  
  * **String Data Type** -
    
    ```html
    <script>
        var str = "Ferari F60";  // string using double quotes
        var str1 = 'Volvo S60';  // string using single quotes.
    </script>
    ```
  
  * **Boolean Data Type** -
    
    ```html
    <script>
        var isOn = true;  // bulb is on
        var isOn = false;  // bulb is off
    </script>
    ```
  
  * **Number Data Type** -
    
    ```html
    <script>
        var x = 45; // Number without decimal point
        var y = 45.90; // Number with decimal point - floating point
        var z = -10; // Number with negative value
    </script>
    ```

- **Reference Type** -
  
  * **Object data type** - An object data type is used to store the collection of data. Object's properties are written as **key:value** pairs, which are **separated by commas** and **enclosed within curly braces** `{}`.
    
    ```html
    <script>
        var name = { };   // It will create an empty object.
        var emp = {firstname:"ram", lastname:"singh", salary:20000};
    </script>
    ```
  
  * **Array data type** - JavaScript Array data type is written inside a pair of square brackets `[]` and is used to store multiple values of the same datatype be it strings, numbers etc.
    
    ```html
    <script>
        // Creating an Array
        var cars = ["Ferrari", "Volvo", "BMW", "Maseratti"];
    </script>
    ```
  
  * **Function data type** - In JavaScript **functions act as a data type which can be assigned to a variable**. JavaScript Function is nothing but **a set of statement inside a code block** which is used to perform a specific operation and **this datatype is of callable in nature**.
    
    ```html
    <script>
        var welcome = function() {
            return "Welcome to JavaScript!";
        }
    </script>
    ```

- **Special Data Type** - 
  
  * **Undefined Data type** - When a variable is just declared and is not assigned any value, it has **undefined** as its value.
    
    ```html
    <script>
        var a;   // Undefined
        alert(a == undefined);   // returns true
    </script>
    ```
  
  * **Null Data type** - JavaScript Null data type is used to represent no value. It is not similar to undefined, and neither it is similar to empty value or zero value.
    
    ```html
    <script>
        var a = null;
        alert(a);
    </script>
    ```

### JavaScript `typeOf` Operator

The `typeOf` operator in JavaScript can be used to check the data type of any variable.

```html
<script>
    // Function datatype
    var welcome = function() {
         return "Welcome to JavaScript!";
    }

    typeof welcome;    // function

    var a = null;
    typeOf a;   // null

    // Array datatype
    var cars = ["Ferrari", "Volvo", "BMW", "Maseratti"];
    typeof cars;    // array
</script>
```

## JavaScript Numbers

JavaScript have only one type of number that is with decimal or without decimal.

```html
    <script>
        // defining the number 
        let numbr = 12344;
        let othernum = 444.000;
    </script>
```

Number with exponent annotation

```html
    <script>
        // defining the number 
        let numbr = 1234e4;
        let othernum = 444e-3;
    </script>
```

JavaScript numbers are always stored as double precision floating point numbers, following the international IEEE 754 standard.

This format stores numbers in 64 bits, where the number (the fraction) is stored in bits 0 to 51, the exponent in bits 52 to 62, and the sign in bit 63:

| Value (aka Fraction/Mantissa) | Exponent          | Sign       |
| ----------------------------- | ----------------- | ---------- |
| 52 bits (0 - 51)              | 11 bits (52 - 62) | 1 bit (63) |

### NaN - Not a Number

`NaN` is a JavaScript reserved word indicating that a number is not a legal number. and we can use the global JavaScript function `isNaN()` to find out if a value is a not a number:

```html
<script>
    document.getElementById("demo").innerHTML = 100 / "hundred";
    let num = 100 / "hundred";
    isNaN(num);
    typeof NaN;
</script>
```

### Infinity

`Infinity` (or `-Infinity`) is the value JavaScript will return if you calculate a number outside the largest possible number.

```js
let myNumber = 2; 
let txt = "";
while (myNumber != infinity) {
   myNumber = myNumber * myNumber;
   txt = txt + myNumber + "<br>";
}
document.getElementById("demo").innerHTML = txt;
typeof Infinity;
```

### Hexadecimal

JavaScript interprets numeric constants as hexadecimal if they are preceded by 0x. 

```js
let x = 0xEF;
```

By default, JavaScript displays numbers as **base 10** decimals.

But you can use the `toString()` method to output numbers from **base 2** to **base 36**.

```js
let x = 40;
x.toString(35);
x.toString(16);
x.toString(8);
x.toString(2);
```

### Javascript number as objects

Normally javascript number are primitive values, but number can also defined as objects with keyword new.

```js
let num = new Number(1233);
let num1 = 1233;
console.log(typeof num);  
console.log(num == num1);
console.log(num === num1);
```

ES6 also added 2 new methods to the Number object:

- `Number.isInteger()` - The `Number.isInteger()` method returns `true` if the argument is an integer.
- `Number.isSafeInteger()` - A safe integer is an integer that can be exactly represented as a double precision number. The  `isSafeInteger()` method returns `true` if the argument is a safe integer.

```js
Number.isInteger(10);
Number.isInteger(10.5);
Number.isSafeInteger(10);
Number.isSafeInteger(12345678901234567890);
```

Safe integers are all integers from -(253 - 1) to +(253 - 1).  This is safe: 9007199254740991. This is not safe: 9007199254740992.

## JavaScript bigInt

JavaScript `BigInt` variables are used to store big integer values that are too big to be represented by a normal JavaScript `Number`. 

To create a `BigInt`, append n to the end of an integer or call `BigInt()`:

```js
let x = 99999999999999999n;
```

The JavaScript `typeof` a `BigInt` is "bigint":

```js
let x = 99999999999999999n;
console.log(typeof x);
```

Operators that can be used on a JavaScript `Number` can also be used on a `BigInt`. 

## Number methods

There are some method available like

| Method          | Description                                        |
| --------------- | -------------------------------------------------- |
| toString()      | Returns a number as a string                       |
| toExponential() | Returns a number written in exponential notation   |
| toFixed()       | Returns a number written with a number of decimals |
| toPrecision()   | Returns a number written with a specified length   |
| ValueOf()       | Returns a number as a number                       |

### The Exponential Method

`toExponential()` returns a string, with a number rounded and written using exponential notation.

```js
let x = 8.656;
x.toExponential(2);
x.toExponential(4);
x.toExponential(6);
```

### The Fixed Method

`toFixed()` returns a string, with the number written with a specified number of decimals:

```js
let x = 8.656;
x.toFixed(0);
x.toFixed(2);
x.toFixed(4);
x.toFixed(6);
```

### The Precision Method

`toPrecision()` returns a string, with a number written with a specified length:

```js
let x = 8.656;
x.toPrecision();
x.toPrecision(2);
x.toPrecision(4);
x.toPrecision(6);
```

### The valueOf Method

`valueOf()` returns a number as a number.

```js
let x = 123;
x.valueOf();
(123).valueOf();
(100 + 23).valueOf();
```

The `valueOf()` method is used internally in JavaScript to convert Number objects to primitive values.

### Converting Variables to Numbers

There are 3 JavaScript methods that can be used to convert a variable to a number:

| Method       | Description                                             |
| ------------ | ------------------------------------------------------- |
| Number()     | Returns a number converted from its argument.           |
| parseFloat() | Parses its argument and returns a floating point number |
| parseInt()   | Parses its argument and returns a whole number          |

### The Number() Method

The `Number()` method can be used to convert JavaScript variables to numbers:

```js
Number(true);
Number(false);
Number("10");
Number("  10");
Number("10  ");
Number(" 10  ");
Number("10.33");
Number("10,33");
Number("10 33");
Number("John");
```

`Number()` can also convert a date to a number.

```js
Number(new Date("1970-01-01"))
```

### The parseInt Method

`parseInt()` parses a string and returns a whole number. Spaces are allowed. Only the first number is returned:

```js
parseInt("-10");
parseInt("-10.33");
parseInt("10");
parseInt("10.33");
parseInt("10 20 30");
parseInt("10 years");
parseInt("years 10");
```

### The parseFloat() Method

`parseFloat()` parses a string and returns a number. Spaces are allowed. Only the first number is returned:

```js
parseFloat("10");
parseFloat("10.33");
parseFloat("10 20 30");
parseFloat("10 years");
parseFloat("years 10");
```

> **NOTE - in parseInt, parseFloat if the number cannot be converted, `NaN` (Not a Number) is returned.**

## JavaScript Number Properties

Number properties are pre-defined and used to calculate the max, min, and other properties. 

| Property          | Description                                           |
| ----------------- | ----------------------------------------------------- |
| EPSILON           | The difference between 1 and the smallest number > 1. |
| MAX_VALUE         | The largest number possible in JavaScript             |
| MIN_VALUE         | The smallest number possible in JavaScript            |
| MAX_SAFE_INTEGER  | The maximum safe integer (253 - 1)                    |
| MIN_SAFE_INTEGER  | The minimum safe integer -(253 - 1)                   |
| POSITIVE_INFINITY | Infinity (returned on overflow)                       |
| NEGATIVE_INFINITY | Negative infinity (returned on overflow)              |
| NaN               | A "Not-a-Number" value                                |

### JavaScript EPSILON

`Number.EPSILON` is the difference between 1 and the smallest floating point number greater than 1.

```js
let x = Number.EPSILON;
```

> **Note - `Number.EPSILON` is an [ES6](https://www.w3schools.com/js/js_es6.asp) feature. It does not work in Internet Explorer.**

### JavaScript MAX_VALUE

`Number.MAX_VALUE` is a constant representing the largest possible number in JavaScript.

```js
let x = Number.MAX_VALUE;
```

### Number Properties Cannot be Used on Variables

Number properties belong to the JavaScript **Number Object**. These properties can only be accessed as `Number.MAX_VALUE`. Using x.MAX_VALUE, where x is a variable or a value, will return `undefined`:

```js
let x = 6;  
x.MAX_VALUE
```

### JavaScript MIN_VALUE

`Number.MIN_VALUE` is a constant representing the lowest possible number in JavaScript.

```js
let x = Number.MIN_VALUE;
```

### JavaScript MAX_SAFE_INTEGER

`Number.MAX_SAFE_INTEGER` represents the maximum safe integer in JavaScript. `Number.MAX_SAFE_INTEGER` is (253 - 1).

```js
let x = Number.MAX_SAFE_INTEGER;
```

### JavaScript MIN_SAFE_INTEGER

`Number.MIN_SAFE_INTEGER` represents the minimum safe integer in JavaScript. `Number.MIN_SAFE_INTEGER` is -(253 - 1).

```js
let x = Number.MIN_SAFE_INTEGER;
```

> **NOTE -`MAX_SAFE_INTEGER` and `MIN_SAFE_INTEGER` are [ES6](https://www.w3schools.com/js/js_es6.asp) features. They do not work in Internet Explorer.**

### JavaScript POSITIVE_INFINITY

```js
let x = Number.POSITIVE_INFINITY;
```

`POSITIVE_INFINITY` is returned on overflow:

```js
let x = 1 / 0;
```

### JavaScript NEGATIVE_INFINITY

```js
let x = Number.NEGATIVE_INFINITY;
```

`NEGATIVE_INFINITY` is returned on overflow:

```js
let x = -1 / 0;
```

### JavaScript NaN - Not a Number

`NaN` is a JavaScript reserved word for a number that is not a legal number.

```js
let x = Number.NaN;
```

Trying to do arithmetic with a non-numeric string will result in `NaN` (Not a Number):

```js
let x = 100 / "Apple";
```

## JavaScript Strings

A string is generally considered as a data type and is often implemented as an array data structure of bytes (or words) that stores a sequence of elements, typically characters, using some character encoding.

A JavaScript string is zero or more characters written inside quotes. You can use single or double quotes:

```js
let text = "Hollywood";
let s_quotes = 'bollywood';
let d_quotes = "bollywood";
```

You can use quotes inside a string, as long as they don't match the quotes surrounding the string:

```js
let answer1 = "It's alright";
let answer2 = "He is called 'mohit'";
let answer3 = 'He is called "shorav"';
```

### String Length

To find the length of a string, use the built-in `length` property:

```js
let text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
let length = text.length;
```

### Escape Character

Because strings must be written within quotes, JavaScript will misunderstand this string:

```js
let text = "Game of Thrones, "Winter is Coming"!";
```

The string will be chopped to "Game of Thrones, ". The solution to avoid this problem, is to use the **backslash escape character**. The backslash (`\`) escape character turns special characters into string characters:

| Code | Result | Description  |
| ---- | ------ | ------------ |
| \'   | '      | Single quote |
| \"   | "      | Double quote |
| \\   | \      | Backslash    |

```js
let text = "Game of Thrones, \"Winter is Coming\"!";
```

Six other escape sequences are valid in JavaScript:

| Code | Result               |
| ---- | -------------------- |
| \b   | Backspace            |
| \f   | Form Feed            |
| \n   | New Line             |
| \r   | Carriage Return      |
| \t   | Horizontal Tabulator |
| \v   | Vertical Tabulator   |

The 6 escape characters above were originally designed to control typewriters, teletypes, and fax machines. They do not make any sense in HTML.

### Breaking Long Code Lines

For best readability, programmers often like to avoid code lines longer than 80 characters. If a JavaScript statement does not fit on one line, the best place to break it is after an operator:

```js
document.getElementById("demo").innerHTML = "Hello " +
"    Dolly!";
```

### JavaScript Strings as Objects

Normally, JavaScript strings are primitive values, created from literals:

```js
let x = "John";  
```

But strings can also be defined as objects with the keyword `new`:

```js
let y = new String("John");
```

```js
let x = "John";  
let y = new String("John");  
```

Do not create Strings objects. The `new` keyword complicates the code and slows down execution speed. string objects can produce unexpected results:

When using the `==` operator, x and y are **equal**:

```js
let x = "John";  
let y = new String("John");
```

When using the `===` operator, x and y are **not equal**:

```js
let x = "John";  
let y = new String("John");
```

Note the difference between `(x==y)` and `(x===y)`.

`(x == y)` true or false?

```js
let x = new String("John");  
let y = new String("John");
```

`(x === y)` true or false?

```js
let x = new String("John");  
let y = new String("John");
```

> **NOTE** - Comparing two JavaScript objects **always** returns **false**.

## JavaScript String Methods

String methods are support common function so that we can manipulate string easily and no requirement to create new method for those functions like slicing string.

### JavaScript String Length

The `length` property returns the length of a string:

```js
let text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
let length = text.length;
```

### Extracting String Parts

There are 3 methods for extracting a part of a string:

- `slice(*start*, *end*)`
- `substring(*start*, *end*)`
- `substr(*start*, *length*)`

#### JavaScript String slice()

`slice()` extracts a part of a string and returns the extracted part in a new string. The method takes 2 parameters: start position, and end position (end not included).

Slice out a portion of a string from position 7 to position 13:

```js
let text = "Apple, Banana, Kiwi";  
let part = text.slice(7, 13);
```

>  **Note** - JavaScript counts positions from zero. 

If you omit the second parameter, the method will slice out the rest of the string:

```js
let text = "Apple, Banana, Kiwi";  
let part = text.slice(7);
```

If a parameter is negative, the position is counted from the end of the string:

```js
let text = "Apple, Banana, Kiwi";  
let part = text.slice(-12);
```

This example slices out a portion of a string from position -12 to position -6:

```js
let text = "Apple, Banana, Kiwi";  
let part = text.slice(-12, -6);
```

#### JavaScript String substring()

`substring()` is similar to `slice()`. The difference is that start and end values less than 0 are treated as 0 in `substring()`.

```js
let str = "Apple, Banana, Kiwi";  
let part = str.substring(7, 13);
```

If you omit the second parameter, `substring()` will slice out the rest of the string.

#### JavaScript String substr()

`substr()` is similar to `slice()`. The difference is that the second parameter specifies the **length** of the extracted part.

```js
let str = "Apple, Banana, Kiwi";  
let part = str.substr(7, 6);
```

If you omit the second parameter, `substr()` will slice out the rest of the string.

```js
let str = "Apple, Banana, Kiwi";  
let part = str.substr(7);
```

If the first parameter is negative, the position counts from the end of the string.

```js
let str = "Apple, Banana, Kiwi";  
let part = str.substr(-4);
```

### Replacing String Content

The `replace()` method replaces a specified value with another value in a string:

```js
let text = "Please visit Microsoft!";  
let newText = text.replace("Microsoft", "W3Schools");  
```

**Note** - 

The `replace()` method does not change the string it is called on.

The `replace()` method returns a new string.

The `replace()` method replaces **only the first** match

If you want to replace all matches, use a regular expression with the /g flag set. See examples below.

By default, the `replace()` method replaces **only the first** match:

```js
let text = "Please visit Microsoft and Microsoft!";  
let newText = text.replace("Microsoft", "W3Schools");  
```

By default, the `replace()` method is case sensitive. Writing MICROSOFT (with upper-case) will not work:

```js
let text = "Please visit Microsoft!";  
let newText = text.replace("MICROSOFT", "W3Schools");  
```

To replace case insensitive, use a **regular expression** with an `/i` flag (insensitive):

```js
let text = "Please visit Microsoft!";  
let newText = text.replace(/MICROSOFT/i, "W3Schools");  
```

> **NOTE** - Regular expressions are written without quotes. To replace all matches, use a **regular expression** with a `/g` flag (global match):

```js
let text = "Please visit Microsoft and Microsoft!";  
let newText = text.replace(/Microsoft/g, "W3Schools");  
```

> **NOTE** - You will learn a lot more about regular expressions in the chapter JavaScript Regular Expressions.

#### JavaScript String ReplaceAll()

In 2021, JavaScript introduced the string method `replaceAll()`:

```js
text = text.replaceAll("Cats","Dogs");  
text = text.replaceAll("cats","dogs");
```

The `replaceAll()` method allows you to specify a regular expression instead of a string to be replaced. If the parameter is a regular expression, the global flag (g) must be set set, otherwise
a TypeError is thrown.

```js
text = text.replaceAll(/Cats/g,"Dogs");  
text = text.replaceAll(/cats/g,"dogs");  
```

> **Note** - `replaceAll()` is an [ES2021](https://www.w3schools.com/js/js_2021.asp) feature. `replaceAll()` does not work in Internet Explorer.

### Converting to Upper and Lower Case

A string is converted to upper case with `toUpperCase()`:

A string is converted to lower case with `toLowerCase()`:

#### JavaScript String toUpperCase()

```js
let text1 = "Hello World!";  
let text2 = text1.toUpperCase();
```

#### JavaScript String toLowerCase()

```js
let text1 = "Hello World!";       // String  
let text2 = text1.toLowerCase();  // text2 is text1 
```

### JavaScript String concat()

`concat()` joins two or more strings:

```js
let text1 = "Hello";  
let text2 = "World";  
let text3 = text1.concat(" ", text2);
```

The `concat()` method can be used instead of the plus operator. These two lines do the same:

```js
text = "Hello" + " " + "World!";  
text = "Hello".concat(" ", "World!");
```

> **Note** - All string methods return a new string. They don't modify the original string. Formally said: Strings are immutable: Strings cannot be changed, only replaced.

### JavaScript String trim()

The `trim()` method removes whitespace from both sides of a string:

```js
let text1 = "      Hello World!      ";  
let text2 = text1.trim();
```

### JavaScript String trimStart()

ECMAScript 2019 added the String method `trimStart()` to JavaScript. The `trimStart()` method works like `trim()`, but removes whitespace only from the start of a string.

```js
let text1 = "     Hello World!     ";  
let text2 = text1.trimStart();
```

JavaScript String `trimStart()` is supported in all browsers since January 2020:

### JavaScript String trimEnd()

ECMAScript 2019 added the String method `trimEnd()` to JavaScript.

The `trimEnd()` method works like `trim()`, but removes whitespace only from the end of a string.

```js
let text1 = "     Hello World!     ";
let text2 = text1.trimEnd();
```

### JavaScript String Padding

ECMAScript 2017 added two String methods: `padStart()` and `padEnd()` to support padding at the beginning and at the end of a string.

### JavaScript String padStart()

The `padStart()` method pads a string with another string:

```js
let text = "5";  
let padded = text.padStart(4,"x");

let text = "5";  
let padded = text.padStart(4,"0");Note
```

The `padStart()` method is a string method. To pad a number, convert the number to a string first.

```js
let numb = 5;  
let text = numb.toString();  
let padded = text.padStart(4,"0");
```

### JavaScript String padEnd()

The `padEnd()` method pads a string with another string:

```js
let text = "5";  
let padded = text.padEnd(4,"x");

let text = "5";  
let padded = text.padEnd(4,"0");
```

**Note** - The `padEnd()` method is a string method. To pad a number, convert the number to a string first.

```js
let numb = 5;  
let text = numb.toString();  
let padded = text.padEnd(4,"0"); 
```

### Browser Support

`padStart()` and `padEnd()` is an ECMAScript 2017 feature. It is supported in all modern browsers, it is not supported in Internet Explorer. 

### Extracting String Characters

There are 3 methods for extracting string characters:

- `charAt(*position*)`
- `charCodeAt(*position*)`
- Property access [ ]

#### JavaScript String charAt()

The `charAt()` method returns the character at a specified 
index (position) in a string:

```js
let text = "HELLO WORLD";  
let char = text.charAt(0);
```

#### JavaScript String charCodeAt()

The `charCodeAt()` method returns the unicode of the character at a specified index in a string, The method returns a UTF-16 code (an integer between 0 and 65535).

```js
let text = "HELLO WORLD";  
let char = text.charCodeAt(0);
```

#### Property Access

ECMAScript 5 (2009) allows property access [ ] on strings:

```js
let text = "HELLO WORLD";  
let char = text[0];
```

> **Note** - Property access might be a little **unpredictable:**
> 
> - It makes strings look like arrays (but they are not)
> - If no character is found, [ ] returns undefined, while charAt() returns an empty string.
> - It is read only. str[0] = "A" gives no error (but does not work!)

```js
let text = "HELLO WORLD";  
text[0] = "A";    // Gives no error, but does not work
```

### Converting a String to an Array

If you want to work with a string as an array, you can convert it to an array.

#### JavaScript String split()

A string can be converted to an array with the `split()` method:

```js
text.split(",")    // Split on commas  
text.split(" ")    // Split on spaces  
text.split("|")    // Split on pipe
```

If the separator is omitted, the returned array will contain the whole string in index [0].

If the separator is "", the returned array will be an array of single characters:

```js
text.split("")
```

## JavaScript Search Methods

In javascript 

### JavaScript String indexOf()

The `indexOf()` method returns the index of (position of) the **first** occurrence of a string in a string:

```js
let str = "Please locate where 'locate' occurs!";  
str.indexOf("locate");
```

> **Note** - JavaScript counts positions from zero.
> 
> 0 is the first position in a string, 1 is the second, 2 is the third, ...

### JavaScript String lastIndexOf()

The `lastIndexOf()` method returns the index of the **last** occurrence of a specified text in a string:

```js
let text = "Please locate where 'locate' occurs!";  
text.lastIndexOf("locate");
```

Both `indexOf()`, and `lastIndexOf()` return -1 if the text is not found:

```js
let text = "Please locate where 'locate' occurs!";  
text.lastIndexOf("John");
```

Both methods accept a second parameter as the starting position for the search:

```js
let text = "Please locate where 'locate' occurs!";  
text.indexOf("locate", 15);
```

The `lastIndexOf()` methods searches backwards (from the end to the beginning), meaning:
if the second parameter is `15`, the search starts at position 15, and searches to the beginning of the string.

```js
let text = "Please locate where 'locate' occurs!";  
text.lastIndexOf("locate", 15);
```

### JavaScript String search()

The `search()` method searches a string for a string (or a regular expression) and returns the position of the match:

```js
let str = "Please locate where 'locate' occurs!";  
str.search("locate");

let str = "Please locate where 'locate' occurs!";  
str.search(/locate/);
```

### Did You Notice?

The two methods, `indexOf()` and `search()`, are **equal?** They accept the same arguments (parameters), and return the same value?

The two methods are **NOT** equal. These are the differences:

- The `search()` method cannot take a second start position argument.
- The `indexOf()` method cannot take 
  powerful search values (regular expressions).

### JavaScript String match()

The `match()` method returns an array containing the results of matching a string against a string (or a regular expression).

Perform a search for "ain":

```js
let text = "The rain in SPAIN stays mainly in the plain";  
text.match("ain");
```

Perform a search for "ain":

```js
let text = "The rain in SPAIN stays mainly in the plain";  
text.match(/ain/);
```

Perform a global search for "ain":

```js
let text = "The rain in SPAIN stays mainly in the plain";  
text.match(/ain/g);
```

Perform a global, case-insensitive search for "ain":

```js
let text = "The rain in SPAIN stays mainly in the plain";  
text.match(/ain/gi);
```

> **Note** - If a regular expression does not include the *g* modifier (global search), `match()` will return only the first match in the string.

### JavaScript String matchAll()

The `matchAll()` method returns an iterator containing the results of matching a string against a string (or a regular expression).

```js
const iterator = text.matchAll("Cats");  
```

If the parameter is a regular expression, the global flag (g) must be set, otherwise a TypeError is thrown.

```js
const iterator = text.matchAll(/Cats/g);  
```

If you want to search case insensitive, the insensitive flag (i) must be set:

```js
const iterator = text.matchAll(/Cats/gi);  
```

> **Notes** - `matchAll()` is an [ES2020](https://www.w3schools.com/js/js_2020.asp) feature. `matchAll()` does not work in Internet Explorer.

### JavaScript String includes()

The `includes()` method returns true if a string contains a specified value. Otherwise it returns `false`. Check if a string includes "world":

```js
let text = "Hello world, welcome to the universe.";  
text.includes("world");
```

Check if a string includes "world". Start at position 12:

```js

```

> **Notes** - 
> 
> `includes()` is case sensitive.
> 
> `includes()` is an [ES6 feature](https://www.w3schools.com/js/js_es6.asp).
> 
> `includes()` is not supported in Internet Explorer.

### JavaScript String startsWith()

The `startsWith()` method returns `true` if a string begins with a specified value. Otherwise it returns `false`:

Returns true:

```js
let text = "Hello world, welcome to the universe.";  
text.startsWith("Hello");
```

Returns false:

```js
let text = "Hello world, welcome to the universe.";  
text.startsWith("world")
```

A start position for the search can be specified:

Returns false:

```js
let text = "Hello world, welcome to the universe.";  
text.startsWith("world", 5)
```

Returns true:

```js
let text = "Hello world, welcome to the universe.";  
text.startsWith("world", 6)
```

> **Notes** - 
> 
> `startsWith()` is case sensitive.
> 
> `startsWith()` is an [ES6 feature](https://www.w3schools.com/js/js_es6.asp).
> 
> `startsWith()` is not supported in Internet Explorer.

### JavaScript String endsWith()

The `endsWith()` method returns `true` if a string ends with a specified value. Otherwise it returns `false`:

Check if a string ends with "Doe":

```js
let text = "John Doe";  
text.endsWith("Doe");
```

Check if the 11 first characters of a string ends with "world":

```js
let text = "Hello world, welcome to the universe.";  
text.endsWith("world", 11);
```

> **Notes** - 
> 
> `endsWith()` is case sensitive.
> 
> `endsWith()` is an [ES6 feature](https://www.w3schools.com/js/js_es6.asp).
> 
> `endsWith()` is not supported in Internet Explorer.
