## JVM 

### 1. ClassLoader

ClassLoader is responsible for loading `.class` files into JVM memory at runtime.
It loads classes dynamically when they are required. The classloader are of three types:-
1. Bootstrap ClassLoader :- 
    - Parent of all class loader.
    - Loads core java classes from JDK
   
2. Extension ClassLoader :- 
   - Child of Bootstrap ClassLoader.
   - Loads extension libraries.

3. Application ClassLoader :-
    - Loads application-specific classes.
    - Loads classes from classpath , project libraries , user-defined classes



### 2. Runtime Data Areas 
1. Heap :- 
    - Shared among all threads
    - Objects and instance variable are stored in heap
    - Garbage Collector manages memory in heap

2. Stack :- 
   - Each thread has its own stack 
   - local variable are stored in stack
   - reference are stored in stack
   - Method calls are stored in stack
   - Automatically created and destroyed with method execution.
  
3. Method Area :-
   - Shared among all threads
   - mostly class metadata are stored here
   - Static variable are stored
   - method code are stored
   
4. PC Register :- 
   - Each thread has its PC Register
   - Stores the address of the current instruction being executed.
   
### 3. Execution Engine
 - It converts bytecode into machine-level instructions that the system can execute.

    ####  1. Interpreter
   -  Interpreter is a component of JVM Execution Engine 
   -  Read byte code line by line
   
   #### 2. JIT (Just in Time) Compiler
   -  It stores the frequently execute bytecode in native machine code
   - Faster execution after compilation.
   
   ####  3. Garbage Collector (GC)
   - Automatically removes unused objects from heap memory.
   - Runs automatically in background.

JIT Compiler vs Interpreter

"Write Once, Run Anywhere"


