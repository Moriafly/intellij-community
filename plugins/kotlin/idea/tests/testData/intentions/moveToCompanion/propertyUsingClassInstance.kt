// SHOULD_FAIL_WITH: Usages of outer class instance inside of property 'y' won't be processed
// IGNORE_K2
class A {
    val x = 1
    val <caret>y = x + 1
}