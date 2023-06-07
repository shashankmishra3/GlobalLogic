## Browser environment

A platform may be a browser, or a web-server or another *host*,  if it can run JavaScript. Each of these provides platform-specific functionality. The JavaScript specification calls that a *host environment*.

A host environment provides its own objects and functions in addition to the language core. Web browsers give a means to control web pages. 

![](/home/zarikoo/trainings/JS/images/Screenshot_2023-02-20_19-18-08.png)

There’s a “root” object called `window`. It has two roles:

1. First, it is a global object for JavaScript code.
2. Second, it represents the “browser window” and provides methods to control it.

```js
function sayHi() {
  console.log("Hello");
}

// global functions are methods of the global object:
window.sayHi();
```

### DOM (Document object model)

It represents all page content as objects that can be modified. The `document` object is the main “entry point” to the page. We can change or create anything on the page using it.

```js
// change the background color to red
document.body.style.background = "red";
```

### BOM (Browser Object Model)

The Browser Object Model (BOM) represents additional objects provided by the browser (host environment) for working with everything except the document.

For instance:

- The [navigator](https://developer.mozilla.org/en-US/docs/Web/API/Window/navigator) object provides background information about the browser and the operating system. There are many properties, but the two most widely known are: `navigator.userAgent` – about the current browser, and `navigator.platform` – about the platform (can help to differentiate between Windows/Linux/Mac etc).
- The [location](https://developer.mozilla.org/en-US/docs/Web/API/Window/location) object allows us to read the current URL and can redirect the browser to a new one.

The functions `alert/confirm/prompt` are also a part of the BOM: they are not directly related to the document, but represent pure browser methods for communicating with the user.

### DOM tree

The backbone of an HTML document is tags.

According to the Document Object Model (DOM), every HTML tag is an object. Nested tags are “children” of the enclosing one. The text inside a tag is an object as well. All these objects are accessible using JavaScript, and we can use them to modify the page. For example, `document.body` is the object representing the `<body>` tag.

```js
document.body.style.backgroud = 'red';
```

Example 

```html
<!DOCTYPE HTML>
<html>
<head>
  <title>My home page</title>
</head>
<body>
  <h1>My home page</h1>
  <p>Hello I am vikas</p>
  <p>I also wrote ...<a href="#">here</a></p>
</body>
</html>
```

The DOM represents HTML as a tree structure of tags.

![](/home/zarikoo/trainings/JS/images/html-tree.svg)

### Autocorrection

If the browser encounters malformed HTML, it automatically corrects it when making the DOM.

For instance, the top tag is always `<html>`. Even if it doesn’t exist in the document, it will exist in the DOM, because the browser will create it. The same goes for `<body>`.

### Nodes

In the context of the [DOM](https://developer.mozilla.org/en-US/docs/Glossary/DOM), a **node** is a single point in the node tree. Various things that are nodes are the document itself, elements, text, and comments.

## Searching: getElement*, querySelector*

The search methods for get elements.

### document.getElementById

If an element has the `id` attribute, we can get the element using the method `document.getElementById(id)`

```js
<div id="elem">
  <div id="elem-content">Element</div>
</div>

<script>
  // get the element
  let elem = document.getElementById('elem');

  // make its background red
  elem.style.background = 'red';
</script>
```

 there’s a global variable named by `id` that references the element:

```js
<div id="elem">
  <div id="elem-content">Element</div>
</div>

<script>
  // elem is a reference to DOM-element with id="elem"
  elem.style.background = 'red';

  // id="elem-content" has a hyphen inside, so it can't be a variable name
  // ...but we can access it using square brackets: window['elem-content']
</script>
```

That’s unless we declare a JavaScript variable with the same name, then it takes precedence:

```js
<div id="elem"></div>

<script>
  let elem = 6; // now elem is 6, not a reference to <div id="elem">

  console.log(elem); // 6
</script>
```

### querySelectorAll

 the most versatile method, `elem.querySelectorAll(css)` returns all elements inside `elem` matching the given CSS selector.

```html
<ul>
  <li>The</li>
  <li>test</li>
</ul>
<ul>
  <li>has</li>
  <li>passed</li>
</ul>
<script>
  let elements = document.querySelectorAll('ul > li:last-child');

   c

  for (let elem of elements) {
    console.log(elem.innerHTML); // "test", "passed"
  }
</script>
```

### querySelector

The call to `elem.querySelector(css)` returns the first element for the given CSS selector.

```js
let newEle = document.querySelector('#param');
console.log(newEle.innerHTML);
```

### matches

The [elem.matches(css)](https://dom.spec.whatwg.org/#dom-element-matches) does not look for anything, it merely checks if `elem` matches the given CSS-selector. It returns `true` or `false`.

```js
<a href="http://example.com/file.zip">...</a>
<a href="http://ya.ru">...</a>

<script>
  // can be any collection instead of document.body.children
  for (let elem of document.body.children) {
    if (elem.matches('a[href$="zip"]')) {
      console.log("The archive reference: " + elem.href );
    }
  }
</script>
```

### closest

*Ancestors* of an element are: parent, the parent of parent, its parent and so on. The ancestors together form the chain of parents from the element to the top. The method `elem.closest(css)` looks for the nearest ancestor that matches the CSS-selector. The `elem` itself is also included in the search. 

```js
<h1>Contents</h1>

<div class="contents">
  <ul class="book">
    <li class="chapter">Chapter 1</li>
    <li class="chapter">Chapter 2</li>
  </ul>
</div>

<script>
  let chapter = document.querySelector('.chapter'); // LI

  console.log(chapter.closest('.book')); // UL
  console.log(chapter.closest('.contents')); // DIV

  console.log(chapter.closest('h1')); // null (because h1 is not an ancestor)
</script>    
```

### getElementsBy*

There are also other methods to look for nodes by a tag, class, etc.

- `elem.getElementsByTagName(tag)` looks for elements with the given tag and returns the collection of them. The `tag` parameter can also be a star `"*"` for “any tags”.
- `elem.getElementsByClassName(className)` returns elements that have the given CSS class.
- `document.getElementsByName(name)` returns elements with the given `name` attribute, document-wide. Very rarely used.

```js
// get all divs in the document
let divs = document.getElementsByTagName('div');


<table id="table">
  <tr>
    <td>Your age:</td>
    <td>
      <label>
        <input type="radio" name="age" value="young" checked> less than 18
      </label>
      <label>
        <input type="radio" name="age" value="mature"> from 18 to 50
      </label>
      <label>
        <input type="radio" name="age" value="senior"> more than 60
      </label>
    </td>
  </tr>
</table>

<script>
  let inputs = table.getElementsByTagName('input');

  for (let input of inputs) {
     console.log( input.value + ': ' + input.checked );
  }
</script>


<form name="my-form">
  <div class="article">Article</div>
  <div class="long article">Long article</div>
</form>

<script>
  // find by name attribute
  let form = document.getElementsByName('my-form')[0];

  // find by class inside the form
  let articles = form.getElementsByClassName('article');
   console.log(articles.length); // 2, found two elements with class "article"
</script>
```

### Live collections

All methods `"getElementsBy*"` return a *live* collection. Such collections always reflect the current state of the document and “auto-update” when it changes.

```js
<div>First div</div>

<script>
  let divs = document.getElementsByTagName('div');
   console.log(divs.length); // 1
</script>

<div>Second div</div>

<script>
   console.log(divs.length); // 2
</script>
```

In contrast, `querySelectorAll` returns a *static* collection. It’s like a fixed array of elements.

```js
<div>First div</div>

<script>
  let divs = document.querySelectorAll('div');
   console.log(divs.length); // 1
</script>

<div>Second div</div>

<script>
   console.log(divs.length); // 1
</script>
```

There are 6 main methods to search for nodes in DOM:

| Method                 | Searches by... | Can call on an element? | Live? |
| ---------------------- | -------------- | ----------------------- | ----- |
| querySelector          | CSS-selector   | true                    | -     |
| querySelectorAll       | CSS-selector   | true                    | -     |
| getElementById         | id             | -                       | -     |
| getElementsByName      | name           | -                       | true  |
| getElementsByTagName   | tag or '*'     | true                    | true  |
| getElementsByClassName | class          | true                    | true  |

## Node properties: type, tag and contents

### DOM node classes

Different DOM nodes may have different properties. For instance, an element node corresponding to tag `<a>` has link-related properties, and the one corresponding to `<input>` has input-related properties and so on. Text nodes are not the same as element nodes. But there are also common properties and methods between all of them, because all classes of DOM nodes form a single hierarchy.

The root of the hierarchy is [EventTarget](https://dom.spec.whatwg.org/#eventtarget), that is inherited by [Node](https://dom.spec.whatwg.org/#interface-node), and other DOM nodes inherit from it.

![](/home/zarikoo/trainings/JS/images/Screenshot_2023-02-20_23-38-33.png)

The classes are:

- [EventTarget](https://dom.spec.whatwg.org/#eventtarget) – is the root “abstract” class for everything.
  
  Objects of that class are never created. It serves as a base, so that all DOM nodes support so-called “events”.

- [Node](https://dom.spec.whatwg.org/#interface-node) – is also an “abstract” class, serving as a base for DOM nodes.
  
  It provides the core tree functionality: `parentNode`, `nextSibling`, `childNodes` and so on (they are getters). Objects of `Node` class are never created. But there are other classes that inherit from it (and so inherit the `Node` functionality).

- [Document](https://dom.spec.whatwg.org/#interface-document), for historical reasons often inherited by `HTMLDocument` (though the latest spec doesn’t dictate it) – is a document as a whole.
  
  The `document` global object belongs exactly to this class. It serves as an entry point to the DOM.

- [CharacterData](https://dom.spec.whatwg.org/#interface-characterdata) – an “abstract” class, inherited by:
  
  - [Text](https://dom.spec.whatwg.org/#interface-text) – the class corresponding to a text inside elements, e.g. `Hello` in `<p>Hello</p>`.
  - [Comment](https://dom.spec.whatwg.org/#interface-comment) – the class for comments. They are not shown, but each comment becomes a member of DOM.

- [Element](https://dom.spec.whatwg.org/#interface-element) – is the base class for DOM elements.
  
  It provides element-level navigation like `nextElementSibling`, `children` and searching methods like `getElementsByTagName`, `querySelector`.
  
  A browser supports not only HTML, but also XML and SVG. So the `Element` class serves as a base for more specific classes: `SVGElement`, `XMLElement` and `HTMLElement`.

- Finally, [HTMLElement](https://html.spec.whatwg.org/multipage/dom.html#htmlelement) is the basic class for all HTML elements. We’ll work with it most of the time.
  
  It is inherited by concrete HTML elements:
  
  - [HTMLInputElement](https://html.spec.whatwg.org/multipage/forms.html#htmlinputelement) – the class for `<input>` elements,
  - [HTMLBodyElement](https://html.spec.whatwg.org/multipage/semantics.html#htmlbodyelement) – the class for `<body>` elements,
  - [HTMLAnchorElement](https://html.spec.whatwg.org/multipage/semantics.html#htmlanchorelement) – the class for `<a>` elements,
  - …and so on.

There are many other tags with their own classes that may have specific properties and methods, while some elements, such as `<span>`, `<section>`, `<article>` do not have any specific properties, so they are instances of `HTMLElement` class.

So, the full set of properties and methods of a given node comes as the result of the chain of inheritance.

let’s consider the DOM object for an `<input>` element. It belongs to [HTMLInputElement](https://html.spec.whatwg.org/multipage/forms.html#htmlinputelement) class.

It gets properties and methods as a superposition of (listed in inheritance order):

- `HTMLInputElement` – this class provides input-specific properties,
- `HTMLElement` – it provides common HTML element methods (and getters/setters),
- `Element` – provides generic element methods,
- `Node` – provides common DOM node properties,
- `EventTarget` – gives the support for events,
- finally it inherits from `Object`, so “plain object” methods like `hasOwnProperty` are also available.

To see the DOM node class name, we can recall that an object usually has the `constructor` property. It references the class constructor, and `constructor.name` is its name:

```js
console.log(document.body.constructor.name)
```

We also can use `instanceof` to check the inheritance:

```js
 console.log( document.body instanceof HTMLBodyElement ); // true
 console.log( document.body instanceof HTMLElement ); // true
 console.log( document.body instanceof Element ); // true
 console.log( document.body instanceof Node ); // true
 console.log( document.body instanceof EventTarget ); // true
```

That’s also easy to see by outputting an element with `console.dir(elem)` in a browser. There in the console you can see `HTMLElement.prototype`, `Element.prototype` and so on.

#### `console.dir(elem)` versus `console.log(elem)`

Most browsers support two commands in their developer tools: `console.log` and `console.dir`. They output their arguments to the console. For JavaScript objects these commands usually do the same.

But for DOM elements they are different:

- `console.log(elem)` shows the element DOM tree.
- `console.dir(elem)` shows the element as a DOM object, good to explore its properties.

### The “nodeType” property

The `nodeType` property provides one more, “old-fashioned” way to get the “type” of a DOM node.

It has a numeric value:

- `elem.nodeType == 1` for element nodes,
- `elem.nodeType == 3` for text nodes,
- `elem.nodeType == 9` for the document object,
- there are few other values in [the specification](https://dom.spec.whatwg.org/#node).

```js
<body>
  <script>
  let elem = document.body;

  // let's examine: what type of node is in elem?
   console.log(elem.nodeType); // 1 => element

  // and its first child is...
   console.log(elem.firstChild.nodeType); // 3 => text

  // for the document object, the type is 9
   console.log( document.nodeType ); // 9
  </script>
</body>
```

### Tag: nodeName and tagName

Given a DOM node, we can read its tag name from `nodeName` or `tagName` properties:

```js
 console.log( document.body.nodeName ); // BODY
 console.log( document.body.tagName ); // BODY
```

Is there any difference between `tagName` and `nodeName`?

Sure, the difference is reflected in their names, but is indeed a bit subtle.

- The `tagName` property exists only for `Element` nodes.
- The `nodeName` is defined for any `Node`:
  - for elements it means the same as `tagName`.
  - for other node types (text, comment, etc.) it has a string with the node type.

`tagName` is only supported by element nodes (as it originates from `Element` class), while `nodeName` can say something about other node types.

```js
<body><!-- comment -->

  <script>
    // for comment
     console.log( document.body.firstChild.tagName ); // undefined (not an element)
     console.log( document.body.firstChild.nodeName ); // #comment

    // for document
     console.log( document.tagName ); // undefined (not an element)
     console.log( document.nodeName ); // #document
  </script>
</body>
```

### innerHTML: the contents

The [innerHTML](https://w3c.github.io/DOM-Parsing/#the-innerhtml-mixin) property allows to get the HTML inside the element as a string. We can also modify it. So it’s one of the most powerful ways to change the page.

```html
<body>
  <p>A paragraph</p>
  <div>A div</div>

  <script>
    console.log( document.body.innerHTML ); // read the current contents
    document.body.innerHTML = 'The new BODY!'; // replace it
  </script>

</body>
```

We can try to insert invalid HTML, the browser will fix our errors:

```html
<body>

  <script>
    document.body.innerHTML = '<b>test'; // forgot to close the tag
     console.log( document.body.innerHTML ); // <b>test</b> (fixed)
  </script>

</body>
```

### outerHTML: full HTML of the element

The `outerHTML` property contains the full HTML of the element. That’s like `innerHTML` plus the element itself.

```html
<div id="elem">Hello <b>World</b></div>

<script>
   console.log(elem.outerHTML); // <div id="elem">Hello <b>World</b></div>
</script>
```

> **Beware: unlike `innerHTML`, writing to `outerHTML` does not change the element. Instead, it replaces it in the DOM.**

```html
<div>Hello, world!</div>

<script>
  let div = document.querySelector('div');

  // replace div.outerHTML with <p>...</p>
  div.outerHTML = '<p>A new element</p>'; // (*)

  // Wow! 'div' is still the same!
  console.log(div.outerHTML); // <div>Hello, world!</div> (**)
</script>
```

The `outerHTML` assignment does not modify the DOM element (the object referenced by, in this case, the variable ‘div’), but removes it from the DOM and inserts the new HTML in its place.

So what happened in `div.outerHTML=...` is:

- `div` was removed from the document.
- Another piece of HTML `<p>A new element</p>` was inserted in its place.
- `div` still has its old value. The new HTML wasn’t saved to any variable.

> **NOTE** - We can write to `elem.outerHTML`, but should keep in mind that it doesn’t change the element we’re writing to (‘elem’). It puts the new HTML in its place instead. We can get references to the new elements by querying the DOM.

### nodeValue/data: text node content

The `innerHTML` property is only valid for element nodes. Other node types, such as text nodes, have their counterpart: `nodeValue` and `data` properties. These two are almost the same

```html
<body>
  Hello
  <!-- Comment -->
  <script>
    let text = document.body.firstChild;
    alert(text.data); // Hello

    let comment = text.nextSibling;
    alert(comment.data); // Comment
  </script>
</body>
```

For text nodes we can imagine a reason to read or modify them, but why comments?

Sometimes developers embed information or template instructions into HTML in them, like this:

```html
<!-- if isAdmin -->
  <div>Welcome, Admin!</div>
<!-- /if -->
```

Then JavaScript can read it from `data` property and process embedded instructions.

### textContent: pure text

The `textContent` provides access to the *text* inside the element: only text, minus all `<tags>`.

```html
<div id="news">
  <h1>Headline!</h1>
  <p>Martians attack people!</p>
</div>

<script>
  // Headline! Martians attack people!
  alert(news.textContent);
</script>
```

> **Writing to `textContent` is much more useful, because it allows to write text the “safe way”.**

Let’s say we have an arbitrary string, for instance entered by a user, and want to show it.

- With `innerHTML` we’ll have it inserted “as HTML”, with all HTML tags.
- With `textContent` we’ll have it inserted “as text”, all symbols are treated literally.

Compare the two:

```html
<div id="elem1"></div>
<div id="elem2"></div>

<script>
  let name = prompt("What's your name?", "<b>Winnie-the-Pooh!</b>");

  elem1.innerHTML = name;
  elem2.textContent = name;
</script>
```

1. The first `<div>` gets the name “as HTML”: all tags become tags, so we see the bold name.
2. The second `<div>` gets the name “as text”, so we literally see `<b>Winnie-the-Pooh!</b>`.

### The “hidden” property

The “hidden” attribute and the DOM property specifies whether the element is visible or not.

```html
<div>Both divs below are hidden</div>

<div hidden>With the attribute "hidden"</div>

<div id="elem">JavaScript assigned the property "hidden"</div>

<script>
  elem.hidden = true;
</script>
```

Technically, `hidden` works the same as `style="display:none"`. But it’s shorter to write.

```html
<div id="elem">A blinking element</div>

<script>
  setInterval(() => elem.hidden = !elem.hidden, 1000);
</script>
```

### More properties

DOM elements also have additional properties, in particular those that depend on the class:

- `value` – the value for `<input>`, `<select>` and `<textarea>` (`HTMLInputElement`, `HTMLSelectElement`…).
- `href` – the “href” for `<a href="...">` (`HTMLAnchorElement`).
- `id` – the value of “id” attribute, for all elements (`HTMLElement`).

```html
<input type="text" id="elem" value="value">

<script>
  alert(elem.type); // "text"
  alert(elem.id); // "elem"
  alert(elem.value); // value
</script>
```

If we want to know the full list of supported properties for a given class, we can find them in the specification. For instance, `HTMLInputElement` is documented at https://html.spec.whatwg.org/#htmlinputelement.

## Attributes and properties

When the browser loads the page, it reads the HTML and generates DOM objects from it. For element nodes, most standard HTML attributes automatically become properties of DOM objects.

For instance, if the tag is `<body id="page">`, then the DOM object has `body.id="page"`  But the attribute-property mapping is not one-to-one

### DOM properties

DOM nodes are regular JavaScript objects. We can alter them.  let’s create a new property in `document.body`:

```js
document.body.myData = {
  name: 'Caesar',
  title: 'Imperator'
}
console.log(document.body.myData.title);
```

```js
document.body.sayTagName = function() {
  alert(this.tagName);
};

document.body.sayTagName();
```

We can also modify built-in prototypes like `Element.prototype` and add new methods to all elements:

```js
Element.prototype.sayHi = function(){
    alert(`Hello, I'm ${this.tagName}`);    
}

document.documentElement.sayHi(); // Hello, I'm HTML
document.body.sayHi(); // Hello, I'm BODY
```

So, DOM properties and methods behave just like those of regular JavaScript objects:

- They can have any value.
- They are case-sensitive (write `elem.nodeType`, not `elem.NoDeTyPe`).

### HTML attributes

In HTML, tags may have attributes. When the browser parses the HTML to create DOM objects for tags, it recognizes *standard* attributes and creates DOM properties from them.

So when an element has `id` or another *standard* attribute, the corresponding property gets created. But that doesn’t happen if the attribute is non-standard.

```html
<body id="test" something="non-standard">
  <script>
    alert(document.body.id); // test
    // non-standard attribute does not yield a property
    alert(document.body.something); // undefined
  </script>
</body>
```

Please note that a standard attribute for one element can be unknown for another one. For instance, `"type"` is standard for `<input>` ([HTMLInputElement](https://html.spec.whatwg.org/#htmlinputelement)), but not for `<body>` ([HTMLBodyElement](https://html.spec.whatwg.org/#htmlbodyelement)). Standard attributes are described in the specification for the corresponding element class.

```html
<body id="body" type="...">
  <input id="input" type="text">
  <script>
    alert(input.type); // text
    alert(body.type); // undefined: DOM property not created, because it's non-standard
  </script>
</body>
```

So, if an attribute is non-standard, there won’t be a DOM-property for it. Is there a way to access such attributes?

Sure. All attributes are accessible by using the following methods:

- `elem.hasAttribute(name)` – checks for existence.
- `elem.getAttribute(name)` – gets the value.
- `elem.setAttribute(name, value)` – sets the value.
- `elem.removeAttribute(name)` – removes the attribute.

Also one can read all attributes using `elem.attributes`: a collection of objects that belong to a built-in [Attr](https://dom.spec.whatwg.org/#attr) class, with `name` and `value` properties.

```html
<body something="non-standard">
  <script>
    alert(document.body.getAttribute('something')); // non-standard
  </script>
</body>
```

HTML attributes have the following features:

- Their name is case-insensitive (`id` is same as `ID`).
- Their values are always strings.

```html
<body>
  <div id="elem" about="Elephant"></div>

  <script>
    console.log( elem.getAttribute('About') ); // (1) 'Elephant', reading

    elem.setAttribute('Test', 123); // (2), writing

    console.log( elem.outerHTML ); // (3), see if the attribute is in HTML (yes)

    for (let attr of elem.attributes) { // (4) list all
      console.log( `${attr.name} = ${attr.value}` );
    }
  </script>
</body>
```

### Property-attribute synchronization

When a standard attribute changes, the corresponding property is auto-updated, and (with some exceptions) vice versa.

```html
<input>

<script>
  let input = document.querySelector('input');

  // attribute => property
  input.setAttribute('id', 'id');
  alert(input.id); // id (updated)

  // property => attribute
  input.id = 'newId';
  alert(input.getAttribute('id')); // newId (updated)
</script>
```

But there are exclusions, for instance `input.value` synchronizes only from attribute → property, but not back:

```html
<input>

<script>
  let input = document.querySelector('input');

  // attribute => property
  input.setAttribute('value', 'text');
  alert(input.value); // text

  // NOT property => attribute
  input.value = 'newValue';
  alert(input.getAttribute('value')); // text (not updated!)
</script>
```

In the example above:

- Changing the attribute `value` updates the property.
- But the property change does not affect the attribute.

That “feature” may actually come in handy, because the user actions may lead to `value` changes, and then after them, if we want to recover the “original” value from HTML, it’s in the attribute.

### DOM properties are typed

DOM properties are not always strings. For instance, the `input.checked` property (for checkboxes) is a boolean:

```html
<input id="input" type="checkbox" checked> checkbox

<script>
  alert(input.getAttribute('checked')); // the attribute value is: empty string
  alert(input.checked); // the property value is: true
</script>
```

 The `style` attribute is a string, but the `style` property is an object:

```html
<div id="div" style="color:red;font-size:120%">Hello</div>

<script>
  // string
  alert(div.getAttribute('style')); // color:red;font-size:120%

  // object
  alert(div.style); // [object CSSStyleDeclaration]
  alert(div.style.color); // red
</script>
```

Most properties are strings though.

Quite rarely, even if a DOM property type is a string, it may differ from the attribute. For instance, the `href` DOM property is always a *full* URL, even if the attribute contains a relative URL or just a `#hash`.

```html
<a id="a" href="#hello">link</a>
<script>
  // attribute
  alert(a.getAttribute('href')); // #hello

  // property
  alert(a.href ); // full URL in the form http://site.com/page#hello
</script>
```

If we need the value of `href` or any other attribute exactly as written in the HTML, we can use `getAttribute`.

### Non-standard attributes, dataset

When writing HTML, we use a lot of standard attributes. But what about non-standard, custom ones? First, let’s see whether they are useful or not? What for? 

Sometimes non-standard attributes are used to pass custom data from HTML to JavaScript, or to “mark” HTML-elements for JavaScript.

```html
<!-- mark the div to show "name" here -->
<div show-info="name"></div>
<!-- and age here -->
<div show-info="age"></div>

<script>
  // the code finds an element with the mark and shows what's requested
  let user = {
    name: "Pete",
    age: 25
  };

  for(let div of document.querySelectorAll('[show-info]')) {
    // insert the corresponding info into the field
    let field = div.getAttribute('show-info');
    div.innerHTML = user[field]; // first Pete into "name", then 25 into "age"
  }
</script>
```

Also they can be used to style an element.

```html
<style>
  /* styles rely on the custom attribute "order-state" */
  .order[order-state="new"] {
    color: green;
  }

  .order[order-state="pending"] {
    color: blue;
  }

  .order[order-state="canceled"] {
    color: red;
  }
</style>

<div class="order" order-state="new">
  A new order.
</div>

<div class="order" order-state="pending">
  A pending order.
</div>

<div class="order" order-state="canceled">
  A canceled order.
</div>
```

Why would using an attribute be preferable to having classes like `.order-state-new`, `.order-state-pending`, `.order-state-canceled`? 

Because an attribute is more convenient to manage. The state can be changed as easy as:

```js
// a bit simpler than removing old/adding a new class
div.setAttribute('order-state', 'canceled');
```

But there may be a possible problem with custom attributes. What if we use a non-standard attribute for our purposes and later the standard introduces it and makes it do something? The HTML language is alive, it grows, and more attributes appear to suit the needs of developers. There may be unexpected effects in such case.

To avoid conflicts, there exist [data-*](https://html.spec.whatwg.org/#embedding-custom-non-visible-data-with-the-data-*-attributes) attributes.

**All attributes starting with “data-” are reserved for programmers’ use. They are available in the `dataset` property.**

For instance, if an `elem` has an attribute named `"data-about"`, it’s available as `elem.dataset.about`.

```html
<body data-about="Elephants">
<script>
  alert(document.body.dataset.about); // Elephants
</script>
```

Multiword attributes like `data-order-state` become camel-cased: `dataset.orderState`.

```html
<style>
  .order[data-order-state="new"] {
    color: green;
  }

  .order[data-order-state="pending"] {
    color: blue;
  }

  .order[data-order-state="canceled"] {
    color: red;
  }
</style>

<div id="order" class="order" data-order-state="new">
  A new order.
</div>

<script>
  // read
  alert(order.dataset.orderState); // new

  // modify
  order.dataset.orderState = "pending"; // (*)
</script>
```

Using `data-*` attributes is a valid, safe way to pass custom data.

Please note that we can not only read, but also modify data-attributes. Then CSS updates the view accordingly: in the example above the last line `(*)` changes the color to blue.

- Attributes – is what’s written in HTML.
- Properties – is what’s in DOM objects.

**A small comparison:**

|      | Properties                                                      | Attributes                 |
| ---- | --------------------------------------------------------------- | -------------------------- |
| Type | Any value, standard properties have types described in the spec | A string                   |
| Name | Name is case-sensitive                                          | Name is not case-sensitive |

Methods to work with attributes are:

- `elem.hasAttribute(name)` – to check for existence.
- `elem.getAttribute(name)` – to get the value.
- `elem.setAttribute(name, value)` – to set the value.
- `elem.removeAttribute(name)` – to remove the attribute.
- `elem.attributes` is a collection of all attributes.

For most situations using DOM properties is preferable. We should refer to attributes only when DOM properties do not suit us, when we need exactly attributes, for instance:

- We need a non-standard attribute. But if it starts with `data-`, then we should use `dataset`.
- We want to read the value “as written” in HTML. The value of the DOM property may be different, for instance the `href` property is always a full URL, and we may want to get the “original” value.
