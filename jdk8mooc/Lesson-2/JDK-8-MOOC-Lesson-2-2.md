# JDK 8 MOOC: Lesson 2-2 #

## Elements of a Stream ##

Stream is an abstraction for specifying aggregate computations. Not tied to a data structure, thus potentially infinite.

Stream simplifies the description of the aggregate computations. Exposes improvement opportunities, and allows laziness and parallelism

Stream consists of three elements (conforming a pipeline):

- **Source**: It produces a source to be used by the intermediate operation.
- **Intermediate operation**: It is a operation which receives as input the stream and returns the modified stream. They can be zero or more.
- **Terminal operation**: It receives a source and produces a a result.

The execution of the pipeline
 
- It is performed only when a terminal operation is called.
- Intermediate operation can be merged.
- Intermediate operation can be lazy evaluated.