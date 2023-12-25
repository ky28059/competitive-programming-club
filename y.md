# What makes for good style?

[...]

## Human-readable code

Code, I think, should read as close to english as possible.

What I *don't* mean by this is that code syntax should mirror the syntax of english grammar, or that we should all write code essays
in big paragraphs and 12pt Times New Roman font.

But I do mean that your code should [...] as much as possible.

What does this function do?
```scheme
; scheme
(define (max-stock-diff stocks)
  (define (stocks-helper num list)
    (if (empty? list)
        0
        (max (- (car list) num) (stocks-helper num (cdr list)))))
  (if (empty? stocks)
      0
      (max (stocks-helper (car stocks) stocks) (max-stock-diff (cdr stocks)))))
```
It's hard to say. But what about this one?
```kotlin
// kotlin
fun maxStockDiff(stocks: List<Int>): Int {
    return stocks.dropLast(1)
        .withIndex()
        .maxOf { stocks.drop(it.index + 1).max() - it.value }
}
```
Now we're getting somewhere. [...]

For example, lets say the task is to check whether every element of an array of strings `arr` ends with a "Z":
```go
// go
allMatch := true
for _, str := range arr {
    if (str[len(str)-1] != 'Z') {
        allMatch = false
        break
    }
}
```
```kotlin
// kotlin
val allMatch = arr.all { it.endsWith("Z") }
```
In terms of efficiency, both approaches execute the same things under the hood, and I'll agree that the Go version may even be
more useful to someone focused solely on micro-optimization (as the for loop jumps out immediately in the Go code while it's hidden by
a helper method in the Kotlin version).

But if your goal is *readability*, the Go code only says *what the program does*: namely,

> Let `allMatch` be true. For each string in `arr`, if the last character of the string is not 'Z', assign `allMatch` to false and
> break the loop.

and it takes an extra bit of tracing through the logic to realize what the actual intent of the loop is. Meanwhile, the Kotlin code directly
states *what the program is meant to do*:

> Let `allMatch` be whether all strings in `arr` end with "Z".

While the phrase has become oft misused, this is what I imagine what people mean when they say "your code should be the comment".
Given a codebase you've never seen before (or even your own code from months ago that you've forgotten about), it's a lot easier to
immediately tell what this does

```kotlin
println(arr.maxOf { it.sum() })
```
> Print the max of the sums of each element of `arr`.

than this:

```java
int max = 0;
for (int[] row : arr) {
    int sum = 0;
    for (int n : row) {
        sum += n;
    }
    max = Math.max(max, sum);
}
System.out.println(max);
```
> Let `max` be 0. For each row in `arr`, let `sum` be 0. For each element of `row`, add it to `sum`. Set `max` to the maximum of itself
> and `sum`. Finally, print `max`.

or

```kotlin
println(arr.sumOf { l -> l.count { it % 2 == 0 } })
```
> Print the sum of the count of even numbers in each element of `arr`.

compared to

```go
count := 0
for _, row := range arr {
    for _, n := range row {
        if n % 2 == 0 {
            count++
        }
    }
}
fmt.Println(count)
```
> Let `count` be 0. For each row in `arr`, for each `n` in the row, if `n` is even increment `count` by 1. Finally, print `count`.

I'm not saying that it's impossible or even hard to trace nested for loops and incrementor variables and such; especially if you've
worked with languages that don't have higher-level constructs that allow you to avoid raw loops very often, the time it takes to convert
from something like
```java
int sum = 0;
for (int i : arr) {
    sum += i;
}
```
to
```kotlin
val sum = arr.sum()
```
can be very small. But especially for more complicated chained operations, it can be very nice to work in a language where you
don't *have* to do that conversion at all.

## The functional paradigm
[...]

A very common task is to take a string of space-separated integers and map it to an `int[]`. Here's how you'd implement that
in "traditional" Java using two arrays and a for loop:
```java
// java
String[] strs = str.split(" ");
int[] nums = new int[strs.length];

for (int i = 0; i < strs.length; i++) {
    nums[i] = Integer.parseInt(strs[i]);
}
```
> Let `strs` be the string split by spaces. Initialize a new `int[]` `nums` with same size as `strs`. For each index `i` of `strs`, set
> `nums[i]` to the result of parsing `strs[i]` as an integer.

Here's the same code in a functional style; notice how even with Java's somewhat-clunky streams API, it's much clearer here that the
split string is being mapped to ints:
```java
// java
int[] nums = Arrays.stream(str.split(" "))
    .mapToInt(Integer::parseInt)
    .toArray();
```
```kotlin
// kotlin
val nums = str.split(" ").map { it.toInt() }
```
```haskell
-- haskell
let nums = map read $ words str :: [Int]
```
> Let `nums` be the result of splitting the string by spaces and mapping each element to an integer.

Functional chaining also makes it very explicit what sequence of transformations is applied to the data.
Take [this problem from HPI 2021](https://github.com/ky28059/competitive-programming-club/blob/master/src/HPI/AnalyzeLiterature.kt), which
asks to print the (rounded) average word count of a sequence of sentences from `stdin`:
```kotlin
val average = readln()
    .dropLast(1)
    .split(Regex("[.?!]"))
    .map { it.trim().split(" ").size }
    .average()
    .roundToInt()
```
It's very clear in the above Kotlin snippet exactly how the string from `stdin` is processed:
1. The last character is dropped (to erase the last punctuation mark for splitting).
2. The string is split by punctuation marks into sentences.
3. Each sentence is trimmed of whitespace, then split by spaces, then mapped to its size (the number of words in the sentence).
4. This list of word counts is averaged.
5. Finally, the average is rounded and cast to an `int`.

The equivalent (Java) code using loops would be
```java
String line = br.readLine();
String[] sentences = line.substring(0, line.length() - 1).split("[.?!]");

double sum = 0.0;
for (String sentence : sentences) {
    String[] words = sentence.trim().split(" ");
    sum += words.length;
}

int average = (int) Math.round(sum / sentences.length);
```
and while an argument can be made that this code only needs to iterate through the array once instead of twice (though I believe most
compilers can optimize these functional chains anyways), each step of the process is much less clear here; it would be take much more
time to understand an uncommented version of this than the Kotlin version above.
