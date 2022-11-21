
#### Comparison with https://gitlab.com/kumanser/asd-qwerty/-/tree/main/Task%208/Kumaniaev%20solution

| #   | Problem A                                                                                                                            | Problem B                                                      |
|-----|--------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| a   | Both solutions equally require one method being overloaded                                                                           | Both solutions equally require one method being overloaded     |
| b   | circular_shift.py: we easily delete Input class and write other version of Adapter pattern                                           | QueenTest.java: create child data class                        |
| c   | KWICTest.java because of the flexibility of adding another split symbol (without any change of the method signature) and data source | Both solutions are similar in respect to this aspect           |
| d   | circular_shift.py because of 'yield', deque ADT, and less type conversions                                                           | QueenTest.java, in Main.py range is called 2*n^3 + n^4 times   |
| e   | KWICTest.java since many classes could be flexibly reused                                                                            | Both are not much scalable to other business logic constraints |



#### Comparison with https://gitlab.com/kumanser/asd-qwerty/-/tree/main/Task%208/Koshevoi%20solution

| #   | Problem A                                                                           | Problem B                                                              |
|-----|-------------------------------------------------------------------------------------|------------------------------------------------------------------------|
| a   | KWICTest.java since only one method should be overloaded                            | Both solutions equally require one method being overloaded             |
| b   | KWICTest.java since in kwic.py we implicitly assume that it is a list in many cases | QueenTest.java: create child data class                                |
| c   | KWICTest.java because of the class inheritance and extension                        | Both solutions are similar in respect to this aspect                   |
| d   | KWICTest.java, many list iterations in kwic.py                                      | QueenTest.java since in queen.py the algorithm may seem less efficient |
| e   | kwic.py because of the useful functions                                             | Both are not much scalable to other business logic constraints         |

