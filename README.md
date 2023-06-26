# calendar-code2 + a Clojure port

This repository [echeran/calendar-code2](https://github.com/echeran/calendar-code2) is a fork
of the original repository for the Common Lisp code that is featured in the book
[_Calendrical Calculations: The Ultimate Edition_](https://www.cambridge.org/core/books/calendrical-calculations/B897CA3260110348F1F7D906B8D9480D)
by Edward M. Reingold and Nachum Dershowitz (2018).
Please refer to the book for the full details of each function that is provided.

This repository provides a Clojure port of the Common Lisp code,
allowing an easy-to-use setup in which all of the code works as intended.


### Why?

Despite having all of the original Common Lisp code at hand,
it is not possible to get it run "out of the box"
([see prior discussion](https://stackoverflow.com/questions/72716454/start-working-with-large-lisp-library-calendrical-calculations)).
Updating the code to get it to run correctly is a non-trivial task.

Clojure is a modern dialect of Lisp with good tooling, documentation, and a wide platform reach.
This allows us to achieve an easy setup experience for the language and the project's dependencies.

Other benefits:

* Having a running version of the book's functions allows us to validate / debug other calendar implementations' outputs by introspecting on helper functions
* We have easy access to computations for calendars that are not yet implemented elsewhere
* If needed to run on other platforms, we can use reader conditionals to make the code simultaneously compile [to JavaScript](https://clojurescript.org/) and [the CLR](https://clojure.org/about/clojureclr).
For example, a webpage could run the Clojurescript (Javascript) code of all the functions locally.
* If we need more precision, we could replace `+`, `-`, and `*` in the Clojure code with the type-promoting versions `+'`, `-'`, and `*'` that give us `BigInteger` and Clojure's fixed-up version of `BigDecimal` when the precision of 64-bit types `long` and `double` are exceeded.

## Using the code

All of the code's symbols (functions, constants) are currently available in the `clj-calcalc.core` namespace.
You should be able to invoke any function you need while in this namespace.

### Examples

```clojure
;; In case your REPL does not automatically start in the `clj-calcaclc.core` namespace
user> (ns clj-calcalc.core)

;; Define some fixed dates used in the book's Appendix C of sample data
clj-calcalc.core> (def rd-vec [-214193 -61387 25469 49217])
#'clj-calcalc.core/rd-vec

;; Matches the column "Ephemeris Correction" in Appendix C sample data
clj-calcalc.core> (->> rd-vec
                       (map ephemeris-correction))
(0.21416985185185175
 0.14363257367091617
 0.11444429141515931
 0.10718320232694657)

;; Matches the column "Solar Longitude at 12:00:00 U.T. (Degrees)" in Appendix C sample data
clj-calcalc.core> (->> rd-vec
                       (map #(+ % 0.5))
                       (map solar-longitude))
(119.47343190503307
 254.2489611345809
 181.43599673954304
 188.66392267483752)

;; Matches the column "Islamic > Arithmetic" in Appendix C sample data
clj-calcalc.core> (->> rd-vec
                       (map islamic-from-fixed))
((-1245 12 9) (-813 2 23) (-568 4 1) (-501 4 6))

;; Matches the column "Chinese > Next Zhongqi" in Appendex C sample data
clj-calcalc.core> (->> rd-vec
                       (map major-solar-term-on-or-after))
(-214191.6331339299
 -61370.72967338959
 25498.215092247046
 49239.00486039391)

```

## Setup instructions

There are a few ways to build Clojure projects. This project will provide instructions for all such supported tools, which are:

* Leiningen

### Common setup prerequisites

You must have Java installed on your system. All versions of Clojure so far support Java 6+.

You will also need a project build tool.

### Leiningen

#### Setup

The setup for Leiningen is straightforward if you are familiar with using Linux/Unix/Windows at the command line. Follow instructions at the homepage (https://leiningen.org/) to download the script that both installs and runs the tool.

Running `lein` for the first time will download the dependencies for Leiningen and likely the latest version of Clojure.

#### Running a REPL

Loading a REPL only requires moving into the Clojure code's project directory and issuing a REPL command to Leiningen:

```
cd calendar-code2/clj/clj-calcalc
lein repl
```

## More info

Enjoy! Feel free to report issues of any errors, or if possible, open pull requests that make the fixes.